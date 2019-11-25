package bshow.dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;

import bshow.dao.Basedao;
import bshow.db.DBhelper;

public class Basedaoimpl implements Basedao{
	@Override
	public void saveObject(String id, Object o) {
		// TODO Auto-generated method stub
		Connection conn=DBhelper.getConnection();
		try {
		//拿到对应的文档xml
		Class c=o.getClass();
		Document doc=DBhelper.getDocumentByClass(c);
		Element insertelement =(Element)doc.selectSingleNode("/class/insert[@id='"+id+"']");
		String sql=insertelement.getTextTrim();
		//获得多少个参数
		int paramterCount =0;
		List<String> fileds=new ArrayList<String>();//带设置的字段List
		Pattern p=Pattern.compile("#[{](\\w+)[}]");
		Matcher m=p.matcher(sql);
		while(m.find()){
			paramterCount++;
			fileds.add(m.group(1));
		}
		//替换所有的sql为   ？
		sql=sql.replaceAll("#[{](\\w+)[}]", "?");  
		System.out.println(sql);
		//预处理
			PreparedStatement ps=conn.prepareStatement(sql);
			//设值
			for (int i = 0; i < paramterCount; i++) {
				String filedname=fileds.get(i);
				String methodname="get"+filedname.substring(0,1).toUpperCase()+filedname.substring(1);
				Method method=c.getMethod(methodname, null);
				ps.setObject(i+1, method.invoke(o, null));
			}
			
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBhelper.closeConnection(conn);
		}
		
	}

	@Override
	public List<Object> select(String id, Object o) {
		// TODO Auto-generated method stub
		List<Object> list=new ArrayList<Object>();
		Class c=o.getClass();
		Connection conn=DBhelper.getConnection();
		try {
			
			//根据对象拿到对应的mapping.xml文档
			Document doc=DBhelper.getDocumentByClass(c);
			Element selectelement=(Element)doc.selectSingleNode("/class/select[@id='"+id+"']");
			//获得元素内容的sql语句
			String sql=selectelement.getTextTrim();
			//匹配参数有多少个#{}.
			int paramterCount =0;
			Pattern p=Pattern.compile("#[{](\\w+)[}]");
			Matcher m=p.matcher(sql);
			List<String>  fileds =new ArrayList<String>();
			while(m.find()){
				fileds.add(m.group(1));
				paramterCount++;
			}
			
			//替换#{} 为?
			sql=sql.replaceAll("#[{](\\w+)[}]", "?");
			PreparedStatement ps=conn.prepareStatement(sql);
			for (int i = 0; i < paramterCount; i++) {
				String filedname=fileds.get(i);
				Method method=c.getDeclaredMethod("get"+filedname.substring(0,1).toUpperCase()+filedname.substring(1), null);
				ps.setObject(i+1, method.invoke(o, null));
			}
			ResultSet rs=ps.executeQuery();
			//拿到返回了的类型 以及它所有的属性
			String className=((Attribute)selectelement.selectSingleNode("./@resulttype")).getValue(); 
			Class returnclass=Class.forName(className);
			Field[] ffs=returnclass.getDeclaredFields();
			
			while(rs.next()){
				Object obj=returnclass.newInstance();
				for (int i = 0; i <ffs.length ; i++) {
					String ffsname=ffs[i].getName();
					//拿到set方法
					Method method =returnclass.getDeclaredMethod("set"+ffsname.substring(0,1).toUpperCase()+ffsname.substring(1), ffs[i].getType());
					//类属性      对应的字段名
					Attribute column=(Attribute)doc.selectSingleNode("/class/property[@name='"+ffsname+"']/@column");
					String columnstr=column.getValue();
					method.invoke(obj, rs.getObject(columnstr));
				}
				list.add(obj);
			}
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBhelper.closeConnection(conn);
		}
		return list;
	}

}

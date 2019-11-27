package bshow.dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;

import bshow.dao.Basedao;
import bshow.db.DBhelper;
import bshow.dto.Goods_classify;
import bshow.pojo.Goods_table;
import bshow.util.MyReplace;
import bshow.util.ober.Looker;
import bshow.util.ober.Subject;
import bshow.web.servlet.form.GoodsByConditionsActionForm;

public class Basedaoimpl implements Basedao,Subject{
	//用来存储观察者
	List<Looker> myLooker=new ArrayList<Looker>();
	
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
	
	//分页
	public List<Object> selectByPagesize(String id,Object o,int page, int pagesize){
		Connection conn=DBhelper.getConnection();
		List<Object> list=new ArrayList<Object>();
		Class c=o.getClass();
		try {
			//根据对象拿到对应的mapping.xml文档
			Document doc=DBhelper.getDocumentByClass(c);
			Element selectelement=(Element)doc.selectSingleNode("/class/select[@id='"+id+"']");
			//获得元素内容的sql语句
			String sql=selectelement.getTextTrim();
			sql=sql+" limit ?,?";
			System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (page-1)*pagesize);
			ps.setInt(2, pagesize);
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
			e.printStackTrace();
		}finally {
			DBhelper.closeConnection(conn);
		}
		return list;
	}

	//获得最大页数
	public int selectMaxPagesize(String id, Object o, int pagesize) {
		Connection conn=DBhelper.getConnection();
		Class c=o.getClass();
		int count=0;//记录总个数
		try {
			//根据对象拿到对应的mapping.xml文档
			Document doc=DBhelper.getDocumentByClass(c);
			Element selectelement=(Element)doc.selectSingleNode("/class/select[@id='"+id+"']");
			//获得元素内容的sql语句
			String sql=selectelement.getTextTrim();
			System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				count=rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			DBhelper.closeConnection(conn);
		}
		return count%pagesize==0?count/pagesize:count/pagesize+1;
	}

	//多条件查询
	public Map<String, String[]> selectGoodsByConditions(GoodsByConditionsActionForm form) {
		Connection conn=DBhelper.getConnection();	
		//select c.goods_price from (select goods_name,goods_price,goods_brand,middle_color,middle_size,middle_repertory,middle_type from goods_table as a inner join middle_table as b on a.goods_no=b.goods_no) as c where  
		Map<String,String[]> goodsByConditions=new HashMap<String, String[]>();
		Map<String,String[]> myGoods_brand=new HashMap<String, String[]>();
		//多条件查询
		String sql="select @ from (select goods_no,goods_name,goods_price,goods_brand,middle_color,middle_size,middle_type from goods_table as a inner join middle_table as b on a.goods_no=b.goods_no) as c where 1=1";
		StringBuffer sb=new StringBuffer(sql);
		if("goods_name".equals(form.getGoods_name())){
			sb.append(" and (c.goods_name like ? or c.goods_brand like ?)");
		}
		if("goods_price".equals(form.getGoods_price())){
			sb.append(" and goods_price>=? and goods_price<=?");
		}
		if("goods_brand".equals(form.getGoods_brand())){
			sb.append(" and goods_brand=?");
		}
		if("middle_color".equals(form.getMiddle_color())){
			sb.append(" and middle_color=?");
		}
		if("middle_size".equals(form.getMiddle_size())){
			sb.append(" and middle_size=?");
		}
		if("middle_type".equals(form.getMiddle_type())){
			sb.append(" and middle_type=?");
		}
		//根据条件构成sql语句
		sql=sb.toString();
		System.out.println(sql);
		try {
			//查询还有的品牌
			String mysql=sql+" group by goods_brand";
			mysql=mysql.replace("@", "goods_brand");
			MyReplace mr=new MyReplace(mysql,conn, myGoods_brand);
			
			//计数
			int index=0;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	
	//实现被观察者
	@Override
	public void addLooker(Looker looker) {
		myLooker.add(looker);
	}

	@Override
	public void removeLooker(Looker looker) {
		myLooker.remove(looker);
	}

	@Override
	public void notifyAllLooker(MyReplace mr) {
		for (Looker looker : myLooker) {
			looker.update(mr);
		}
	}

}

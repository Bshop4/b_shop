package bshow.dao.impl;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		Element insertelement =(Element)doc.selectSingleNode("/class/insert[@id="+id+"]");
		String sql=insertelement.getTextTrim();
		//获得多少个参数
		int paramterCount =0;
		List<String> fileds=new ArrayList<String>();
		Pattern p=Pattern.compile("#[{](\\w)[}]");
		Matcher m=p.matcher(sql);
		while(m.find()){
			paramterCount++;
			fileds.add(m.group(1));
		}
		//替换所有的sql为   ？
		sql.replaceAll("#[{](\\w+)[}]", "?");  
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

}

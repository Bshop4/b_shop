package bshow.db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBhelper {
	
	private static DataSource  cpd= null;
	private static Context context= null;
	private static SAXReader saxreader=new SAXReader();//创建读取xml文件的读取器
	private static Document doc=null; 
	private static List<Document> mappingList = new ArrayList<Document>();
	
	static{
		InputStream is=DBhelper.class.getResourceAsStream("/sqlmap.xml");
		try {
			//上下文的实例
			context= new InitialContext();
			getDataSource();
			//加载配置文件
			doc=saxreader.read(is);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//获得数据源
	public static DataSource  getDataSource(){
		try {
			cpd=(DataSource)context.lookup("java:comp/env/mysql");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cpd;
	}
	
	//获得连接
	public static Connection getConnection(){
		Connection conn = null;
		try {
			if(cpd!=null){
				conn = cpd.getConnection();//从链接池拿到一个链接
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	//关闭链接，退还到连接池
	public static void closeConnection(Connection conn){
		try {
			if(conn!=null&&!conn.isClosed()){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//加载所有的映射文件
	public static void loadMappings(){
		List<Element> list =doc.selectNodes("/properties/mappings/mapping");
		try {
			for(Element element : list) {
				String path=element.attributeValue("path");
				Document mappingdoc =saxreader.read(DBhelper.class.getResourceAsStream("/"+path));
				mappingList.add(mappingdoc);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//根据属性名获得
	
	
	//根据类对象找到对应映射文件
	public static Document getDocumentByClass(Class c){
		loadMappings();
		for (int i = 0; i < mappingList.size(); i++) {
			Document currentdoc=mappingList.get(i);
			Attribute attr=(Attribute)currentdoc.selectSingleNode("/class/@name");
			String classname =attr.getValue();
			try {
				if(c==Class.forName(classname)){
					return currentdoc;
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
}

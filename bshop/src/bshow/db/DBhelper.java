package bshow.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBhelper {
	
	private static DataSource  cpd= null;
	private static Context context= null;
	static{
		try {
			//上下文的实例
			context= new InitialContext();
			getDataSource();
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
	
}

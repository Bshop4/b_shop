package bshow.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bshow.dao.AdminDao;
import bshow.db.DBhelper;
import bshow.web.servlet.form.UpdateMyAccountForm;

public class AdminDaoImpl implements AdminDao{

	@Override
	public int selectAccount(String account) {
		int n=0;
		Connection conn=DBhelper.getConnection();
		String sql="select * from administrator_table where administrator_account=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, account);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				n=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBhelper.closeConnection(conn);
		}
		return n;
	}

	@Override
	public boolean doLogin(String account, String password) {
		boolean flag=false;
		Connection conn=DBhelper.getConnection();
		String sql="select * from administrator_table where administrator_account=? and sdministrator_password=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, account);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBhelper.closeConnection(conn);
		}
		return flag;
	}

	@Override
	public boolean updateAccountByAdmin(UpdateMyAccountForm form) {
		boolean flag=false;
		Connection conn=DBhelper.getConnection();
		String sql="update account_table set password=?,email=?,ipaddress=?,ban=? where account=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setString(1, form.getPassword());
			ps.setString(2, form.getEmail());
			ps.setString(3, form.getIpaddress());
			if(form.getBan()!=null){
				ps.setInt(4,Integer.parseInt(form.getBan()));
			}else{
				ps.setInt(4, 0);
			}
			ps.setString(5, form.getAccount());
			
			int n=ps.executeUpdate();
			if(n!=0){
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBhelper.closeConnection(conn);
		}
		return flag;
	}

	@Override
	public int deleteMyAccountByAdmin(String account) {
		int n=0;
		Connection conn=DBhelper.getConnection();
		String sql="delete from account_table where account=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, account);
			n=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBhelper.closeConnection(conn);
		}
		return n;
	}

}

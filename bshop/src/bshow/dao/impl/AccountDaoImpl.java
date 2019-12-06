package bshow.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bshow.dao.AccountDao;
import bshow.db.DBhelper;

public class AccountDaoImpl implements AccountDao{

	@Override
	public String getNicknameByAccount(String account) {
		String nickname=null;
		Connection conn= DBhelper.getConnection();
		String sql="select nickname from personinfo_table where account=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, account);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				nickname=rs.getString("nickname");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBhelper.closeConnection(conn);
		}
		return nickname;
	}

	@Override
	public int getCartNumberByAccont(String account) {
		int cartNum=0;
		Connection conn= DBhelper.getConnection();
		String sql="select sum(cgoods_number) from cart_table where account=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, account);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				cartNum=rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBhelper.closeConnection(conn);
		}
		return cartNum;
	}

	@Override
	public int getIsBan(String account) {
		int myban=0;
		Connection conn= DBhelper.getConnection();
		String sql="select * from account_table where account=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, account);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				myban=rs.getInt("ban");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBhelper.closeConnection(conn);
		}
		return myban;
	}
	
}

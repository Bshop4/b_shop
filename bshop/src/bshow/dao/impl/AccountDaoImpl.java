package bshow.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bshow.dao.AccountDao;
import bshow.pojo.Account_table;

public class AccountDaoImpl implements AccountDao {

	@Override
	public boolean insertAccount(Account_table account, Connection con) throws Exception {

		String sql = "insert into account_table(account,password,email,ipaddress,ban) values(?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, account.getAccount());
		ps.setString(2, account.getPassword());
		ps.setString(3, account.getEmail());
		ps.setString(4, account.getIpaddress());
		ps.setInt(5, account.getBan());
		int n = ps.executeUpdate();
		if (n != 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteAccount(Account_table account, Connection con) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from account_table where account_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, account.getAccount_id());
		int n = ps.executeUpdate();
		if (n != 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateAccout(Account_table account, Connection con) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update account_table set account=?,password=?,email=?,ipaddress=?,ban=? where account_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, account.getAccount());
		ps.setString(2, account.getPassword());
		ps.setString(3, account.getEmail());
		ps.setString(4, account.getIpaddress());
		ps.setInt(5, account.getBan());
		ps.setInt(5, account.getAccount_id());
		int n = ps.executeUpdate();
		if (n != 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<Account_table> queryAllAccount(Connection con) throws Exception {
		// TODO Auto-generated method stub
		List<Account_table> list = new ArrayList<Account_table>();
		String sql = "select * from account_table";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Account_table at = new Account_table();
			at.setAccount_id(rs.getInt("account_id"));
			at.setBan(rs.getInt("ban"));
			at.setAccount(rs.getString("account"));
			at.setPassword(rs.getString("password"));
			at.setEmail(rs.getString("email"));
			at.setIpaddress(rs.getString("ipaddress"));
			list.add(at);
		}
		return list;
	}

	@Override
	public Account_table queryOneAccount(int account_id, Connection con) throws Exception {
//		Account_table act = null;
//		String sql = "select * from account_table where account_id = ?";
//		PreparedStatement ps = con.prepareStatement(sql);
//		ps.setInt(1, account_id);
//		ResultSet rs = ps.executeQuery();
//		while (rs.next()) {
//			act = new Account_table();
//			act.setAccount_id(rs.getInt("account_id"));
//			act.setBan(rs.getInt("ban"));
//			act.setAccount(rs.getString("account"));
//			act.setPassword(rs.getString("password"));
//			act.setEmail(rs.getString("email"));
//			act.setIpaddress(rs.getString("ipaddress"));
//		}
		return null;
	}

}

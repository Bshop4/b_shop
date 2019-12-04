package bshow.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bshow.db.DBhelper;
import bshow.pojo.Account_table;
import bshow.service.AccountService;

public class AccountServiceimpl implements AccountService{

	@Override
	public List<Account_table> selectPage(int PageNo, int PageSize,String account,String email) {
		// TODO Auto-generated method stub
		Connection conn=DBhelper.getConnection();
		List<Account_table> mylist=new ArrayList<Account_table>();
		String sql="select * from account_table where 1=1";
		StringBuffer sb=new StringBuffer(sql);
		if(account!=null){
			sb.append(" and account like ?");
		}
		if(email!=null){
			sb.append(" and email like ?");
		}
		sb.append(" limit ?,?");
		sql=sb.toString();
		try {
			//记录索引
			int index=0;
			PreparedStatement ps=conn.prepareStatement(sql);
			if(account!=null){
				ps.setString(++index, "%"+account+"%");
			}
			if(email!=null){
				ps.setString(++index, "%"+email+"%");
			}
			
			ps.setInt(++index, PageSize*(PageNo-1));
			ps.setInt(++index, PageSize);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Account_table a=new Account_table();
				a.setAccount(rs.getString("account"));
				a.setBan(rs.getInt("ban"));
				a.setEmail(rs.getString("email"));
				a.setIpaddress(rs.getString("ipaddress"));
				a.setPassword(rs.getString("password"));
				mylist.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBhelper.closeConnection(conn);
		}
		return mylist;
	}

	@Override
	public int selectMaxPage(int PageNo, int PageSize, String account, String email) {
		Connection conn=DBhelper.getConnection();
		int max=0;
		String sql="select count(*) from account_table where 1=1";
		StringBuffer sb=new StringBuffer(sql);
		if(account!=null){
			sb.append(" and account like ?");
		}
		if(email!=null){
			sb.append(" and email like ?");
		}
		sql=sb.toString();
		try {
			//记录索引
			int index=0;
			PreparedStatement ps=conn.prepareStatement(sql);
			if(account!=null){
				ps.setString(++index, "%"+account+"%");
			}
			if(email!=null){
				ps.setString(++index, "%"+email+"%");
			}
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				max=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBhelper.closeConnection(conn);
		}
		return max%PageSize==0?(max/PageSize):(max/PageSize+1);
	}

}

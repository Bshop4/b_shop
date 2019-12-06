package bshow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import bshow.db.DBhelper;
import bshow.pojo.Account_table;
import bshow.pojo.Collection_table;

public class CollectionDaoImpl implements CollectionDao{

	@Override
	public List<Collection_table> queryAllColletionByAccount(int page, int pageSize, String account) {
		// TODO Auto-generated method stub
		List<Collection_table> list = new ArrayList<Collection_table>();
		Connection con = DBhelper.getConnection();
		
		String sql="select * from collection_table where 1=1";
		StringBuffer sb=new StringBuffer(sql);
		if(account!=null){
			sb.append(" and account like ?");
		}
		sb.append(" limit ?,?");
		sql=sb.toString();
		try {
			//记录索引
			int index=0;
			PreparedStatement ps=con.prepareStatement(sql);
			if(account!=null){
				ps.setString(++index, "%"+account+"%");
			}
			ps.setInt(++index, pageSize*(page-1));
			ps.setInt(++index, pageSize);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				
				Collection_table ct = new Collection_table();
				ct.setCid(rs.getInt("cid"));
				ct.setAccount(rs.getString("account"));
				ct.setGoods_name(rs.getString("goods_name"));
				ct.setGoods_no(rs.getString("goods_no"));
				ct.setGoods_photo(rs.getString("goods_photo"));
				ct.setState(rs.getInt("state"));
				list.add(ct);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBhelper.closeConnection(con);
		}
		return list;
	}

	@Override
	public int getMaxPage(int page, int pageSize, String account) {
		Connection conn=DBhelper.getConnection();
		int max=0;
		String sql="select count(*) from collection_table where 1=1";
		StringBuffer sb=new StringBuffer(sql);
		if(account!=null){
			sb.append(" and account like ?");
		}
		sql=sb.toString();
		try {
			//记录索引
			int index=0;
			PreparedStatement ps=conn.prepareStatement(sql);
			if(account!=null){
				ps.setString(++index, "%"+account+"%");
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
		return max%pageSize==0?(max/pageSize):(max/pageSize+1);
	}
	
	

}

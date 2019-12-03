package bshow.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bshow.dao.GoodsDao;
import bshow.db.DBhelper;
import bshow.pojo.Goods_table;

public class GoodsDaoImpl implements GoodsDao{

	@Override
	public List<Goods_table> getGoodsByTime(int page, int pagesize) {
		List<Goods_table> list=new ArrayList<Goods_table>();
		Connection conn=DBhelper.getConnection();
		String sql="select * from goods_table order by goods_uptime desc limit ?,?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, (page-1)*pagesize);
			ps.setInt(2, pagesize);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Goods_table g=new Goods_table();
				g.setGoods_photo(rs.getString("goods_photo"));
				g.setGoods_brand(rs.getString("goods_brand"));
				g.setGoods_name(rs.getString("goods_name"));
				g.setGoods_no(rs.getString("goods_no"));
				g.setGoods_like(rs.getInt("goods_like"));
				g.setGoods_price(rs.getDouble("goods_price"));
				list.add(g);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBhelper.closeConnection(conn);
		}
		return list;
	}

	@Override
	public List<Goods_table> getGoodsByExplosive(int page, int pagesize) {
		List<Goods_table> list=new ArrayList<Goods_table>();
		Connection conn=DBhelper.getConnection();
		String sql="select * from goods_table order by goods_like desc limit ?,?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, (page-1)*pagesize);
			ps.setInt(2, pagesize);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Goods_table g=new Goods_table();
				g.setGoods_photo(rs.getString("goods_photo"));
				g.setGoods_brand(rs.getString("goods_brand"));
				g.setGoods_name(rs.getString("goods_name"));
				g.setGoods_no(rs.getString("goods_no"));
				g.setGoods_like(rs.getInt("goods_like"));
				g.setGoods_price(rs.getDouble("goods_price"));
				list.add(g);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBhelper.closeConnection(conn);
		}
		return list;
	}

}

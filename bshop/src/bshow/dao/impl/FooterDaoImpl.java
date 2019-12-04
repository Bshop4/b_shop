package bshow.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bshow.dao.FooterDao;
import bshow.db.DBhelper;
import bshow.dto.GoodsAndFooter;

public class FooterDaoImpl implements FooterDao{

	//根据账号查询足迹
	@Override
	public List<GoodsAndFooter> getFooterByAccount(String account) {
		Connection conn=DBhelper.getConnection();
		List<GoodsAndFooter> list=new ArrayList<GoodsAndFooter>();
		String sql="select b.goods_photo,b.goods_brand,b.goods_name,b.goods_price,b.goods_no,c.footprint_time from goods_table as b inner join (select a.footprint_goodsno,a.footprint_time from footprint_table as a where account=?) as c on b.goods_no=c.footprint_goodsno";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, account);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				GoodsAndFooter gaf=new GoodsAndFooter();
				gaf.setFootprint_time(rs.getString("footprint_time"));
				gaf.setGoods_brand(rs.getString("goods_brand"));
				gaf.setGoods_name(rs.getString("goods_name"));
				gaf.setGoods_no(rs.getString("goods_no"));
				gaf.setGoods_photo(rs.getString("goods_photo"));
				gaf.setGoods_price(rs.getDouble("goods_price"));
				list.add(gaf);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBhelper.closeConnection(conn);
		}
		return list;
	}

	@Override
	public boolean deleteFooter(String goods_no,String footprint_time) {
		boolean flag=false;
		Connection conn=DBhelper.getConnection();
		String sql="delete from footprint_table where footprint_goodsno=? and footprint_time=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, goods_no);
			ps.setString(2, footprint_time);
			int m=ps.executeUpdate();
			if(m!=0){
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

}

package bshow.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bshow.dao.GoodsDao;
import bshow.pojo.Goods_table;

public class GoodsDaoImpl implements GoodsDao {
	// 添加商品
	@Override
	public boolean insertGoods(Goods_table goods, Connection con) throws Exception {
		String sql = "insert into goods_table(goods_name,goods_price,goods_explain,goods_like,goods_photo,goods_category,goods_sex,goods_color,goods_size,goods_explainphoto,goods_discount,shop_id,goods_season,goods_uptime,goods_ban) value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, goods.getGoods_name());
		ps.setDouble(2, goods.getGoods_price());
		ps.setString(3, goods.getGoods_explain());
		ps.setInt(4, goods.getGoods_like());
		ps.setString(5, goods.getGoods_photo());
		ps.setString(6, goods.getGoods_category());
		ps.setString(7, goods.getGoods_sex());
		ps.setString(8, goods.getGoods_color());
		ps.setString(9, goods.getGoods_size());
		ps.setString(10, goods.getGoods_explainphoto());
		ps.setDouble(11, goods.getGoods_discount());
		ps.setInt(12, goods.getShop_id());
		ps.setString(13, goods.getGoods_season());
		ps.setString(14, goods.getGoods_uptime());
		ps.setString(15, goods.getGoods_ban());
		int n = ps.executeUpdate();
		if (n != 0) {
			return true;
		}
		return false;
	}

	// 删除商品
	@Override
	public boolean deleteGoods(Goods_table goods, Connection con) throws Exception {
		String sql = "delete from goods_table where goods_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, goods.getGoods_id());
		int n = ps.executeUpdate();
		if (n != 0) {
			return true;
		}
		return false;
	}

	// 更改商品信息
	@Override
	public boolean updateGoods(Goods_table goods, Connection con) throws Exception {
		String sql = "update goods_table set goods_name=?,goods_price=?,goods_explain=?,goods_like=?,goods_photo=?,goods_category=?,goods_sex=?,goods_color=?,goods_size=?,goods_explainphoto=?,goods_discount=?,shop_id=?,goods_season=?,goods_uptime=?,goods_ban=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, goods.getGoods_name());
		ps.setDouble(2, goods.getGoods_price());
		ps.setString(3, goods.getGoods_explain());
		ps.setInt(4, goods.getGoods_like());
		ps.setString(5, goods.getGoods_photo());
		ps.setString(6, goods.getGoods_category());
		ps.setString(7, goods.getGoods_sex());
		ps.setString(8, goods.getGoods_color());
		ps.setString(9, goods.getGoods_size());
		ps.setString(10, goods.getGoods_explainphoto());
		ps.setDouble(11, goods.getGoods_discount());
		ps.setInt(12, goods.getShop_id());
		ps.setString(13, goods.getGoods_season());
		ps.setString(14, goods.getGoods_uptime());
		ps.setString(15, goods.getGoods_ban());
		int n = ps.executeUpdate();
		if (n != 0) {
			return true;
		}
		return false;
	}

	// 根据商品类别查询商品
	@Override
	public List<Goods_table> queryGoodsByCategory(String category, Connection con) throws Exception {
		List<Goods_table> list = new ArrayList<Goods_table>();
		String sql = "select * from goods_table where category=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Goods_table gt = new Goods_table();
			gt.setGoods_name(rs.getString("goods_name"));
			gt.setGoods_price(rs.getDouble("goods_price"));
			gt.setGoods_explain(rs.getString("goods_explain"));
			gt.setGoods_like(rs.getInt("goods_like"));
			gt.setGoods_photo(rs.getString("goods_photo"));
			gt.setGoods_category(rs.getString("goods_category"));
			gt.setGoods_sex(rs.getString("goods_sex"));
			gt.setGoods_color(rs.getString("goods_color"));
			gt.setGoods_size(rs.getString("goods_size"));
			gt.setGoods_explainphoto(rs.getString("goods_explainphoto"));
			gt.setGoods_discount(rs.getDouble("goods_discount"));
			gt.setShop_id(rs.getInt("shop_id"));
			gt.setGoods_season(rs.getString("goods_season"));
			gt.setGoods_uptime(rs.getString("goods_uptime"));
			gt.setGoods_ban(rs.getString("goods_ban"));
			list.add(gt);
		}
		return list;
	}

	// 根据店铺主键查询商品
	@Override
	public List<Goods_table> queryGoodsByShopId(int shopId, Connection con) throws Exception {
		List<Goods_table> list = new ArrayList<Goods_table>();
		String sql = "select * from goods_table where shop_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Goods_table gt = new Goods_table();
			gt.setGoods_name(rs.getString("goods_name"));
			gt.setGoods_price(rs.getDouble("goods_price"));
			gt.setGoods_explain(rs.getString("goods_explain"));
			gt.setGoods_like(rs.getInt("goods_like"));
			gt.setGoods_photo(rs.getString("goods_photo"));
			gt.setGoods_category(rs.getString("goods_category"));
			gt.setGoods_sex(rs.getString("goods_sex"));
			gt.setGoods_color(rs.getString("goods_color"));
			gt.setGoods_size(rs.getString("goods_size"));
			gt.setGoods_explainphoto(rs.getString("goods_explainphoto"));
			gt.setGoods_discount(rs.getDouble("goods_discount"));
			gt.setShop_id(rs.getInt("shop_id"));
			gt.setGoods_season(rs.getString("goods_season"));
			gt.setGoods_uptime(rs.getString("goods_uptime"));
			gt.setGoods_ban(rs.getString("goods_ban"));
			list.add(gt);
		}
		return list;
	}

}

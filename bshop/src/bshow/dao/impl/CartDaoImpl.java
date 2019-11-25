package bshow.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bshow.dao.CartDao;
import bshow.pojo.Cart_table;

public class CartDaoImpl implements CartDao {
	// 增加购物车内的商品
	@Override
	public boolean insertCart(Cart_table cart, Connection con) throws Exception {
		String sql = "insert into Cart_table(cart_number,goods_price,goods_explain,cart_state) value(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, cart.getCart_number());
		ps.setDouble(2, cart.getGoods_price());
		ps.setString(3, cart.getGoods_explain());
		ps.setInt(4, cart.getCart_state());
		int n = ps.executeUpdate();
		if (n != 0) {
			return true;
		}
		return false;
	}

	// 删除购物车内的商品
	@Override
	public boolean deleteCart(Cart_table cart, Connection con) throws Exception {
		String sql = "delete from Cart_table where cart_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, cart.getCart_id());
		int n = ps.executeUpdate();
		if (n != 0) {
			return true;
		}
		return false;
	}

	// 更新购物车内的商品
	@Override
	public boolean updateCart(Cart_table cart, Connection con) throws Exception {
		String sql = "update Cart_table set cart_number=?,goods_price=?,goods_explain=?,cart_state=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, cart.getCart_number());
		ps.setDouble(2, cart.getGoods_price());
		ps.setString(3, cart.getGoods_explain());
		ps.setInt(4, cart.getCart_state());
		int n = ps.executeUpdate();
		if (n != 0) {
			return true;
		}
		return false;
	}

	// 查找购物车商品
	@Override
	public List<Cart_table> queryAllCart(Connection con) throws Exception {
		List<Cart_table> list = new ArrayList<Cart_table>();
		String sql = "select * form cart_table";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Cart_table ct = new Cart_table();
			ct.setCart_id(rs.getInt("cart_id"));
			ct.setCart_number(rs.getInt("cart_number"));
			ct.setGoods_price(rs.getDouble("goods_price"));
			ct.setGoods_explain(rs.getString("goods_explain"));
			ct.setCart_state(rs.getInt("cart_state"));
			list.add(ct);
		}
		return list;
	}

}

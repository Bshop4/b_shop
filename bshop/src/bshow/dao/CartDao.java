package bshow.dao;

import java.sql.Connection;
import java.util.List;

import bshow.pojo.Cart_table;

public interface CartDao {

	// 增加购物车内的商品
	public boolean insertCart(Cart_table cart, Connection con) throws Exception;

	// 删除购物车内的商品
	public boolean deleteCart(Cart_table cart, Connection con) throws Exception;

	// 更新购物车内的商品
	public boolean updateCart(Cart_table cart, Connection con) throws Exception;

	// 查找购物车商品
	public List<Cart_table> queryAllCart(Connection con) throws Exception;

}

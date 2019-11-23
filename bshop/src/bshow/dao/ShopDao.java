package bshow.dao;

import java.sql.Connection;
import java.util.List;

import bshow.pojo.Shop_table;
/**
 * 商家表dao
 * @author 10415
 *
 */
public interface ShopDao {
	
	//增
	public boolean insertShopInfo(Shop_table shop,Connection con) throws Exception;
	
	//删
	public boolean deleteShopInfo(Shop_table shop,Connection con) throws Exception;
	
	//改
	public boolean updateShopInfo(Shop_table shop, Connection con) throws Exception;
	
	//查某个店的所有商品
	public List<Shop_table> queryAllShopGoods(int shopId,Connection con) throws Exception;
	
	
}

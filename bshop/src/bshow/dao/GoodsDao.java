package bshow.dao;

import java.sql.Connection;
import java.util.List;

import bshow.pojo.Cart_table;
import bshow.pojo.Goods_table;

/**
 * 商品dao
 * @author 10415
 *
 */
public interface GoodsDao {
	
	//添加商品
	public boolean insertGoods(Goods_table goods,Connection con) throws Exception;
	
	//删除商品
	public boolean deleteGoods(Goods_table goods,Connection con) throws Exception;
	
	//更改商品信息
	public boolean updateGoods(Goods_table goods,Connection con) throws Exception;
	
	//根据商品类别查询商品
	public List<Goods_table> queryGoodsByCategory(String category,Connection con) throws Exception;
	
	//根据店铺主键查询商品
	public List<Goods_table> queryGoodsByShopId(int shopId,Connection con) throws Exception;
	
	
	
}

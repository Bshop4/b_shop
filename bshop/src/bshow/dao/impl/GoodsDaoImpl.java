package bshow.dao.impl;

import java.sql.Connection;
import java.util.List;

import bshow.dao.GoodsDao;
import bshow.pojo.Goods_table;

public class GoodsDaoImpl implements GoodsDao{

	@Override
	public boolean insertGoods(Goods_table goods, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteGoods(Goods_table goods, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateGoods(Goods_table goods, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Goods_table> queryGoodsByCategory(String category, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Goods_table> queryGoodsByShopId(int shopId, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}

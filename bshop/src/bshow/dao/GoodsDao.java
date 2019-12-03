package bshow.dao;

import java.util.List;

import bshow.pojo.Goods_table;

public interface GoodsDao {
	public List<Goods_table> getGoodsByTime(int page,int pagesize);
	public List<Goods_table> getGoodsByExplosive(int page,int pagesize);
}

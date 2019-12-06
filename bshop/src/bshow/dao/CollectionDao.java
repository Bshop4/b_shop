package bshow.dao;

import java.util.List;

import bshow.pojo.Collection_table;

public interface CollectionDao {
	
	public List<Collection_table> queryAllColletionByAccount(int page,int pageSize,String account);

	public int getMaxPage(int page, int pageSize,String account);
}

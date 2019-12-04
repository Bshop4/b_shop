package bshow.dao;

import java.util.List;

import bshow.dto.GoodsAndFooter;

public interface FooterDao {
	public List<GoodsAndFooter> getFooterByAccount(String account);
	public boolean deleteFooter(String goods_no,String footprint_time);
}

package bshow.dao;

import java.util.List;

import bshow.dto.GoodsAndFooter;

public interface FooterDao {
	public List<GoodsAndFooter> getFooterByAccount(String account);
}

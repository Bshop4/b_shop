package bshow.pojo;

import java.io.Serializable;

public class Shop_table implements Serializable{
	private int shop_id;//店铺的主键      
	private String goods_no;//商品的主键
	private String shop_no;//商品的主键
	public int getShop_id() {
		return shop_id;
	}
	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	public String getGoods_no() {
		return goods_no;
	}
	public void setGoods_no(String goods_no) {
		this.goods_no = goods_no;
	}
	public String getShop_no() {
		return shop_no;
	}
	public void setShop_no(String shop_no) {
		this.shop_no = shop_no;
	}
	
}

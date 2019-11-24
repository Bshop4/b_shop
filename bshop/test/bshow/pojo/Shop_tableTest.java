package bshow.pojo;

import java.io.Serializable;

public class Shop_tableTest implements Serializable{
	private int shop_id;//店铺的主键      
	private int goods_id;//商品的主键
	public int getShop_id() {
		return shop_id;
	}
	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	
}

package bshow.pojo;

import java.io.Serializable;

public class Cart_table implements Serializable{
	private int cart_id;//购物车主键
	private int cart_number;//购物车商品的数量
	private double 	goods_price;//商品的单价
	private String   goods_name;//商品的名字
	private int cart_state;//购物车的状态(是否选中成功)
	
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public int getCart_number() {
		return cart_number;
	}
	public void setCart_number(int cart_number) {
		this.cart_number = cart_number;
	}
	public double getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(double goods_price) {
		this.goods_price = goods_price;
	}
	
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public int getCart_state() {
		return cart_state;
	}
	public void setCart_state(int cart_state) {
		this.cart_state = cart_state;
	}


}

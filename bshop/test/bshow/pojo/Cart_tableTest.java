package bshow.pojo;

import java.io.Serializable;

public class Cart_tableTest implements Serializable{
	private int cart_id;//购物车主键
	private int cart_number;//购物车商品的数量
	private double 	goods_price;//商品的单价
	private String   goods_explain;//商品的解释
	private int cart_state;//购物车的状态(是否交易成功)
	
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
	public String getGoods_explain() {
		return goods_explain;
	}
	public void setGoods_explain(String goods_explain) {
		this.goods_explain = goods_explain;
	}
	public int getCart_state() {
		return cart_state;
	}
	public void setCart_state(int cart_state) {
		this.cart_state = cart_state;
	}


}

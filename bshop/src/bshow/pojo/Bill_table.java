package bshow.pojo;

import java.io.Serializable;
import java.util.Date;

public class Bill_table implements Serializable{
	private int bill_id  ; //订单主键
	private String address;//收货地址
	private String bill_time;// 订单时间
	private double 	allprice;//  订单总价格
	private String account; //用户帐号
	private String goods_name;//商品名称
	private double goods_price;//商品单价
	private int cart_number;//（购车里的商品数量）
	private String  bill_code;//订单编码
	
	public int getBill_id() {
		return bill_id;
	}
	public void setBill_id(int bill_id) {
		this.bill_id = bill_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBill_time() {
		return bill_time;
	}
	public void setBill_time(String bill_time) {
		this.bill_time = bill_time;
	}
	public double getAllprice() {
		return allprice;
	}
	public void setAllprice(double allprice) {
		this.allprice = allprice;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public double getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(double goods_price) {
		this.goods_price = goods_price;
	}
	public int getCart_number() {
		return cart_number;
	}
	public void setCart_number(int cart_number) {
		this.cart_number = cart_number;
	}
	public String getBill_code() {
		return bill_code;
	}
	public void setBill_code(String bill_code) {
		this.bill_code = bill_code;
	}
	


	


	

	 
	

}

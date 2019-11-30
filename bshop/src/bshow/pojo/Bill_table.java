package bshow.pojo;

import java.io.Serializable;

public class Bill_table implements Serializable {
	private int bill_id; // 订单主键
	private String address;// 收货地址
	private String bill_time;// 订单时间
	private double allprice;// 订单总价格
	private String account; // 用户帐号
	private String goods_name;// 商品名称
	private double goods_price;// 商品单价
	private int cart_number;// （购车里的商品数量）
	private int bill_state;// 1表示选中，0表示未选中
	private String bill_code;// 订单编码
	private String goods_photo;// 商品图片
	private String goods_id;// 商品编号
	private int bill_isclearing; // 订单是否付钱 1表示结算了 2 表示未结算
	private String goods_color;// 商品颜色
	private String goods_size;// 商品尺寸
	private int goods_no;// 商品number

	public int getBill_isclearing() {
		return bill_isclearing;
	}

	public void setBill_isclearing(int bill_isclearing) {
		this.bill_isclearing = bill_isclearing;
	}

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

	public String getGoods_photo() {
		return goods_photo;
	}

	public void setGoods_photo(String goods_photo) {
		this.goods_photo = goods_photo;
	}

	public String getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}

	public int getBill_state() {
		return bill_state;
	}

	public void setBill_state(int bill_state) {
		this.bill_state = bill_state;
	}

	public String getGoods_color() {
		return goods_color;
	}

	public void setGoods_color(String goods_color) {
		this.goods_color = goods_color;
	}

	public String getGoods_size() {
		return goods_size;
	}

	public void setGoods_size(String goods_size) {
		this.goods_size = goods_size;
	}

	public int getGoods_no() {
		return goods_no;
	}

	public void setGoods_no(int goods_no) {
		this.goods_no = goods_no;
	}

}

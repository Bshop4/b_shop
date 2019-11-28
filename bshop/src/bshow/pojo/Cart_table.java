package bshow.pojo;

import java.io.Serializable;

public class Cart_table implements Serializable {
	private int cart_id; // 购物车主键
	private String cgoods_photo;// 购物车商品的图片
	private String cgoods_desc;// 商品的描述说明
	private int cgoods_number;// 商品的数量
	private double cgoods_price;// 商品的单价
	private double cgoods_sub;// 商品的小计
	private String cgoods_no;// 商品的编号
	private int cgoods_state;// 购物车的状态(是否交易成功)
	private String cgoods_color;// 购物车商品颜色.
	private String cgoods_size;// 购物车商品尺寸

	private String account;// 用户账号

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public String getCgoods_photo() {
		return cgoods_photo;
	}

	public void setCgoods_photo(String cgoods_photo) {
		this.cgoods_photo = cgoods_photo;
	}

	public String getCgoods_desc() {
		return cgoods_desc;
	}

	public void setCgoods_desc(String cgoods_desc) {
		this.cgoods_desc = cgoods_desc;
	}

	public int getCgoods_number() {
		return cgoods_number;
	}

	public void setCgoods_number(int cgoods_number) {
		this.cgoods_number = cgoods_number;
	}

	public double getCgoods_price() {
		return cgoods_price;
	}

	public void setCgoods_price(double cgoods_price) {
		this.cgoods_price = cgoods_price;
	}

	public double getCgoods_sub() {
		return cgoods_sub;
	}

	public void setCgoods_sub(double cgoods_sub) {
		this.cgoods_sub = cgoods_sub;
	}

	public String getCgoods_no() {
		return cgoods_no;
	}

	public void setCgoods_no(String cgoods_no) {
		this.cgoods_no = cgoods_no;
	}

	public int getCgoods_state() {
		return cgoods_state;
	}

	public void setCgoods_state(int cgoods_state) {
		this.cgoods_state = cgoods_state;
	}

	public String getCgoods_color() {
		return cgoods_color;
	}

	public void setCgoods_color(String cgoods_color) {
		this.cgoods_color = cgoods_color;
	}

	public String getCgoods_size() {
		return cgoods_size;
	}

	public void setCgoods_size(String cgoods_size) {
		this.cgoods_size = cgoods_size;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

}

package bshow.web.servlet.form;

import bshow.web.servlet.core.ActionForm;

public class GoodsByConditionsActionForm extends ActionForm{
	private String goods_price;
	private String goods_brand;
	private String middle_color;
	private String middle_size;
	private String goods_name;
	private String middle_type;
	public String getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(String goods_price) {
		this.goods_price = goods_price;
	}
	public String getGoods_brand() {
		return goods_brand;
	}
	public void setGoods_brand(String goods_brand) {
		this.goods_brand = goods_brand;
	}
	public String getMiddle_color() {
		return middle_color;
	}
	public void setMiddle_color(String middle_color) {
		this.middle_color = middle_color;
	}
	public String getMiddle_size() {
		return middle_size;
	}
	public void setMiddle_size(String middle_size) {
		this.middle_size = middle_size;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public String getMiddle_type() {
		return middle_type;
	}
	public void setMiddle_type(String middle_type) {
		this.middle_type = middle_type;
	}
	@Override
	public String toString() {
		return "GoodsByConditionsActionForm [goods_price=" + goods_price + ", goods_brand=" + goods_brand
				+ ", middle_color=" + middle_color + ", middle_size=" + middle_size + ", goods_name=" + goods_name
				+ ", middle_type=" + middle_type + "]";
	}
	
}

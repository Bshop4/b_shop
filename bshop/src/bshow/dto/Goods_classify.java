package bshow.dto;

import java.io.Serializable;

public class Goods_classify implements Serializable{
	private double goods_price;
	private String goods_brand;
	private String middle_color;
	private String middle_size;
	private int middle_repertory;
	private String middle_type;
	public double getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(double goods_price) {
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
	public int getMiddle_repertory() {
		return middle_repertory;
	}
	public void setMiddle_repertory(int middle_repertory) {
		this.middle_repertory = middle_repertory;
	}
	public String getMiddle_type() {
		return middle_type;
	}
	public void setMiddle_type(String middle_type) {
		this.middle_type = middle_type;
	}
	@Override
	public String toString() {
		return "Goods_classify [goods_price=" + goods_price + ", goods_brand=" + goods_brand + ", middle_color="
				+ middle_color + ", middle_size=" + middle_size + ", middle_repertory=" + middle_repertory
				+ ", middle_type=" + middle_type + "]";
	}
	
}

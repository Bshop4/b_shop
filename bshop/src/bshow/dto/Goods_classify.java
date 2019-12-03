package bshow.dto;

import java.io.Serializable;

public class Goods_classify implements Serializable {
	private String goods_price;
	private String goods_brand;
	private String middle_color;
	private String middle_size;
	private String goods_place;
	private int middle_repertory;
	private String middle_type;
	private String goods_name;
	private String goods_photo;
	private String goods_no;
	private int maxPageCount;
	private int goods_like;
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
	public String getGoods_place() {
		return goods_place;
	}
	public void setGoods_place(String goods_place) {
		this.goods_place = goods_place;
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
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public String getGoods_photo() {
		return goods_photo;
	}
	public void setGoods_photo(String goods_photo) {
		this.goods_photo = goods_photo;
	}
	public String getGoods_no() {
		return goods_no;
	}
	public void setGoods_no(String goods_no) {
		this.goods_no = goods_no;
	}
	public int getMaxPageCount() {
		return maxPageCount;
	}
	public void setMaxPageCount(int maxPageCount) {
		this.maxPageCount = maxPageCount;
	}
	public int getGoods_like() {
		return goods_like;
	}
	public void setGoods_like(int goods_like) {
		this.goods_like = goods_like;
	}
	@Override
	public String toString() {
		return "Goods_classify [goods_price=" + goods_price + ", goods_brand=" + goods_brand + ", middle_color="
				+ middle_color + ", middle_size=" + middle_size + ", goods_place=" + goods_place + ", middle_repertory="
				+ middle_repertory + ", middle_type=" + middle_type + ", goods_name=" + goods_name + ", goods_photo="
				+ goods_photo + ", goods_no=" + goods_no + ", maxPageCount=" + maxPageCount + ", goods_like="
				+ goods_like + "]";
	}

	

}

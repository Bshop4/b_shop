package bshow.dto;

import java.io.Serializable;

public class GoodsAndFooter implements Serializable{
	private String footprint_time;
	private String goods_no;
	private String goods_brand;
	private String goods_photo;
	private double goods_price;
	private String goods_name;
	public String getFootprint_time() {
		return footprint_time;
	}
	public void setFootprint_time(String footprint_time) {
		this.footprint_time = footprint_time;
	}
	public String getGoods_no() {
		return goods_no;
	}
	public void setGoods_no(String goods_no) {
		this.goods_no = goods_no;
	}
	public String getGoods_brand() {
		return goods_brand;
	}
	public void setGoods_brand(String goods_brand) {
		this.goods_brand = goods_brand;
	}
	public String getGoods_photo() {
		return goods_photo;
	}
	public void setGoods_photo(String goods_photo) {
		this.goods_photo = goods_photo;
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
}

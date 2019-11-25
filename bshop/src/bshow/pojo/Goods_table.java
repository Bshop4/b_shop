package bshow.pojo;

import java.io.Serializable;
import java.util.Date;

public class Goods_table implements Serializable,Cloneable{
	private int goods_id;//商品主键
	private String  goods_name;//商品名字
	private double 	goods_price;//商品单价
	//private String 	goods_explain;//商品描述
	private int goods_like;//商品点赞数
	private String goods_photo;//商品图片
	private String goods_category;//商品的类别
	private String goods_sex;//商品男女
	private String goods_color;//商品的颜色
	private String goods_size;//商品的大小
	private String 	goods_explainphoto;//商品描述的图片
	private double goods_discount;//商品的折扣
	private int shop_id;//店铺的主键
//	private String goods_season;//商品的类型季节如：春
	private String goods_place;//商品发货地
	private String goods_uptime;//商品的上架时间
	private int goods_ban;//商品是否被禁用
	private String goods_location;//商品的上衣，下装
	private String goods_no;//（商品的编号）
	private String goods_brand;//（商品的品牌）
	private String goods_smallphoto;//（商品的小图）
	
	@Override
	public String toString() {
		return "Goods_table [goods_id=" + goods_id + ", goods_name=" + goods_name + ", goods_price=" + goods_price
				+ ", goods_like=" + goods_like + ", goods_photo=" + goods_photo + ", goods_category=" + goods_category
				+ ", goods_sex=" + goods_sex + ", goods_color=" + goods_color + ", goods_size=" + goods_size
				+ ", goods_explainphoto=" + goods_explainphoto + ", goods_discount=" + goods_discount + ", shop_id="
				+ shop_id + ", goods_place=" + goods_place + ", goods_uptime=" + goods_uptime + ", goods_ban="
				+ goods_ban + ", goods_location=" + goods_location + ", goods_no=" + goods_no + ", goods_brand="
				+ goods_brand + ", goods_smallphoto=" + goods_smallphoto + "]";
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	
	public String getGoods_place() {
		return goods_place;
	}

	public void setGoods_place(String goods_place) {
		this.goods_place = goods_place;
	}

	public String getGoods_explainphoto() {
		return goods_explainphoto;
	}
	public void setGoods_explainphoto(String goods_explainphoto) {
		this.goods_explainphoto = goods_explainphoto;
	}
	public String getGoods_brand() {
		return goods_brand;
	}
	public void setGoods_brand(String goods_brand) {
		this.goods_brand = goods_brand;
	}
	public String getGoods_smallphoto() {
		return goods_smallphoto;
	}
	public void setGoods_smallphoto(String goods_smallphoto) {
		this.goods_smallphoto = goods_smallphoto;
	}
	public String getGoods_location() {
		return goods_location;
	}
	public void setGoods_location(String goods_location) {
		this.goods_location = goods_location;
	}
	public String getGoods_no() {
		return goods_no;
	}
	public void setGoods_no(String goods_no) {
		this.goods_no = goods_no;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
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
	public int getGoods_like() {
		return goods_like;
	}
	public void setGoods_like(int goods_like) {
		this.goods_like = goods_like;
	}
	public String getGoods_photo() {
		return goods_photo;
	}
	public void setGoods_photo(String goods_photo) {
		this.goods_photo = goods_photo;
	}
	public String getGoods_category() {
		return goods_category;
	}
	public void setGoods_category(String goods_category) {
		this.goods_category = goods_category;
	}
	public String getGoods_sex() {
		return goods_sex;
	}
	public void setGoods_sex(String goods_sex) {
		this.goods_sex = goods_sex;
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
	public double getGoods_discount() {
		return goods_discount;
	}
	public void setGoods_discount(double goods_discount) {
		this.goods_discount = goods_discount;
	}
	public int getShop_id() {
		return shop_id;
	}
	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	public String getGoods_uptime() {
		return goods_uptime;
	}
	public void setGoods_uptime(String goods_uptime) {
		this.goods_uptime = goods_uptime;
	}
	public int getGoods_ban() {
		return goods_ban;
	}
	public void setGoods_ban(int goods_ban) {
		this.goods_ban = goods_ban;
	}

	
	


	
	
	
	
	
	

	
	

	
	

}

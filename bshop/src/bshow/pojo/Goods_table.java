package bshow.pojo;

import java.io.Serializable;
import java.util.Date;

public class Goods_table implements Serializable{
	private int goods_id;//商品主键
	private String  goods_name;//商品名字
	private double 	goods_price;//商品单价
	private String 	goods_explain;//商品描述
	private int goods_like;//商品点赞数
	private String goods_photo;//商品图片
	private String goods_category;//商品的类别
	private String goods_sex;//商品男女
	private String goods_color;//商品的颜色
	private String goods_size;//商品的大小
	private String 	goods_explainphoto;//商品描述的图片
	private double goods_discount;//商品的折扣
	private int shop_id;//店铺的主键
	private String goods_season;//商品的类型季节如：春
	private String goods_uptime;//商品的上架时间
	private String goods_ban;//商品是否被禁用
	
	
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
	public String getGoods_explain() {
		return goods_explain;
	}
	public void setGoods_explain(String goods_explain) {
		this.goods_explain = goods_explain;
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
	public String getGoods_explainphoto() {
		return goods_explainphoto;
	}
	public void setGoods_explainphoto(String goods_explainphoto) {
		this.goods_explainphoto = goods_explainphoto;
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
	public String getGoods_season() {
		return goods_season;
	}
	public void setGoods_season(String goods_season) {
		this.goods_season = goods_season;
	}
	public String getGoods_uptime() {
		return goods_uptime;
	}
	public void setGoods_uptime(String goods_uptime) {
		this.goods_uptime = goods_uptime;
	}
	public String getGoods_ban() {
		return goods_ban;
	}
	public void setGoods_ban(String goods_ban) {
		this.goods_ban = goods_ban;
	}

	
	


	
	
	
	
	
	

	
	

	
	

}

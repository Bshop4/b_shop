package bshow.pojo;

import java.io.Serializable;
/**
 * 商品分类表
 * @author 10415
 *
 */
public class Classify_table implements Serializable{
	
	private int classify_id;//主键
	private String goods_size;//尺寸
	private String goods_style;//风格、春夏秋冬
	private String goods_location;//上衣、下装
	private String goods_color;//颜色
	public int getClassify_id() {
		return classify_id;
	}
	public void setClassify_id(int classify_id) {
		this.classify_id = classify_id;
	}
	public String getGoods_size() {
		return goods_size;
	}
	public void setGoods_size(String goods_size) {
		this.goods_size = goods_size;
	}
	public String getGoods_style() {
		return goods_style;
	}
	public void setGoods_style(String goods_style) {
		this.goods_style = goods_style;
	}
	public String getGoods_location() {
		return goods_location;
	}
	public void setGoods_location(String goods_location) {
		this.goods_location = goods_location;
	}
	public String getGoods_color() {
		return goods_color;
	}
	public void setGoods_color(String goods_color) {
		this.goods_color = goods_color;
	}
	
	

}

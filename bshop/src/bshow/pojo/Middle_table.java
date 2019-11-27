package bshow.pojo;

import java.io.Serializable;
import java.util.Arrays;

public class Middle_table implements Serializable,Cloneable{
	private int middle_id;
	private String middle_color;
	private String goods_no;
	private String goods_smallphoto;
	private String middle_size;
	private int middle_repertory;
	private String middle_type;
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	public int getMiddle_id() {
		return middle_id;
	}
	public void setMiddle_id(int middle_id) {
		this.middle_id = middle_id;
	}
	public String getMiddle_color() {
		return middle_color;
	}
	public void setMiddle_color(String middle_color) {
		this.middle_color = middle_color;
	}
	public String getGoods_no() {
		return goods_no;
	}
	public void setGoods_no(String goods_no) {
		this.goods_no = goods_no;
	}
	
	
	public String getGoods_smallphoto() {
		return goods_smallphoto;
	}
	public void setGoods_smallphoto(String goods_smallphoto) {
		this.goods_smallphoto = goods_smallphoto;
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
		return "Middle_table [middle_id=" + middle_id + ", middle_color=" + middle_color + ", goods_no=" + goods_no
				+ ", goods_smallphoto=" + goods_smallphoto + ", middle_size=" + middle_size
				+ ", middle_repertory=" + middle_repertory + ", middle_type=" + middle_type + "]";
	}

	
	
	
	
	
	
	
	 

}

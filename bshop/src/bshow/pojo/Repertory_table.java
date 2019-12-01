package bshow.pojo;

import java.io.Serializable;

public class Repertory_table implements Serializable ,Cloneable{
	private int repertory_id;
	private String goods_no;
	private String repertory_color;
	private String repertory_size;
	private int repertory_number;
	
	
	
	
	@Override
	public String toString() {
		return "Repertory_table [repertory_id=" + repertory_id + ", goods_no=" + goods_no + ", repertory_color="
				+ repertory_color + ", repertory_size=" + repertory_size + ", repertory_number=" + repertory_number
				+ "]";
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	public int getRepertory_id() {
		return repertory_id;
	}
	public void setRepertory_id(int repertory_id) {
		this.repertory_id = repertory_id;
	}
	public String getGoods_no() {
		return goods_no;
	}
	public void setGoods_no(String goods_no) {
		this.goods_no = goods_no;
	}
	public String getRepertory_color() {
		return repertory_color;
	}
	public void setRepertory_color(String repertory_color) {
		this.repertory_color = repertory_color;
	}
	public String getRepertory_size() {
		return repertory_size;
	}
	public void setRepertory_size(String repertory_size) {
		this.repertory_size = repertory_size;
	}
	public int getRepertory_number() {
		return repertory_number;
	}
	public void setRepertory_number(int repertory_number) {
		this.repertory_number = repertory_number;
	}

}

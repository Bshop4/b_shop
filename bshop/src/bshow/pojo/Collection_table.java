package bshow.pojo;

import java.io.Serializable;
import java.util.Arrays;

public class Collection_table implements Serializable{
	
	private int cid;
	private String account;
	private String goods_no;
	private int state;
	private String goods_photo;
	private String goods_name;
	public String getGoods_photo() {
		return goods_photo;
	}
	public void setGoods_photo(String goods_photo) {
		this.goods_photo = goods_photo;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getGoods_no() {
		return goods_no;
	}
	public void setGoods_no(String goods_no) {
		this.goods_no = goods_no;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Collection_table [cid=" + cid + ", account=" + account + ", goods_no=" + goods_no + ", state=" + state
				+ ", goods_photo=" + goods_photo + ", goods_name=" + goods_name + "]";
	}
	
	
	
	

}

package bshow.pojo;

import java.io.Serializable;

public class Collection_table implements Serializable{
	
	private int cid;
	private String account;
	private String goods_no;
	private int state;
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
				+ "]";
	}
	
	

}

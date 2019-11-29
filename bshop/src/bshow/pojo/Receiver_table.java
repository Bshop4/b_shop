package bshow.pojo;

import java.io.Serializable;

public class Receiver_table implements Serializable{
	
	private int rid;//id
	private String receiver;//收货人
	private String postcode;//邮编
	private String address;//地址
	private String tel;//手机
	private String account;//账户
	
	
	
	public int getRid() {
		return rid;
	}



	public void setRid(int rid) {
		this.rid = rid;
	}



	public String getReceiver() {
		return receiver;
	}



	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}



	public String getPostcode() {
		return postcode;
	}



	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getTel() {
		return tel;
	}



	public void setTel(String tel) {
		this.tel = tel;
	}



	public String getAccount() {
		return account;
	}



	public void setAccount(String account) {
		this.account = account;
	}



	@Override
	public String toString() {
		return "Receiver_table [rid=" + rid + ", receiver=" + receiver + ", postcode=" + postcode + ", address="
				+ address + ", tel=" + tel + ", account=" + account + "]";
	}

	
	
}

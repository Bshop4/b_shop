package bshow.pojo;

import java.io.Serializable;

public class Receiver_table implements Serializable{
	
	private int rid;//id
	private String receiver;//收货人
	private String postal;//邮编
	private String address;//地址
	private String telephone;//手机
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
	public String getPostal() {
		return postal;
	}
	public void setPostal(String postal) {
		this.postal = postal;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	@Override
	public String toString() {
		return "Receiver_table [rid=" + rid + ", receiver=" + receiver + ", postal=" + postal + ", address=" + address
				+ ", telephone=" + telephone + ", account=" + account + "]";
	}
	
	
	
	
	
}
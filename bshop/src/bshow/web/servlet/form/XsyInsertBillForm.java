package bshow.web.servlet.form;

import bshow.web.servlet.core.ActionForm;

public class XsyInsertBillForm extends ActionForm {
	private String cart_id;
	private String account;
	private String address;

	public String getCart_id() {
		return cart_id;
	}

	public void setCart_id(String cart_id) {
		this.cart_id = cart_id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}

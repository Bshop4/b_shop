package bshow.web.servlet.form;

import bshow.web.servlet.core.ActionForm;

public class SaveAddressForm extends ActionForm {
	private String name;
	private String iphone;
	private String postcode;
	private String AllAddress;
	private String account;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIphone() {
		return iphone;
	}

	public void setIphone(String iphone) {
		this.iphone = iphone;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getAllAddress() {
		return AllAddress;
	}

	public void setAllAddress(String allAddress) {
		AllAddress = allAddress;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

}

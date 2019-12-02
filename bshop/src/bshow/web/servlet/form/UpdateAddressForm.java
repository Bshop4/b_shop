package bshow.web.servlet.form;

import bshow.web.servlet.core.ActionForm;

public class UpdateAddressForm extends ActionForm {
	private String name;
	private String iphone;

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
}

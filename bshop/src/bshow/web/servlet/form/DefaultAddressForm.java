package bshow.web.servlet.form;

import bshow.web.servlet.core.ActionForm;

public class DefaultAddressForm extends ActionForm {
	private String account;
	private int ischeck;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getIscheck() {
		return ischeck;
	}

	public void setIscheck(int ischeck) {
		this.ischeck = ischeck;
	}
}

package bshow.web.servlet.form;

import bshow.web.servlet.core.ActionForm;

public class Login_ActionForm extends ActionForm{
	private String account;
	private String password;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

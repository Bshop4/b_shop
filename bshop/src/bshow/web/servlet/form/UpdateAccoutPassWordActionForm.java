package bshow.web.servlet.form;

import bshow.web.servlet.core.ActionForm;

public class UpdateAccoutPassWordActionForm extends ActionForm{
	private String account;
	private String email;
	private String password;
	
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

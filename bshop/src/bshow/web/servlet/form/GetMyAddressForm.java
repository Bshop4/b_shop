package bshow.web.servlet.form;

import bshow.web.servlet.core.ActionForm;

public class GetMyAddressForm extends ActionForm {
	private String msg;
	private String uname;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}
}

package bshow.web.servlet.form;

import bshow.web.servlet.core.ActionForm;

public class DeleteBillByBillIdForm extends ActionForm{
	
	private String billid;
	private String account;
	
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getBillid() {
		return billid;
	}

	public void setBillid(String billid) {
		this.billid = billid;
	}
	
	

}

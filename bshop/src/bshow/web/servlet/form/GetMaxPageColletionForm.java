package bshow.web.servlet.form;

import bshow.web.servlet.core.ActionForm;

public class GetMaxPageColletionForm extends ActionForm{
	
	
	private String account;
	private String page;
	private String pagesize;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getPagesize() {
		return pagesize;
	}
	public void setPagesize(String pagesize) {
		this.pagesize = pagesize;
	}
	
	

}

package bshow.web.servlet.form;

import bshow.web.servlet.core.ActionForm;

public class MaxPageActionForm extends ActionForm{
	private String pagesize;

	public String getPagesize() {
		return pagesize;
	}

	public void setPagesize(String pagesize) {
		this.pagesize = pagesize;
	}

	@Override
	public String toString() {
		return "MaxPageActionForm [pagesize=" + pagesize + "]";
	}
	
}

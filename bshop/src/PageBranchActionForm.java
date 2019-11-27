

import bshow.web.servlet.core.ActionForm;

public class PageBranchActionForm extends ActionForm{
	private String page;
	private String pagesize;
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
	@Override
	public String toString() {
		return "PageBranchActionForm [page=" + page + ", pagesize=" + pagesize + "]";
	}
	
}

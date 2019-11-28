package bshow.web.servlet.form;

import bshow.web.servlet.core.ActionForm;

public class NavigationActionForm extends ActionForm{
	private String min;
	private String max;
	public String getMin() {
		return min;
	}
	public void setMin(String min) {
		this.min = min;
	}
	public String getMax() {
		return max;
	}
	public void setMax(String max) {
		this.max = max;
	}
	
}

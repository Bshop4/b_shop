package bshow.web.servlet.form;

import bshow.web.servlet.core.ActionForm;

public class MyDeleteActionForm extends ActionForm{
	public String goods_no;
	public String footprint_time;
	public String getGoods_no() {
		return goods_no;
	}
	public void setGoods_no(String goods_no) {
		this.goods_no = goods_no;
	}
	public String getFootprint_time() {
		return footprint_time;
	}
	public void setFootprint_time(String footprint_time) {
		this.footprint_time = footprint_time;
	}

	
}

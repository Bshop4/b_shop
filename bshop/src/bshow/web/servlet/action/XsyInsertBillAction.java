package bshow.web.servlet.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bshow.dao.Basedao;
import bshow.dao.impl.Basedaoimpl;
import bshow.pojo.Bill_table;
import bshow.pojo.Cart_table;
import bshow.util.GenericPrimaryKey;
import bshow.web.servlet.core.Action;
import bshow.web.servlet.core.ActionForm;
import bshow.web.servlet.core.ActionForward;

public class XsyInsertBillAction extends Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		// 从cart_account.js获得传来的参数
		String cart_id = request.getParameter("cart_id");
		String account = request.getParameter("account");
		String address = request.getParameter("address");

		Cart_table ct = new Cart_table();
		Bill_table bt = new Bill_table();
		ct.setAccount(account);
		ct.setCart_id(Integer.parseInt(cart_id));
		Basedao bd = new Basedaoimpl();
		List<Object> list = bd.select("selectState", ct);
		Cart_table obj = (Cart_table) list.get(0);
		// 设置bt的值
		bt.setAccount(obj.getAccount());
		bt.setAddress(address);
		bt.setGoods_id(String.valueOf(obj.getCart_id()));
		bt.setAllprice(obj.getCgoods_sub());
		bt.setBill_code("");
		bt.setBill_isclearing(0);
		bt.setBill_state(0);
		bt.setBill_time(new Date().toString());
		bt.setCart_number(obj.getCgoods_number());
		bt.setGoods_color(obj.getCgoods_color());
		bt.setGoods_name(obj.getCgoods_desc());
		bt.setGoods_no(obj.getCgoods_no());
		bt.setGoods_photo(obj.getCgoods_photo());
		bt.setGoods_price(obj.getCgoods_price());
		bt.setGoods_size(obj.getCgoods_size());
		bt.setBill_isclearing(0);
		bt.setBill_code(GenericPrimaryKey.getPrimaryKey());
		// 存入数据库
		bd.saveObject("insertone", bt);
		return null;
	}

}

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
//		String msg = xb.getCart_id();
		String cart_id = request.getParameter("cart_id");
		String account = request.getParameter("account");
		System.out.println(cart_id + "a");
		Cart_table ct = new Cart_table();
		Bill_table bt = new Bill_table();
		ct.setAccount(account);
		Basedao bd = new Basedaoimpl();
		List<Object> list = bd.select("selectByState", ct);
		System.out.println(list.size());
		for (Object object : list) {
//			System.out.println(object);
			Cart_table obj = (Cart_table) object;
			bt.setAccount(obj.getAccount());
			bt.setAddress("");
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

		}
		bd.saveObject("insertone", bt);
//		AddBill ab = new AddBillImpl();
//		boolean flag = ab.AddBill(cart_id);
//		System.out.println(flag);
////		JSONObject obj = JSONObject.fromObject(msg);
////		System.out.println(obj);
		return null;
	}

}

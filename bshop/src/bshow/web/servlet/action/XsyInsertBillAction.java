package bshow.web.servlet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bshow.dao.Basedao;
import bshow.dao.impl.Basedaoimpl;
import bshow.pojo.Bill_table;
import bshow.web.servlet.core.Action;
import bshow.web.servlet.core.ActionForm;
import bshow.web.servlet.core.ActionForward;

public class XsyInsertBillAction extends Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
//		XsyInsertBillForm xb = (XsyInsertBillForm) form;
//		String msg = xb.getCart_id();
		String cart_ids = request.getParameter("cart_id");
		System.out.println(cart_ids);
		int cart_id = Integer.parseInt(cart_ids);
		Bill_table bt = new Bill_table();
		bt.setGoods_no(cart_id);
		Basedao bd = new Basedaoimpl();
		boolean flag = bd.saveObject("insertgoodsBill", bt);
//		JSONObject obj = JSONObject.fromObject(msg);
//		System.out.println(obj);
		return null;
	}

}

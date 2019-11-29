package bshow.web.servlet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bshow.web.servlet.core.Action;
import bshow.web.servlet.core.ActionForm;
import bshow.web.servlet.core.ActionForward;
import bshow.web.servlet.form.InsertBillForm;
import net.sf.json.JSONArray;

/**
 * 插入到bill_table
 * 
 * @author Administrator
 *
 */
public class InsertBillAction extends Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		InsertBillForm ib = (InsertBillForm) form;
		String msg = ib.getMsg();
		JSONArray obj = JSONArray.fromObject(msg);
		System.out.println(obj);
//		String account = obj.getString("account");
//		String cart_id = obj.getString("cart_id");
//		String cgoods_color = obj.getString("cgoods_color");
//		String cgoods_desc = obj.getString("cgoods_desc");
//		int cgoods_no = obj.getInt("cgoods_no");
//		int cgoods_number = obj.getInt("cgoods_number");
//		String cgoods_photo = obj.getString("cgoods_photo");
//		Double cgoods_price = obj.getDouble("cgoods_price");
//		String cgoods_size = obj.getString("cgoods_size");
//		int cgoods_state = obj.getInt("cgoods_state");
//		Double cgoods_sub = obj.getDouble("cgoods_sub");
//		Date time = new Date();
//		String now = time.toString();
//		String uuid = UUID.randomUUID().toString().substring(0, 8);
//
//		Bill_table bt = new Bill_table();
//		bt.setAllprice(cgoods_sub);
//		bt.setAccount(account);
//		bt.setGoods_name(cgoods_desc);
//		bt.setGoods_price(cgoods_price);
//		bt.setCart_number(cgoods_number);
//		bt.setGoods_photo(cgoods_photo);
//		bt.setGoods_id(cart_id);
//		bt.setGoods_color(cgoods_color);
//		bt.setGoods_size(cgoods_size);
//		bt.setGoods_no(cgoods_no);
//		bt.setBill_state(cgoods_state + 1);// 11
//		bt.setBill_isclearing(2);
//		bt.setBill_time(now);
//		bt.setBill_code(uuid);
//		bt.setAddress("");
//
//		Basedao bd = new Basedaoimpl();
//		boolean flag = bd.saveObject("insertone", bd);
//		JSONArray ja = JSONArray.fromObject(flag);
////		将数据交给前端
//		PrintWriter out = response.getWriter();
//		out.print(ja.toString());
		return null;

	}

}

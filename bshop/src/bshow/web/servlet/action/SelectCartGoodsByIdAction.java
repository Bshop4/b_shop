package bshow.web.servlet.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bshow.dao.Basedao;
import bshow.dao.impl.Basedaoimpl;
import bshow.pojo.Cart_table;
import bshow.web.servlet.core.Action;
import bshow.web.servlet.core.ActionForm;
import bshow.web.servlet.core.ActionForward;
import net.sf.json.JSONArray;

public class SelectCartGoodsByIdAction extends Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		String cart_id = request.getParameter("cart_id");
		int goods_id = Integer.parseInt(cart_id);
		Cart_table ct = new Cart_table();
		ct.setCart_id(goods_id);
		Basedao bd = new Basedaoimpl();
		List<Object> list = bd.select("selectById", ct);
//		System.out.println("ct");
		JSONArray ja = JSONArray.fromObject(list);
//		将数据交给前端
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(ja.toString());
		return null;
	}

}

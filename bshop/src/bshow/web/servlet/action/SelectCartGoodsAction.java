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

public class SelectCartGoodsAction extends Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
//		String cgoods_no = request.getParameter("cgoods_no");
		String account = request.getParameter("account");
//		System.out.println("cgoods_no");
//		System.out.println(cgoods_no);
		Cart_table ct = new Cart_table();
		ct.setAccount(account);
		Basedao bd = new Basedaoimpl();
		List<Object> list = bd.select("selectone", ct);
//		System.out.println("ct");
		JSONArray ja = JSONArray.fromObject(list);
//		将数据交给前端
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("UTF-8");
		out.print(ja.toString());
		return null;
	}

}

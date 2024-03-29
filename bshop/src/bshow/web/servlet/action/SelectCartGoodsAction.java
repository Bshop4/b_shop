package bshow.web.servlet.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
//		String account = request.getParameter("account");
		String account = "";
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if ("account".equals(cookie.getName())) {
				account = cookie.getValue();
			}
		}
		if (account == "") {
			account = (String) request.getSession().getAttribute("accouont");
		}
		Cart_table ct = new Cart_table();
		ct.setAccount(account);
		Basedao bd = new Basedaoimpl();
		List<Object> list = bd.select("selectone", ct);
		list.add(account);
		JSONArray ja = JSONArray.fromObject(list);
//		将数据交给前端
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(ja.toString());
		return null;
	}

}

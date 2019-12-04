package bshow.web.servlet.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bshow.dao.Basedao;
import bshow.dao.impl.Basedaoimpl;
import bshow.pojo.Receiver_table;
import bshow.web.servlet.core.Action;
import bshow.web.servlet.core.ActionForm;
import bshow.web.servlet.core.ActionForward;
import net.sf.json.JSONArray;

public class DefaultAddressAction extends Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		String account = request.getParameter("account");
//		System.out.println(account);
		Receiver_table rt = new Receiver_table();
		rt.setAccount(account);
//		rt.setIscheck(1);
		Basedao bd = new Basedaoimpl();
		List<Object> obj = bd.select("defaultAddress", rt);
		JSONArray ja = JSONArray.fromObject(obj);
		response.setCharacterEncoding("UTF-8");
//		将数据交给前端
		PrintWriter out = response.getWriter();
		out.print(ja.toString());
		return null;
	}

}

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

public class GetMyAddressAction extends Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		String ischeck = request.getParameter("msg");
//		System.out.println(ischeck);
		int ic = Integer.parseInt(ischeck);
		Receiver_table rt = new Receiver_table();
		rt.setIscheck(ic);
		Basedao bd = new Basedaoimpl();
		List<Object> list = bd.select("afterAddress", rt);
		JSONArray ja = JSONArray.fromObject(list);
//		将数据交给前端
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(ja.toString());
		return null;
	}

}

package bshow.web.servlet.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bshow.dao.MiddleTableDao;
import bshow.dao.impl.MiddleTableDaoImpl;
import bshow.web.servlet.core.Action;
import bshow.web.servlet.core.ActionForm;
import bshow.web.servlet.core.ActionForward;
import bshow.web.servlet.form.NavigationActionForm;
import net.sf.json.JSONArray;


public class NavigationAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		MiddleTableDao mtd=new MiddleTableDaoImpl();
		NavigationActionForm myform=(NavigationActionForm)form;
		int min=Integer.parseInt(myform.getMin());
		int max=Integer.parseInt(myform.getMax());
		List<String> list=mtd.selectNav(min, max);
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-Type", "application/json;charset=utf-8");
		JSONArray ja=JSONArray.fromObject(list);
		//将数据交给前端
		PrintWriter out=response.getWriter();
		out.print(URLDecoder.decode(ja.toString(), "utf-8"));
		return null;
	}

}

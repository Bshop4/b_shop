package bshow.web.servlet.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bshow.dao.FooterDao;
import bshow.dao.impl.FooterDaoImpl;
import bshow.web.servlet.core.Action;
import bshow.web.servlet.core.ActionForm;
import bshow.web.servlet.core.ActionForward;
import bshow.web.servlet.form.MyDeleteActionForm;

public class MyDeleteAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		MyDeleteActionForm myform=(MyDeleteActionForm)form;
		String goods_no=myform.getGoods_no();
		String footprint_time=myform.getFootprint_time();
		FooterDao dao=new FooterDaoImpl();
		boolean flag=dao.deleteFooter(goods_no,footprint_time);
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		out.print(String.valueOf(flag));
		return null;
	}

}

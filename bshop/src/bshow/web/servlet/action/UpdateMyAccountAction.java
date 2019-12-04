package bshow.web.servlet.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bshow.dao.AdminDao;
import bshow.dao.impl.AdminDaoImpl;
import bshow.web.servlet.core.Action;
import bshow.web.servlet.core.ActionForm;
import bshow.web.servlet.core.ActionForward;
import bshow.web.servlet.form.UpdateMyAccountForm;

public class UpdateMyAccountAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		UpdateMyAccountForm myform=(UpdateMyAccountForm)form;
		AdminDao dao=new AdminDaoImpl();
		boolean flag=dao.updateAccountByAdmin(myform);
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		if(flag){
			request.getSession().setAttribute("account", "aaa");
			String json="{\"code\":\"0\",\"msg\":\"修改成功\"}";
			out.print(json);
		}else{
			String json="{\"code\":\"1\",\"msg\":\"修改失败\"}";
			out.print(json);
		}
		return null;
	}

}

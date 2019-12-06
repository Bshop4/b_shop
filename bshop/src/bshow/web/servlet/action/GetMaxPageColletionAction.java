package bshow.web.servlet.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bshow.dao.CollectionDao;
import bshow.dao.CollectionDaoImpl;
import bshow.web.servlet.core.Action;
import bshow.web.servlet.core.ActionForm;
import bshow.web.servlet.core.ActionForward;

public class GetMaxPageColletionAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		
		String account = null;
		int page = 0;
		int pagesize = 0;
		
		if(request.getParameter("account") != null){
			account = request.getParameter("account");
		}
		if(request.getParameter("page") != null){
			page = Integer.parseInt(request.getParameter("page"));
		}
		if(request.getParameter("pagesize") != null){
			pagesize = Integer.parseInt(request.getParameter("pagesize"));
		}
		
		
		
		CollectionDao cd = new CollectionDaoImpl();
		int max = cd.getMaxPage(page, pagesize, account);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		
		pw.print(max);
		
		
		
		return null;
	}
	
	

}

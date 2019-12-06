package bshow.web.servlet.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bshow.dao.Basedao;
import bshow.dao.CollectionDao;
import bshow.dao.CollectionDaoImpl;
import bshow.dao.impl.Basedaoimpl;
import bshow.pojo.Collection_table;
import bshow.web.servlet.core.Action;
import bshow.web.servlet.core.ActionForm;
import bshow.web.servlet.core.ActionForward;
import bshow.web.servlet.form.SelectCollectionByAccountForm;
import net.sf.json.JSONArray;

public class SelectCollectionByAccountAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		
		SelectCollectionByAccountForm scbaf = (SelectCollectionByAccountForm)form;
		String account = scbaf.getAccount();
		
		int page=0;
		int pagesize=0;
		
		if(scbaf.getPage() != null){
			page = Integer.parseInt(scbaf.getPage());
		}
		if(scbaf.getPagesize() != null){
			pagesize = Integer.parseInt(scbaf.getPagesize());
		}
		
		CollectionDao cd = new CollectionDaoImpl();
		List<Collection_table> list = cd.queryAllColletionByAccount(page, pagesize, account);
//		System.out.println(list.size());
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		
		JSONArray ja = JSONArray.fromObject(list);
		pw.print(ja.toString());
		
		
		return null;
	}
	
	

}

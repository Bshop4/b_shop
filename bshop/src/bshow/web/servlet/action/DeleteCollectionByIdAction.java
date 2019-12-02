package bshow.web.servlet.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bshow.dao.Basedao;
import bshow.dao.impl.Basedaoimpl;
import bshow.pojo.Collection_table;
import bshow.web.servlet.core.Action;
import bshow.web.servlet.core.ActionForm;
import bshow.web.servlet.core.ActionForward;
import bshow.web.servlet.form.DeleteCollectionByIdForm;
import net.sf.json.JSONArray;

public class DeleteCollectionByIdAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		
		DeleteCollectionByIdForm dcbif = (DeleteCollectionByIdForm)form;
		String account = dcbif.getAccount();
		String myid = dcbif.getMyid();
		
		Basedao bd = new Basedaoimpl();
		Collection_table ct = new Collection_table();
		ct.setCid(Integer.parseInt(myid));
		boolean f = bd.deleteObject("deleteCollectionById", ct);
		if(f){
			Collection_table ct1 = new Collection_table();
			ct1.setAccount(account);
			List<Object> list = bd.select("selectCollectionByAccount", ct1);
			response.setCharacterEncoding("UTF-8");
			PrintWriter pw = response.getWriter();
			JSONArray ja = JSONArray.fromObject(list);
			pw.print(ja.toString());
		}
		
		
		return null;
	}
	
	

}

package bshow.web.servlet.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bshow.dao.Basedao;
import bshow.dao.impl.Basedaoimpl;
import bshow.pojo.Collection_table;
import bshow.web.servlet.core.Action;
import bshow.web.servlet.core.ActionForm;
import bshow.web.servlet.core.ActionForward;
import bshow.web.servlet.form.DeleteCollectionForm;
import net.sf.json.JSONObject;

public class DeleteCollectionAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		
		DeleteCollectionForm dcf = (DeleteCollectionForm)form;
		String msg = dcf.getMsg();
		JSONObject obj = JSONObject.fromObject(msg);
		String goodsno = obj.getString("goodsno");
		String account = obj.getString("account");
		
		Collection_table ct = new Collection_table();
		ct.setAccount(account);
		ct.setGoods_no(goodsno);
		Basedao bd = new Basedaoimpl();
		boolean f = bd.deleteObject("deleteCollection", ct);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		if(f){
			pw.print("1");
		}
		
		
		
		return null;
	}
	
	

}

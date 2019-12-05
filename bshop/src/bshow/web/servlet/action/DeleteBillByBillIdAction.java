package bshow.web.servlet.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bshow.dao.Basedao;
import bshow.dao.impl.Basedaoimpl;
import bshow.pojo.Bill_table;
import bshow.web.servlet.core.Action;
import bshow.web.servlet.core.ActionForm;
import bshow.web.servlet.core.ActionForward;

public class DeleteBillByBillIdAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		
		String billid = request.getParameter("billid");
		int id = Integer.parseInt(billid);
		
		Basedao bd = new Basedaoimpl();
		
		Bill_table bt = new Bill_table();
		bt.setBill_id(id);
//		System.out.println(bt);
		boolean f = bd.deleteObject("deleteBillById", bt);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		if(f){
			pw.print("取消成功");
		}
		
		
		
		
		return null;
	}
	
	

}

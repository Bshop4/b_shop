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

public class UpdateBillClearingAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		
		String billcode = request.getParameter("billcode");
		
		Bill_table bt = new Bill_table();
		bt.setBill_code(billcode);
		bt.setBill_isclearing(1);
		
		Basedao bd = new Basedaoimpl();
		
		boolean f = bd.updataObject("updateClearing", bt);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		
		if(f){
			pw.print("1");
		}else{
			pw.print("0");
		}
		
		
		return null;
	}
	
	

}

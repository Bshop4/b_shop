package bshow.web.servlet.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bshow.dao.Basedao;
import bshow.dao.impl.Basedaoimpl;
import bshow.pojo.Receiver_table;
import bshow.web.servlet.core.Action;
import bshow.web.servlet.core.ActionForm;
import bshow.web.servlet.core.ActionForward;
import bshow.web.servlet.form.DeleteAddressByRidForm;
import net.sf.json.JSONObject;

public class DeleteAddressByRidAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		DeleteAddressByRidForm dabrf = (DeleteAddressByRidForm)form;
		String rid = dabrf.getMsg();
		
		Receiver_table rt = new Receiver_table();
		rt.setRid(Integer.parseInt(rid));
		Basedao bd = new Basedaoimpl();
		boolean f = bd.deleteObject("deleteAddress", rt);
		PrintWriter pw = response.getWriter();
		response.setCharacterEncoding("UTF-8");
		if(f){
			pw.print("1");			
		}
		
		return null;
	}

}

package bshow.web.servlet.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bshow.dao.Basedao;
import bshow.dao.impl.Basedaoimpl;
import bshow.pojo.Receiver_table;
import bshow.web.servlet.core.Action;
import bshow.web.servlet.core.ActionForm;
import bshow.web.servlet.core.ActionForward;
import bshow.web.servlet.form.EditModalForm;
import net.sf.json.JSONObject;

public class EditModalAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		
		EditModalForm emf = (EditModalForm)form;
		String eid = emf.getEid();
		
		Receiver_table rt = new Receiver_table();
		rt.setRid(Integer.parseInt(eid));
		
		Basedao bd = new Basedaoimpl();
		List<Object> list = bd.select("selectById", rt);
		Receiver_table rt1 = (Receiver_table)list.get(0);
		JSONObject jo = JSONObject.fromObject(rt1);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.print(jo.toString());
		
		
		
		return null;
	}
	
	

}

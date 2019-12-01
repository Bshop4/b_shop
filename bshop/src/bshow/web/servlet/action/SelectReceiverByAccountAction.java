package bshow.web.servlet.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import bshow.web.servlet.form.SelectReceiverByAccountForm;
import net.sf.json.JSONArray;

public class SelectReceiverByAccountAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		
		SelectReceiverByAccountForm sbaf = (SelectReceiverByAccountForm)form;
		String account = sbaf.getAccount();
		Basedao bd = new Basedaoimpl();
		
		Receiver_table rt = new Receiver_table();
		rt.setAccount(account);
		rt.setAddress("");
		rt.setPostal("");
		rt.setReceiver("");
		rt.setTelephone("");
		rt.setIscheck(0);
		
		List<Object> list = bd.select("selectReceiverByAccount", rt);
		
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		JSONArray ja = JSONArray.fromObject(list);
		pw.print(ja.toString());
		
		return null;
	}

}

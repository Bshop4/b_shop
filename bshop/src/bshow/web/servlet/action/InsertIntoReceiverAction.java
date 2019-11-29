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
import bshow.web.servlet.form.InsertIntoReceiverForm;
import net.sf.json.JSONObject;

public class InsertIntoReceiverAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		
		InsertIntoReceiverForm iir = (InsertIntoReceiverForm)form;
		String msg = iir.getMsg();
		JSONObject obj = JSONObject.fromObject(msg);
		String name = obj.getString("name");
		String iphone = obj.getString("iphone");
		String postcode = obj.getString("postcode");
		String AllAddress = obj.getString("AllAddress");
		String account = obj.getString("account");
		
		Receiver_table rt = new Receiver_table();
		rt.setAccount(account);
		rt.setAddress(AllAddress);
		rt.setPostal(postcode);
		rt.setReceiver(name);
		rt.setTelephone(iphone);
		rt.setIscheck(0);
//		System.out.println(rt);
		
		

		Basedao bd = new Basedaoimpl();
		bd.saveObject("insertIntoReceiver", rt);
		
		List<Object> lists = bd.select("selectReceiverByAll", rt);
		Receiver_table rts = (Receiver_table)lists.get(0);
		PrintWriter pw = response.getWriter();
		pw.print(rts.getRid());
		
		return null;
	}
	
	

}

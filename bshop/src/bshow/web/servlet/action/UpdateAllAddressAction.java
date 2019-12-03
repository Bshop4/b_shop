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
import bshow.web.servlet.form.UpdateAllAddressForm;
import net.sf.json.JSONObject;

public class UpdateAllAddressAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		
		UpdateAllAddressForm uaaf = (UpdateAllAddressForm)form;
		String msg = uaaf.getMsg();
		JSONObject obj = JSONObject.fromObject(msg);
		/**
		 * "name" : name,
		"iphone" : iphone,
		"postcode" : postcode,
		"AllAddress" : AllAddress,
		"account" : account,
		"eid" : eid,
		 */
		
		String name = obj.getString("name");
		String iphone = obj.getString("iphone");
		String postcode = obj.getString("postcode");
		String AllAddress = obj.getString("AllAddress");
		String account = obj.getString("account");
		String eid = obj.getString("eid");
		
		Receiver_table rt = new Receiver_table();
		rt.setAccount(account);
		rt.setAddress(AllAddress);
		rt.setPostal(postcode);
		rt.setRid(Integer.parseInt(eid));
		rt.setReceiver(name);
		rt.setTelephone(iphone);
		
//		System.out.println(rt);
		Basedao bd = new Basedaoimpl();
		boolean f = bd.updataObject("updateAllAddress", rt);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		if(f){
			pw.print("1");
		}
		
		
		return null;
	}
	
	

}

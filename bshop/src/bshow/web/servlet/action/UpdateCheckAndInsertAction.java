package bshow.web.servlet.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bshow.dao.Basedao;
import bshow.dao.impl.Basedaoimpl;
import bshow.pojo.Personinfo_table;
import bshow.pojo.Receiver_table;
import bshow.web.servlet.core.Action;
import bshow.web.servlet.core.ActionForm;
import bshow.web.servlet.core.ActionForward;
import bshow.web.servlet.form.UpdateCheckAndInsertForm;
import net.sf.json.JSONObject;

public class UpdateCheckAndInsertAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		
		/**
		 * "name" : name,
    		"iphone" : iphone,
    		"postcode" : postcode,
    		"address" : address,
    		"rid" : rid,
    		"account" : account
		 */
		UpdateCheckAndInsertForm ucaif = (UpdateCheckAndInsertForm)form;
		String msg = ucaif.getMsg();
		JSONObject obj = JSONObject.fromObject(msg);
//		System.out.println(obj.getString("name"));
		String name = obj.getString("name");
		String iphone = obj.getString("iphone");
		String postcode = obj.getString("postcode");
		String address = obj.getString("address");
		int rid = Integer.parseInt(obj.getString("rid"));
		String account = obj.getString("account");
		
		Receiver_table rt = new Receiver_table();
		rt.setAccount(account);
		rt.setAddress(address);
		rt.setIscheck(1);
		rt.setPostal(postcode);
		rt.setReceiver(name);
		rt.setRid(rid);
		rt.setTelephone(iphone);

		Basedao bd = new Basedaoimpl();
		boolean f = bd.updataObject("updateIsCheck", rt);
		if(f){
			List<Object> list = bd.select("selectReceiverByAccount", rt);
			for (Object object : list) {
				if(((Receiver_table)object).getRid() != rid){
					((Receiver_table)object).setIscheck(0);
				}
			}
			for (Object object : list) {
				bd.updataObject("updateIsCheck", (Receiver_table)object);
			}
			
			Personinfo_table pt = new Personinfo_table();
			pt.setAccount(account);
			pt.setAddress(address);
			boolean ff = bd.updataObject("updateAddress", pt);
			
		}
		
		
		return null;
	}

}

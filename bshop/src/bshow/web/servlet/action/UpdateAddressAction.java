package bshow.web.servlet.action;

import java.io.IOException;
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

public class UpdateAddressAction extends Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		// 从cart_account.js传过来的
		String name = request.getParameter("name");
		String iphone = request.getParameter("iphone");
		String postcode = request.getParameter("postcode");
		String AllAddress = request.getParameter("AllAddress");
		String account = request.getParameter("account");
		String myAllAdress = name + "" + iphone + "" + postcode + "" + AllAddress;
//		System.out.println(myAllAdress);
		Basedao bd = new Basedaoimpl();
		Receiver_table rt = new Receiver_table();
		rt.setAccount(account);
		List<Object> list = bd.select("defaultAddress", rt);
		for (Object object : list) {
			Receiver_table obj = (Receiver_table) object;
			obj.setIscheck(0);
//			System.out.println(obj);
			bd.updataObject("updateaddressReceiver2", obj);
		}
		Receiver_table rt1 = new Receiver_table();
		rt1.setTelephone(iphone);
		rt1.setAccount(account);
		rt1.setAddress(AllAddress);
		rt1.setPostal(postcode);
		rt1.setIscheck(2);
		bd.updataObject("updateaddressReceiver", rt1);
		return null;
	}

}

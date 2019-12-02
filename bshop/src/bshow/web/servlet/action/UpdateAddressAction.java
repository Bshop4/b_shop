package bshow.web.servlet.action;

import java.io.IOException;

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
		String name = request.getParameter("name");
		String iphone = request.getParameter("iphone");
		String postcode = request.getParameter("postcode");
		String AllAddress = request.getParameter("AllAddress");
		String myAllAdress = name + "" + iphone + "" + postcode + "" + AllAddress;
		System.out.println(myAllAdress);
		Receiver_table rt = new Receiver_table();
		rt.setTelephone(iphone);
		Basedao bd = new Basedaoimpl();
		bd.updataObject("updateaddressReceiver", rt);
		System.out.println(1);
		return null;

	}

}

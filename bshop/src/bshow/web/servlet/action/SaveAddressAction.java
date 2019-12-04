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
import net.sf.json.JSONArray;

public class SaveAddressAction extends Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String iphone = request.getParameter("iphone");
		String postcode = request.getParameter("postcode");
		String AllAddress = request.getParameter("AllAddress");
		String myAllAdress = name + "" + iphone + "" + postcode + "" + AllAddress;
//		System.out.println(myAllAdress);
		Receiver_table rt = new Receiver_table();
		rt.setReceiver(name);
		rt.setTelephone(iphone);
		rt.setPostal(postcode);
		rt.setAddress(AllAddress);
		rt.setAccount("pyla1");
		rt.setIscheck(0);
		Basedao bd = new Basedaoimpl();
		boolean flag = bd.saveObject("insertaddressReceiver", rt);
//		System.out.println(flag);
		JSONArray ja = JSONArray.fromObject(flag);
//		将数据交给前端
		PrintWriter out = response.getWriter();
		out.print(ja.toString());
		return null;
	}

}

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
import net.sf.json.JSONArray;

public class SaveAddressAction extends Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String iphone = request.getParameter("iphone");
		String postcode = request.getParameter("postcode");
		String AllAddress = request.getParameter("AllAddress");
		System.out.println(name);
		System.out.println(iphone);
		System.out.println(postcode);
		System.out.println(AllAddress);
		String myAllAdress = name + "" + iphone + "" + postcode + "" + AllAddress;
		System.out.println(myAllAdress);
		Bill_table bt = new Bill_table();
		bt.setAddress(myAllAdress);
		Basedao bd = new Basedaoimpl();
		boolean flag = bd.saveObject("insertaddressBill", bt);
		System.out.println(flag);
		JSONArray ja = JSONArray.fromObject(flag);
//		将数据交给前端
		PrintWriter out = response.getWriter();
		out.print(ja.toString());
		return null;
	}

}

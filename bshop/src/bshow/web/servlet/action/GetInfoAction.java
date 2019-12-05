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
import bshow.pojo.Personinfo_table;
import bshow.web.servlet.core.Action;
import bshow.web.servlet.core.ActionForm;
import bshow.web.servlet.core.ActionForward;
import bshow.web.servlet.form.GetInfoForm;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GetInfoAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		
		GetInfoForm gif = (GetInfoForm)form;
		String account = gif.getAccount();
		Personinfo_table pt = new Personinfo_table();
		pt.setAccount(account);
		Basedao bd = new Basedaoimpl();
		List<Object> list = bd.select("selectByAccount", pt);
//		if()
		Personinfo_table pt1 = (Personinfo_table)list.get(0);
//		System.out.println(pt1);
//		int person_id = pt1.getPersonInfo_id();
//		System.out.println(person_id);
		List<Object> list1 = new ArrayList<Object>();
		list1.add(pt1.getPersonInfo_id());//0
		list1.add(pt1.getNickname());//1
		list1.add(pt1.getAccount());//2
		list1.add(new String(pt1.getPhoto()));//3
		list1.add(pt1.getAddress());//4
		list1.add(pt1.getSex());//5
		list1.add(pt1.getBirthday());//6
//		list1.add(pt1.getTel());//7
//		list1.add(pt1.getPostcode());//8
//		System.out.println(new String(pt1.getPhoto()));
		response.setCharacterEncoding("UTF-8");
//		for (Object object : list1) {
//			System.out.println(object);
//		}
		JSONArray jo = JSONArray.fromObject(list1);
		PrintWriter pw = response.getWriter();
		pw.print(jo.toString());
		
		return null;
	}
	
	

}

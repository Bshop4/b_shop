package bshow.web.servlet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bshow.dao.Basedao;
import bshow.dao.impl.Basedaoimpl;
import bshow.pojo.Personinfo_table;
import bshow.web.servlet.core.Action;
import bshow.web.servlet.core.ActionForm;
import bshow.web.servlet.core.ActionForward;
import bshow.web.servlet.form.UpdatePersonInfoForm;
import net.sf.json.JSONObject;

public class UpdatePersonInfoAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		
		UpdatePersonInfoForm pt = (UpdatePersonInfoForm)form;
		String msg = pt.getMsg();
		JSONObject obj = JSONObject.fromObject(msg);
//		System.out.println(obj);
		String pid = obj.getString("pid");
		String imgPhoto1 = obj.getString("imgPhoto1");
		String account1 = obj.getString("account1");
		String nickName1 = obj.getString("nickName1");
		String sex1 = obj.getString("sex1");
		String date1 = obj.getString("date1");
		String myAddress1 = obj.getString("myAddress1");
		
		Personinfo_table pt1 = new Personinfo_table();
		pt1.setPersonInfo_id(Integer.parseInt(pid));
		pt1.setAccount(account1);
		pt1.setAddress(myAddress1);
		pt1.setBirthday(date1);
		pt1.setPhoto(imgPhoto1.getBytes());
		pt1.setSex(sex1);
		pt1.setNickname(nickName1);
		System.out.println(pt1);
		
		Basedao bd = new Basedaoimpl();
		bd.updataObject("updatePersonInfo", pt1);
		
		
		
		
		
		
		return null;
	}

}

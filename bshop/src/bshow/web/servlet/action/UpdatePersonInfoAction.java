package bshow.web.servlet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		System.out.println(obj);
		
		
		
		
		
		return null;
	}

}

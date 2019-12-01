package bshow.web.servlet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bshow.web.servlet.core.Action;
import bshow.web.servlet.core.ActionForm;
import bshow.web.servlet.core.ActionForward;
import bshow.web.servlet.form.XsyInsertBillForm;
import net.sf.json.JSONArray;

public class XsyInsertBillAction extends Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		XsyInsertBillForm xb = (XsyInsertBillForm) form;
		String msg = xb.getMsg();
		JSONArray obj = JSONArray.fromObject(msg);
		System.out.println(obj);
		return null;
	}

}

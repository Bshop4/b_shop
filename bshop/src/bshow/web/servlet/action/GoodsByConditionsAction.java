package bshow.web.servlet.action;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bshow.dao.Basedao;
import bshow.dao.impl.Basedaoimpl;
import bshow.db.DBhelper;
import bshow.pojo.Middle_table;
import bshow.web.servlet.core.Action;
import bshow.web.servlet.core.ActionForm;
import bshow.web.servlet.core.ActionForward;
import bshow.web.servlet.form.GoodsByConditionsActionForm;

public class GoodsByConditionsAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		Basedao bd=new Basedaoimpl();
		GoodsByConditionsActionForm myform=(GoodsByConditionsActionForm)form;
//		//拿到请求所有的参数
//		Map<String, String[]> mymap=request.getParameterMap();
		bd.selectGoodsByConditions(myform);
		if(myform!=null){
			
		}
		return null;
	}

}

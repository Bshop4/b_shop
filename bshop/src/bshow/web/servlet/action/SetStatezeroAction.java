package bshow.web.servlet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bshow.dao.Basedao;
import bshow.dao.impl.Basedaoimpl;
import bshow.pojo.Cart_table;
import bshow.web.servlet.core.Action;
import bshow.web.servlet.core.ActionForm;
import bshow.web.servlet.core.ActionForward;

public class SetStatezeroAction extends Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		Cart_table ct = new Cart_table();
		Basedao bd = new Basedaoimpl();
		boolean flag = bd.updataObject("updateStatezero", ct);
		System.out.println(flag);
		return null;
	}

}

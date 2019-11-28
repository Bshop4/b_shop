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

public class DeleteCartGoodsAction extends Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		String cart_ids = request.getParameter("cart_id");
		// 转为int类型
		int cart_id = Integer.parseInt(cart_ids);
		System.out.println(cart_id);
		Cart_table ct = new Cart_table();
		ct.setCart_id(cart_id);
		Basedao bd = new Basedaoimpl();
		return null;
	}

}

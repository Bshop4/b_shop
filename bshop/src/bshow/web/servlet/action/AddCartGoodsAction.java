package bshow.web.servlet.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import bshow.dao.Basedao;
import bshow.dao.impl.Basedaoimpl;
import bshow.pojo.Cart_table;
import bshow.test.Test;
import bshow.web.servlet.core.Action;
import bshow.web.servlet.core.ActionForm;
import bshow.web.servlet.core.ActionForward;
import net.sf.json.JSONArray;

public class AddCartGoodsAction extends Action {
	private static final Logger log = Logger.getLogger(Test.class);
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		String cart_ids = request.getParameter("cart_id");
		// 转int
		int cart_id = Integer.parseInt(cart_ids);
//		System.out.println(cart_id);
		Cart_table ct = new Cart_table();
		ct.setCart_id(cart_id);
		Basedao bd = new Basedaoimpl();
		boolean flag = bd.updataObject("addone", ct);
		if(flag){
			log.info("加入购物车成功");
		}else{
			log.info("加入购物车失败");
		}
		JSONArray ja = JSONArray.fromObject(flag);
//		将数据交给前端
		PrintWriter out = response.getWriter();
		out.print(ja.toString());
		return null;
	}

}

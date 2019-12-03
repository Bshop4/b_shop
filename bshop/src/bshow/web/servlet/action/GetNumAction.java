package bshow.web.servlet.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bshow.dao.Basedao;
import bshow.dao.impl.Basedaoimpl;
import bshow.pojo.Repertory_table;
import bshow.web.servlet.core.Action;
import bshow.web.servlet.core.ActionForm;
import bshow.web.servlet.core.ActionForward;
import bshow.web.servlet.form.GetNumForm;
import net.sf.json.JSONObject;

public class GetNumAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		
		GetNumForm gnf = (GetNumForm)form;
		String msg = gnf.getMsg();
		JSONObject obj = JSONObject.fromObject(msg);
		String goodsno = obj.getString("goodsno");
		String color = obj.getString("color");
		String size = obj.getString("size");
		
		Repertory_table rt = new Repertory_table();
		rt.setGoods_no(goodsno);
		rt.setRepertory_size(size);
		rt.setRepertory_color(color);
		Basedao bd = new Basedaoimpl();
		List<Object> list = bd.select("selectNum", rt);
		int num = ((Repertory_table)list.get(0)).getRepertory_number();
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.print(num);
		
		
		return null;
	}
	
	

}

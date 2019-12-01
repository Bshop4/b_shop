package bshow.web.servlet.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bshow.dao.Basedao;
import bshow.dao.impl.Basedaoimpl;
import bshow.pojo.Collection_table;
import bshow.pojo.Goods_table;
import bshow.web.servlet.core.Action;
import bshow.web.servlet.core.ActionForm;
import bshow.web.servlet.core.ActionForward;
import bshow.web.servlet.form.InsertCollectionForm;
import net.sf.json.JSONObject;

public class InsertCollectionAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		
		InsertCollectionForm icf = (InsertCollectionForm)form;
		String msg = icf.getMsg();
		JSONObject obj = JSONObject.fromObject(msg);
		String goodsno = obj.getString("goodsno");
		String account = obj.getString("account");
		
		Goods_table gt = new Goods_table();
		gt.setGoods_no(goodsno);
		Basedao bd = new Basedaoimpl();
		List<Object> list = bd.select("selectAllByGoodsNo", gt);
//		System.out.println(list.get(0));
		String photo = ((Goods_table)list.get(0)).getGoods_photo();
		String goodsname = ((Goods_table)list.get(0)).getGoods_name();
		
		Collection_table ct = new Collection_table();
		ct.setAccount(account);
		ct.setGoods_name(goodsname);
		ct.setGoods_photo(photo);
		ct.setGoods_no(goodsno);
		ct.setState(0);
		boolean f = bd.saveObject("insertCollection", ct);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw =  response.getWriter();
		if(f){
			pw.print("1");
		}
		
		
		return null;
	}
	
	

}

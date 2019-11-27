package bshow.web.servlet.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bshow.dao.Basedao;
import bshow.dao.impl.Basedaoimpl;
import bshow.pojo.Goods_table;
import bshow.pojo.Middle_table;
import bshow.web.servlet.core.Action;
import bshow.web.servlet.core.ActionForm;
import bshow.web.servlet.core.ActionForward;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SelectGoodsNoAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String goodsno = request.getParameter("goodsno");
		//System.out.println("goodsno"+goodsno);
		Goods_table gt = new Goods_table();
		gt.setGoods_no(goodsno);
		Basedao ba = new Basedaoimpl();
		List<Object> list =  ba.select("selectAllByGoodsNo", gt);
		
		Middle_table mt  =new Middle_table();
		mt.setGoods_no(goodsno);
		List<Object> listb = ba.select("selectAllSm", mt);
		
		String allimgurl = new String(((Middle_table)listb.get(0)).getGoods_smallphoto());
		String[] strArr = allimgurl.split(",");
		//System.out.println(strArr.length);
		
		List<Object> listbb = new ArrayList<Object>();
		for (int i = 0; i < strArr.length; i++) {
			listbb.add(strArr[i]);
		}
		
		Goods_table gt1 = (Goods_table) list.get(0);
//		System.out.println(new String(gt1.getGoods_explainphoto(),"utf-8"));
		System.out.println(new String(gt1.getGoods_explainphoto()));
		
		listbb.add(gt1);
		
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-Type", "application/json;charset=utf-8");
//		for (Object object : listbb) {
//			System.out.println(object);
//		}
		
		JSONArray ja = JSONArray.fromObject(listbb);
		PrintWriter out=response.getWriter();
//		out.print(URLDecoder.decode(ja.toString(),"UTF-8"));
		out.print(ja.toString());
		
		return null;
	}

}






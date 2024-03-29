package bshow.web.servlet.action;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bshow.dao.Basedao;
import bshow.dao.impl.Basedaoimpl;
import bshow.pojo.Collection_table;
import bshow.pojo.Goods_table;
import bshow.pojo.Middle_table;
import bshow.pojo.Repertory_table;
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
		String goodsno = null;
		if(request.getParameter("goodsno") != null){
			goodsno = request.getParameter("goodsno");
		}
		String account = "";
		String token = "";
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if("account".equals(cookie.getName())){
				account = cookie.getValue();
			}
			if("token".equals(cookie.getName())){
				token = cookie.getValue();
			}
		}
		if(account == ""){
			account = (String)request.getSession().getAttribute("accouont");
		}
		if(token == ""){
			token = (String)request.getSession().getAttribute("token");
		}
		
		
		Goods_table gt = new Goods_table();
		gt.setGoods_no(goodsno);
		Basedao ba = new Basedaoimpl();
		
		List<Object> list =  ba.select("selectAllByGoodsNo", gt);
		
		Middle_table mt  =new Middle_table();
		mt.setGoods_no(goodsno);
		List<Object> listb = ba.select("selectAllSm", mt);
		String allimgurl = "";
		if(listb.size() != 0){
			allimgurl = new String(((Middle_table)listb.get(0)).getGoods_smallphoto());
		}
		String[] strArr = allimgurl.split(",");
		List<Object> listbb = new ArrayList<Object>();
		
		if(strArr.length > 4){
			for (int i = 0; i < 4; i++) {
				listbb.add(strArr[i]);
			}
		}else if(strArr.length <= 4){
			for (int i = 0; i < strArr.length; i++) {
				listbb.add(strArr[i]);
			}
		}
		
		Goods_table gt1 = null;
		if(list.size() != 0){
			gt1 = (Goods_table) list.get(0);
		}
//		System.out.println(gt1.getGoods_color());
//		System.out.println(gt1.getGoods_size());
		String colorstr = gt1.getGoods_color();
		String[] colorarr = colorstr.split(",");
		String color = colorarr[0];
		String sizestr = gt1.getGoods_size();
		String[] sizearr = sizestr.split(",");
		String size = sizearr[0];
		Repertory_table rt = new Repertory_table();
		rt.setGoods_no(goodsno);
		rt.setRepertory_color(color);
		rt.setRepertory_size(size);
		List<Object> listrt =  ba.select("selectNum", rt);
		Repertory_table rt1 = null;
		if(listrt.size()>0){
			rt1 = (Repertory_table)listrt.get(0);
		}
		int num = rt1.getRepertory_number();
		
		String exp = new String(gt1.getGoods_explainphoto());
		listbb.add(exp);
		
		Collection_table ct = new Collection_table();
		ct.setAccount(account);
		ct.setGoods_no(goodsno);
		List<Object> list12 = ba.select("selectColloction", ct);
		String str = "";
		if(list12.size() == 0){
			str = "0";
		}else{
			str = "1";
		}
		listbb.add(num);//-5
		listbb.add(account);//-4
		listbb.add(token);//-3
		listbb.add(str);//-2
		listbb.add(gt1);//-1
		
		
		
		response.setCharacterEncoding("UTF-8");
		JSONArray ja = JSONArray.fromObject(listbb);
		PrintWriter out= response.getWriter();
		out.print(ja.toString());
		return null;
	}

}






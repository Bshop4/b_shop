package bshow.web.servlet.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bshow.dao.Basedao;
import bshow.dao.impl.Basedaoimpl;
import bshow.pojo.Middle_table;
import bshow.web.servlet.core.Action;
import bshow.web.servlet.core.ActionForm;
import bshow.web.servlet.core.ActionForward;
import bshow.web.servlet.form.SelectCartGoodsForm;
import bshow.web.servlet.form.SelectColorForm;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SelectColortAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		
		String goods_no = "231914979320863";
		Middle_table mt = new Middle_table();
		mt.setGoods_no(goods_no);
		Basedao bd = new Basedaoimpl();
		List<Object> list = bd.select("selectAllSm", mt);
		System.out.println(list.size());
		for (Object object : list) {
			System.out.println(new String(((Middle_table)object).getGoods_smallphoto()));
		}
		
//		SelectColorForm scg = (SelectColorForm)form;
//		String msg = scg.getMsg();
//		JSONObject obj = JSONObject.fromObject(msg);
//		String goods_no = obj.getString("goods_no");
//		String color = obj.getString("color");
//		
//		Middle_table mt = new Middle_table();
//		mt.setGoods_no(goods_no);
//		mt.setMiddle_color(color);
//		
//		Basedao bd = new Basedaoimpl();
//		List<Object> list = bd.select("selectColorAndNo", mt);
//		for (Object object : list) {
//			System.out.println((Middle_table)object);
//		}
//		
//		List<String> listcolorphoto = new ArrayList<String>();
//		if(list.size()>=4){
//			for (int i = 0; i < 4; i++) {
//				String mphoto = new String(((Middle_table)list.get(i)).getGoods_smallphoto());
//				listcolorphoto.add(mphoto);
//			}
//			
//		}else if(list.size()>=0 && list.size() < 4){
//			for (int i = 0; i < list.size(); i++) {
//				String mphoto = new String(((Middle_table)list.get(i)).getGoods_smallphoto());
//				listcolorphoto.add(mphoto);
//			}
//		}
//		for (String string : listcolorphoto) {
//			System.out.println(string);
//		}
		
//		request.setCharacterEncoding("UTF-8");
//		PrintWriter pw = response.getWriter();
//		JSONArray ja = JSONArray.fromObject(listcolorphoto);
//		pw.print(ja.toString());
		
		return null;
	}
	
	

}

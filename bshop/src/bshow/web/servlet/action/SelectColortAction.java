package bshow.web.servlet.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bshow.dao.Basedao;
import bshow.dao.impl.Basedaoimpl;
import bshow.pojo.Middle_table;
import bshow.pojo.Repertory_table;
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
		
		SelectColorForm scg = (SelectColorForm)form;
		String msg = scg.getMsg();
		JSONObject obj = JSONObject.fromObject(msg);
		String goods_no = obj.getString("goods_no");
		String color = obj.getString("color");
		String size = obj.getString("size");
		
		Middle_table mt = new Middle_table();
		mt.setGoods_no(goods_no);
		mt.setMiddle_color(color);
		
		Basedao bd = new Basedaoimpl();
		List<Object> list = bd.select("selectColorAndNo", mt);
		Set<String> hs = new HashSet<String>();
		for (Object object : list) {
			hs.add(new String(((Middle_table)object).getGoods_smallphoto()));
		}
		List<String> list1 = new ArrayList<String>(hs);
		List<String> list2 = new ArrayList<String>();
		List<String> listStr = new ArrayList<String>();
		for (String string : list1) {
			if(string.contains(",")){
				String[] strArr = string.split(",");
				for (String string2 : strArr) {
					list2.add(string2);
				}
				
			}else{
				list2.add(string);
			}
		}
//		for (String string : list2) {
//			System.out.println("ls2 " + string);
//		}
		
		
		if(list2.size() >= 4){
			for (int i = 0; i < 4; i++) {
				listStr.add(list2.get(i));
			}
		}else if(list2.size() >=1 && list2.size() < 4){
			for (int i = 0; i < list2.size(); i++) {
				listStr.add(list2.get(i));
			}
		}
		
		Repertory_table rt = new Repertory_table();
		rt.setGoods_no(goods_no);
		rt.setRepertory_color(color);
		rt.setRepertory_size(size);
		List<Object> listnum = bd.select("selectNum", rt);
		int num = ((Repertory_table)listnum.get(0)).getRepertory_number();
		
		listStr.add(String.valueOf(num));
		
		request.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		JSONArray ja = JSONArray.fromObject(listStr);
		pw.print(ja.toString());
		
		return null;
	}
	
	

}

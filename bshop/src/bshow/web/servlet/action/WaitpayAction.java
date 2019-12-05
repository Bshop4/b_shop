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
import bshow.pojo.Bill_table;
import bshow.web.servlet.core.Action;
import bshow.web.servlet.core.ActionForm;
import bshow.web.servlet.core.ActionForward;
import net.sf.json.JSONArray;

public class WaitpayAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		
		String account = request.getParameter("account");
		
		Bill_table bt = new Bill_table();
		bt.setAccount(account);
		bt.setBill_isclearing(0);
		
		Basedao bd = new Basedaoimpl();
		List<Object> list = bd.select("selectone", bt);
//		System.out.println(list.size());
		List<Object> listo = new ArrayList<Object>();
		if(list.size() == 1){
			
			Bill_table bt1 = (Bill_table)list.get(0);
			if(bt1.getGoods_name().contains(",")){
				String[] nameArr = bt1.getGoods_name().split(",");
				String[] priceArr = bt1.getGoods_price().split(",");
				String[] photoArr = bt1.getGoods_photo().split(",");
				String[] numArr = bt1.getCart_number().split(",");
				String[] colorArr = bt1.getGoods_color().split(",");//待定
//				String[] sizeArr = bt1.getGoods_size().split(",");//待定
				for(int i=0; i < nameArr.length ; i++){
					Bill_table b = new Bill_table();
					b.setBill_code(bt1.getBill_code());//订单号
					b.setGoods_price(priceArr[i]);//单价
					b.setGoods_name(nameArr[i]);
					b.setCart_number(numArr[i]);
					b.setGoods_photo(photoArr[i]);
					b.setAddress(bt1.getAddress());
					b.setGoods_color(colorArr[i]);
					listo.add(b);
				}
			}
			
		}
		
		
		for (Object object : listo) {
			System.out.println(object);
		}
		
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter pw = response.getWriter();
		
		JSONArray ja = JSONArray.fromObject(listo);
		pw.print(ja.toString());
		
		
		
		
		
		
		
		
		
		return null;
	}
	
	

}

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
		List<Object> list = bd.select("selecttwo", bt);
//		List<Object> listbill = new ArrayList<Object>();
		List<Object> listbills = new ArrayList<Object>();
		int count=list.size();
		for (int i = 0; i < count; i++) {
			StringBuffer sbill=new StringBuffer();
			Bill_table bill_1=(Bill_table)list.get(i);
			sbill.append("{");
			//订单号：
			sbill.append("\"billcode\":");
			sbill.append("\"");
			sbill.append(bill_1.getBill_code());
			sbill.append("\"");
			sbill.append(",");
			//地址
			sbill.append("\"address\":");
			sbill.append("\"");
			sbill.append(bill_1.getAddress());
			sbill.append("\"");
			sbill.append(",");
			//时间
			sbill.append("\"time\":");
			sbill.append("\"");
			sbill.append(bill_1.getBill_time());
			sbill.append("\"");
			sbill.append(",");
			//是否付清
			sbill.append("\"isclearing\":");
			sbill.append("\"");
			sbill.append(bill_1.getBill_isclearing());
			sbill.append("\"");
			sbill.append(",");
			//总价
			sbill.append("\"allprice\":");
			sbill.append("\"");
			sbill.append(bill_1.getAllprice());
			sbill.append("\"");
			sbill.append(",");
			//商品数组
			sbill.append("\"goods\":");
			sbill.append("[");
			String[] nameArr = bill_1.getGoods_name().split(",");
			String[] priceArr = bill_1.getGoods_price().split(",");
			String[] photoArr = bill_1.getGoods_photo().split(",");
			String[] numArr = bill_1.getCart_number().split(",");
			String[] colorArr = bill_1.getGoods_color().split(",");//待定
			String[] sizeArr = bill_1.getGoods_size().split(",");//待定
			for (int j = 0; j < nameArr.length; j++) {
				sbill.append("{");
				//图片
				sbill.append("\"photo\":");
				sbill.append("\"");
				sbill.append(photoArr[j]);
				sbill.append("\"");
				sbill.append(",");
				//名字
				sbill.append("\"name\":");
				sbill.append("\"");
				sbill.append(nameArr[j]);
				sbill.append("\"");
				sbill.append(",");
				//颜色
				sbill.append("\"color\":");
				sbill.append("\"");
				sbill.append(colorArr[j]);
				sbill.append("\"");
				sbill.append(",");
				//数量
				sbill.append("\"num\":");
				sbill.append("\"");
				sbill.append(numArr[j]);
				sbill.append("\"");
				sbill.append(",");
				//单价
				sbill.append("\"price\":");
				sbill.append("\"");
				sbill.append(priceArr[j]);
				sbill.append("\"");
				sbill.append(",");
				//大小
				sbill.append("\"size\":");
				sbill.append("\"");
				sbill.append(sizeArr[j]);
				sbill.append("\"");
				sbill.append("}");
				if(j==nameArr.length-1){
					sbill.append("]");
					break;
				}
				sbill.append(",");
			}
			sbill.append("}");
			listbills.add(sbill.toString());
		}
		if(count==0){
			listbills.add("1");
		}
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		JSONArray ja = JSONArray.fromObject(listbills);
		pw.print(ja.toString());
		
		return null;
	}
	
	

}

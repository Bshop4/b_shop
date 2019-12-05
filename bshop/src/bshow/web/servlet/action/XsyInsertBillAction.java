package bshow.web.servlet.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bshow.dao.Basedao;
import bshow.dao.impl.Basedaoimpl;
import bshow.pojo.Bill_table;
import bshow.pojo.Cart_table;
import bshow.util.GenericPrimaryKey;
import bshow.web.servlet.core.Action;
import bshow.web.servlet.core.ActionForm;
import bshow.web.servlet.core.ActionForward;

public class XsyInsertBillAction extends Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		//从cart_account.js获得传来的参数
		String cart_id = request.getParameter("cart_id");
		String account = request.getParameter("account");
		String address = request.getParameter("address");
		String [] cartidarr=cart_id.split(",");
		Cart_table[] ctarr = new Cart_table[cartidarr.length];
		Cart_table ct = new Cart_table();
		Bill_table bt = new Bill_table();
		Basedao bd = new Basedaoimpl();
		List<Object> list=null;
		for (int i = 0; i < cartidarr.length; i++) {
			ct.setAccount(account);
			ct.setCart_id(Integer.parseInt(cartidarr[i]));
			list = bd.select("selectState", ct);
			ctarr[i]= (Cart_table) list.get(0);
		}
		// 设置bt的值
		bt.setAccount(account);
		bt.setAddress(address);
		StringBuffer Bcart_id=new StringBuffer();
		StringBuffer Bcart_number=new StringBuffer();
		StringBuffer Bcart_price=new StringBuffer();
		StringBuffer Bcart_color=new StringBuffer();
		StringBuffer Bcart_name=new StringBuffer();
		StringBuffer Bcart_no=new StringBuffer();
		StringBuffer Bcart_photo=new StringBuffer();
		StringBuffer Bcart_size=new StringBuffer();
		for (int i = 0; i < ctarr.length; i++) {
			Bcart_id.append(ctarr[i].getCart_id());
			Bcart_number.append(ctarr[i].getCgoods_number());
			Bcart_price.append(ctarr[i].getCgoods_price());
			Bcart_color.append(ctarr[i].getCgoods_color());
			Bcart_name.append(ctarr[i].getCgoods_desc());
			Bcart_no.append(ctarr[i].getCgoods_no());
			Bcart_photo.append(ctarr[i].getCgoods_no());
			Bcart_size.append(ctarr[i].getCgoods_size());
			if(i==ctarr.length-1){
				break;
			}
			Bcart_id.append(",");
			Bcart_number.append(",");
			Bcart_price.append(",");
			Bcart_color.append(",");
			Bcart_name.append(",");
			Bcart_no.append(",");
			Bcart_photo.append(",");
			Bcart_size.append(",");
		}
		bt.setCart_number(Bcart_number.toString());
		bt.setGoods_id(Bcart_id.toString());
		bt.setGoods_price(Bcart_price.toString());
		bt.setGoods_color(Bcart_color.toString());
		bt.setGoods_name(Bcart_name.toString());
		bt.setGoods_no(Bcart_no.toString());
		bt.setGoods_photo(Bcart_photo.toString());
		bt.setGoods_size(Bcart_size.toString());
		
		double sub=0;
		for (int i = 0; i < ctarr.length; i++) {
			sub+=ctarr[i].getCgoods_sub();
		}
		bt.setAllprice(sub);
		
		bt.setBill_isclearing(0);
		bt.setBill_state(0);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		bt.setBill_time(sdf.format(new Date()));
		bt.setBill_isclearing(0);
		String bill_code=GenericPrimaryKey.getSuiJinumber();
		bt.setBill_code(bill_code);
		// 存入数据库
		boolean flag=bd.saveObject("insertone", bt);
		if(flag){
			String json="{\"code\":\"0\",\"msg\":\"订单生成成功\",\"data\":{\"bill_code\":\""+bill_code+"\",\"account\":\""+account+"\"}}";
		}else{
			String json="{\"code\":\"419\",\"msg\":\"订单生成失败\"}";
			
		}
		
		return null;
	}

}

package bshow.web.servlet.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bshow.dao.Basedao;
import bshow.dao.impl.Basedaoimpl;
import bshow.pojo.Cart_table;
import bshow.web.servlet.core.Action;
import bshow.web.servlet.core.ActionForm;
import bshow.web.servlet.core.ActionForward;
import bshow.web.servlet.form.InsertCartBuyForm;
import net.sf.json.JSONObject;

public class InsertCartBuyAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		
		InsertCartBuyForm icbf = (InsertCartBuyForm)form;
		String msg = icbf.getMsg();
		JSONObject obj = JSONObject.fromObject(msg);
//		System.out.println(obj);
		/**
		 * "goodsNo":goodsNo,
        	"getnumber":getnumber,
        	"imgurl":imgurl,
        	"getgoodsname":getgoodsname,
        	"getprice":getprice,
        	"getAllprice":getAllprice,
        	"getcolor":getcolor,
        	"getsize":getsize,
        	"account":account
		 */
		String goodsNo = obj.getString("goodsNo");
		String getnumber = obj.getString("getnumber");
		String imgurl = obj.getString("imgurl");
		String getgoodsname = obj.getString("getgoodsname");
		String getprice = obj.getString("getprice");
		String getAllprice = obj.getString("getAllprice");
		String getcolor = obj.getString("getcolor");
		String getsize = obj.getString("getsize");
		String account = obj.getString("account");
		int state = 1;
		
		Cart_table ct = new Cart_table();
		ct.setAccount(account);
		ct.setCgoods_color(getcolor);
		ct.setCgoods_desc(getgoodsname);
		ct.setCgoods_no(goodsNo);
		ct.setCgoods_number(Integer.parseInt(getnumber));
		ct.setCgoods_photo(imgurl);
		ct.setCgoods_size(getsize);
		ct.setCgoods_price(Double.valueOf(getprice));
		ct.setCgoods_sub(Double.parseDouble(getAllprice));
		ct.setCgoods_state(state);
		
		Basedao bd = new Basedaoimpl();
		boolean f = bd.saveObject("insertToCart", ct);
//		System.out.println(f);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		if(f){
			pw.print("1");
		}
		
		return null;
	}
	
	

}

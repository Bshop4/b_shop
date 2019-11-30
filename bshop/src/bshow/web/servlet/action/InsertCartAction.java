
package bshow.web.servlet.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bshow.dao.Basedao;
import bshow.dao.impl.Basedaoimpl;
import bshow.pojo.Cart_table;
import bshow.web.servlet.core.Action;
import bshow.web.servlet.core.ActionForm;
import bshow.web.servlet.core.ActionForward;
import bshow.web.servlet.form.InsertCartForm;
import net.sf.json.JSONObject;

public class InsertCartAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		
		InsertCartForm icf = (InsertCartForm)form;
		String msg = icf.getMsg();
		JSONObject obj = JSONObject.fromObject(msg);
		
		String goodsNo = obj.getString("goodsNo");
		String getnumber = obj.getString("getnumber");
		String imgurl = obj.getString("imgurl");
		String getgoodsname = obj.getString("getgoodsname");
		String getprice = obj.getString("getprice");
		String getAllprice = obj.getString("getAllprice");
		String getcolor = obj.getString("getcolor");
		String getsize = obj.getString("getsize");
		String account = obj.getString("account");
		
		Cart_table ct = new Cart_table();
		ct.setAccount(account);
		ct.setCgoods_color(getcolor);
		ct.setCgoods_desc(getgoodsname);
		ct.setCgoods_sub(Double.parseDouble(getAllprice));
		ct.setCgoods_price(Double.parseDouble(getprice));
		ct.setCgoods_number(Integer.parseInt(getnumber));
		ct.setCgoods_photo(imgurl);
		ct.setCgoods_size(getsize);
		ct.setCgoods_no(goodsNo);
		ct.setCgoods_state(0);
		
		Basedao bd = new Basedaoimpl();
		List<Object> list = bd.select("selectCartByGoodsno", ct);
		if(list.size() == 0){
			bd.saveObject("insertToCart", ct);
		}else if(list.size() == 1){
			Cart_table ct1 = (Cart_table)list.get(0);
			int id = ct1.getCart_id();
			int num = ct1.getCgoods_number();
			num += Integer.parseInt(getnumber);
			ct1.setCgoods_number(num);
			int allprice = num * Integer.parseInt(getprice);
			ct1.setCgoods_sub(Double.valueOf(allprice));
			boolean f = bd.updataObject("updateCart1", ct1);
		}
		
		
//		if("0".equals(state)){
//			Cart_table ct = new Cart_table();
//			ct.setAccount(account);
//			ct.setCgoods_color(getcolor);
//			ct.setCgoods_desc(getgoodsname);
//			ct.setCgoods_sub(Double.parseDouble(getAllprice));
//			ct.setCgoods_price(Double.parseDouble(getprice));
//			ct.setCgoods_number(Integer.parseInt(getnumber));
//			ct.setCgoods_photo(imgurl);
//			ct.setCgoods_size(getsize);
//			ct.setCgoods_no(goodsNo);
//			ct.setCgoods_state(0);
//			System.out.println("第一次");
//			bd.saveObject("insertToCart", ct);
//			
//		}else if("1".equals(state)){
//			Cart_table ct = new Cart_table();
//			List<Object> list = bd.select("selectCartByGoodsno", ct);
//			Cart_table ct1 = (Cart_table)list.get(0);
//			System.out.println("第二次" + ct1);
//			
//			
//		}
		
		
		return null;
	}

}

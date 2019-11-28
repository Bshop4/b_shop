package bshow.web.servlet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String state = obj.getString("state");
		String account = obj.getString("account");
		
		
		if("0".equals(state)){
			
		}
		
		
		return null;
	}

}

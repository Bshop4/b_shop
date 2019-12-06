package bshow.web.servlet.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bshow.dao.Basedao;
import bshow.dao.impl.Basedaoimpl;
import bshow.pojo.Footprint_table;
import bshow.web.servlet.core.Action;
import bshow.web.servlet.core.ActionForm;
import bshow.web.servlet.core.ActionForward;
import bshow.web.servlet.form.FootPrintActionForm;
import net.sf.json.JSONObject;

public class FootPrintAction extends Action{

	/* (non-Javadoc)
	 * @see bshow.web.servlet.core.Action#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, bshow.web.servlet.core.ActionForm)
	 */
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		
		//返回给前端的值
		boolean flag=false;
		
		FootPrintActionForm myform=(FootPrintActionForm)form;
		String footprint_goodsno=myform.getFootprint_goodsno();
		
		Footprint_table ft=new Footprint_table();
		//获得当前时间
		Date d=new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date=dateFormat.format(d);
		
		//通过cookie或者session拿帐号
		HttpSession session=request.getSession();
		String account=(String)session.getAttribute("account");
		
		Cookie[] cookies=request.getCookies();
		if(account==null){
			for (Cookie cookie : cookies) {
				if("account".equals(cookie.getName())){
					account=cookie.getValue();
					break;
				}
			}
		}else{
			account=account;
		}
		
		if(account != null){
			Footprint_table ft1 = new Footprint_table();
			ft1.setAccount(account);
			ft1.setFootprint_goodsno(footprint_goodsno);
			ft1.setFootprint_time(date);
			Basedao bd=new Basedaoimpl();
			List<Object> list1 = bd.select("selectit", ft1);
			if(list1.size() == 0){
				flag=bd.saveObject("insertone", ft1);
			}
		}else{
			flag=false;
		}
		
		
//		if(account!=null){
//			ft.setAccount(account);
//			ft.setFootprint_goodsno(footprint_goodsno);
//			ft.setFootprint_time(date);
//			
//			Basedao bd=new Basedaoimpl();
//			flag=bd.saveObject("insertone", ft);
//			 
//		}else{
//			flag=false;
//		}
		
		//发送给前台
		

		response.setCharacterEncoding("utf-8");
//		response.setHeader("Content-Type", "application/json;charset=utf-8");
//		JSONObject jo=JSONObject.fromObject(flag);
		
		
		PrintWriter out=response.getWriter();
		out.print(flag);
		
		return null;
	}

}

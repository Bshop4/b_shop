package bshow.web.servlet.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bshow.web.servlet.core.Action;
import bshow.web.servlet.core.ActionForm;
import bshow.web.servlet.core.ActionForward;
import net.sf.json.JSONObject;

public class ExitLoginAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		Cookie[] cookies=request.getCookies();
		HttpSession session=request.getSession();
		boolean flag=false;
		boolean flag1=false;
		boolean flag2=false;
		if(cookies!=null){
			//移除cookie中账号
			for (Cookie cookie : cookies) {
				if("account".equals(cookie.getName())){
					cookie.setDomain("localhost");
					cookie.setPath("/bshop");
					cookie.setMaxAge(0);
					response.addCookie(cookie);
					flag=true;  
				}
				if("token".equals(cookie.getName())){
					cookie.setDomain("localhost");
					cookie.setPath("/bshop");
					cookie.setMaxAge(0);
					response.addCookie(cookie);
					flag2=true;
				}
			}
		}
		if(session!=null){
			//移除session中的账号
			session.removeAttribute("account");
			session.removeAttribute("password");
			session.removeAttribute("token");
			flag1=true;
		}
		//传给前端
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		if(flag&flag1&flag2){
			String json="{\"code\":\"0\"}";
			out.print(json);
		}else{
			String json="{\"code\":\"1\"}";
			out.print(json);
		}
		return null;
	}

}

package bshow.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class ExitLogin
 */
@WebServlet("/ExitLogin")
public class ExitLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExitLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies=request.getCookies();
		HttpSession session=request.getSession();
		boolean flag=false;
		boolean flag1=false;
		boolean flag2=false;
		if(cookies!=null){
			//移除cookie中账号
			for (Cookie cookie : cookies) {
				if("account".equals(cookie.getName())){
					cookie.setMaxAge(0);
					response.addCookie(cookie);
					flag=true;  
				}
				if("token".equals(cookie.getName())){
					cookie.setMaxAge(0);
					response.addCookie(cookie);
					flag2=true;
				}
			}
		}
		if(session!=null){
			//移除session中的账号
			session.removeAttribute("account");
			flag1=true;
		}
		//传给前端
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-Type", "application/json;charset=utf-8");
		JSONObject jo=JSONObject.fromObject(flag&flag1&flag2);
		PrintWriter out=response.getWriter();
		out.print(URLDecoder.decode(jo.toString(), "utf-8"));
	}
}

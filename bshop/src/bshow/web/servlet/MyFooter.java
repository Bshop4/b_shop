package bshow.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bshow.dao.FooterDao;
import bshow.dao.impl.FooterDaoImpl;
import bshow.dto.GoodsAndFooter;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class MyFooter
 */
@WebServlet("/MyFooter")
public class MyFooter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyFooter() {
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
		
		FooterDao dao=new FooterDaoImpl();
		List<GoodsAndFooter> mylist=dao.getFooterByAccount(account);
		if(mylist!=null){
			response.setCharacterEncoding("utf-8");
			response.setHeader("Content-Type", "application/json;charset=utf-8");
			JSONArray ja=JSONArray.fromObject(mylist);
			//将数据交给前端
			PrintWriter out=response.getWriter();
			out.print(URLDecoder.decode(ja.toString(), "utf-8"));
		}else{
			response.setCharacterEncoding("utf-8");
			//将数据交给前端
			PrintWriter out=response.getWriter();
			out.print(mylist);
		}
	}
}

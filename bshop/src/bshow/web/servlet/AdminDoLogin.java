package bshow.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bshow.dao.AdminDao;
import bshow.dao.impl.AdminDaoImpl;

/**
 * Servlet implementation class AdminDoLogin
 */
@WebServlet("/AdminDoLogin")
public class AdminDoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDoLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account=request.getParameter("account");
		String password=request.getParameter("password");
		AdminDao dao=new AdminDaoImpl();
		boolean flag=dao.doLogin(account, password);
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		if(flag){
			request.getSession().setAttribute("account", "aaa");
			String json="{\"code\":\"0\",\"msg\":\"用户存在\"}";
			out.print(json);
		}else{
			String json="{\"code\":\"1\",\"msg\":\"帐号或密码错误\"}";
			out.print(json);
		}
	}

}

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
 * Servlet implementation class DeleteMyAccount
 */
@WebServlet("/DeleteMyAccount")
public class DeleteMyAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMyAccount() {
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
		AdminDao dao=new AdminDaoImpl();
		int n=dao.deleteMyAccountByAdmin(account);
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		if(n!=0){
			String json="{\"code\":\"0\",\"msg\":\"删除成功\"}";
			out.print(json);
		}else{
			String json="{\"code\":\"1\",\"msg\":\"删除失败\"}";
			out.print(json);
		}
	}

}

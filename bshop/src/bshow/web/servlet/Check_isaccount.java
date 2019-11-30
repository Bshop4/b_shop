package bshow.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bshow.dao.Basedao;
import bshow.dao.impl.Basedaoimpl;
import bshow.pojo.Account_table;

/**
 * Servlet implementation class Check_isaccount
 */
@WebServlet("/Check_isaccount")
public class Check_isaccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Check_isaccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String state=request.getParameter("state");
		//A代表帐号E代表邮箱。根据AE来查询是否有
		if("AE".equalsIgnoreCase(state)){
			String account=request.getParameter("account");
			String email=request.getParameter("email");
			Basedao dao=new Basedaoimpl();
			Account_table at=new Account_table();
			at.setAccount(account);
			at.setEmail(email);
			List<Object> list=dao.select("selectByAE",at);
			PrintWriter out =response.getWriter();
			if(list.size()==0){
				out.print(false);
			}else{
				out.print(true);
			}
			return;
		}
		
		//A代表帐号,根据A来查询是否有
		if("A".equalsIgnoreCase(state)){
			String account=request.getParameter("account");
			Basedao dao=new Basedaoimpl();
			Account_table at=new Account_table();
			at.setAccount(account);
			List<Object> list=dao.select("selectByAccount",at);
			PrintWriter out =response.getWriter();
			if(list.size()==0){
				out.print(true);
			}else{
				out.print(false);
			}
			return;
		}
		
	}

}

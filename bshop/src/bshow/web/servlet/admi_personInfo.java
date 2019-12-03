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
import bshow.pojo.Administrator_table;

/**
 * Servlet implementation class admi_personInfo
 */
@WebServlet("/admi_personInfo")
public class admi_personInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admi_personInfo() {
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
		Basedao dao=new Basedaoimpl();
		Administrator_table adm=new Administrator_table();
//		String zhanghao=(String)request.getAttribute("Administrator_table");
		String zhanghao="admin";
		adm.setAdministrator_account(zhanghao);
		List<Object> list=dao.select("selectone", adm);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		if(!list.isEmpty()){
			Administrator_table adm1=(Administrator_table)list.get(0);
			String json="{\"code\":\"0\",\"msg\":\"成功\",\"data\":{\"account\":\""+adm1.getAdministrator_account()+"\"}}";
			out.print(json);
		}else{
			String json="{\"code\":\"417\",\"msg\":\"管理员查询失败\"}";
			out.print(json);
		}
		
	}

}

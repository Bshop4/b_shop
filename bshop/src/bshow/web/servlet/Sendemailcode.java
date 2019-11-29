package bshow.web.servlet;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;
import xyw.util.SendmailUtil;

/**
 * Servlet implementation class Sendemailcode1
 */
@WebServlet("/Sendemailcode")
public class Sendemailcode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sendemailcode() {
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
		Random r=new Random();
		String email=request.getParameter("email");
		PrintWriter out =response.getWriter();
		response.setCharacterEncoding("UTF-8");
		String json="";
		StringBuffer code=new StringBuffer("");
		BASE64Encoder be=new BASE64Encoder();
		try {
			int ii=r.nextInt(3)+5;
			for (int i = 0; i < ii; i++) {
				code.append(r.nextInt(9));
			}
			SendmailUtil.send(email, "嘿店注册", "验证码:"+code);
		} catch (Exception e) {
			// TODO: handle exception
			String jsonfalse="{code:'0405',msg:'邮箱格式错误'}";
			out.print(jsonfalse);
		}
		//1041551225@qq.com    814402195@qq.com
		
		out.print("{\"code\":\"0\",\"msg\":\"sendSuccess\",\"passage\":\""+ be.encode(code.toString().getBytes())+"\"}");
	}

}

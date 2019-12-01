package bshow.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bshow.dao.AccountDao;
import bshow.dao.impl.AccountDaoImpl;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class JudgementLogin
 */
@WebServlet("/JudgementLogin")
public class JudgementLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JudgementLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> list = new ArrayList<String>();
		String account = null;
		String nickname = null;
		int cartNum = 0;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("account".equals(cookie.getName())) {
					account = cookie.getValue();
				}
			}
		} else {
			HttpSession session = request.getSession();
			account = (String) session.getAttribute("account");
		}

		if (account == null) {
			nickname = "noPeopleLogin";
			cartNum = 0;
		} else {
			AccountDao ad = new AccountDaoImpl();

			// 根据账号查昵称
			nickname = ad.getNicknameByAccount(account);

			// 根据账号查购物车商品数量
			cartNum = ad.getCartNumberByAccont(account);
		}

		list.add(nickname);
		list.add(String.valueOf(account));
		// 传给前端
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-Type", "application/json;charset=utf-8");
		JSONArray ja = JSONArray.fromObject(list);
		PrintWriter out = response.getWriter();
		out.print(URLDecoder.decode(ja.toString(), "utf-8"));
	}
}

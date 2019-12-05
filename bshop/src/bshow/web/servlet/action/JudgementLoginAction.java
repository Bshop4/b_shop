package bshow.web.servlet.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bshow.dao.AccountDao;
import bshow.dao.impl.AccountDaoImpl;
import bshow.web.servlet.core.Action;
import bshow.web.servlet.core.ActionForm;
import bshow.web.servlet.core.ActionForward;
import net.sf.json.JSONArray;

public class JudgementLoginAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		List<String> list = new ArrayList<String>();
		String account = null;
		String nickname = null;
		int cartNum = 0;
		
		//获取account在session和cookie的值
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("account".equals(cookie.getName())) {
					account = cookie.getValue();
				}
			}
		}
		if(account==null){
			HttpSession session=request.getSession();
			account=(String)session.getAttribute("account");
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
		list.add(String.valueOf(cartNum));
		
//		for(int i=0;i<list.size();i++){
//			System.out.println(list.get(i));
//		}
		
		// 传给前端
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-Type", "application/json;charset=utf-8");
		JSONArray ja = JSONArray.fromObject(list);
		PrintWriter out = response.getWriter();
		out.print(URLDecoder.decode(ja.toString(), "utf-8"));
		return null;
	}

}

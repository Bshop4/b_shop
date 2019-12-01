package bshow.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest myrequest=(HttpServletRequest)request;
		HttpServletResponse myresponse=(HttpServletResponse)response;
		
		//获取session中是否有值
		HttpSession session=myrequest.getSession();
		Object obj=session.getAttribute("account");
		
		if(obj==null){
			myresponse.sendRedirect("/bshop/login.jsp");
		}else{
			//放行
			chain.doFilter(myrequest, myresponse);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}

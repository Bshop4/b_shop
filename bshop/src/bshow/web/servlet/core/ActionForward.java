package bshow.web.servlet.core;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.Element;

public class ActionForward {
	private String path=null;
	private boolean redirect=false;
	public ActionForward(String path) {
		this(path,false);
	}
	public ActionForward(String path, boolean redirect) {
		this.path=path;
		this.redirect=redirect;
	}
	public void forward(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		//从应用程序中拿出配置文件
		Document config=(Document)request.getServletContext().getAttribute("config");
		//获得应该处理的路径
		String uri=(String)request.getAttribute("uri");
		List<Element> list=config.selectNodes("/properties/PagePattern[@name='"+uri+"']/path[@name='"+path+"']");
		String selectPath=null;
		for (Element element : list) {
			selectPath=element.getStringValue();
			System.out.println("应该处理的路径"+selectPath);
		}
		if(redirect){
			response.sendRedirect(selectPath);
		}else{
			request.getRequestDispatcher(selectPath).forward(request, response);
		}
	}
}

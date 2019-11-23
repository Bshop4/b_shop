package bshow.web.servlet.core;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;

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
		//实现应该配置的路径
		if(redirect){
			
		}
	}
}

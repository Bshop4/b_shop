package bshow.web.servlet.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bshow.dao.Basedao;
import bshow.dao.impl.Basedaoimpl;
import bshow.pojo.Account_table;
import bshow.web.servlet.core.Action;
import bshow.web.servlet.core.ActionForm;
import bshow.web.servlet.core.ActionForward;
import bshow.web.servlet.form.Sign_accountActionForm;
import xyw.util.SendmailUtil;

public class Sign_account extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Sign_accountActionForm saa=(Sign_accountActionForm)form; 
		Basedao dao=new Basedaoimpl();
		Account_table at=new Account_table();
		at.setAccount(saa.getAccount());
		at.setEmail(saa.getEmail());
		at.setPassword(saa.getPassword());
		at.setIpaddress(getIpAddress(request));
		System.out.println(getIpAddress(request));
		PrintWriter out=response.getWriter();
		String json="";
		try {
			SendmailUtil.send(at.getEmail(), "嘿店注册", "验证码:"+123456);
		} catch (Exception e) {
			// TODO: handle exception
			String jsonfalse="{code:'404',msg:'邮箱格式错误'}";
			out.print(jsonfalse);
		}
		out.print("123456");
		//dao.saveObject(id, o);
		return null;
	}


      

	  public  String getIpAddress(HttpServletRequest request) { 
		  String ip = request.getHeader("X-Forwarded-For");  
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	                ip = request.getHeader("Proxy-Client-IP");  
	            }  
	            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	                ip = request.getHeader("WL-Proxy-Client-IP");  
	            }  
	            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	                ip = request.getHeader("HTTP_CLIENT_IP");  
	            }  
	            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	                ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
	            }  
	            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	                ip = request.getRemoteAddr();  
	            }  
	        } else if (ip.length() > 15) {  
	            String[] ips = ip.split(",");  
	            for (int index = 0; index < ips.length; index++) {  
	                String strIp = (String) ips[index];  
	                if (!("unknown".equalsIgnoreCase(strIp))) {  
	                    ip = strIp;  
	                    break;  
	                }  
	            }  
	        }  
	        return ip; 
	  }

}

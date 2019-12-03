package bshow.web.servlet.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import bshow.dao.Basedao;
import bshow.dao.impl.Basedaoimpl;
import bshow.pojo.Account_table;
import bshow.pojo.Cart_table;
import bshow.pojo.Personinfo_table;
import bshow.test.Test;
import bshow.util.Encryptdecrypt;
import bshow.web.servlet.core.Action;
import bshow.web.servlet.core.ActionForm;
import bshow.web.servlet.core.ActionForward;
import bshow.web.servlet.form.Sign_accountActionForm;
import xyw.util.SendmailUtil;

public class Sign_accountAction extends Action{
	private static final Logger log = Logger.getLogger(Test.class);
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Sign_accountActionForm saa=(Sign_accountActionForm)form; 
		Basedao dao=new Basedaoimpl();
		Basedao dao1=new Basedaoimpl();
		//给帐号表添加所有的信息
		Account_table at=new Account_table();
		at.setAccount(saa.getAccount());
		at.setEmail(saa.getEmail());
		try {
			String pass=Encryptdecrypt.encrypt(saa.getPassword());
			at.setPassword(pass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.warn(e+"==Sign_accountAction密码加密两次出错");
		}
		at.setIpaddress(getIpAddress(request));
		boolean flagAccount=dao.saveObject("insertone", at);
		//给信息表添加帐号
		Personinfo_table pt=new Personinfo_table();
		pt.setAccount(saa.getAccount());
		pt.setPhoto("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1574939266&di=75f2a98533ef7c3b864db90f3dd90856&src=http://bpic.588ku.com/element_origin_min_pic/01/31/87/96573b585a7c9c4.jpg".getBytes());
		pt.setAddress("");
		pt.setNickname(saa.getAccount());
		pt.setBirthday("");
		pt.setSex("");
		boolean flagPersoninfo=dao1.saveObject("insertone", pt);
		
		
		//给信息表添加帐号
//		Cart_table ct=new Cart_table();
//		//cgoods_photo,cgoods_desc,cgoods_number,cgoods_price,cgoods_sub,cgoods_no,cgoods_state,cgoods_color,cgoods_size,account
//		ct.setAccount(saa.getAccount());
//		ct.setCgoods_desc("");
//		ct.setCgoods_color("");
//		ct.setCgoods_no("");
//		ct.setCgoods_number(0);
//		ct.setCgoods_state(0);
//		ct.setCgoods_photo("");
//		ct.setCgoods_price(0);
//		ct.setCgoods_sub(0);
//		ct.setCgoods_size("");
//		boolean flagCart=dao1.saveObject("insertToCart", ct);
		
		
		//编写返回给js页面的值
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		String json="";
		if(flagPersoninfo&&flagAccount){
			json="{\"code\":\"0\",\"msg\":\"successSgin登录成功\"}";
			out.print(json);
			return null;
		}
		
		if(!flagPersoninfo){
			json="{\"code\":\"412\",\"msg\":\"Personin_tableSavefoError信息添加出错\"}";
			//只要有一边失败就要删除成功的表
			
			
		}
		
		if(!flagAccount){
			json="{\"code\":\"411\",\"msg\":\"Account_tableSaveError帐号添加出错\"}";
		}
		
		
//		if(!flagCart){
//			json="{\"code\":\"416\",\"msg\":\"Account_tableSaveError购物车添加出错\"}";
//		}
		
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

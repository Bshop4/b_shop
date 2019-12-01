package bshow.web.servlet.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import bshow.dao.Basedao;
import bshow.dao.impl.Basedaoimpl;
import bshow.pojo.Account_table;
import bshow.test.Test;
import bshow.util.Encryptdecrypt;
import bshow.web.servlet.core.Action;
import bshow.web.servlet.core.ActionForm;
import bshow.web.servlet.core.ActionForward;
import bshow.web.servlet.form.UpdateAccoutPassWordActionForm;

public class UpdateAccoutPassWordAction extends Action{
	private static final Logger log = Logger.getLogger(Test.class);
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		UpdateAccoutPassWordActionForm uapa=(UpdateAccoutPassWordActionForm)form;
		Basedao dao=new Basedaoimpl();
		boolean updataPassflag=false;
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		if(uapa.getAccount()!=""&&uapa.getAccount()!=null){
			Account_table at=new Account_table();
			at.setAccount(uapa.getAccount());
			at.setEmail(uapa.getEmail());
			String pass="";
			try {
				pass=Encryptdecrypt.encrypt(uapa.getPassword());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.warn(e+"UpdateAccoutPassWordAction修改密码时加密失败");
			}
			at.setPassword(pass);
			updataPassflag=dao.updataObject("updatePassWord", at);
			if(updataPassflag){
				String json="{\"code\":0,\"msg\":\"修改密码成功\"}";
				out.print(json);
			}else{
				String json="{\"code\":\"415\",\"msg\":\"修改密码失败\"}";
				out.print(json);
			}
		}
		
		return null;
	}

}

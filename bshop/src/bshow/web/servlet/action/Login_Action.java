package bshow.web.servlet.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import bshow.dao.Basedao;
import bshow.dao.impl.Basedaoimpl;
import bshow.pojo.Account_table;
import bshow.test.Test;
import bshow.util.Encryptdecrypt;
import bshow.util.GenericPrimaryKey;
import bshow.web.servlet.core.Action;
import bshow.web.servlet.core.ActionForm;
import bshow.web.servlet.core.ActionForward;
import bshow.web.servlet.form.Login_ActionForm;
import net.sf.json.JSONObject;

public class Login_Action extends Action{
	private static final Logger log = Logger.getLogger(Test.class);
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Basedao dao=new Basedaoimpl();
		Login_ActionForm la=(Login_ActionForm)form;
		String inAccount=la.getAccount();
		String inPass="";
		try {
			inPass=Encryptdecrypt.encrypt(la.getPassword());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.warn(e+"Login_Action密码加密两次出错");
			return null;
		}
		//去帐号表查询有无这个帐号
		Account_table at=new Account_table();
		at.setAccount(inAccount);
		List<Object> list=dao.select("selectByAccount", at);
		String json="";
		response.setCharacterEncoding("utf-8");
		//response.setHeader("Content-Type", "application/json;charset=utf-8");
		PrintWriter out=response.getWriter();
		if(list.size()!=0){
			Account_table outAccountObject=(Account_table)list.get(0);
			//用来对比是否是同一个帐号密码
			//帐号对比
			String uid=GenericPrimaryKey.getPrimaryKey();
			if(inAccount.equals(outAccountObject.getAccount())){
				//密码对比
				if(inPass.equals(outAccountObject.getPassword())){
					//更新当前的ip地址
					json="{\"code\":0,\"msg\":\"LoginSuccess登录成功\",\"data\":{\"token\":\""+uid+"\",\"username\":\""+outAccountObject.getAccount()+"\"}}";
					out.print(json);
				}else{
					json="{\"code\":\"414\",\"msg\":\"LoginFailed帐号或密码不正确\"}";
					out.print(json);
				}
			}
		}else{
			json="{\"code\":\"413\",\"msg\":\"NoThisAccount帐号不存在\"}";
			out.print(json);
		}
		return null;
	}
	
}

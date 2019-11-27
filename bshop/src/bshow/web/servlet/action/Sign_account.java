package bshow.web.servlet.action;

import java.io.IOException;

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
		at.setIpaddress(request.getLocalAddr());
		//dao.saveObject(id, o);
		return null;
	}
}

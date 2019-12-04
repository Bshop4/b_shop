package bshow.web.servlet.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bshow.service.AccountService;
import bshow.service.impl.AccountServiceimpl;
import bshow.web.servlet.core.Action;
import bshow.web.servlet.core.ActionForm;
import bshow.web.servlet.core.ActionForward;
import bshow.web.servlet.form.Administrator_selectAccountForm;

public class AdminMaxPageAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		AccountService as=new AccountServiceimpl();
		Administrator_selectAccountForm myform=(Administrator_selectAccountForm)form;
		
		//赋值默认值
		String myNeedAccount=null;
		String email=null;
		int pageNo=0;
		int pageSize=0;
		
		if(myform.getAccount()!=null){
			myNeedAccount=myform.getAccount();
		}
		
		if(myform.getEmail()!=null){
			email=myform.getEmail();
		}
		
		if(myform.getPageNo()!=null){
			pageNo=Integer.parseInt(myform.getPageNo());
		}
		if(myform.getPageSize()!=null){
			pageSize=Integer.parseInt(myform.getPageSize());
		} 
		
		int n=as.selectMaxPage(pageNo, pageSize, myNeedAccount, email);
		
		PrintWriter out=response.getWriter();
		out.print(n);
		
		return null;
	}

}

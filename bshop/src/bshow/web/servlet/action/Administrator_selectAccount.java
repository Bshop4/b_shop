package bshow.web.servlet.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bshow.dao.Basedao;
import bshow.dao.impl.Basedaoimpl;
import bshow.pojo.Account_table;
import bshow.service.AccountService;
import bshow.service.impl.AccountServiceimpl;
import bshow.web.servlet.core.Action;
import bshow.web.servlet.core.ActionForm;
import bshow.web.servlet.core.ActionForward;
import bshow.web.servlet.form.Administrator_selectAccountForm;
import net.sf.json.JSONArray;

public class Administrator_selectAccount extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Administrator_selectAccountForm asf=(Administrator_selectAccountForm)form;
		
//		Account_table at =new Account_table();
//		String account=(String)request.getSession().getAttribute("account");
//		if(account!=null&&account!=""){
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
			
//			System.out.println("传过来的数据"+myNeedAccount);
			
			List<Account_table> mylist=as.selectPage(pageNo, pageSize, myNeedAccount,email);
			
			
			response.setCharacterEncoding("utf-8");
			response.setHeader("Content-Type", "application/json;charset=utf-8");
			JSONArray ja=JSONArray.fromObject(mylist);
			//将数据交给前端
			PrintWriter out=response.getWriter();
			out.print(URLDecoder.decode(ja.toString(), "utf-8"));
		
		return null;
	}
	
}

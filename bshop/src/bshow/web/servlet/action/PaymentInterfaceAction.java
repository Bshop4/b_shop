package bshow.web.servlet.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.Naming;
import java.rmi.NotBoundException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bshow.pojo.Bank;
import bshow.service.BankService;
import bshow.web.servlet.core.Action;
import bshow.web.servlet.core.ActionForm;
import bshow.web.servlet.core.ActionForward;
import bshow.web.servlet.form.PaymentInterfaceForm;
import net.sf.json.JSONObject;

public class PaymentInterfaceAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		PaymentInterfaceForm piff = (PaymentInterfaceForm)form;
		
		String msg = piff.getMsg();
		System.out.println(msg);
		JSONObject obj = JSONObject.fromObject(msg);
		
		String pay_name = obj.getString("pay_name");
		String pay_money = obj.getString("pay_money");
		String pay_pass = obj.getString("pay_pass");
		
		BankService bs=null;
		try {
			bs = (BankService)Naming.lookup(BankService.ADDRESS);
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(bs);
		double balance = bs.queryAccount(pay_name, pay_pass);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		
		if(balance != -1){
			if(balance - Double.valueOf(pay_money) >= 0){
				balance -= Double.valueOf(pay_money);
				Bank b = new Bank();
				b.setAccount(pay_name);
				b.setBalance(balance);
				boolean f = bs.update(b);
				if(f){
					pw.print("支付成功");
					
				}
				
			}else{
				pw.print("余额不足");
			}
		}else{
			pw.print("密码不正确！");
		}
		
		
		return null;
	}
	
	

}

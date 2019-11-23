package bshow.web.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import bshow.web.others.PersonInfo;

/**
 * @deprecated实现单态登录
 * @author Administrator
 *
 */
public class LoginSessionListener implements HttpSessionAttributeListener{
	
	Map<String,HttpSession> map=new HashMap<String, HttpSession>();
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		//获得session中存入的key
		String name=event.getName();
		
		//登录
		if(name.equals("personInfo")){
			PersonInfo personInfo=(PersonInfo)event.getValue();
			if(map.get(personInfo.getAccount())!=null){
				//map中有记录，表明该账号在其他机器上登陆过，将以前的登录失效
				HttpSession session=map.get(personInfo.getAccount());//拿出原来的Session
				PersonInfo oldPersonInfo=(PersonInfo)session.getAttribute("personInfo");
				System.out.println("帐号" + oldPersonInfo.getAccount() + "在" + oldPersonInfo.getIp() + "已经登录，该登录将被迫下线。");
				session.removeAttribute("personInfo");
				session.setAttribute("msg", "您的帐号已经在其他机器上登录，您被迫下线。");
			}
			
			//将session以用户名为索引，放入map中
			map.put(personInfo.getAccount(), event.getSession());
			System.out.println("帐号" + personInfo.getAccount() + "在" + personInfo.getIp() + "登录。");
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		String name=event.getName();
		//注销
		if(name.equals("personInfo")){
			//将该session从map中移出
			PersonInfo personInfo=(PersonInfo)event.getValue();
			map.remove(personInfo.getAccount());
			System.out.println("账号"+personInfo.getAccount()+"注销.");
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		String name=event.getName();
		
		//没有注销的情况下，用另一个账号登录
		if(name.equals("personInfo")){
			//移出旧的登录信息
			PersonInfo oldPersonInfo=(PersonInfo)event.getValue();
			map.remove(oldPersonInfo.getAccount());
			
			//新的登录信息
			PersonInfo personInfo=(PersonInfo)event.getSession().getAttribute("personInfo");
			
			//也要检查新登录的账号是否在别的机器上登陆过
			if(map.get(personInfo.getAccount())!=null){
				// map 中有记录，表明该帐号在其他机器上登录过，将以前的登录失效
				HttpSession session=map.get(personInfo.getAccount());
				session.removeAttribute("personInfo");
				session.setAttribute("msg", "您的帐号已经在其他机器上登录，您被迫下线。");
			}
			map.put(personInfo.getAccount(), event.getSession());
		}
	}

}

package bshow.web.listener;

import java.io.InputStream;

import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class MyAppListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("程序启动了");
		//获取config.xml文件
		InputStream config=MyAppListener.class.getResourceAsStream("/bshop/mvc/config.xml");
		System.out.println(config);
		SAXReader reader=new SAXReader();
		Document doc=null;
		//准备存Action实例的map集合
		Properties actionPool=new Properties();
		try {
			doc=reader.read(config);
			//将配置文件存在应用程序的作用域中
			sce.getServletContext().setAttribute("config", doc);
			sce.getServletContext().setAttribute("actionPool", actionPool);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}

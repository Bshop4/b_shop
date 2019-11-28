package bshow.web.servlet.core;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.Element;

/**
 * Servlet implementation class ActionServlet
 */
@WebServlet("/ActionServlet")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入ActionServlet————doPost");
		// 拿出应用程序中的action池
		Properties actionPool = (Properties) this.getServletContext().getAttribute("actionPool");
		// 拿出配置文件
		Document config = (Document) this.getServletContext().getAttribute("config");
		// 获得提交的路径
		String uri = request.getRequestURI();
		// 截取提取的uri
		int a = uri.lastIndexOf("/");
		int b = uri.indexOf(".");
		if (a != -1 && b != -1 && b > a) {
			uri = uri.substring(a + 1, b);
		}
		// 将url存入request中
		request.setAttribute("uri", uri);

		// 将数据封装到对应的form中
		// 通过uri找到要封装数据的ActionForm类
		List<Element> list = config.selectNodes("/properties/PagePattern[@name='" + uri + "']/ActionForm");
		String classFormName = null;
		for (Element element : list) {
			classFormName = element.getStringValue();
//			System.out.println(classFormName);
		}
//		System.out.println(classFormName);
//		System.out.println(111222);
		// 反射出form的实例
		ActionForm form = null;
		try {
			Class c = Class.forName(classFormName);
			form = (ActionForm) c.newInstance();
			// 拿到请求所有的参数
			Set<Map.Entry<String, String[]>> set = request.getParameterMap().entrySet();
			for (Map.Entry<String, String[]> entry : set) {
				String param = entry.getKey();
				// 找到对应的set方法
				Method m = c.getDeclaredMethod("set" + param.substring(0, 1).toUpperCase() + param.substring(1),
						String.class);
//				System.out.println(entry.getValue()[0]);
				m.invoke(form, entry.getValue()[0]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 通过uri找到要处理该uri的类的全路径
		List<Element> list1 = config.selectNodes("/properties/PagePattern[@name='" + uri + "']/Action");
		String className = null;
		for (Element element : list1) {
			className = element.getStringValue();
			// System.out.println(className);
		}
		Action action = null;
		try {
			if (className != null) {
				// 我们先去actionPool中拿对应的实例
				Object obj = actionPool.get(className);
				if (obj == null) {
					// 表示第一次访问该action
					// 反射出子类的实例转型成父类的引用
					action = (Action) Class.forName(className).newInstance();
					// 将实例存入action池中
					actionPool.put(className, action);
				} else {
					// 表示第N次访问该action
					action = (Action) obj;
				}
				ActionForward af = action.execute(request, response, form);
				// 跳转
				if (af == null) {
					return;
				} else {
					af.forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init() throws ServletException {
//		System.out.println("初始化了ActionServlet");
	}
}

package bshow.web.servlet.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bshow.dao.GoodsDao;
import bshow.dao.impl.GoodsDaoImpl;
import bshow.pojo.Goods_table;
import bshow.web.servlet.core.Action;
import bshow.web.servlet.core.ActionForm;
import bshow.web.servlet.core.ActionForward;
import bshow.web.servlet.form.NewsGoodByTimeActionForm;
import net.sf.json.JSONArray;

public class ExplosiveGoodAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		NewsGoodByTimeActionForm myform=(NewsGoodByTimeActionForm)form;
		GoodsDao dao=new GoodsDaoImpl();
		//将form转换为自己需要的
		if(myform!=null){
			int page=Integer.parseInt(myform.getPage());
			int pagesize=Integer.parseInt(myform.getPagesize());
			List<Goods_table> list=dao.getGoodsByExplosive(page, pagesize);
			response.setCharacterEncoding("utf-8");
			response.setHeader("Content-Type", "application/json;charset=utf-8");
			JSONArray ja=JSONArray.fromObject(list);
			//将数据交给前端
			PrintWriter out=response.getWriter();
			out.print(URLDecoder.decode(ja.toString(),"UTF-8"));	
		}
		return null;
	}

}

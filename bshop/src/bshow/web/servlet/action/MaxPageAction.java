package bshow.web.servlet.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bshow.dao.Basedao;
import bshow.dao.impl.Basedaoimpl;
import bshow.db.DBhelper;
import bshow.pojo.Goods_table;
import bshow.web.servlet.core.Action;
import bshow.web.servlet.core.ActionForm;
import bshow.web.servlet.core.ActionForward;
import bshow.web.servlet.form.MaxPageActionForm;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class MaxPageAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		Connection conn=DBhelper.getConnection();
		Goods_table goods=new Goods_table();
		Basedao dao=new Basedaoimpl();
		//将form转换为自己需要的
		MaxPageActionForm myform=(MaxPageActionForm)form;
		if(myform!=null){
			int pagesize=Integer.parseInt(myform.getPagesize());
			int maxsize=dao.selectMaxPagesize("selectMaxPagesize", goods, pagesize);
			//将数据交给前端
			PrintWriter out=response.getWriter();
			out.print(maxsize);
		}
		return null;
	}
}

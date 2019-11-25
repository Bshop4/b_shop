package bshow.web.servlet.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.Connection;
import java.util.List;

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
import bshow.web.servlet.form.PageBranchActionForm;
import net.sf.json.JSONArray;

public class PageBranchAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		Connection conn=DBhelper.getConnection();
		Goods_table goods=new Goods_table();
		Basedao dao=new Basedaoimpl();
		//将form转换为自己需要的
		PageBranchActionForm myform=(PageBranchActionForm)form;
		if(myform!=null){
			int page=Integer.parseInt(myform.getPage());
			int pagesize=Integer.parseInt(myform.getPagesize());
			List<Object> list=dao.selectByPagesize("selectByPagesize",goods,page, pagesize);
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

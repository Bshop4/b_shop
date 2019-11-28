package bshow.web.servlet.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bshow.dao.Basedao;
import bshow.dao.impl.Basedaoimpl;
import bshow.db.DBhelper;
import bshow.dto.Goods_classify;
import bshow.pojo.Middle_table;
import bshow.web.servlet.core.Action;
import bshow.web.servlet.core.ActionForm;
import bshow.web.servlet.core.ActionForward;
import bshow.web.servlet.form.GoodsByConditionsActionForm;
import net.sf.json.JSONArray;

public class GoodsByConditionsAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		Basedao bd=new Basedaoimpl();
		GoodsByConditionsActionForm myform=(GoodsByConditionsActionForm)form;
//		//拿到请求所有的参数
//		Map<String, String[]> mymap=request.getParameterMap();
		Map<String, List<Goods_classify>> mymap=bd.selectGoodsByConditions(myform);
//		System.out.println(mymap.size());
//		Set<Map.Entry<String, List<Goods_classify>>> set= mymap.entrySet();
//		for (Map.Entry<String, List<Goods_classify>> entry : set) {
//			if("goodsConditions".equals(entry.getKey())){
//				List<Goods_classify> doods=entry.getValue();
//				for (Goods_classify goods_classify : doods) {
//					System.out.println(goods_classify.toString());
//				}
//			}
//		}
		
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-Type", "application/json;charset=utf-8");
		JSONArray ja=JSONArray.fromObject(mymap);
		//将数据交给前端
		PrintWriter out=response.getWriter();
		out.print(URLDecoder.decode(ja.toString(), "utf-8"));
		return null;
	}

}

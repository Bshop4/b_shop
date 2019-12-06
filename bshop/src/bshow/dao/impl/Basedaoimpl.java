package bshow.dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;

import bshow.dao.Basedao;
import bshow.db.DBhelper;
import bshow.dto.Goods_classify;
import bshow.test.Test;
import bshow.util.MyReplace;
import bshow.util.ober.Looker;
import bshow.web.servlet.form.GoodsByConditionsActionForm;

public class Basedaoimpl implements Basedao, Looker {
	private static final Logger log = Logger.getLogger(Test.class);// 日志
	// 用来存储所有的信息
	Map<String, List<Goods_classify>> allNeeds = new ConcurrentHashMap<String, List<Goods_classify>>();

	@Override
	public boolean saveObject(String id, Object o) {
		// TODO Auto-generated method stub

		Connection conn = DBhelper.getConnection();
		try {
			// 拿到对应的文档xml
			Class c = o.getClass();
			Document doc = DBhelper.getDocumentByClass(c);
			Element insertelement = (Element) doc.selectSingleNode("/class/insert[@id='" + id + "']");
			String sql = insertelement.getTextTrim();
			// 获得多少个参数
			int paramterCount = 0;
			List<String> fileds = new ArrayList<String>();// 带设置的字段List
			Pattern p = Pattern.compile("#[{](\\w+)[}]");
			Matcher m = p.matcher(sql);
			while (m.find()) {
				paramterCount++;
				fileds.add(m.group(1));
			}
			// 替换所有的sql为 ？
			sql = sql.replaceAll("#[{](\\w+)[}]", "?");
			// 预处理
			PreparedStatement ps = conn.prepareStatement(sql);
			// 设值
			for (int i = 0; i < paramterCount; i++) {
				String filedname = fileds.get(i);
				String methodname = "get" + filedname.substring(0, 1).toUpperCase() + filedname.substring(1);
				Method method = c.getMethod(methodname, null);
				ps.setObject(i + 1, method.invoke(o, null));
			}

			int psint = ps.executeUpdate();
			if (psint != 0) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBhelper.closeConnection(conn);
		}
		return false;
	}

	@Override
	public List<Object> select(String id, Object o) {
		List<Object> list = new ArrayList<Object>();
		Class c = o.getClass();
		Connection conn = DBhelper.getConnection();
		try {

			// 根据对象拿到对应的mapping.xml文档
			Document doc = DBhelper.getDocumentByClass(c);
			Element selectelement = (Element) doc.selectSingleNode("/class/select[@id='" + id + "']");
			// 获得元素内容的sql语句
			String sql = selectelement.getTextTrim();
			// 匹配参数有多少个#{}.
			int paramterCount = 0;
			Pattern p = Pattern.compile("#[{](\\w+)[}]");
			Matcher m = p.matcher(sql);
			List<String> fileds = new ArrayList<String>();
			while (m.find()) {
				fileds.add(m.group(1));
				paramterCount++;
			}

			// 替换#{} 为?
			sql = sql.replaceAll("#[{](\\w+)[}]", "?");
			PreparedStatement ps = conn.prepareStatement(sql);
			for (int i = 0; i < paramterCount; i++) {
				String filedname = fileds.get(i);
				Method method = c.getDeclaredMethod(
						"get" + filedname.substring(0, 1).toUpperCase() + filedname.substring(1), null);
				ps.setObject(i + 1, method.invoke(o, null));
			}

			ResultSet rs = ps.executeQuery();
			// 拿到返回了的类型 以及它所有的属性
			String className = ((Attribute) selectelement.selectSingleNode("./@resulttype")).getValue();
			// System.out.println(className);//bshow.pojo.Cart_table
			Class returnclass = Class.forName(className);
			// 获得本类所有的声明字段
			Field[] ffs = returnclass.getDeclaredFields();
			while (rs.next()) {
				Object obj = returnclass.newInstance();
				for (int i = 0; i < ffs.length; i++) {
					String ffsname = ffs[i].getName();
//					System.out.println(ffsname);
					// 拿到set方法
					Method method = returnclass.getDeclaredMethod(
							"set" + ffsname.substring(0, 1).toUpperCase() + ffsname.substring(1), ffs[i].getType());
					// 类属性 对应的字段名
					Attribute column = (Attribute) doc
							.selectSingleNode("/class/property[@name='" + ffsname + "']/@column");
					String columnstr = column.getValue();
					method.invoke(obj, rs.getObject(columnstr));
				}
				list.add(obj);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBhelper.closeConnection(conn);
		}
		return list;
	}

	// 分页
	public List<Object> selectByPagesize(String id, Object o, int page, int pagesize) {
		Connection conn = DBhelper.getConnection();
		List<Object> list = new ArrayList<Object>();
		Class c = o.getClass();
		try {
			// 根据对象拿到对应的mapping.xml文档
			Document doc = DBhelper.getDocumentByClass(c);
			Element selectelement = (Element) doc.selectSingleNode("/class/select[@id='" + id + "']");
			// 获得元素内容的sql语句
			String sql = selectelement.getTextTrim();
			sql = sql + " limit ?,? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (page - 1) * pagesize);
			ps.setInt(2, pagesize);
			ResultSet rs = ps.executeQuery();
			// 拿到返回了的类型 以及它所有的属性
			String className = ((Attribute) selectelement.selectSingleNode("./@resulttype")).getValue();
			Class returnclass = Class.forName(className);
			Field[] ffs = returnclass.getDeclaredFields();

			while (rs.next()) {
				Object obj = returnclass.newInstance();
				for (int i = 0; i < ffs.length; i++) {
					String ffsname = ffs[i].getName();
					// 拿到set方法
					Method method = returnclass.getDeclaredMethod(
							"set" + ffsname.substring(0, 1).toUpperCase() + ffsname.substring(1), ffs[i].getType());
					// 类属性 对应的字段名
					Attribute column = (Attribute) doc
							.selectSingleNode("/class/property[@name='" + ffsname + "']/@column");
					String columnstr = column.getValue();
					method.invoke(obj, rs.getObject(columnstr));
				}
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBhelper.closeConnection(conn);
		}
		return list;
	}

	// 获得最大页数
	public int selectMaxPagesize(String id, Object o, int pagesize) {
		Connection conn = DBhelper.getConnection();
		Class c = o.getClass();
		int count = 0;// 记录总个数
		try {
			// 根据对象拿到对应的mapping.xml文档
			Document doc = DBhelper.getDocumentByClass(c);
			Element selectelement = (Element) doc.selectSingleNode("/class/select[@id='" + id + "']");
			// 获得元素内容的sql语句
			String sql = selectelement.getTextTrim();
//			System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBhelper.closeConnection(conn);
		}
		return count % pagesize == 0 ? count / pagesize : count / pagesize + 1;
	}

	// 多条件查询
	public Map<String, List<Goods_classify>> selectGoodsByConditions(GoodsByConditionsActionForm form) {
		Connection conn = DBhelper.getConnection();
		// select c.goods_price from (select
		// a.goods_no,a.goods_name,a.goods_price,a.goods_brand,b.middle_color,b.middle_size,b.middle_type
		// from goods_table as a inner join middle_table as b on a.goods_no=b.goods_no)
		// as c where
		// 多条件查询
		String sql = "select @ from (select a.goods_like,a.goods_place,a.goods_photo,a.goods_no,a.goods_name,a.goods_price,a.goods_brand,b.middle_color,b.middle_size,b.middle_type from goods_table as a inner join middle_table as b on a.goods_no=b.goods_no) as c where 1=1";
		StringBuffer sb = new StringBuffer(sql);
		if (form.getGoods_name() != null) {
			String judgename = form.getGoods_name().replaceAll("\\s", "");
			String name=judgename.substring(0,judgename.length()-1);
			System.out.println(judgename);
			//第一次为精准查询，第二次为模糊查询
			if(judgename.substring(judgename.length()-1).equals("1")){
				sb.append(" and (c.goods_name like ? or c.goods_brand like ? or c.middle_type like ?)");
			}else{
				char[] myname = name.toCharArray();
				for (int i = 0; i < myname.length; i++) {
					if (i == 0 && myname.length - 1 > 0) {
						sb.append(" and ( (c.goods_name like ? or c.goods_brand like ?)");
					} else if (i == 0) {
						sb.append(" and (c.goods_name like ? or c.goods_brand like ?)");
					} else if (i == myname.length - 1) {
						sb.append(" or (c.goods_name like ? or c.goods_brand like ?) )");
					} else {
						sb.append(" or (c.goods_name like ? or c.goods_brand like ?)");
					}
				}
			}
		}
		if (form.getGoods_price() != null) {
			sb.append(" and c.goods_price>=? and c.goods_price<=?");
		}
		if (form.getGoods_brand() != null) {
			sb.append(" and c.goods_brand=?");
		}
		if (form.getMiddle_color() != null) {
			sb.append(" and c.middle_color=?");
		}
		if (form.getMiddle_size() != null) {
			sb.append(" and c.middle_size=?");
		}
		if (form.getMiddle_type() != null) {
			sb.append(" and c.middle_type=?");
		}
		if (form.getGoods_place() != null) {
			sb.append(" and c.goods_place=?");
		}
		// 根据条件构成sql语句
		sql = sb.toString();
//		System.out.println(sql);

		// 查询还有的品牌
		String mysql = sql + " group by c.goods_brand";
		mysql = mysql.replace("@", "c.goods_brand");
		MyReplace mr = new MyReplace("goods_brand", mysql, conn, this, form);
		// 用线程处理查询
		Thread t = new Thread(mr);
		t.start();

		// 查询还有的价格
		Connection conn2 = DBhelper.getConnection();
		String mysql2 = sql + " group by c.goods_price order by c.goods_price";
		mysql2 = mysql2.replace("@", "c.goods_price");
		MyReplace mr2 = new MyReplace("goods_price", mysql2, conn2, this, form);
		// 用线程处理查询
		Thread t2 = new Thread(mr2);
		t2.start();

		// 查询还有的颜色
		Connection conn3 = DBhelper.getConnection();
		String mysql3 = sql + " group by c.middle_color";
		mysql3 = mysql3.replace("@", "c.middle_color");
		MyReplace mr3 = new MyReplace("middle_color", mysql3, conn3, this, form);
		// 用线程处理查询
		Thread t3 = new Thread(mr3);
		t3.start();

		// 查询还有的尺码
		Connection conn4 = DBhelper.getConnection();
		String mysql4 = sql + " group by c.middle_size";
		mysql4 = mysql4.replace("@", "c.middle_size");
		MyReplace mr4 = new MyReplace("middle_size", mysql4, conn4, this, form);
		// 用线程处理查询
		Thread t4 = new Thread(mr4);
		t4.start();

		// 查询还有的类别
		Connection conn5 = DBhelper.getConnection();
		String mysql5 = sql + " group by c.middle_type";
		mysql5 = mysql5.replace("@", "c.middle_type");
		MyReplace mr5 = new MyReplace("middle_type", mysql5, conn5, this, form);
		// 用线程处理查询
		Thread t5 = new Thread(mr5);
		t5.start();

		// 查询商品
		Connection conn6 = DBhelper.getConnection();
		String mysql6 = sql + " group by c.goods_no order by c.goods_like desc limit ?,?";
		mysql6 = mysql6.replace("@", "c.goods_like,c.goods_no,c.goods_brand,c.goods_name,c.goods_photo,c.goods_price");
		MyReplace mr6 = new MyReplace("goodsConditions", mysql6, conn6, this, form);
		// 用线程处理查询
		Thread t6 = new Thread(mr6);
		t6.start();

		// 查询发货地
		Connection conn7 = DBhelper.getConnection();
		String mysql7 = sql + " group by c.goods_place";
		mysql7 = mysql7.replace("@", "c.goods_place");
		MyReplace mr7 = new MyReplace("goods_place", mysql7, conn7, this, form);
		// 用线程处理查询
		Thread t7 = new Thread(mr7);
		t7.start();

		// 查询最大页数
		Connection conn8 = DBhelper.getConnection();
		String mysql8 = "SELECT COUNT(d.goods_no) from (" + sql + " group by c.goods_no) as d";
		mysql8 = mysql8.replace("@", "c.goods_no");
		MyReplace mr8 = new MyReplace("maxPageCount", mysql8, conn8, this, form);
		// 用线程处理查询
		Thread t8 = new Thread(mr8);
		t8.start();

		// 满足条件跳出循环
		while (true) {
			if (allNeeds.size() == 8) {
				break;
			}
		}
		return allNeeds;
	}

	// 实现观察者
	public void update(Map<String, List<Goods_classify>> mymap) {
		allNeeds.putAll(mymap);
	}

	@Override
	public boolean updataObject(String id, Object o) {
		// TODO Auto-generated method stub
		Connection conn = DBhelper.getConnection();
		try {
			// 拿到对应的文档xml
			Class c = o.getClass();
			Document doc = DBhelper.getDocumentByClass(c);
			Element insertelement = (Element) doc.selectSingleNode("/class/update[@id='" + id + "']");
			String sql = insertelement.getTextTrim();
			// 获得多少个参数
			int paramterCount = 0;
			List<String> fileds = new ArrayList<String>();// 带设置的字段List
			Pattern p = Pattern.compile("#[{](\\w+)[}]");
			Matcher m = p.matcher(sql);
			while (m.find()) {
				paramterCount++;
				fileds.add(m.group(1));
			}
			// 替换所有的sql为 ？
			sql = sql.replaceAll("#[{](\\w+)[}]", "?");

			// 获得多少个需要修改的值
			int paramterval = 0;
			List<String> setval = new ArrayList<String>();// 带设置的字段修改的值List
			Pattern pset = Pattern.compile("@[{](\\w+)[}]");
			Matcher mset = pset.matcher(sql);
			while (mset.find()) {
				paramterval++;
				setval.add(mset.group(1));
			}
			// sql替换所有的 @{\\w+} 为 ？
			sql = sql.replaceAll("@[{](\\w+)[}]", "?");

			// 预处理
			PreparedStatement ps = conn.prepareStatement(sql);
			int index = 0;
			// 设修改值
			for (int i = 0; i < paramterval; i++) {
				String filedname = setval.get(i);
				String methodname = "get" + filedname.substring(0, 1).toUpperCase() + filedname.substring(1);
				Method method = c.getMethod(methodname, null);
				ps.setObject(++index, method.invoke(o, null));
			}

			// 设条件值
			for (int i = 0; i < paramterCount; i++) {
				String filedname = fileds.get(i);
				String methodname = "get" + filedname.substring(0, 1).toUpperCase() + filedname.substring(1);
				Method method = c.getMethod(methodname, null);
				ps.setObject(++index, method.invoke(o, null));
			}

			int psint = ps.executeUpdate();
			if (psint != 0) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBhelper.closeConnection(conn);
		}

		return false;
	}

	@Override
	public boolean deleteObject(String id, Object o) {
		// TODO Auto-generated method stub
		Connection conn = DBhelper.getConnection();
		try {
			// 拿到对应的文档xml
			Class c = o.getClass();
			Document doc = DBhelper.getDocumentByClass(c);
			Element deleteelement = (Element) doc.selectSingleNode("/class/delete[@id='" + id + "']");
//			System.out.println(deleteelement + "aa");
			String sql = deleteelement.getTextTrim();
			// 获得多少个参数
			int paramterCount = 0;
			List<String> fileds = new ArrayList<String>();// 带设置的字段List
			Pattern p = Pattern.compile("#[{](\\w+)[}]");
			Matcher m = p.matcher(sql);
			while (m.find()) {
				paramterCount++;
				fileds.add(m.group(1));
			}
			// 替换所有的sql为 ？
			sql = sql.replaceAll("#[{](\\w+)[}]", "?");
			// 预处理
			PreparedStatement ps = conn.prepareStatement(sql);
			// 设值
			for (int i = 0; i < paramterCount; i++) {
				String filedname = fileds.get(i);
				String methodname = "get" + filedname.substring(0, 1).toUpperCase() + filedname.substring(1);
				Method method = c.getMethod(methodname, null);
				ps.setObject(i + 1, method.invoke(o, null));
			}
			int psint = ps.executeUpdate();
			if (psint != 0) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBhelper.closeConnection(conn);
		}
		return false;
	}

	// delete from table where id in (#{int},#{String},#{int})
	// 表删除多行
	@Override
	public boolean deleteMachObject(String id, Object o, List<Object> list) {
		// TODO Auto-generated method stub
		Connection conn = DBhelper.getConnection();
		// 拿到对应的配置文件
		Class c = o.getClass();
		Document doc = DBhelper.getDocumentByClass(c);
		Element deleteElement = (Element) doc.selectSingleNode("/class/delete[@id='" + id + "']");
		String sql = deleteElement.getTextTrim();
		// 获得多少个参数
		int paramterCount = 0;
		Pattern p = Pattern.compile("#[{]\\w+[}]");
		List<String> typelist = new ArrayList<String>();// 存类型
		Matcher m = p.matcher(sql);
		while (m.find()) {
			paramterCount++;
		}
		sql = sql.replaceAll("#[{]\\w+[}]", "?");
		if (list.isEmpty()) {
			log.warn("deleteMachObject类的参数list为空");
		}

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			for (int i = 0; i < paramterCount; i++) {
				ps.setObject(i + 1, list.get(i));
			}
			int psint = ps.executeUpdate(sql);
			if (psint == paramterCount) {
				return true;
			} else {
				// 回滚
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error(e.toString() + "======" + "dao删除多行数据获取sql语句");
		}

		return false;
	}

}

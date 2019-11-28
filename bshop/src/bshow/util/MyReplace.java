package bshow.util;


import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import bshow.dao.impl.Basedaoimpl;
import bshow.db.DBhelper;
import bshow.dto.Goods_classify;
import bshow.util.ober.Looker;
import bshow.util.ober.Subject;
import bshow.web.servlet.form.GoodsByConditionsActionForm;

public class MyReplace implements Runnable,Subject{
	private String mysql=null;
	private Connection conn=null;
	
	//用来区分存在哪个map中
	private String mykey=null;
	
	private Map<String,List<Goods_classify>> mymap=new HashMap<String, List<Goods_classify>>();
	private Basedaoimpl bdi=null;
	private GoodsByConditionsActionForm form=null;
	
	//用来存储观察者
	List<Looker> myLookers=new ArrayList<Looker>();
	
	public MyReplace(String mykey,String mysql,Connection conn,Basedaoimpl bdi,GoodsByConditionsActionForm form) {
		this.mysql=mysql;
		this.bdi=bdi;
		this.conn=conn;
		this.mykey=mykey;
		this.form=form;
		
		//添加到观察者集合中
		this.addLooker(bdi);
	}
	
	@Override
	public void run() {
		//用来存储取出来的数据
		List<Goods_classify> mylist=new ArrayList<Goods_classify>();
		//用来计数
		int index=0;
		try {
			PreparedStatement ps=conn.prepareStatement(mysql);
			if(form.getGoods_name()!=null){
				char[] myname=form.getGoods_name().toCharArray();
				for (int i = 0; i < myname.length; i++) {
					ps.setString(++index, "%"+myname[i]+"%");
					ps.setString(++index, "%"+myname[i]+"%");
				}
			}
			if(form.getGoods_price()!=null){
				String[] myprice=form.getGoods_price().split("-");
				for (String string : myprice) {
					ps.setDouble(++index, Double.parseDouble(string));
				}
			}
			if(form.getGoods_brand()!=null){
				ps.setString(++index, form.getGoods_brand());
			}
			if(form.getMiddle_color()!=null){
				ps.setString(++index, form.getMiddle_color());
			}
			if(form.getMiddle_size()!=null){
				ps.setString(++index, form.getMiddle_size());
			}
			if(form.getMiddle_type()!=null){
				ps.setString(++index, form.getMiddle_type());
			}
			//分页查询
			if("goodsConditions".equals(mykey)){
				int page=0;
				int pagesize=0;
				if(form.getPage()!=null){
					page=Integer.parseInt(form.getPage());
				}
				if(form.getPagesize()!=null){
					pagesize=Integer.parseInt(form.getPagesize());
				}
				ps.setInt(1, (page-1)*pagesize);
				ps.setInt(2, pagesize);
			}
			ResultSet rs=ps.executeQuery();
			if("goods_price".equals(mykey)){
				System.out.println("goods_price");
				while(rs.next()){
					//存储数据到集合中
					Goods_classify gc=new Goods_classify();
					gc.setGoods_price(rs.getDouble(mykey));
					mylist.add(gc);
				}
			}else if("goodsConditions".equals(mykey)){
				System.out.println("goodsConditions");
				while(rs.next()){
					//存储数据到集合中
					Goods_classify gc=new Goods_classify();
					gc.setGoods_price(rs.getDouble("goods_price"));
					gc.setGoods_name(rs.getString("goods_name"));
					gc.setGoods_no(rs.getString("goods_no"));
					gc.setGoods_photo(rs.getString("goods_photo"));
					mylist.add(gc);
				}
			}else{
				System.out.println(rs.next());
				while(rs.next()){
					Goods_classify gc=new Goods_classify();
					//采用远程调用与反射
					String str="set"+mykey.substring(0,1).toUpperCase()+mykey.substring(1);
					Class c=gc.getClass();
					Method m=c.getDeclaredMethod(str, String.class);
					m.invoke(c, rs.getString(mykey));
					mylist.add(gc);
				}
			}
			mymap.put(mykey, mylist);
			//通知所有观察者
			this.notifyAllLooker(mymap);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBhelper.closeConnection(conn);
		}
	}
	

	@Override
	public void addLooker(Looker looker) {
		myLookers.add(looker);
	}

	@Override
	public void removeLooker(Looker looker) {
		myLookers.remove(looker);
	}

	@Override
	public void notifyAllLooker(Map<String,List<Goods_classify>> mymap) {
		for (Looker looker : myLookers) {
			looker.update(mymap);
		}
	}
}

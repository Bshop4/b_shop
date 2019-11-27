package bshow.util;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import bshow.dao.Basedao;
import bshow.dao.impl.Basedaoimpl;
import bshow.db.DBhelper;
import bshow.pojo.Goods_table;
import bshow.pojo.Middle_table;
import bshow.pojo.Shop_table;
import junit.framework.TestCase;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Loadgoods{
	private Basedao dao=new Basedaoimpl();
	private Basedao dao1=new Basedaoimpl();
	private Basedao dao2=new Basedaoimpl();
	private Shop_table shop=new Shop_table();
	public void action(){
		for (int i = 6; i <= 20; i++) {
			fun(i);
			System.out.println("第"+i+"页");
		}
		
	}
	public void fun(int pageNum){
		Random r=new Random();
		//获取连接
		//Connection conn=DBhelper.getConnection();
		
		Document doc=null;
		try {
			//男装http://139.9.0.154:8090/product/search?v=1&appKey=100001&pageSize=20&pageNum=1&dispId=004&deviceNumber=1574825469317&channel=1
			//女装---http://139.9.0.154:8090/product/search?v=1&appKey=100001&pageSize=20&pageNum="+pageNum+"&dispId=003&deviceNumber=1574651749650&channel=1
			doc =Jsoup.connect("http://139.9.0.154:8090/product/search?v=1&appKey=100001&pageSize=20&pageNum="+pageNum+"&dispId=004&deviceNumber=1574825469317&channel=1").ignoreContentType(true).timeout(10000).get();
			String body = doc.body().html();
			JSONObject json = JSONObject.fromObject(body);
			Object data=json.get("data");
			JSONObject jdata= JSONObject.fromObject(data);
			JSONArray jlist= JSONArray.fromObject(jdata.get("esProducts"));
			JSONObject jsondata2=null;//相当于JSONObject data2=(JSONObject)json2.get("data");
			java.text.DecimalFormat   df =new java.text.DecimalFormat("#.00");  
			//df.format(你要格式化的数字);
			for (Object object : jlist) {
				Middle_table middle=new Middle_table();
				ArrayList<Middle_table> listmiddle=new ArrayList<Middle_table>();
				Goods_table goods=new Goods_table();
				JSONObject obj=JSONObject.fromObject(object);
				//System.out.println("￥"+obj.getString("cuPrice"));
				goods.setGoods_price(Double.parseDouble(obj.getString("cuPrice")));
				//System.out.println("品牌"+obj.getString("brandName"));
				goods.setGoods_brand(obj.getString("brandName"));
				//System.out.println("名字"+obj.getString("productName"));
				goods.setGoods_name(obj.getString("productName"));
				//System.out.println("图片"+obj.getString("proPictDir"));
				goods.setGoods_photo(obj.getString("proPictDir"));
				//System.out.println("折扣0"+df.format(Double.parseDouble(obj.getString("cuPrice"))/Double.parseDouble(obj.getString("originalPrice"))));
				String d=df.format(Double.parseDouble(obj.getString("cuPrice"))/Double.parseDouble(obj.getString("originalPrice")));
				goods.setGoods_discount(Double.parseDouble(d));
				//System.out.println("上架时间"+new Date().getTime());
				long l=new Date().getTime();
				goods.setGoods_uptime(String.valueOf(l));
				//System.out.println("商品编号"+obj.getString("productSid"));
				String code=obj.getString("productSid");
				middle.setGoods_no(code);//中间表
				goods.setGoods_no(code);
				shop.setGoods_no(code);
				
				//详情网页请求 http://139.9.0.154:8080/router?appKey=100001&v=1.0&method=product.newDetail.get&pid=250711473283551&deviceNumber=1574582545228&channel=1
				doc =Jsoup.connect("http://139.9.0.154:8080/router?appKey=100001&v=1.0&method=product.newDetail.get&pid="+code+"&deviceNumber=1574582545228&channel=1").ignoreContentType(true).timeout(10000).get();
				//详情
				JSONObject json2=JSONObject.fromObject(doc.text());
				JSONObject data2=(JSONObject)json2.get("data");
				jsondata2=data2;
				try {
					Pattern p = Pattern.compile("productDetail\":\"([\\s\\S]+)\",\"saleState");
					Matcher m = p.matcher(doc.select("body").html().toString());
					while(m.find())
					{	
						// 具体详情描述
						//System.out.println(m.group(1));
						String st=m.group(1);
						st=st.replaceAll("\\\\t", "");
						st=st.replaceAll("\\\\&quot;", "");
						st=st.replaceAll(".jpg/", ".jpg");
						st=st.replaceAll(".JPG/", ".JPG");
						goods.setGoods_explainphoto(st.getBytes());
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//颜色
				JSONArray arr=(JSONArray)data2.get("skuList");
				int colorlength=0;
				StringBuffer sb=new StringBuffer("");
				StringBuffer sbtype=null;
				for (Object object2 : arr) {
					colorlength++;
					JSONObject  arr_0=(JSONObject)object2;
					//System.out.println("颜色"+arr_0.getString("firstClassAttrName"));
					if(arr.size()==colorlength){
						sb.append(arr_0.getString("firstClassAttrName"));
					}else{
						sb.append(arr_0.getString("firstClassAttrName"));
						sb.append(",");
					}
					
					//商品小图
					int smallength=0;
					StringBuffer sbsmal=new StringBuffer("");
					JSONArray photolist=(JSONArray)arr_0.get("imgUrlList");
					for (int j = 0; j < photolist.size(); j++) {
						//System.out.println("小图==="+photolist.get(j));
						smallength++;
						if(photolist.size()==smallength){
							sbsmal.append(photolist.get(j).toString());
						}else{
							sbsmal.append(photolist.get(j).toString());
							sbsmal.append(",");
						}
					}
					
					//第一个颜色
					if(colorlength==1){
						//goods.setGoods_color(arr_0.getString("firstClassAttrName"));
						middle.setMiddle_color(arr_0.getString("firstClassAttrName"));
						middle.setGoods_smallphoto(sbsmal.toString());
					}
					
					//如果颜色有多种就克隆一个商品
					if(colorlength>1){
						try {
							Middle_table middleclone =(Middle_table)middle.clone();
							middleclone.setMiddle_color(arr_0.getString("firstClassAttrName"));
//							for (Middle_table color : listmiddle) {
////								color.setMiddle_color(arr_0.getString("firstClassAttrName"));
////								color.setGoods_smallphoto(sbsmal.toString());
//								Middle_table colorclone =(Middle_table)color.clone();
//								colorclone.setMiddle_color(arr_0.getString("firstClassAttrName"));
//								colorclone.setGoods_smallphoto(sbsmal.toString());
//								//把克隆放进集合
//								listmiddle.add(colorclone);
//							}
							//把克隆放进集合
							listmiddle.add(middleclone);
						} catch (CloneNotSupportedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					//商品小图
//					int smallength=0;
//					StringBuffer sbsmal=new StringBuffer("");
//					JSONArray photolist=(JSONArray)arr_0.get("imgUrlList");
//					for (int j = 0; j < photolist.size(); j++) {
//						//System.out.println("小图==="+photolist.get(j));
//						smallength++;
//						if(photolist.size()==smallength){
//							sbsmal.append(photolist.get(j).toString());
//						}else{
//							sbsmal.append(photolist.get(j).toString());
//							sbsmal.append(",");
//						}
//					}
					//第一个商品颜色小图
//					if(colorlength==1){
//						middle.setGoods_smallphoto(sbsmal.toString());
//					}
					
					//如果颜色有多种就给克隆一个商品的小图
//					if(colorlength>1){
//						listmiddle.get(colorlength-2).setGoods_smallphoto(sbsmal.toString());
						
//						listgoods.get(colorlength-2).setGoods_smallphoto(sbsmal.toString());
//						try {
//							Goods_table goodsclone =(Goods_table)goods.clone();
//							goodsclone.setGoods_smallphoto(sbsmal.toString());
						//把克隆放进集合
						//listgoods.add(goodsclone);
//						} catch (CloneNotSupportedException e) {
						// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					}
					//System.out.println(sbsmal.toString());
					//goods.setGoods_smallphoto(sbsmal.toString());
					
					
					
					//尺码
					int sizelength=0;
					StringBuffer sbsize=new StringBuffer("");
					JSONArray sizelist=(JSONArray)arr_0.get("skuAndPriceList");
					int ii=listmiddle.size();
					for (Object object3 : sizelist) {
						sizelength++;
						JSONObject objsize=(JSONObject)object3;
						if(sizelist.size()==sizelength){
							sbsize.append(objsize.getString("subClassAttrName"));
						}else{
							sbsize.append(objsize.getString("subClassAttrName"));
							sbsize.append(",");
						}
//						第一个尺码
						if(sizelength==1){
							middle.setMiddle_size(objsize.getString("subClassAttrName"));
							for (Middle_table size : listmiddle) {
								size.setMiddle_size(objsize.getString("subClassAttrName"));
							}
						}
						
						//如果尺码有多种就克隆一个商品
						if(sizelength>1){
							try {
								if(colorlength==1){
									
									Middle_table middleclone =(Middle_table)middle.clone();
									//把克隆放进集合
									middleclone.setMiddle_size(objsize.getString("subClassAttrName"));
									listmiddle.add(middleclone);
								}
								for (int j = 0; j <ii; j++) {
									Middle_table sizeclone =(Middle_table)listmiddle.get(j).clone();
									sizeclone.setMiddle_size(objsize.getString("subClassAttrName"));
									//把克隆放进集合
									listmiddle.add(sizeclone);
								}
							} catch (CloneNotSupportedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
					}
					
					//什么装，女装，下装
					ii=listmiddle.size();
					int typelength=0;
					sbtype=new StringBuffer("");
					JSONArray arrtype=(JSONArray)data2.get("saleCategoryList");
					for (Object type : arrtype) {
						typelength++;
						JSONObject  arr_1=(JSONObject)type;
						//System.out.println("装束的类型 ："+arr_1.getString("categName"));
						if(arrtype.size()==typelength){
							sbtype.append(arr_1.getString("categName"));
						}else{
							sbtype.append(arr_1.getString("categName"));
							sbtype.append(",");
						}
						
						//第一个类型
						if(typelength==1){
							middle.setMiddle_type(arr_1.getString("categName"));
							for (Middle_table tpye : listmiddle) {
								//Middle_table tpyeclone =(Middle_table)tpye.clone();
								tpye.setMiddle_type(arr_1.getString("categName"));
								//把克隆放进集合
								//listmiddle.add(tpyeclone);
							}
						}
						
						//如果类型有多种就克隆一个商品
						if(typelength>1){
							try {
								if(colorlength==1){
									Middle_table middleclone =(Middle_table)middle.clone();
									middleclone.setMiddle_type(arr_1.getString("categName"));
									//把克隆放进集合
									listmiddle.add(middleclone);
								}
								for (int j = 0; j <ii; j++) {
									Middle_table tpyeclone =(Middle_table)listmiddle.get(j).clone();
									tpyeclone.setMiddle_type(arr_1.getString("categName"));
									//把克隆放进集合
									listmiddle.add(tpyeclone);
								}
//								for (Middle_table tpye : listmiddle) {
//									Middle_table tpyeclone =(Middle_table)tpye.clone();
//									tpyeclone.setMiddle_type(arr_1.getString("categName"));
//									//把克隆放进集合
//									listmiddle.add(tpyeclone);
//								}
							} catch (CloneNotSupportedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					
					
					
					//设置克隆的尺码
					//System.out.println(sbsize.toString());
					goods.setGoods_size(sbsize.toString());
					
					if(colorlength==1){
						//System.out.println(colorlength+"====="+middle.toString());
						middle.setMiddle_repertory(r.nextInt(99));
						dao2.saveObject("insertone", middle);
					}
					
					//打印中间表
					for (int j = 0; j < listmiddle.size(); j++) {
						//System.out.println("颜色循坏"+colorlength+"====="+listmiddle.get(j));
						listmiddle.get(j).setMiddle_repertory(r.nextInt(99));
						dao2.saveObject("insertone", listmiddle.get(j));
					}
					
					//把listmiddle
					listmiddle=null;
					listmiddle=new ArrayList<Middle_table>();
					
				}
				
				//System.out.println(sb.toString());
				//循环sb，加颜色
				goods.setGoods_color(sb.toString());
				
				//System.out.println(sbtype.toString());
				goods.setGoods_location(sbtype.toString());
				
				//给空属性，随便给值
				//点赞数
				goods.setGoods_like(r.nextInt(555));
				//类别
				goods.setGoods_category(sbtype.toString());
				//商家
				String shopno=String.valueOf(r.nextInt(5)+1);
				goods.setShop_no(shopno);
				shop.setShop_no(shopno);
				//发货地
				if(data2.get("deliveryRegion")==null){
					goods.setGoods_place("湖南"); 
				}else{
					goods.setGoods_place(data2.getString("deliveryRegion"));
				}
				
				//dao.saveObject("insertone", goods);
				//System.out.println("goods"+goods);
				dao.saveObject("insertone", goods);
				dao1.saveObject("insertone", shop);
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//DBhelper.closeConnection(conn);
		}
		
	}
}

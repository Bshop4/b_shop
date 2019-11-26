package bshow.pojo;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import bshow.dao.Basedao;
import bshow.dao.impl.Basedaoimpl;
import bshow.db.DBhelper;
import junit.framework.TestCase;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Loadgoods extends TestCase{
	public void action(){
		
		for (int i = 1; i <= 1; i++) {
			fun(i);
		}
		
	}
	public void fun(int pageNum){
		Random r=new Random();
		//获取连接
		//Connection conn=DBhelper.getConnection();
		//Basedao dao=new Basedaoimpl();
		Document doc=null;
		ArrayList<Goods_table> listgoods=new ArrayList<Goods_table>();
		try {
			doc =Jsoup.connect("http://139.9.0.154:8090/product/search?v=1&appKey=100001&pageSize=20&pageNum="+pageNum+"&dispId=003&deviceNumber=1574651749650&channel=1").ignoreContentType(true).timeout(10000).get();
			String body = doc.body().html();
			JSONObject json = JSONObject.fromObject(body);
			Object data=json.get("data");
			JSONObject jdata= JSONObject.fromObject(data);
			JSONArray jlist= JSONArray.fromObject(jdata.get("esProducts"));
			JSONObject jsondata2=null;//相当于JSONObject data2=(JSONObject)json2.get("data");
			java.text.DecimalFormat   df =new java.text.DecimalFormat("#.00");  
			//df.format(你要格式化的数字);
			int i=0;
			for (Object object : jlist) {
				Goods_table goods=new Goods_table();
				i++;
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
				goods.setGoods_no(code);
				
				//详情网页请求 http://139.9.0.154:8080/router?appKey=100001&v=1.0&method=product.newDetail.get&pid=250711473283551&deviceNumber=1574582545228&channel=1
				doc =Jsoup.connect("http://139.9.0.154:8080/router?appKey=100001&v=1.0&method=product.newDetail.get&pid="+code+"&deviceNumber=1574582545228&channel=1").ignoreContentType(true).timeout(10000).get();
				//详情
				JSONObject json2=JSONObject.fromObject(doc.text());
				JSONObject data2=(JSONObject)json2.get("data");
				jsondata2=data2;
				//颜色
				JSONArray arr=(JSONArray)data2.get("skuList");
				int colorlength=0;
				StringBuffer sb=new StringBuffer("");
				
				for (Object object2 : arr) {
					colorlength++;
					//JSONObject  arr_0=(JSONObject)arr.get(0);
					JSONObject  arr_0=(JSONObject)object2;
					//System.out.println("颜色"+arr_0.getString("firstClassAttrName"));
					if(arr.size()==colorlength){
						sb.append(arr_0.getString("firstClassAttrName"));
					}else{
						sb.append(arr_0.getString("firstClassAttrName"));
						sb.append(",");
					}
					//第一个颜色
					if(colorlength==1){
						goods.setGoods_color(arr_0.getString("firstClassAttrName"));
					}
					
					//如果颜色有多种就克隆一个商品
					if(colorlength>1){
						i++;
						try {
							Goods_table goodsclone =(Goods_table)goods.clone();
							goodsclone.setGoods_color(arr_0.getString("firstClassAttrName"));
							//把克隆放进集合
							listgoods.add(goodsclone);
						} catch (CloneNotSupportedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					
					//尺码
					int sizelength=0;
					StringBuffer sbsize=new StringBuffer("");
					JSONArray sizelist=(JSONArray)arr_0.get("skuAndPriceList");
					for (Object object3 : sizelist) {
						sizelength++;
						JSONObject objsize=(JSONObject)object3;
						//System.out.println("尺码==="+objsize.getString("subClassAttrName"));
						if(sizelist.size()==sizelength){
							sbsize.append(objsize.getString("subClassAttrName"));
						}else{
							sbsize.append(objsize.getString("subClassAttrName"));
							sbsize.append(",");
						}
//						第一个尺码
						if(sizelength==1){
							goods.setGoods_size(objsize.getString("subClassAttrName"));
						}
						
						//如果尺码有多种就克隆一个商品
						if(sizelength>1){
							try {
								Goods_table goodsclone =(Goods_table)goods.clone();
								goodsclone.setGoods_size(objsize.getString("subClassAttrName"));
								//把克隆放进集合
								//listgoods.add(goodsclone);
							} catch (CloneNotSupportedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
					}
					
					//设置克隆的尺码
					System.out.println(sbsize.toString());
					goods.setGoods_size(sbsize.toString());
					for (int j = 0; j < listgoods.size(); j++) {
						listgoods.get(j).setGoods_size(sbsize.toString());
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
					//第一个商品颜色小图
					if(colorlength==1){
						goods.setGoods_smallphoto(sbsmal.toString());
					}
					
					//如果颜色有多种就给克隆一个商品的小图
					if(colorlength>1){
						listgoods.get(colorlength-2).setGoods_smallphoto(sbsmal.toString());
//						try {
//							Goods_table goodsclone =(Goods_table)goods.clone();
//							goodsclone.setGoods_smallphoto(sbsmal.toString());
							//把克隆放进集合
							//listgoods.add(goodsclone);
//						} catch (CloneNotSupportedException e) {
							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
					}
					System.out.println(sbsmal.toString());
					//goods.setGoods_smallphoto(sbsmal.toString());
					
				}
				
				System.out.println(sb.toString());
				//循环sb，加颜色
				goods.setGoods_color(sb.toString());
				
				//什么装，女装，下装
				int typelength=0;
				StringBuffer sbtype=new StringBuffer("");
				JSONArray arrtype=(JSONArray)data2.get("saleCategoryList");
				for (Object object2 : arrtype) {
					typelength++;
					JSONObject  arr_1=(JSONObject)object2;
					//System.out.println("装束的类型 ："+arr_1.getString("categName"));
					if(arrtype.size()==typelength){
						sbtype.append(arr_1.getString("categName"));
					}else{
						sbtype.append(arr_1.getString("categName"));
						sbtype.append(",");
					}
				}
				System.out.println(sbtype.toString());
				goods.setGoods_location(sbtype.toString());
				//克隆的每一个都加类型
				for (int k = 0; k < listgoods.size(); k++) {
					listgoods.get(k).setGoods_location(sbtype.toString());
				}
				
				
				//给空属性，随便给值
				//点赞数
				goods.setGoods_like(r.nextInt(555));
				//类别
				goods.setGoods_category("无");
				//性别
				goods.setGoods_sex("女装");
				//具体详情描述
				goods.setGoods_explainphoto(data2.getString("productDetail"));
				//商家
				goods.setShop_id(r.nextInt(5)+1);
				
				//发货地
				if(data2.get("deliveryRegion")==null){
					goods.setGoods_place("湖南"); 
				}else{
					goods.setGoods_place(data2.getString("deliveryRegion"));
				}
				
				
				//dao.saveObject("insertone", goods);
				System.out.println(goods);
//				for (int k = 0; k < listgoods.size(); k++) {
//					System.out.println(listgoods.get(k));
//				}
				System.out.println();
				System.out.println();
			}
			System.out.println(i);
			
			for (Goods_table l : listgoods) {
				//给空属性，随便给值
				//点赞数
				l.setGoods_like(r.nextInt(555));
				//类别
				l.setGoods_category("无");
				//性别
				l.setGoods_sex("女装");
				//具体详情描述
				
				//商家
				l.setShop_id(r.nextInt(5)+1);
				
				//发货地
				if(jsondata2.get("deliveryRegion")==null){
					l.setGoods_place("湖南");
				}else{
					l.setGoods_place(jsondata2.getString("deliveryRegion"));
				}
			}
			//打印克隆的数据
			for (int k = 0; k < listgoods.size(); k++) {
				System.out.println(listgoods.get(k));
			}
			//把数据存入库中
//			for (Goods_table l : listgoods) {
//				dao.saveObject("insertone", l);
//			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//DBhelper.closeConnection(conn);
		}
		
	}
}

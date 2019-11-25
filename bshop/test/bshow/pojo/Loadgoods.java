package bshow.pojo;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

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
		//获取连接
		//Connection conn=DBhelper.getConnection();
		Goods_table goods=new Goods_table();
		Document doc=null;
		try {
			doc =Jsoup.connect("http://139.9.0.154:8090/product/search?v=1&appKey=100001&pageSize=20&pageNum="+pageNum+"&dispId=003&deviceNumber=1574651749650&channel=1").ignoreContentType(true).timeout(10000).get();
			String body = doc.body().html();
			JSONObject json = JSONObject.fromObject(body);
			Object data=json.get("data");
			JSONObject jdata= JSONObject.fromObject(data);
			JSONArray jlist= JSONArray.fromObject(jdata.get("esProducts"));
			
			java.text.DecimalFormat   df =new java.text.DecimalFormat("#.00");  
			//df.format(你要格式化的数字);
			int i=0;
			for (Object object : jlist) {
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
					//如果颜色有多种就克隆一个商品
					if(colorlength<1){
						
						
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
					}
					System.out.println(sbsize.toString());
					goods.setGoods_color(sbsize.toString());
					
					
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
					System.out.println(sbsmal.toString());
					goods.setGoods_smallphoto(sbsmal.toString());
					
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
				
				
				System.out.println();
				System.out.println();
			}
			
			System.out.println(i);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//DBhelper.closeConnection(conn);
		}
		
	}
}

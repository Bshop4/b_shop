package bshow.pojo;

import java.io.IOException;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import junit.framework.TestCase;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Loadgoods extends TestCase{
	public void action(){
		for (int i = 1; i <= 5; i++) {
			fun(i);
		}
		
	}
	public void fun(int pageNum){
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
				System.out.println("￥"+obj.getString("cuPrice"));
				System.out.println("名字"+obj.getString("brandName"));
				System.out.println("描述"+obj.getString("productName"));
				System.out.println("图片"+obj.getString("proPictDir"));
				System.out.println("折扣0"+df.format(Double.parseDouble(obj.getString("cuPrice"))/Double.parseDouble(obj.getString("originalPrice"))));
				System.out.println("上架时间"+new Date().getTime());
				System.out.println("商品编号"+obj.getString("productSid"));
				String code=obj.getString("productSid");
				//http://139.9.0.154:8080/router?appKey=100001&v=1.0&method=product.newDetail.get&pid=250711473283551&deviceNumber=1574582545228&channel=1
				doc =Jsoup.connect("http://139.9.0.154:8080/router?appKey=100001&v=1.0&method=product.newDetail.get&pid="+code+"&deviceNumber=1574582545228&channel=1").ignoreContentType(true).timeout(10000).get();
				//详情
				JSONObject json2=JSONObject.fromObject(doc.text());
				JSONObject data2=(JSONObject)json2.get("data");
				//颜色
				JSONArray arr=(JSONArray)data2.get("skuList");
				for (Object object2 : arr) {
					//JSONObject  arr_0=(JSONObject)arr.get(0);
					JSONObject  arr_0=(JSONObject)object2;
					System.out.println("颜色"+arr_0.getString("firstClassAttrName"));
					
					//尺码
					JSONArray sizelist=(JSONArray)arr_0.get("skuAndPriceList");
					for (Object object3 : sizelist) {
						JSONObject objsize=(JSONObject)object3;
						System.out.println("尺码==="+objsize.getString("subClassAttrName"));
					}
					
					//商品小图
					JSONArray photolist=(JSONArray)arr_0.get("imgUrlList");
					for (int j = 0; j < photolist.size(); j++) {
						System.out.println("小图==="+photolist.get(j));
					}
				}
				
				//什么装，女装，下装
				JSONArray arrtype=(JSONArray)data2.get("saleCategoryList");
				for (Object object2 : arrtype) {
					JSONObject  arr_1=(JSONObject)object2;
					System.out.println("装束的类型 ："+arr_1.getString("categName"));
				}
				
				
				System.out.println();
				System.out.println();
			}
			
			System.out.println(i);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

package bshow.pojo;

import java.io.IOException;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import junit.framework.TestCase;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Loadgoods extends TestCase{
	
	public void fun(){
		Document doc=null;
		try {
			//http://139.9.0.154:8080/router?appKey=100001&v=1.0&method=product.newDetail.get&pid=250711473283551&deviceNumber=1574582545228&channel=1
			doc =Jsoup.connect("http://139.9.0.154:8090/plan/search?pageNum=1&pageSize=20&planId=1012").ignoreContentType(true).timeout(10000).get();
			//http://139.9.0.154:8090/plan/search?pageNum=2&pageSize=20&planId=1012
			String body = doc.body().html();
			JSONObject json = JSONObject.fromObject(body);
			Object data=json.get("data");
			JSONObject jdata= JSONObject.fromObject(data);
			JSONArray jlist= JSONArray.fromObject(jdata.get("esProducts"));
			//System.out.println(jlist);
//			System.out.println("$"+jdata.get("cuPrice"));
//			System.out.println("名字"jdata.get("brandName"));
//			System.out.println("描述"+jdata.get("productName"));
//			System.out.println("图片"+jdata.get("proPictDir"));
//			Elements img=doc.getElementsByClass("itemBox");
			java.text.DecimalFormat   df =new java.text.DecimalFormat("#.00");  
			//df.format(你要格式化的数字);
			int i=0;
			for (Object object : jlist) {
				i++;
				JSONObject obj=JSONObject.fromObject(object);
				System.out.println("$"+obj.getString("cuPrice"));
				System.out.println("名字"+obj.getString("brandName"));
				System.out.println("描述"+obj.getString("productName"));
				System.out.println("图片"+obj.getString("proPictDir"));
				System.out.println("折扣0"+df.format(Double.parseDouble(obj.getString("cuPrice"))/Double.parseDouble(obj.getString("originalPrice"))));
				System.out.println("上架时间"+new Date().getTime());
				String code=obj.getString("productSid");
				//http://139.9.0.154:8080/router?appKey=100001&v=1.0&method=product.newDetail.get&pid=250711473283551&deviceNumber=1574582545228&channel=1
				doc =Jsoup.connect("http://139.9.0.154:8080/router?appKey=100001&v=1.0&method=product.newDetail.get&pid="+code+"&deviceNumber=1574582545228&channel=1").ignoreContentType(true).timeout(10000).get();
				JSONObject json2=JSONObject.fromObject(doc.text());
				JSONObject data2=(JSONObject)json2.get("data");
				JSONArray arr=(JSONArray)data2.get("skuList");
				JSONObject  arr_0=(JSONObject)arr.get(0);
				System.out.println("颜色"+arr_0.getString("firstClassAttrName"));
				
				JSONArray photolist=(JSONArray)arr_0.get("imgUrlList");
				for (int j = 0; j < photolist.size(); j++) {
					System.out.println("小图==="+photolist.get(j));
				}
				
				//尺码
				JSONArray sizelist=(JSONArray)arr_0.get("skuAndPriceList");
				for (Object object2 : sizelist) {
					JSONObject objsize=(JSONObject)object2;
					System.out.println("尺码==="+objsize.getString("subClassAttrName"));
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

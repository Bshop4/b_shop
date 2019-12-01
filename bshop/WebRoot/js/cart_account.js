//请求数据库的购物车数据
var XMLHttp;
// 创建ajax对象
function createXMLHttp() {
	// google
	if (window.XMLHttpRequest) {
		XMLHttp = new XMLHttpRequest();
	} else {
		try {
			// IE
			XMLHttp = new ActiveXObject("Msxm2.XMLHTTP");
		} catch (e) {
			XMLHttp = new ActiveXObject("MicrosoftXMLHTTP");
		}
	}
}
// 定义一个需要进行操作的变量
var returnResult;
//定义应付金额
var sum=0;
// 页面加载查询数据库状态值为1的商品
$(document).ready(function() {
	var account_name = getUrlVal("account_name");
	console.log(account_name)
// var goods_ids = window.localStorage.getItem('goods_id');
// console.log(account_name);
// var account = "pyla1";
	createXMLHttp();
	$.ajax({
		type : "POST",
		url : "selectCartGoodsByState.do",
		data : {"account" : account_name},
		success : function(result) {
			var result=JSON.parse(result);
			returnResult = result;
			// 验证
			if (result.account==0) {
				console.log("请求数据失败");
				return;
			};
			for (var i = 0; i < result.length; i++) {
//				console.log(result[i].cgoods_sub);
				sum += result[i].cgoods_sub;
//				console.log(sum)
				var str = `
					<tr class="go-bill">
						<td class="left" data-id=${result[i].cart_id}>
							<img src=${result[i].cgoods_photo} style="width:100px;height:100px"/>
						</td>
						<td class="desc">${result[i].cgoods_desc}</td>
			            <td class="calculate">
				            <span class="count">${result[i].cgoods_number}</span>
			            </td>
						<td>${result[i].cgoods_color}</td>
						<td>${result[i].cgoods_size}</td>
			            <td>${result[i].cgoods_price}</td>
			            <td class="subtotal">${result[i].cgoods_sub}</td>
			            <td><a href="javascript:;" class="del" data-id=${result[i].cart_id}>删除</a></td>
			        </tr>
					`;
				 // 把每次组装好的添加进table
			     $('table').append(str);
			};
//			console.log(sum);
			// 设置总价
			$('.sum-all').html('合计：¥' + sum + '.00');
//			console.log(sum);
			allMount = result.length;
		    // 所有的业务逻辑都在这之后
		    clickAll();
		}
	})
})

function clickAll() {
	// 点击删除 当前元素tr删除
	// 点击整个表格
	$('table').click(function(event) {
		// 点击删除
		if (event.target.className == 'del') {
			// 要做商品减的业务
			console.log('点击了删除');
			// 找到tr删除自己
			var tab = event.target.parentNode.parentNode.parentNode;
			var tr = event.target.parentNode.parentNode;
			// 得到删除的商品的id
			var cart_id = $(event.target).attr("data-id");
			$.ajax({
				type:"POST",
				url:"deleteCartGoods.do",
				data:{"cart_id":cart_id},
				success:function(result){
					var result = JSON.parse(result);
				}
			});
			tab.removeChild(tr);
			// 调用总价
			sumAll();
		}
		;
	});
};


  function mysaveclicks(){
      var name = document.getElementById("myname").value;
      var iphone = document.getElementById("myiphone").value;
      var postcode = document.getElementById("mypostcode").value;
      var pro = document.getElementById("province").value;
      var city = document.getElementById("city").value;
      var area = document.getElementById("area").value;
      var detailaddress = document.getElementById("mydetailaddress").value;

      if(name == ""){
          $(".namelable").show();
          return ;
      }else{
          $(".namelable").hide();
      }

      var reiphone = /^1[0-9]{10}/;
      if(reiphone.test(iphone) != true){
          $(".iplabel").show();
          return;
      }else{
          $(".iplabel").hide();
      }

      if(postcode == ""){
          $(".postlabel").show();
          return ;
      }else{
          $(".postlabel").hide();
      }

      // 新加判断 原地址判断删除
      if(pro == "" || city == "" || area == "" || detailaddress == "" || pro == "请选择省份" || city == "请选择城市" || area == "请选择区县"){
          $("#addlabel").show();
          return;
      }else{
          $("#addlabel").hide();
      }


      if(reiphone.test(iphone) == true && name != "" && postcode != ""){
      // 定义变量
      var getPro;
      var getCity;
      var getArea;
      var AllAddress;

      for(var i=0;i<infos.length;i++){
          if(infos[i].code == $('#province').val()){
              getPro = infos[i].name;// 省份
          }
      };
      for(var j=0;j<cities.length;j++){
          if(cities[j].code == $('#city').val()){
              getCity = cities[j].name;// 城市
              for (var k=0;k<cities[j].area.length;k++){
                  if(cities[j].area[k].code == $('#area').val()){
                      getArea = cities[j].area[k].name;// 区县
                  }
              }
          }
      }
      AllAddress = getPro + getCity + getArea +  detailaddress;

      document.getElementById("save1").setAttribute("data-dismiss","modal");
      $(".address-list").css({
//  		"width": "1180px",
//  		"height": "80px",
    	"display":"inline-block",
  		"margin-left": "10px",
  		"position": "relative",
  	  })
  	  $(".btn-no-data").css({
  		"display": "none",
  	  })
  	  
  	  if(reiphone.test(iphone) == true && name != "" && postcode != ""){
	  	  var obj = $("<li style='float: left;margin-left: 20px;border:2px solid white;'></li>");
	  	  $(".address-list").append(obj)
	  	  obj.append("收货人姓名：" + name);
	  	  obj.append(document.createElement("br"));
	  	  obj.append("收货人电话：" + iphone);
	  	  obj.append(document.createElement("br"));
	  	  obj.append("收货人邮编：" + postcode);
	  	  obj.append(document.createElement("br"));
	  	  obj.append("收货人地址：" + AllAddress);
	  	  
	  	  $("li").click(function() {
	        $(this).siblings('li').removeClass('selected');    // 删除其他li的边框样式
	        $(this).addClass('selected');                            // 为当前li添加边框样式
	  	  });
	
	  	  document.getElementById("myname").value = "";
	  	  document.getElementById("myiphone").value = "";
	  	  document.getElementById("mypostcode").value = "";
	  	  document.getElementById("province").value = "请选择省份";
	  	  document.getElementById("city").value = "请选择城市";
	  	  document.getElementById("area").value = "请选择区县";
	  	  document.getElementById("mydetailaddress").value = "";  
      }
      }
  }
  
// 获得地址参数栏的值
  function getUrlVal(property) {
  	// 地址栏
  	var urlStr = window.location.search.substring(1);
  	var re = new RegExp('(^|&)' + property + '=([^&]*)(&|$)');
  	var result = urlStr.match(re);
  	if(result == null) {
  		return;
  	};
  	return result[2];
  };
  
  $('#btn-account').click(function() { 
	  console.log(222111);
		$('go-bill').each(function(i) {
//			console.log($(this));	
			var tab = $(this).parent();
			var tr = $(this);
			console.log(111);
			cart_id = $(this).eq(i).find("td:first").attr("data-id");
			console.log(cart_id);
////			先根cart_id更新一遍,选的是哪个id，将这个商品的状态值改变
//			$.ajax({
//				type : "POST",
//				url : "xsyinsertBill.do",
//				data : {"cart_id" : cart_id},
//				success : function(result) {
//					var result=JSON.parse(result);
//					console.log(result);
//				}
//			})
//			tab.get(0).removeChild(tr.get(0));
		})
//		window.open('pay.jsp');
	  	var mone = document.getElementById('sum-all').innerHTML;
//	  	console.log(money);
	  	var money = mone.substring(4);
//		location.href="pay.jsp?pay_money="+money;
		//var dizhi = $('.address-list'.children.class="selected");
		//console.log(dizhi+"222");
////		window.localStorage.setItem('goods_id',cart_id);
	})
  
  

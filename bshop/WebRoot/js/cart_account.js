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
// 定义应付金额
var sum=0;
var account_name;
// 页面加载查询数据库状态值为1的商品
$(document).ready(function() {
	// 支付订单按钮禁用
	$(".btn-account").attr("disabled",true);
	$(".btn-account").css({"cursor":"not-allowed"});
	account_name = getUrlVal("account_name");
	console.log(account_name);
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
				sum += result[i].cgoods_sub;
				var str = `
					<tr class="go-bill" data-tr="active">
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
			            <td><a href="javascript:;" class="del" data-id=${result[i].cart_id} data-toggle="modal" data-target="#myModal">删除</a></td>
			        </tr>
					`;
				 // 把每次组装好的添加进table
			     $('table').append(str);
			};
			// 设置总价
			$('.sum-all').html('合计：¥' + sum + '.00');
			allMount = result.length;
		    // 所有的业务逻辑都在这之后
		    clickAll();
		}				
	})
	// 找出买家默认地址
	$.ajax({
		type:"POST",
		url:"defaultAddress.do",
		data:{"account":account_name},
		success:function(result){
			var result = JSON.parse(result);
//			console.log(result);
			var obj1 = eval(result);
			$(".address-list").css({
		    	"display":"inline-block",
		  		"margin-left": "10px",
		  		"position": "relative",
		  	  })
		  	$(".btn-no-data").css({
		  		"display": "none",
		  	})
			 // 添加默认li标签
		  	  for (var i = 0; i < obj1.length; i++) {
			  	  var obj = $("<li onclick='defaultli(this)' style='float: left;margin-left: 20px;border:2px solid white;'></li>");
			  	  $(".address-list").append(obj)
//			  	  console.log(obj1.length);
		  		  obj.append("收货人姓名：" + obj1[i].receiver);
		  		  obj.append(document.createElement("br"));
		  		  obj.append("收货人电话：" + obj1[i].telephone);
		  		  obj.append(document.createElement("br"));
		  		  obj.append("收货人邮编：" + obj1[i].postal);
		  		  obj.append(document.createElement("br"));
		  		  obj.append("收货人地址：" + obj1[i].address);		
			}
		}
	})	
	
})
var sum1=0;
function clickAll() {
	// 点击整个表格
	$('table').click(function(event) {
		// 点击删除
		if (event.target.className == 'del') {
			// 要做商品减的业务
			// 找到tr
			var tab = event.target.parentNode.parentNode.parentNode;
			var tr = event.target.parentNode.parentNode;
//			console.log(event.target.parentNode.previousElementSibling.innerText)
			// 得到删除的商品的id
			var cart_id = $(event.target).attr("data-id");
//			$.ajax({
//				type:"POST",
//				url:"updateInac.do",
//				data:{"cart_id":cart_id},
//				success:function(result){
//					var result = JSON.parse(result);
//				}
//			});
			sum1 =sum - event.target.parentNode.previousElementSibling.innerText
			console.log(sum1);
			$('.el-sure').click(function(){
				console.log(111)
				$.ajax({
					type:"POST",
					url:"deleteCartGoods.do",
					data:{"cart_id":cart_id},
					success:function(result){
						var result = JSON.parse(result);
						console.log(result);// true(删除成功)
						$('.sum-all').html('合计：¥' + sum1 + '.00');
						tab.removeChild(tr);// 删除tr
					}
				});
			})
//			// 调用总价
//			sumAll();
		}
		;
	});
};

//求总价方法
//function sumAll() {
//	var sum = 0;
//	// 拿到所的 active
//	$('[data-tr="active"]').each(function() {
//		sum += parseInt($(this).children().siblings('.subtotal').html());
//	});
//	// 设置总价
//	$('.sum-all').html('合计：¥' + sum + '.00');
//};

// 定义地址
var name="";
var iphone="";
var postcode="";
var AllAddress="";
  // 点击模态框的保存
  function mysaveclicks(){
      name = document.getElementById("myname").value;
      iphone = document.getElementById("myiphone").value;
      postcode = document.getElementById("mypostcode").value;
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
    	"display":"inline-block",
  		"margin-left": "10px",
  		"position": "relative",
  	  })
  	  $(".btn-no-data").css({
  		"display": "none",
  	  })
  	  
  	  if(reiphone.test(iphone) == true && name != "" && postcode != ""){
  		  // 收货信息不为空保存到数据库
  		  $.ajax({
  			  type:"POST",
  			  url:"saveAddress.do",
  			  data:{"name":name,"iphone":iphone,"postcode":postcode,"AllAddress":AllAddress,"account":account_name},
  			  success:function(result){
  				  console.log(result);
  			  }
  		  })
  		  // 添加li标签
	  	  var obj = $("<li onclick='defaultli(this)' style='float: left;margin-left: 20px;border:2px solid white;' data=df></li>");
	  	  $(".address-list").append(obj)
	  	  obj.append("收货人姓名：" + name);
	  	  obj.append(document.createElement("br"));
	  	  obj.append("收货人电话：" + iphone);
	  	  obj.append(document.createElement("br"));
	  	  obj.append("收货人邮编：" + postcode);
	  	  obj.append(document.createElement("br"));
	  	  obj.append("收货人地址：" + AllAddress);
	  	  
// $(".address-list li").click(function() {
// $(this).siblings('li').removeClass('selected');// 删除其他li的边框样式
// $(this).addClass('selected');// 为当前li添加边框样式
// $(".btn-account").attr("disabled",false);//取消禁用标志
// $(".btn-account").css({"cursor":"pointer"});
// console.log($('li').prop("className"));
//			
// //如果是选中则将收获信息的状态值改为2
// if($('.address-list li').prop("className")=='selected') {
// $.ajax({
// type:"POST",
// url:"updateAddress.do",
// data:{"name":name,"iphone":iphone,"postcode":postcode,"AllAddress":AllAddress},
// success:function(result){
// console.log(result);
// }
// })
// }
		      
		    // 如果不是选中则将收获信息的状态值改为0
// if($(this).siblings('li').class!='selected') {
// $.ajax({
// type:"POST",
// url:"updateAddress1.do",
// data:{"name":name,"iphone":iphone,"postcode":postcode,"AllAddress":AllAddress},
// success:function(result){
// console.log(result);
// }
// })
// }
// });

	  	  // 保存后将地址信息设为空
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
  
var dizhi;
function defaultli(obj){
	var str = $(obj).text();
	var str1 = str.split("收");
	var name = str1[1].slice(5);
	var iphone = str1[2].slice(5);
	var postcode = str1[3].slice(5);
	var AllAddress = str1[4].slice(5);
	$(obj).siblings('li').removeClass('selected');// 删除其他li的边框样式
    $(obj).addClass('selected');// 为当前li添加边框样式
    $(".btn-account").attr("disabled",false);// 取消禁用标志
    $(".btn-account").css({"cursor":"pointer"});
    dizhi = AllAddress;
    console.log(dizhi);
	  // 如果是选中则将收获信息的状态值改为2
//    if($(obj).prop("className")=='selected') {
  	 $.ajax({
  		 type:"POST",
  		 url:"updateAddress.do",
  		 data:{"name":name,"iphone":iphone,"postcode":postcode,"AllAddress":AllAddress,"account":account_name},
  		 success:function(result){
  			 console.log(result);
  		 }
  	  })
//    }
}
//点击支付订单存入数据并且跳转到倒计时页面
$('#btn-account').click(function() { 
		$('[data-tr="active"]').each(function() {
			var tab = $(this).parent();
			var tr = $(this);
			//var sss = name+iphone+postcode+AllAddress;
			cart_id = $(this).find("td:first").attr("data-id");
			console.log(cart_id);
			// 把订单cart_id,account,address传给需要插入的action
			$.ajax({
				type : "POST",
				url : "xsyinsertBill.do",
				data : {"cart_id" : cart_id,"account":account_name,"address":dizhi},
				success : function(result) {
					var result=JSON.parse(result);
					console.log(result); 
				} 
			})
		})
		// 如果是选中则将收获信息的状态值改为1
//if($('li').class='selected') {
//$.ajax({
//type:"POST",
//url:"updateAddress.do",
//data:{"name":name,"iphone":iphone,"postcode":postcode,"AllAddress":AllAddress},
//success:function(result){
//console.log(result);
//}
//})
//}
	  	var mone = document.getElementById('sum-all').innerHTML;
	  	var money = mone.substring(4);
	  	console.log(money);
	  	// 跳转
	  	location.href="/bshop/badAccess/pay.jsp?pay_money="+money+"&pay_name="+account_name;
	})

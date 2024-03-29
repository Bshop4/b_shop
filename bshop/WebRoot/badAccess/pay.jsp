<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>我的支付界面</title>
		<style>
			* {
				margin: 0px;
				padding: 0px;
			}
			img {
				border: none;
				vertical-align: bottom;
			}
			a {
				text-decoration: none;
			}
			li {
				list-style: none;
			}
			.disburse {
				width: 1200px;
				/*background: darkseagreen;*/
				margin: 100px auto;
			}
			.clock {
				display: inline-block;
			}
			.title {
				font-size: 18px;
				padding-left: 40px;
				/*display: inline-block;*/
			}
			.countDown {
				padding-top: 6px;
				font-size: 15px;
				display: inline-block;
				/*display: inline-block;*/
			}
			.quickly {
				display: inline-block;
			}
			.dis-top {
				width: 270px;
				margin: auto;
			}
			.order-info {
				margin-top: 31px;
				margin-left: -480px;
				height: 120px;
				width: 1200px;
				background-color: #ecefef;
				text-align: center;
			}
			h4 {
				padding-top: 36px;
				font-size: 16px;
			}
			.order-info-p {
				padding-top: 20px;
			}
			.inputone{
				line-height: 44px;
			}
			.inputtwo{
				line-height: 44px;
				padding-left: 40px;
			}
			.zfb-wx{
				cursor: pointer;
				margin-top: 30px;
				margin-left: 30px;
			}
			.ple-pay{
				margin-top: 30px;
			}
			.el-radio_original{
				width: 16px;
				height: 16px;
			}
			.go-pay{
				text-align: center;
				line-height: 60px;
			}
			.pay-btn{
				width: 200px;
				height: 60px;
				background: black;
				margin: 48px auto 0;
				color: white;
				cursor: pointer;
				font-size: 25px;
			}
			.lblb{
				cursor:pointer;
			}
			.msg{
				display: none;
			}
		</style>
		<link rel="stylesheet" href="/bshop/css/animate.css" />
		<link rel="stylesheet" href="/bshop/css/bootstrap.css" />
		<link rel="stylesheet" href="/bshop/css/index.css" />
		<link rel="stylesheet" href="/bshop/css/base.css" />
	</head>

	<body>
		<!--头部-->
		<div class="top">
			<div class="top-bar">
				<div class="btn">
					<a href="sign.jsp">注册</a>
					<a href="Login.jsp">登录</a>
					<a class="glyphicon glyphicon-shopping-cart"></a>
				</div>
				<div class="logBtn">
					<a class="mingZi"></a>
					<a class="exitM">[退出]</a>&nbsp;&nbsp;&nbsp;|
					<a class="glyphicon glyphicon-shopping-cart" href="/bshop/badAccess/cart.jsp"></a>
					<span class="badge store_number">0</span>
					<ul class="last-span">|&nbsp;&nbsp;&nbsp;我的嘿店<p class="glyphicon glyphicon-chevron-down"></p>
						<li>
							<div class="personalInfo">
								<a href="/bshop/PersonInfo">个人中心</a>
								<a>我的订单</a>
								<a>我的收藏</a>
							</div>
						</li>
					</ul>
					
				</div>

				<!--整合logo-->
				<div class="logo">
				</div>
				<div class="search-wrap">
					<input placeholder="搜索品牌或类别或名字" maxlength="4" onkeyup="this.value=this.value.replace(/[^a-zA-Z\u4e00-\u9fa5]/g,'')" />
					<button class="glyphicon glyphicon-search"></button>
				</div>
			</div>
		</div>
		<!--导航-->
		<div class="taber-bar">
			<!--上部分导航-->
			<div class="tabs-list-top">
				<ul class="tabs-list text-center">
					<li class="tab">
						<a href="/bshop/index.jsp">首页</a>
					</li>
					<li class="tab">
						<a href="/bshop/newsGood.jsp">新品</a>
					</li>
					<li class="tab">
						<a href="/bshop/classify.jsp?middle_type=男装">男装</a>
					</li>
					<li class="tab">
						<a href="/bshop/classify.jsp?middle_type=女装">女装</a>
					</li>
					<li class="tab">
						<a href="/bshop/explosiveGood.jsp">爆款</a>
					</li>
					<li class="tab">
						<a>嘿店移动版</a>
					</li>
				</ul>
			</div>
			<!--下部分导航-->
			<div class="tabs-list-buttom">
				<ul class="tabs-list text-center">
				</ul>
			</div>
		</div>
		<div class="disburse">
			<div class="dis-top">
				<div class="clock"><img src="/bshop/img/clock11.png" /></div>
				<div class="quickly">
					<div class="title">请尽快完成支付</div>
					<div class="countDown" id="timer1">订单将在0小时0分0秒后关闭</div>
				</div>
				<div class="order-info">
					<h4 id="heji">合计：￥0.00</h4>
					<p class="order-info-p" id="sh-msg"><span>收货信息:</span></p>
				</div>
			</div>
			<div class="dis-mid">
				<p class="ple-pay">请选择支付方式</p>
				<p class="zfb-wx"><label class="lblb"><span class="inputone"><input type="radio" class="el-radio_original" name="sex"/><img src="/bshop/img/zhifubao11.png"></span></label><label class="lblb"><span class="inputtwo"><input type="radio" class="el-radio_original" name="sex"/><img src="/bshop/img/weixin11.png"></span></label></p>
			</div>
			<div class="go-pay"><button type="button" class="pay-btn" id="pay-btn" data-toggle="modal" data-target="#payment1">支付</button></div>
		</div>
		
		<div class="modal fade" id="payment1" data-backdrop="static"
			id="addressform">
			<div class="modal-dialog">
				<div class="modal-content" style="width:500px;height:300px;">

					<div class="modal-header">
						<h2 class="text-success modal-title">
							支付 <span class="close" data-dismiss="modal">&times;</span>
						</h2>  
					</div>

					<div class="modal-body">
						<div class="row">
							<div class="col-md-8 col-md-offset-2">
								<div class="form-group">
									<label>请输入支付密码:</label> <input type="password" class="form-control"
										id="paypass" /><span class="msg">正在支付...</span>
								</div>
							</div>
						</div>
					</div>

					<div class="modal-footer">
					<center>
						<button class="btn btn-success" id="paypay" onclick="goPay(this)">支付</button>
					</center>
					</div>

				</div>
			</div>
		</div>
	</div>
		
		
		
		
		
	<!--返回顶部-->
		<div class="toTop">
			<span class="glyphicon glyphicon-open"></span>
		</div>
		<!--底部-->
		<div id="row-1">
			<!--底部三个图标-->
			<div class="row-1">
				<div class="ariplane">
					<img src="/bshop/img/airplane.png" /> 海外直销
				</div>
				<div class="handshake">
					<img src="/bshop/img/handshake.png" /> 品质保证
				</div>
				<div class="zheng">
					<img src="/bshop/img/zheng.png" /> 售后保障
				</div>
			</div>
		</div>
		<!--底部banner与二维码-->
		<div id="row-2">
			<div class="row-2">
				<div class="logo-wrap">
					<img src="/bshop/img/Bshop_logo1.png" class="logo-wrap-img1" />
					<a><img src="/bshop/img/weixin.png" class="logo-wrap-img2" /></a>
					<a><img src="/bshop/img/weibo.png" class="logo-wrap-img3" /></a>
				</div>
				<ul class="help-link-list">
					<li class="link">
						<a>ceo邮箱</a>
					</li>
					<li class="link">
						<a>售后服务</a>
					</li>
					<li class="link">
						<a>常见问题</a>
					</li>
					<li class="link">
						<a>关税问题</a>
					</li>
					<li class="link">
						<a>物流配送</a>
					</li>
				</ul>
				<div class="qrcode-wrap">
					<div class="qrcode-wrap-title">
						<span>移动嘿店</span>
					</div>
					<ul>
						<li class="qrcpde"><img src="/bshop/img/erweima.png"></li>
						<li class="qrcpde"><img src="/bshop/img/erweima.png"></li>
						<li class="qrcpde"><img src="/bshop/img/erweima.png"></li>
					</ul>
				</div>
				<div class="contact-wrap">
					<div class="contact-wrap-title">
						<span>联系我们</span>
						<p>
							<a>400-888-4499(9:00~19:00)</a>
						</p>
					</div>
					<div class="btn-service">
						在线客服
					</div>
				</div>
			</div>
		</div>

		<div id="row-3">
			<div class="row-3">
				<div class="copytright">
					Copyright © 2008-2018 Xiu.com深圳走秀网络科技有限公司版权所有 . 粤ICP备07502993号 粤公网安备 44030402000804号
				</div>
			</div>
		</div>

		<div id="row-4">
			<div class="row-4">
				<div class="row-4-m">
					<div class="row-4-service">
						<a><img src="/bshop/img/licence2.png"></a></div>
					<div class="row-4-service">
						<a><img src="/bshop/img/licence1.png"></a>
					</div>
					<a class="row-4-service-2"><img src="/bshop/img/police2.png"></a>
					<a class="row-4-service-2"><img src="/bshop/img/police1.png"></a>
					<a class="row-4-service-2"><img src="/bshop/img/rights.png"></a>
				</div>
			</div>
		</div>
	</body>

</html>
<script src="/bshop/js/jquery.min.js"></script>
<script src="/bshop/js/bootstrap.js"></script>
<script type="text/javascript" src="/bshop/js/banner.js"></script>
<script src="/bshop/js/base.js"></script>
<script> 
 //倒计时
  function countDown( maxtime,fn ) {   
    var timer = setInterval(function() { 
        if( !!maxtime ){   
          var day = Math.floor(maxtime / 86400),
          hour = Math.floor((maxtime % 86400) / 3600),
        minutes = Math.floor((maxtime % 3600) / 60), 
        seconds = Math.floor(maxtime%60),  
        msg = "订单将在"+hour+"小时"+minutes+"分"+seconds+"秒"+"后关闭";   
        fn( msg ); 
        --maxtime;   
      } else {   
        clearInterval( timer ); 
        fn("订单将在0小时0分0秒后关闭");  
      }   
    }, 1000); 
  } 
  countDown( 1799,function( msg ) { 
    document.getElementById('timer1').innerHTML = msg; 
  }) 
 // 获取价格
 $(document).ready(function() {
	var pay_money = getUrlVal("pay_money");
	var uname = getUrlVal("pay_name");
	document.getElementById('heji').innerHTML = "应付：￥"+pay_money;
	$.ajax({
		type:"POST",
		url:"getMyAddress.do",
		data:{"msg":2,"uname":uname},
		success:function(result){
			var result = JSON.parse(result);
			//console.log(result);
			var obj1 = eval(result);
			//设置收货地址
			document.getElementById('sh-msg').innerHTML = "收货人:"+obj1[0].receiver +"  "+"电话:"+ obj1[0].telephone+"  "+"邮编:"+ obj1[0].postal+"  "+"地址:"+ obj1[0].address; 
		}
	})
 })
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
  //如果点击支付就改变订单状态。
 // document.getElementById("#pay-btn").onclick = function(){
	 //console.log(222);
 // }
	//function paypass(){
	//	var str = prompt("请填写支付密码", ""); 
	//}
	
	
	function goPay(obj){
		$(".msg").html("正在支付...").show().css("color","green");
		var pay_money = getUrlVal("pay_money");
		var pay_name = getUrlVal("pay_name");
		var billcode = getUrlVal("bill_code");
		var pay_pass = $("#paypass").val();
		
		var test = {
			"pay_money" : pay_money,
			"pay_name" : pay_name,
			"pay_pass" : pay_pass,
		}
		
		$.ajax({
			type : "post",
			url : "paymentInterface.do",
			data : {"msg" : JSON.stringify(test)},
			success: function(re){
				//console.log(re);
				if(re == "密码不正确！"){
					$(".msg").html(re).show().css("color","red");
				}
				if(re == "余额不足"){
					$(".msg").html(re).show().css("color","red");
				}
				if(re == "支付成功"){
					$(".msg").html(re).show().css("color","green");
				
				//去修改订单的支付情况	
				$.ajax({
					type : "post",
					url : "updateBillClearing.do",
					data : {
						"billcode" : billcode
					},
					success : function(re) {
					}
				}); 
				
				setTimeout(function() {
					$("#payment1").modal("hide");
					location.href="/bshop/badAccess/successful.jsp";
				}, 600);
					
					//document.getElementById("paypay").setAttribute("data-dismiss", "modal");
				} 
				
			}
		})
	}
	
	
	
	
	
	
	
	
	
</script> 
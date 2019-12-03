<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title></title>
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
				text-align: center;
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
		</style>
	</head>

	<body>
		<div class="disburse">
			<div class="dis-top">
				<div class="clock"><img src="img/clock11.png" /></div>
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
				<p class="zfb-wx"><label class="lblb"><span class="inputone"><input type="radio" class="el-radio_original" name="sex"/><img src="img/zhifubao11.png"></span></label><label class="lblb"><span class="inputtwo"><input type="radio" class="el-radio_original" name="sex"/><img src="img/weixin11.png"></span></label></p>
			</div>
			<div class="go-pay"><button type="button" class="pay-btn">去支付</button></div>
		</div>
	</body>

</html>
<script src="js/jquery.min.js"></script>
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
	document.getElementById('heji').innerHTML = "应付：￥"+pay_money;
	$.ajax({
		type:"POST",
		url:"getMyAddress.do",
		data:{"msg":2},
		success:function(result){
			var result = JSON.parse(result);
			console.log(result);
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
</script> 
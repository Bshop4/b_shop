<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>支付成功</title>
<link rel="stylesheet" href="/bshop/css/animate.css" />
<link rel="stylesheet" href="/bshop/css/bootstrap.css" />
<link rel="stylesheet" href="/bshop/css/index.css" />
<link rel="stylesheet" href="/bshop/css/base.css" />
<link rel="stylesheet" href="/bshop/css/bootstrap.css" />
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
			.more{
				width: 1200px;
				margin: auto;
			}
			.gg{
				width: 95px;
				margin: 100px auto 0px;
			}
			.zfcg{
				font-size: 20px;
				text-align: center;
				text-autospace: 2px;
				margin-top: 20px;
			}
			.witer{
				text-align: center;
				margin-top: 20px;
			}
		</style>
</head>
<body>

<!--头部-->
	<div class="top">
		<div class="top-bar">
			<div class="btn">
				<a href="/bshop/sign.jsp" target="_blank">注册</a> <a href="/bshop/Login.jsp"
					target="_blank">登录</a> <a class="glyphicon glyphicon-shopping-cart"></a>
			</div>
			<div class="logBtn">
				<a class="mingZi"></a> <a class="exitM">[退出]</a>&nbsp;&nbsp;&nbsp;|
				<a class="glyphicon glyphicon-shopping-cart" href="/bshop/badAccess/cart.jsp"></a> <span
					class="badge store_number">0</span>
				<ul class="last-span">
					|&nbsp;&nbsp;&nbsp;我的嘿店
					<p class="glyphicon glyphicon-chevron-down"></p>
					<li>
						<div class="personalInfo">
							<a href="/bshop/PersonInfo">个人中心</a> <a>我的订单</a> <a>我的收藏</a>
						</div>
					</li>
				</ul>

			</div>

			<!--整合logo-->
			<div class="logo"></div>
			<div class="search-wrap">
				<input placeholder="搜索商品" maxlength="4"
					onkeyup="this.value=this.value.replace(/[^a-zA-Z\u4e00-\u9fa5]/g,'')" />
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
						<a href="index.jsp">首页</a>
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
	<!--所有商品-->
	<section class="section-merchandise">
	<div class="merchandise">
		<ul></ul>
	</div>
	</section>
	<div class="more">
		<div class="gg">
			<img src="/bshop/img/zfwc.png"/>
		</div>
			<p class="zfcg">支付成功!</p>
			<p class="witer">感谢您够买嘿店商品，工作人员立即为您发货！</p>
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
				<img src="/bshop/img/Bshop_logo1.png" class="logo-wrap-img1" /> <a><img
					src="/bshop/img/weixin.png" class="logo-wrap-img2" /></a> <a><img
					src="/bshop/img/weibo.png" class="logo-wrap-img3" /></a>
			</div>
			<ul class="help-link-list">
				<li class="link"><a>ceo邮箱</a></li>
				<li class="link"><a>售后服务</a></li>
				<li class="link"><a>常见问题</a></li>
				<li class="link"><a>关税问题</a></li>
				<li class="link"><a>物流配送</a></li>
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
				<div class="btn-service">在线客服</div>
			</div>
		</div>
	</div>

	<div id="row-3">
		<div class="row-3">
			<div class="copytright">Copyright © 2008-2018
				Xiu.com深圳走秀网络科技有限公司版权所有 . 粤ICP备07502993号 粤公网安备 44030402000804号</div>
		</div>
	</div>

	<div id="row-4">
		<div class="row-4">
			<div class="row-4-m">
				<div class="row-4-service">
					<a><img src="/bshop/img/licence2.png" /> </a>
				</div>
				<div class="row-4-service">
					<a><img src="/bshop/img/licence1.png"></a>
				</div>
				<a class="row-4-service-2"><img src="/bshop/img/police2.png"></a> <a
					class="row-4-service-2"><img src="/bshop/img/police1.png"></a> <a
					class="row-4-service-2"><img src="/bshop/img/rights.png"></a>
			</div>
		</div>
	</div>
</body>
</html>
<script src="/bshop/js/jquery.min.js"></script>
<script type="text/javascript" src="/bshop/js/bootstrap.js"></script>
<script type="text/javascript" src="/bshop/js/base.js"></script>
<script type="text/javascript" src="/bshop/js/banner.js"></script>
<script type="text/javascript" src="/bshop/js/infos.js"></script>


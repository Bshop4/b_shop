<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<title>B-SHOP嘿店</title> 
		<link rel="stylesheet" href="css/animate.css" />
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/index.css" />
		<link rel="stylesheet" href="css/base.css" />
  </head>
  
  <body>
    		<!--头部-->
		<div class="top">
			<div class="top-bar">
				<div class="btn">
					<a href="sign.jsp" target="_blank">注册</a>
					<a href="Login.jsp" target="_blank">登录</a>
					<a class="glyphicon glyphicon-shopping-cart"></a>
				</div>
				<div class="logBtn">
					<a class="mingZi"></a>
					<a class="exitM">[退出]</a>&nbsp;&nbsp;&nbsp;|
					<a class="glyphicon glyphicon-shopping-cart" href="cart.jsp"></a>
					<span class="badge store_number">0</span>
					<ul class="last-span">|&nbsp;&nbsp;&nbsp;我的嘿店<p class="glyphicon glyphicon-chevron-down"></p>
						<li>
							<div class="personalInfo">
								<a href="personInfo.jsp">个人中心</a>
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
					<input placeholder="搜索商品" />
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
						<a>新品</a>
					</li>
					<li class="tab">
						<a>男士</a>
					</li>
					<li class="tab">
						<a>女士</a>
					</li>
					<li class="tab">
						<a>品牌</a>
					</li>
					<li class="tab">
						<a>走秀移动版</a>
					</li>
				</ul>
			</div>
			<!--下部分导航-->
			<div class="tabs-list-buttom">
				<ul class="tabs-list text-center">
				</ul>
			</div>
		</div>
		<!--轮播图-->
		<section class="section-banner">
			<div class="banner">
				<ul>
					<li class="active">
						<a href="">
							<img src="img/banner01.webp" />
						</a>
					</li>
					<li>
						<a href="">
							<img src="img/banner02.webp" />
						</a>
					</li>
					<li>
						<a href="">
							<img src="img/banner03.webp" />
						</a>
					</li>
					<li>
						<a href="">
							<img src="img/banner04.webp" />
						</a>
					</li>
					<li>
						<a href="">
							<img src="img/banner05.webp" />
						</a>
					</li>
					<li>
						<a href="">
							<img src="img/banner06.webp" />
						</a>
					</li>
					<li>
						<a href="">
							<img src="img/banner07.webp" />
						</a>
					</li>
					<li>
						<a href="">
							<img src="img/banner01.webp" />
						</a>
					</li>
				</ul>
				<!--按钮-->
				<a href="javascript:;" class="prev"><img src="img/prev.png" /> </a>
				<a href="javascript:;" class="next"><img src="img/next.png" /> </a>
				<!--小圆点-->
				<div class="number">
					<span class="current"></span>
					<span></span>
					<span></span>
					<span></span>
					<span></span>
					<span></span>
					<span></span>
				</div>
			</div>
		</section>
		<!--空白-->
		<div class="topic-space"></div>
		<!--尖货推荐-->
		<section class="section-title">
			<div class="topic-title text-center">尖货推荐</div>
		</section>
		<section class="section-goods">
			<ul class="img-list">
				<li class="animated fadeInLeftBig wow" data-wow-duration="0.5s">
					<a>
						<img src="img/尖货推荐01.webp" />
					</a>
				</li>
				<li class="animated fadeInUpBig wow" data-wow-duration="0.5s">
					<a>
						<img src="img/尖货推荐02.webp" />
					</a>
				</li>
				<li class="animated fadeInRightBig wow" data-wow-duration="0.5s">
					<a>
						<img src="img/尖货推荐03.webp" />
					</a>
				</li>
			</ul>
			<ul class="img-list">
				<li class="animated fadeInLeftBig wow" data-wow-duration="0.5s">
					<a>
						<img src="img/尖货推荐04.webp" />
					</a>
				</li>
				<li class="animated fadeInUpBig wow" data-wow-duration="0.5s">
					<a>
						<img src="img/尖货推荐05.webp" />
					</a>
				</li>
				<li class="animated fadeInRightBig wow" data-wow-duration="0.5s">
					<a>
						<img src="img/尖货推荐06.webp" />
					</a>
				</li>
			</ul>
			<ul class="img-list">
				<li class="animated fadeInLeftBig wow" data-wow-duration="0.5s">
					<a>
						<img src="img/尖货推荐07.webp" />
					</a>
				</li>
				<li class="animated fadeInUpBig wow" data-wow-duration="0.5s">
					<a>
						<img src="img/尖货推荐08.webp" />
					</a>
				</li>
				<li class="animated fadeInRightBig wow" data-wow-duration="0.5s">
					<a>
						<img src="img/尖货推荐09.webp" />
					</a>
				</li>
			</ul>
			<ul class="img-list">
				<li class="animated fadeInLeftBig wow" data-wow-duration="0.5s">
					<a>
						<img src="img/尖货推荐10.webp" />
					</a>
				</li>
				<li class="animated fadeInUpBig wow" data-wow-duration="0.5s">
					<a>
						<img src="img/尖货推荐11.webp" />
					</a>
				</li>
				<li class="animated fadeInRightBig wow" data-wow-duration="0.5s">
					<a>
						<img src="img/尖货推荐12.webp" />
					</a>
				</li>
			</ul>
			<ul class="img-list">
				<li class="animated fadeInLeftBig wow" data-wow-duration="0.5s">
					<a>
						<img src="img/尖货推荐13.webp" />
					</a>
				</li>
				<li class="animated fadeInUpBig wow" data-wow-duration="0.5s">
					<a>
						<img src="img/尖货推荐14.webp" />
					</a>
				</li>
				<li class="animated fadeInRightBig wow" data-wow-duration="0.5s">
					<a>
						<img src="img/尖货推荐15.webp" />
					</a>
				</li>
			</ul>
			<ul class="img-list">
				<li class="animated fadeInLeftBig wow" data-wow-duration="0.5s">
					<a>
						<img src="img/尖货推荐16.webp" />
					</a>
				</li>
				<li class="animated fadeInUpBig wow" data-wow-duration="0.5s">
					<a>
						<img src="img/尖货推荐17.webp" />
					</a>
				</li>
				<li class="animated fadeInRightBig wow" data-wow-duration="0.5s">
					<a>
						<img src="img/尖货推荐18.webp" />
					</a>
				</li>
			</ul>
			<ul class="img-list">
				<li class="animated fadeInLeftBig wow" data-wow-duration="0.5s">
					<a>
						<img src="img/尖货推荐19.webp" />
					</a>
				</li>
				<li class="animated fadeInUpBig wow" data-wow-duration="0.5s">
					<a>
						<img src="img/尖货推荐20.webp" />
					</a>
				</li>
				<li class="animated fadeInRightBig wow" data-wow-duration="0.5s">
					<a>
						<img src="img/尖货推荐21.webp" />
					</a>
				</li>
			</ul>
		</section>
		<!--特惠推荐-->
		<section class="section-title">
			<div class="topic-title text-center">特惠推荐</div>
		</section>
		<section class="section-preferential">
			<div class="">
				<div class="preferential pull-left animated fadeInLeftBig wow" data-wow-duration="0.5s">
					<a><img src="img/特惠推荐01.webp" /></a>
				</div>
				<div class="preferential pull-right animated fadeInRightBig wow" data-wow-duration="0.5s">
					<a><img src="img/特惠推荐02.webp" /></a>
				</div>
			</div>
		</section>
		<!--发现好货-->
		<section class="section-title">
			<div class="topic-title text-center">发现好货</div>
		</section>
		<section class="section-merchandise">
			<div class="merchandise">
				<ul></ul>
			</div>
			<div id="loading" class="h4 loading text-center">加载中...</div>
		</section>
		<!--按钮-->
		<section class="container more">
		</section>
		<!--返回顶部-->
		<div class="toTop">
			<span class="glyphicon glyphicon-open"></span>
		</div>
		<!--底部-->
		<div id="row-1">
			<!--底部三个图标-->
			<div class="row-1">
				<div class="ariplane">
					<img src="img/airplane.png" /> 海外直销
				</div>
				<div class="handshake">
					<img src="img/handshake.png" /> 品质保证
				</div>
				<div class="zheng">
					<img src="img/zheng.png" /> 售后保障
				</div>
			</div>
		</div>
		<!--底部banner与二维码-->
		<div id="row-2">
			<div class="row-2">
				<div class="logo-wrap">
					<img src="img/zouxiu.png" class="logo-wrap-img1" />
					<a><img src="img/weixin.png" class="logo-wrap-img2" /></a>
					<a><img src="img/weibo.png" class="logo-wrap-img3" /></a>
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
						<span>移动走秀</span>
					</div>
					<ul>
						<li class="qrcpde"><img src="img/erweima.png"></li>
						<li class="qrcpde"><img src="img/erweima.png"></li>
						<li class="qrcpde"><img src="img/erweima.png"></li>
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
						<a><img src="img/licence2.png"></a></div>
					<div class="row-4-service">
						<a><img src="img/licence1.png"></a>
					</div>
					<a class="row-4-service-2"><img src="img/police2.png"></a>
					<a class="row-4-service-2"><img src="img/police1.png"></a>
					<a class="row-4-service-2"><img src="img/rights.png"></a>
				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/banner.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
	<script type="text/javascript" src="js/wow.min.js"></script>
	<script type="text/javascript" src="js/base.js"></script>
	<script src="js/donghua.js"></script>
	<script>
		//初始化调用
		new WOW().init();
	</script>
</html>

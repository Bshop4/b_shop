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
	<meta name="viewport" content="width=device-width,initial-scale=1"/>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="css/animate.css"/>
		<link rel="stylesheet" type="text/css" href="css/Login.css"/>
		<link rel="stylesheet" type="text/css" href="css/base.css"/>
		<link rel="stylesheet" type="text/css" href="css/pyl_nav.css"/>
		<title>B-SHOP嘿店——欢迎BOSS</title>
  </head>
  
  <body>
   <nav class="navbar navbar-inverse">
			<!--logo-->
			<div class="navbar-header">
				<a href="index.jsp" class="navbar-brand aimg">
					<img class="navbar-left" src="img/bg-logo2-white.png">
				</a>
				<button class="navbar-toggle" data-target="#pyl_nav" data-toggle="collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
			</div>
				
			<!--导航-->
			<div class="pyl_navbar_nav navbar-left navbar-collapse collapse" id="pyl_nav">
				<ul class="nav navbar-nav">
					<li><a href="index.jsp"><span>首页</span></a></li>
					<li><a href="">新品</a></li>
					<li><a href="">女士</a></li>
					<li><a href="">男士</a></li>
					<li><a href="">品牌</a></li>
				</ul>
			</div>
				
			<!--登录注册-->	
			<div class="navbar-right pyl_login_btn visible-md visible-lg">
				<a href="Login.jsp" target="_self" class="navbar-link pull-right"><buttom class="btn navbar-btn"><span>登录</span></buttom></a>
				<a href="sign.jsp" target="_self" class="navbar-link pull-right"><buttom class="btn navbar-btn"><span>注册</span></buttom></a>
			</div>
		</nav>
		
		<div class="container">
			<div class="pyl_user_box">
					<p class="pyl_textlogin">帐号登录</p>
					<div class="pyl_login_user">
						<input type="text" class="" placeholder="请输入登录帐号"/>
						<span class="pyl_login_user_tips">帐号长度只能是4-20字符</span>
					</div>
					<div class="pyl_login_userpass">
						<input type="password" class="" placeholder="请输入登录密码"/>
						<span class="pyl_login_password_tips">帐号或密码不正确</span>
					</div>
					<div class="row">
						<div class="col-sm-7 col-sm-offset-4 text-right pyl_userfindpass">
							<button class="btn pull-right" id="pyl_findpass">找回密码</button>
							<button class="btn  pull-right" id="pyl_login">注册帐号</button>
						</div>
					</div>
					<div class="pyl_fastlogin_btn"><button>立即登录</button></div>
			</div>
		</div>
		
		<!--注册是否成功提示-->
		<div class="animated slide pyl_sign_tips wow" data-wow-diretion='0.1s'>
			<h2 class="">登录成功</h2>
			<p>最近本店又来一批新的产品</p>
			<p>稍等，马上入店。</p>
			<a href="Login.jsp" target="_blank" class="animated fadeIn wow"><div class="zhang"></div></a>
		</div>
		
		
		<!--重复登录问题-->
		<div class="pyl_panel">
			<p>老板你已经登录了<button class="btn" id="backheadpage">返回主页</button></p>
			<p>您是否注销<button class="btn"id="backlogin">注销</button></p>
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
	          <img src="img/Bshop_logo1.png" class="logo-wrap-img1" />
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
	            <span>移动嘿店</span>
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
	            <a><img src="img/licence2.png"> </a></div>
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
</html>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/pyl_nav_net.js"></script>
<script src="js/base.js"></script>
<script src="js/wow.min.js"></script>
<script src="js/Login.js"></script>

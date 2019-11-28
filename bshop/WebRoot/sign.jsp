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
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
		<link rel="stylesheet" type="text/css" href="css/base.css"/>
		<link rel="stylesheet" type="text/css" href="css/sign.css"/>
		<link rel="stylesheet" type="text/css" href="css/pyl_nav.css"/>
		<link rel="stylesheet" type="text/css" href="css/animate.css"/>
		
		
		<title>B-SHOP嘿店——期待你很久了</title>
		<style type="text/css">
			
		</style>
  </head>
  
 	<body>
		<nav class="navbar navbar-inverse">
			<!--logo-->
			<div class="navbar-header">
				<a href="new_file.jsp" class="navbar-brand aimg">
					<img class="navbar-left" src="img/bg-logo2-white.png">
				</a>
				<button class="navbar-toggle" data-toggle="collapse" data-target="#pyl_nav">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
			</div>
				
			<!--导航-->
			<div class="pyl_navbar_nav navbar-left navbar-collapse collapse" id="pyl_nav">
				<ul class="nav navbar-nav ">
					<li><a href="index.jsp">首页</a></li>
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
			<div class="pyl_sign_words">
					<h2 class="animated zoomInLeft wow" data-wow-duration='0.7s'>您好</h2>
					<p class="animated zoomInLeft wow" data-wow-duration='0.9s'>完成注册就能体验本站提供的所有功能</p>
			</div>
			<div class="pyl_center">
				<ul>
					<li>
						<span>用	 户 名</span>
						<input type="text" placeholder="请输入用户名" class="user"/>
						<div class="pyl_true"></div>
						<div class="userclear"></div>
					</li>
					<div class="div_tips">
						<span class="use-tips">&Theta; 支持中文，英文，数字，'-','_'的组合，4-20个字符</span>
					</div>
					
					<li>
						<span>设置密码</span>
						<input type="password" class="pyl_sign_password" placeholder="建议使用两种或两种以上字符组合"/>
						<div class="pyl_true"></div>
					</li>
					<div class="div_tips">
						<span class="pass-tips"><i></i>&Theta; 建议使用数字，字母，和符号两种及以上的组合，6-20个字符</span>
					</div>
					
					<li>
						<span>确认密码</span>
						<input type="password" class="truepassword" placeholder="请再次输入密码" />
						<div class="pyl_true"></div>
					</li>
					<div class="div_tips">
						<span class="truepass-tips">&otimes; 两次密码不同</span>
					</div>
					
					<li>
						<span>邮箱验证</span>
						<input type="text" class="email" placeholder="请输入邮箱"/>
						<div class="pyl_true"></div>
					</li>
					<div class="div_tips">
						<span class="email-tips">&otimes; 邮箱格式错误</span>
					</div>
					
					<li>
						<span>邮箱验证码</span>
						<input type="text" class="emailcode" placeholder="请输入邮箱验证码"/>
						<div class="pyl_true"></div>
					</li>
					<div class="div_tips">
						<span class="emailcode-tips"></span>
					</div>
					<li>
						<div class="sendemailcode">发送验证码</div>
					</li>
					<li>
						<input type="button"  value="立即注册" class="pyl_sign_btn"/>
					</li>
					<div class="div_tips">
						<span class="zhuce-tips"></span>
					</div>
				</ul>
			</div>
		</div>
		
		
		<!--注册是否成功提示-->
		<div class="animated slideInDown pyl_sign_tips">
			<h2 class="">注册成功</h2>
			<p>恭喜老板这么顺利来到这。</p>
			<p>我这里只有你想不到的东西，进店感受一下！！</p>
			<p id='backtime'>3后秒自动进入</p>
			<a href="index.jsp" target="_self" class="animated fadeIn wow" data-wow-delay='1s'><div class="zhang"></div></a>
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
<script src="js/sign.js"></script>

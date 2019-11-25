<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="css/findpass.css" />
		<link rel="stylesheet" href="css/animate.css" />
	    <link rel="stylesheet" href="css/bootstrap.css" />
	    <link rel="stylesheet" href="css/index.css" />
		<link rel="stylesheet" href="css/base.css" />
		<style>
		</style>
	</head>
	<body>
		<!--头部-->
    <div class="top">
      <div class="top-bar">
        <div class="btn">
          <a>注册</a>
          <a>登录</a>
          <a class="glyphicon glyphicon-shopping-cart"></a>
        </div>
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
            <a>首页</a>
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
    <!--所有商品-->
    <section class="section-merchandise">
      <div class="merchandise">
        <ul></ul>
      </div>
    </section>
		<div class="top-safety">安全校验</div>
		<div class="top-forget">你忘记密码了吗？</div>
		<div class="if-foget">如果您忘记了密码，请输入您用于创建账户的手 机号码，我们将会给你发送一条验证码信息，以 便恢复密码。</div>
		<div class="phone-num">手机号码</div>
		<input autocomplete="off" type="text" class="input-control" />
		<div class="img-varify">图形验证码</div>
		<input autocomplete="off" type="text" class="input-control" />
		<div class="msg-varify">短信验证码</div>
		<div class="msg-msg">
			<input autocomplete="off" type="text" class="input-controls" /><button class="el-button">发送验证码</button>
		</div>
		<button class="find-button">找回密码</button>

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
            <a><img src="img/licence2.png"/></a></div>
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
    
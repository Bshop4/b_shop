<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>我的购物车</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<title>B-SHOP嘿店——购物车</title>
<link rel="stylesheet" href="/bshop/css/cart.css" />
<link rel="stylesheet" href="/bshop/css/animate.css" />
<link rel="stylesheet" href="/bshop/css/bootstrap.css" />
<link rel="stylesheet" href="/bshop/css/index.css" />
<link rel="stylesheet" href="/bshop/css/base.css" />
<!--<link rel="stylesheet" href="css/footer.css" />-->

<style>
			.modal-header{
				border-bottom: none;
				height:20px;
				padding: 15px 15px 10px 15px;
			}
			.modal-body{
				border-bottom: none;
				height: 20px;
			}
			.modal-footer{
				border-top: none;
			}
			.el-button{
				display: inline-block;
			    cursor: pointer;
			    background: #fff;
			    border: 1px solid #dcdfe6;
			    border-color: #dcdfe6;
			    color: #606266;
			    text-align: center;
			    padding: 6px 10px;	
			    font-size: 12px;
			    border-radius: 4px;
			}
			.el-sure{
				background: black;
				color: white;
			}
		</style>
</head>
<body>
	<!--头部-->
	<div class="top">
		<div class="top-bar">
			<div class="btn">
				<a href="sign.jsp" target="_blank">注册</a> <a href="Login.jsp"
					target="_blank">登录</a> <a class="glyphicon glyphicon-shopping-cart"></a>
			</div>
			<div class="logBtn">
				<a class="mingZi"></a> <a class="exitM">[退出]</a>&nbsp;&nbsp;&nbsp;|
				<a class="glyphicon glyphicon-shopping-cart" href="cart.jsp"></a> <span
					class="badge store_number">0</span>
				<ul class="last-span">
					|&nbsp;&nbsp;&nbsp;我的嘿店
					<p class="glyphicon glyphicon-chevron-down"></p>
					<li>
						<div class="personalInfo">
							<a href="PersonInfo">个人中心</a> <a>我的订单</a> <a>我的收藏</a>
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
	<!--所有商品-->
	<section class="section-merchandise">
	<div class="merchandise">
		<ul></ul>
	</div>
	</section>
	<!--返回顶部-->
	<h3>
		购物车(<span class="carts-number">0</span>)
	</h3>
	<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<th class="left"><input type="checkbox" class="checkAll" />全选</th>
			<th>商品</th>
			<th>数量</th>
			<th>颜色</th>
			<th>尺码</th>
			<th>单价</th>
			<th>小计</th>
			<th>操作</th>
		</tr>
	</table>
	<div class="footer">
		<input type="checkbox" class="checkAll" />全选 <span class="dele"><a
			href="javascript:;" class="delAll">删除选中的商品</a></span> <span class="sum-all"
			id="all-sum">合计：¥0.00</span>
	</div>
	<div class="account">
		<button type="button" class="btn-account" id="open">去结算</button>
	</div>
	
	
	<!--删除模态框结构-->
		<div class="modal fade" id="myModal">
			<!--窗口层   大中小  默认为中-->
			<div class="modal-dialog" style="width: 420px;">
				<!--内容层-->
				<div class="modal-content">
					<!--头部，身体，底部-->
					<div class="modal-header">
						<span class="close" data-dismiss="modal">&times;</span>
					</div>
					<div class="modal-body">
						<span>确认删除？</span>
					</div>
					<div class="modal-footer">
						<button type="button" class="el-button el-dissure" id="quxiao" data-dismiss="modal">取消</button>
						<button type="button" class="el-button el-sure" id="queren" data-dismiss="modal">确认</button>
					</div>
				</div>
			</div>
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
					<a><img src="/bshop/img/licence2.png"></a>
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
<script src="/bshop/js/jquery-3.4.1.min.js"></script>
<script src="/bshop/js/bootstrap.js"></script>
<script src="/bshop/js/base.js"></script>
<script src="/bshop/js/cart.js"></script>
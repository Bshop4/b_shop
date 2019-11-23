<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
<link rel="stylesheet" href="css/cart_account.css" />
<link rel="stylesheet" href="css/animate.css" />
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/index.css" />
<link rel="stylesheet" href="css/base.css" />

<link rel="stylesheet" href="css/base.css" />
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/personInfo.css" />

<meta charset="UTF-8">
</head>
<body>
	<!--头部-->
	<div class="top">
		<div class="top-bar">
			<div class="btn">
				<a>注册</a> <a>登录</a> <a class="glyphicon glyphicon-shopping-cart"></a>
			</div>
			<div class="logo"></div>
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
				<li class="tab"><a>首页</a></li>
				<li class="tab"><a>新品</a></li>
				<li class="tab"><a>男士</a></li>
				<li class="tab"><a>女士</a></li>
				<li class="tab"><a>品牌</a></li>
				<li class="tab"><a>走秀移动版</a></li>
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
	<!--<div class="toTop">
      <span class="glyphicon glyphicon-open"></span>
    </div>-->
	<div class="btn-cart-lik">
		<a href="">＜返回购物车</a>
	</div>
	<div class="address-layout">
		<div class="title-title">选择收获地址</div>
		<ul class="address-list">
			<li style="float: left"></li>
		</ul>
		<div class="more-wrap">
			<span class="btn-no-data" style="font-size: 13px;" class="now-no">暂无收货地址 </span>

			<button id="user-myaddress" data-toggle="modal"
				data-target="#addAddress"
				style="background: white; left: 200px; top: 228px; border: 1px solid black;">+新增地址</button>

		</div>
		<div class="checkout-content-title">确认商品清单</div>
		<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<th>商品</th>
				<th>描述</th>
				<th>数量</th>
				<th>单价</th>
				<th>小计</th>
			</tr>
		</table>
		<div class="footer">
			<div style="width: 1200px; height: 40px;">
				<span>备注留言：</span><input
					style="height: 36px; width: 600px; border: 1px solid dashed; padding-left: 10px;"
					placeholder="50字以内" maxlength="50" class="l_a_m ";> </input> <span
					class="sum-all" style="font-size: 20px; line-height: 40px;">应付金额：¥0.00</span>
			</div>

			<div class="account">
				<button type="button" class="btn-account">确认订单</button>
			</div>
		</div>
	</div>



	<div class="modal fade" id="addAddress" data-backdrop="static"
		id="addressform">
		<div class="modal-dialog">
			<div class="modal-content">

				<div class="modal-header">
					<h2 class="text-success modal-title">
						新增地址 <span class="close" data-dismiss="modal">&times;</span>
					</h2>
				</div>

				<div class="modal-body">
					<div class="row">
						<div class="col-md-8 col-md-offset-2">
							<div class="form-group">
								<label>收货人姓名:</label> <input type="text" class="form-control"
									id="myname" /><label class="namelable">收货人姓名不能为空</label>
							</div>

							<div class="form-group">
								<label>手机号:</label> <input type="text" class="form-control"
									id="myiphone" /><label class="iplabel">手机号格式错误</label>
							</div>

							<div class="form-group">
								<label>邮编:</label> <input type="text" class="form-control"
									id="mypostcode" /><label class="postlabel">邮编不能为空</label>
							</div>

							<div class="form-group">
								<label>收货地址:</label> <input type="text" class="form-control"
									id="myproaddress" /><label class="addresslabel">收货地址不能为空</label>
							</div>
						</div>
					</div>
				</div>

				<div class="modal-footer">
					<button class="btn btn-success" data-dismiss="modal" id="save1"
						onclick="mysaveclicks()">保存</button>
					<button class="btn btn-danger" data-dismiss="modal" id="cancel1">取消</button>
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
				<img src="img/zouxiu.png" class="logo-wrap-img1" /> <a><img
					src="img/weixin.png" class="logo-wrap-img2" /></a> <a><img
					src="img/weibo.png" class="logo-wrap-img3" /></a>
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
					<a><img src="img/licence2.png" /> </a>
				</div>
				<div class="row-4-service">
					<a><img src="img/licence1.png"></a>
				</div>
				<a class="row-4-service-2"><img src="img/police2.png"></a> <a
					class="row-4-service-2"><img src="img/police1.png"></a> <a
					class="row-4-service-2"><img src="img/rights.png"></a>
			</div>
		</div>
	</div>
</body>
</html>
<script src="js/cart_account.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/base.js"></script>

<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/base.js"></script>
<script type="text/javascript" src="js/banner.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>



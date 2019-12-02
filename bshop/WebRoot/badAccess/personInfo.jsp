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

<title>B-SHOP嘿店</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="css/base.css" />
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/personInfo.css" />

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
				<a class="mingZi"></a> <a class="exitM">[退出]&nbsp;&nbsp;&nbsp;|</a>
				<a class="glyphicon glyphicon-shopping-cart" href="cart.jsp"></a> <span
					class="badge store_number">0</span>
				<ul class="last-span">
					|&nbsp;&nbsp;&nbsp;我的嘿店
					<p class="glyphicon glyphicon-chevron-down"></p>
					<li>
						<div class="personalInfo">
							<a href="personInfo.jsp">个人中心</a> <a>我的订单</a> <a>我的收藏</a>
						</div>
					</li>
				</ul>

			</div>

			<!--整合logo-->
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
				<li class="tab"><a href="index.jsp">首页</a></li>
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
	<div class="user">
		<div class="user-left">
			<ul>
				<li id="myinfo">我的信息</li>
				<li id="mymenu">我的订单</li>
				<li id="myaddress">收货地址</li>
				<li id="mycollection">我的收藏</li>
				<li id="myfooter">我的足迹</li>
			</ul>
		</div>

		<div class="user-right">
			<div class="title">
				<p>我的信息</p>
			</div>

			<div class="photo">
				<img alt="" id="imgPhoto"> <label class="pic">头像:</label> <label
					for="fileupload" id="labelPhoto"> <input type="file"
					id="fileupload" class="inputPhoto" onchange="show(this)" />
				</label>
			</div>

			<div class="account">
				<label class="user-acc">账号:</label> <input readonly
					class="user-acc-input">
				<span class="notModify">账号不能修改</span>
			</div>
			<div class="nickName">
				<label class="user-nickName" id="user-nickname1">昵称:</label> <input
					type="text" class="user-in-nickName" />
			</div>
			<div class="sex">
				<label class="user-sex">性别:</label> <input class="man" type="radio"
					value="male" name="sex" checked="checked">男 <input
					class="woman" type="radio" value="female" name="sex">女
			</div>
			<div class="birth">
				<label class="user-birth">生日:</label> <input class="userdate"
					type="date" />
			</div>
			<div class="takeOver">
				<label class="user-takeOver">收货地址:</label> <input type="text"
					class="myAddress" readonly="readonly" />
			</div>

			<button class="cancel" id="cancel">取消</button>
			<button class="save" id="save">保存</button>

		</div>

		<div class="user-right1">
			<div class="title1">
				<p>我的订单</p>
			</div>
			<table border="1" width="1000" cellspacing="0" height="80"
				style="margin-left: 10px">
				<tr style="text-align: center">
					<th>订单编号</th>
					<th>商品</th>
					<th>单价</th>
					<th>数量</th>
					<th>小计</th>
					<th>时间</th>
				</tr>
				<tr style="text-align: center">
					<td>111</td>
					<td>222</td>
					<td>333</td>
					<td>444</td>
					<td>555</td>
					<td>666</td>
				</tr>
			</table>
		</div>

		<div class="user-right2">
			<div class="title2">
				<p>收货地址</p>
			</div>
			<button id="user-myaddress"
				class="btn btn-info navbar-btn navbar-left" data-toggle="modal"
				data-target="#addAddress" style="background: black">+新增地址</button>


		</div>

		<div class="user-right3">
			<div class="title3">
				<p>我的收藏</p>
			</div>
			<div class="my_collection">
				<ul class="pro-list"></ul>
			</div>
		</div>
		
		<!-- 我的足迹 -->
		<div class="user-right4">
			
		</div>


		<div class="modal fade" id="addAddress" data-backdrop="static"
			id="addressform">
			<div class="modal-dialog">
				<div class="modal-content" style="width:700px;height:540px;">

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
									<label>收货地址:</label><br>
									<!--修改-->
									<select id="province" onchange="getCity(this)">
										<option>请选择省份</option>
									</select> <select name="" id="city" onchange="getArea(this)">
										<option value="">请选择城市</option>
									</select> <select name="" id="area">
										<option value="">请选择区县</option>
									</select>
								</div>
								<!--新增-->
								<div class="form-group">
									<label>详细地址:</label> <input type="text" class="form-control"
										id="mydetailaddress" /> <label id="addlabel">收货地址不能为空</label>
								</div>
							</div>
						</div>
					</div>

					<div class="modal-footer">
						<button class="btn btn-success" id="save1" onclick="mysaveclick()">保存</button>
						<button class="btn btn-danger" data-dismiss="modal" id="cancel1">取消</button>
					</div>

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
				<img src="img/Bshop_logo1.png" class="logo-wrap-img1" /> <a><img
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
					<a><img src="img/licence2.png"></a>
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
<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/base.js"></script>
<script type="text/javascript" src="js/banner.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/personInfo.js"></script>
<script type="text/javascript" src="js/infos.js"></script>
<script type="text/javascript">
	function show(obj) {
		var fr = new FileReader();
		var f = obj.files[0];
		fr.readAsDataURL(f);
		fr.onload = function(e) {
			var content = e.target.result;
			//预览
			document.getElementById("imgPhoto").src = content;
			console.log(content)
		}
	}
</script>

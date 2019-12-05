<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的订单</title>
<link rel="stylesheet" href="/bshop/css/cart_account.css" />
<link rel="stylesheet" href="/bshop/css/animate.css" />
<link rel="stylesheet" href="/bshop/css/bootstrap.css" />
<link rel="stylesheet" href="/bshop/css/index.css" />
<link rel="stylesheet" href="/bshop/css/base.css" />
<link rel="stylesheet" href="/bshop/css/bootstrap.css" />
<link rel="stylesheet" href="/bshop/css/personInfo.css" />

<meta charset="UTF-8">

<style>
			.modal-header11{
				border-bottom: none;
				height:20px;
				padding: 15px 15px 10px 15px;
			}
			.modal-body11{
				border-bottom: none;
				height: 20px;
			}
			.modal-footer11{
				border-top: none;
				width: 418px;
				height: 40px;
			}
			.el-button11{
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
			    float: right;
			    padding: 8px;
			}
			.el-sure11{
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
	<!--返回顶部-->
	<!--<div class="toTop">
      <span class="glyphicon glyphicon-open"></span>
    </div>-->
	<div class="btn-cart-lik">
		<a href="cart.jsp">＜返回购物车</a>
	</div>
	<div class="address-layout">
		<div class="title-title">选择收获地址<span style="color:red;font-size:12px">（选中才可以支付哦!）</span></div>
		<ul class="address-list">
			<li style="float: left"></li>
		</ul>
		<div class="more-wrap">
			<span class="btn-no-data" style="font-size: 13px;" class="now-no">暂无收货地址 </span>
			<div class="woaidong" style="position:relative;left:0px;top:0px"><button id="user-myaddress" data-toggle="modal"
				data-target="#addAddress"
				style="background: white; border: 1px solid black;">+新增地址</button>
			</div>
		</div>
		<div class="checkout-content-title">确认商品清单</div>
		<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<th>商品</th>
				<th>描述</th>
				<th>数量</th>
				<th>颜色</th>
		        <th>尺码</th>
		        <th>单价</th>
		        <th>小计</th>
		        <th>操作</th>
			</tr>
		</table>
		<div class="footer">
			<div style="width: 1200px; height: 40px;">
				<span>备注留言：</span><input
					style="height: 36px; width: 600px; border: 1px solid dashed; padding-left: 10px;"
					placeholder="50字以内" maxlength="50" class="l_a_m ";> </input> <span
					class="sum-all" style="font-size: 20px; line-height: 40px;" id="sum-all">合计：¥0.00</span>
			</div>

			<div class="account">
				<button type="button" class="btn-account" id="btn-account">支付订单</button>
			</div>
		</div>
	</div>

	 <div class="modal fade" id="addAddress" data-backdrop="static" id="addressform">
        <div class="modal-dialog">
            <div class="modal-content" style="width:700px;height:540px;">

                <div class="modal-header">
                    <h2 class="text-success modal-title">新增地址
                        <span class="close" data-dismiss="modal">&times;</span>
                    </h2>
                </div>

                <div class="modal-body">
                    <div class="row">
                        <div class="col-md-8 col-md-offset-2">
                            <div class="form-group">
                                <label>收货人姓名:</label>
                                <input type="text" class="form-control" id="myname"/><label class="namelable">收货人姓名不能为空</label>
                            </div>

                            <div class="form-group">
                                <label>手机号:</label>
                                <input type="text" class="form-control" id="myiphone"/><label class="iplabel">手机号格式错误</label>
                            </div>

                            <div class="form-group">
                                <label>邮编:</label>
                                <input type="text" class="form-control" id="mypostcode"/><label class="postlabel">邮编不能为空</label>
                            </div>

                            <div class="form-group">
                                <label>收货地址:</label><br>
                                <!--修改-->
                                <select id="province"  onchange="getCity(this)">
                                    <option>请选择省份</option>
                                </select>
                                <select name="" id="city" onchange="getArea(this)">
                                    <option value="">请选择城市</option>
                                </select>
                                <select name="" id="area" >
                                    <option value="">请选择区县</option>
                                </select>
                            </div>
                            <!--新增-->
                            <div class="form-group">
                                <label>详细地址:</label>
                                <input type="text" class="form-control" id="mydetailaddress"/>
                                  <label id="addlabel">收货地址不能为空</label>
                            </div>

                        </div>
                    </div>
                </div>

                <div class="modal-footer">
                    <button class="btn btn-success" id="save1" onclick="mysaveclicks()">保存</button>
                    <button class="btn btn-danger" data-dismiss="modal" id="cancel1" >取消</button>
                </div>

            </div>
        </div>
    </div>
    
    
    
    <!--删除模态框结构-->
 		<div class="modal fade" id="myModal">
			<!--窗口层   大中小  默认为中-->
			<div class="modal-dialog" style="width: 420px;">
				<!--内容层-->
				<div class="modal-content">
					<!--头部，身体，底部-->
					<div class="modal-header11">
						<span class="close" data-dismiss="modal">&times;</span>
					</div>
					<div class="modal-body11">
						<span>确认删除？</span>
					</div>
					<div class="modal-footer11">
						<button type="button" class="el-button11 el-sure11" id="queren" data-dismiss="modal">确认</button>
						<button type="button" class="el-button11 el-dissure" id="quxiao" data-dismiss="modal">取消</button>
					</div>
				</div>
			</div>
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
<!--<script type="text/javascript" src="/bshop/js/personInfo.js"></script>  -->
<script type="text/javascript" src="/bshop/js/mtk.js"></script>
<script type="text/javascript" src="/bshop/js/infos.js"></script>

<script src="/bshop/js/cart_account.js"></script>


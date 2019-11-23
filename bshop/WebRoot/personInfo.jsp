<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
    <style>
        * {
            margin: 0px;
            padding: 0px;
        }
        a {
            text-decoration: none;
        }
        li {
            list-style: none;
        }
        img {
            border: none;
            vertical-align: bottom;
        }

        .user{
            width: 1200px;
            height: 682px;
            margin: 0px auto;
            /*border: 1px solid red;*/
            position: relative;
        }

        .user-left{
            height: 442px;
            width: 180px;
            /*border: 1px solid red;*/

        }
        .user-left ul{
            padding: 20px 0px 32px 28px;
        }

        .user-left ul li{
            width: 152px;
            height: 15px;
            line-height: 15px;
            margin: 0px 0px 24px;
            cursor: pointer;
        }

        .user-right{
            display: block;
            /*display:none;*/
            width: 1020px;
            height: 662px;
            /*border: 1px solid red;*/
            border-left: 2px solid rgba(255, 145, 75, 0.28);
            position: absolute;
            left: 180px;
            top: 0px;
            padding: 20px 0px 0px;
        }

        .title2, .title1, .title{
            height: 18px;
            width: 1020px;
            padding: 0px 0px 24px 16px;

        }
        .title2,.title1,.title>p{
            height: 18px;
            /*width: 1020px;*/
            font-size: 18px;
            line-height: 18px;
            font-weight: bolder;
        }

        .photo{
            width: 956px;
            height: 109px;
        }

        .pic{
            width:120px;
            height:32px;
            display: inline-block;
            padding: 0px 12px 0px 0px;
            font-size: 13px;
            line-height: 32px;
            text-align: right;
        }

        .user-logo{
            width: 96px;
            height: 96px;
            border: 1px solid #f79c34;
            position: absolute;
            top: 50px;
            left: 137px;
            cursor: pointer;
        }
        .user-takeOver ,.user-birth,.user-sex,.user-nickName ,.user-acc{
            width: 120px;
            height: 32px;
            display: inline-block;
            padding: 0px 12px 0px 0px;
            font-size: 13px;
            line-height: 32px;
            text-align: right;
        }

        .myAddress, .user-in-nickName, .user-acc-input{
            width: 230px;
            height: 35px;
        }

        .user-in-nickName{
             margin-top: 5px;
         }

        .save ,.cancel{
            width: 176px;
            height: 42px;
            font-size: 16px;
            border: 1px solid black;
            position: absolute;
            left: 300px;
            top: 420px;
            cursor: pointer;
        }
        .save{
            left: 500px;
            background: black;
            color: white;
        }

        .user-right1{
            display: none;
            width: 1020px;
            height: 662px;
            border: 1px solid red;
            position: absolute;
            left: 180px;
            top: 0px;
            padding: 20px 0px 0px;
        }

        #myinfo{
            color: red;
        }

        .user-right2{
            display: none;
            width: 1020px;
            height: 662px;
            position: absolute;
            left: 180px;
            top: 0px;
            padding: 20px 0px 0px;
        }
        #user-myaddress{
            position: absolute;
            right: 100px;
            top:2px;
            width: 115px;
            height: 35px;
        }

        /*.addresslist{*/
            /*width: 1000px;*/
            /*height: 120px;*/
            /*!*border: 1px solid red;*!*/
            /*margin-left: 10px;*/
            /*position: relative;*/
        /*}*/

        /*.addresslist>li{*/
            /*width: 750px;*/
            /*height: 100px;*/
            /*!*border: 1px solid red;*!*/
            /*margin-top: 10px;*/
            /*margin-left: 10px;*/
        /*}*/

        /*.insertName,.insertMyaddress,.insertPostcode{*/
            /*padding: 0px 0px 10px;*/
        /*}*/

        /*.edit, .del{*/
            /*width: 30px;*/
            /*height: 20px;*/
            /*font-size: 15px;*/
            /*position: absolute;*/
            /*right: 50px;*/
            /*top:50%;*/
            /*cursor: pointer;*/
            /*text-decoration: underline;*/
        /*}*/
        /*.edit{*/
            /*right: 90px;*/
        /*}*/

        /*.binggou{*/
            /*width: 15px;*/
            /*height:15px;*/
            /*background: black;*/
            /*display: inline-block;*/
            /*color: whitesmoke;*/
            /*cursor: pointer;*/
        /*}*/
        /*.redefult{*/
            /*font-weight: bolder;*/
        /*}*/

        #addressform{
            position: relative;
        }
        .iplabel{
            position: absolute;
            top: 135px;
            left: 16px;
            font-size: 12px;
            color: red;
            display: none;
        }

        .namelable{
            position: absolute;
            top: 60px;
            left: 16px;
            font-size: 12px;
            color: red;
            display: none;
        }

        .postlabel{
            position: absolute;
            top: 208px;
            left: 16px;
            font-size: 12px;
            color: red;
            display: none;
        }
        .addresslabel{
            position: absolute;
            top: 283px;
            left: 16px;
            font-size: 12px;
            color: red;
            display: none;
        }
    </style>

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
					<a class="exitM">[退出]&nbsp;&nbsp;&nbsp;|</a>
					<a class="glyphicon glyphicon-shopping-cart" href="cart.jsp"></a>
					<span class="badge store_number">0</span>
					<ul class="last-span">|&nbsp;&nbsp;&nbsp;我的走秀<p class="glyphicon glyphicon-chevron-down"></p>
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
 <div class="user">

        <div class="user-left">
            <ul>
                <li id="myinfo">我的信息</li>
                <li id="mymenu">我的订单</li>
                <li id="myaddress">收货地址</li>
            </ul>
        </div>

        <div class="user-right">
            <div class="title"><p>我的信息</p></div>

            <div class="photo">
                <label class="pic">头像:</label>
                <div class="user-logo" style="background-image: url("ph")"></div>
            </div>

            <div class="account">
                <label class="user-acc">账号:</label>
                <input value="账号" readonly class="user-acc-input">
            </div>
            <div class="nickName">
                <label class="user-nickName">昵称:</label>
                <input type="text" class="user-in-nickName"/>
            </div>
            <div class="sex">
                <label class="user-sex">性别:</label>
                <input type="radio" value="male" name="sex" checked>男
                <input type="radio" value="female" name="sex">女
            </div>
            <div class="birth">
                <label class="user-birth">生日:</label>
                <input type="date"/>
            </div>
            <div class="takeOver">
                <label class="user-takeOver">收货地址:</label>
                <input type="text" value="地址" class="myAddress"/>
            </div>

            <button class="cancel" id="cancel">取消</button>
            <button class="save" id="save">保存</button>

        </div>

        <div class="user-right1">
            <div class="title1"><p>我的订单</p></div>
            <table border="1" width="1000" cellspacing="0" height="80" style="margin-left: 10px">
                <tr>
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
            <div class="title2"><p>收货地址</p></div>
            <button  id="user-myaddress"  class="btn btn-info navbar-btn navbar-left" data-toggle="modal" data-target="#addAddress" style="background: black">+新增地址</button>

            <!--<ul class="addresslist">-->
                <!--<li>-->
                    <!--<div class="insertName">詹佳磊&nbsp;&nbsp;&nbsp;&nbsp;1593590290</div>-->
                    <!--<div class="insertPostcode">邮编:123456</div>-->
                    <!--<div class="insertMyaddress">收货地址:浙江省XXXXXXXXXXXXXX</div>-->
                    <!--<span class="binggou">√</span>-->
                    <!--<span class="redefult">设为默认</span>-->
                    <!--<div class="edit">编辑</div>-->
                    <!--<div class="del">删除</div>-->
                <!--</li>-->
            <!--</ul>-->
        </div>

    <div class="modal fade" id="addAddress" data-backdrop="static" id="addressform">
        <div class="modal-dialog">
            <div class="modal-content">

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
                                <label>收货地址:</label>
                                <input type="text" class="form-control" id="myproaddress"/><label class="addresslabel">收货地址不能为空</label>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="modal-footer">
                    <button class="btn btn-success"   id="save1" onclick="mysaveclick()">保存</button>
                    <button class="btn btn-danger" data-dismiss="modal" id="cancel1" >取消</button>
                </div>

            </div>
        </div>
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
<script type="text/javascript" src="js/base.js"></script>
<script type="text/javascript" src="js/banner.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script>

   $("#myinfo").click(function(){
        $("#myinfo").css({
            color:"red"
        });

        $("#mymenu").css({
            color:"black"
        })
        $("#myaddress").css({
            color:"black"
        })
        $(".user-right").show();
        $(".user-right1").hide();
        $(".user-right2").hide();

    })

    $("#mymenu").click(function(){
        $("#mymenu").css({
            color:"red"
        });
        $("#myinfo").css({
            color:"black"
        })
        $("#myaddress").css({
            color:"black"
        })
        $(".user-right1").show();
        $(".user-right").hide();
        $(".user-right2").hide();
    })

    $("#myaddress").click(function(){
        $("#myaddress").css({
            color:"red"
        });
        $("#myinfo").css({
            color:"black"
        })
        $("#mymenu").css({
            color:"black"
        })
        $(".user-right2").show();
        $(".user-right").hide();
        $(".user-right1").hide();
    })



    $("#user-myaddress").click(function(){
        document.getElementById("save1").setAttribute("data-dismiss","");
    })

    function mysaveclick(){

        var name = document.getElementById("myname").value;
        var iphone = document.getElementById("myiphone").value;
        var postcode = document.getElementById("mypostcode").value;
        var address = document.getElementById("myproaddress").value;

        if(name == ""){
            $(".namelable").show();
            return ;
        }else{
            $(".namelable").hide();
        }

        var reiphone = /^1[0-9]{10}/;
        if(reiphone.test(iphone) != true){
            $(".iplabel").show();
            return;
        }else{
            $(".iplabel").hide();
        }

        if(postcode == ""){
            $(".postlabel").show();
            return ;
        }else{
            $(".postlabel").hide();
        }
        if(address == ""){
            $(".addresslabel").show();
            return;
        }else{
            $(".addresslabel").hide();
        }

        if(reiphone.test(iphone) == true && name != "" && postcode != "" && address != ""){
            document.getElementById("save1").setAttribute("data-dismiss","modal");
                $(".user-right2").append("<ul class='addresslist'><li><div class='insertName'>"+name+"&nbsp;&nbsp;&nbsp;&nbsp;"+iphone+"</div><div class='insertPostcode'>邮编:"+postcode+"</div><div class='insertMyaddress'>收货地址:"+address+"</div><span class='binggou'>√</span><span class='redefult'>设为默认</span><div class='edit'>编辑</div><div class='del' onclick='delclick(this)'>删除</div></li></ul>");
                $(".addresslist").css({
                    "width": "1000px",
                    "height": "120px",
                    "margin-left": "10px",
                    "position": "relative"
                })

                $(".addresslist>li").css({
                    "width": "750px",
                    "height": "100px",
                    "margin-top": "10px",
                    "margin-left": "10px",
                })

                $(".insertName,.insertMyaddress,.insertPostcode").css({
                    "padding": "0px 0px 10px",
                })

                $(".edit, .del").css({
                    "width": "30px",
                    "height": "20px",
                    "font-size": "15px",
                    "position": "absolute",
                    "right": "50px",
                    "top":"50%",
                    "cursor": "pointer",
                    "text-decoration": "underline"
                })

                $(".edit").css({
                    "right":"90px"
                })

                $(".binggou").css({
                    "width": "15px",
                    "height":"15px",
                    "background": "black",
                    "display": "inline-block",
                    "color": "whitesmoke",
                    "cursor": "pointer",
                })

                $(".redefult").css({
                    "font-weight": "bolder",
                })

        }
        var len = $(".user-right2").children().length;
        if(len > 3){
            $(".nowaddress").remove();
        }

        document.getElementById("myname").value = "";
        document.getElementById("myiphone").value = "";
        document.getElementById("mypostcode").value = "";
        document.getElementById("myproaddress").value = "";

    }


    function  delclick(obj){

        $(obj).parent().parent().remove();
        var len = $(".user-right2").children().length;
        if(len == 2){
            $(".user-right2").append("<div class='nowaddress'>-_-您现在暂无收获地址~<div>");
            $(".nowaddress").css({
                "font-size" : "25px",
                "width" : "1000px",
                "height" : "300px",
                "text-align" : "center",
                "line-height" : "300px"
            })
        }

    }
    
    (function () {
        var len = $(".user-right2").children().length;
        if(len == 2){
            $(".user-right2").append("<div class='nowaddress'>-_-您现在暂无收获地址~<div>");
            $(".nowaddress").css({
                "font-size" : "25px",
                "width" : "1000px",
                "height" : "300px",
                "text-align" : "center",
                "line-height" : "300px"
            })
        }
    })()



</script>
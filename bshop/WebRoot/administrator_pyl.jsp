<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'administrator.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/administrator.css"/>
  </head>
  
  <body>
		
		<!--顶部-->
		<div class="AM_top">
			<!--导航条的左边logo-->
			<div class="left_logo">
				<img src="img/bg-logo2-black.png"/>
			</div>
			
			
			<!--导航条的中间-->
			<div class="center_text">
				<span>嘿店管理系统</span>
			</div>
			
			<!--导航条的右边-->
			<div class="right_user">
				<div class="other"></div>
				<!-- <div class="photo">
					<img src="img/11_03.png"/>
				</div>
				<div class="name">
					<span>名称</span>
					<div class="triangle-top"></div>
				</div> -->
			</div>
			
			
		</div>
		
		
		<!--中间-->
		<div class="AM_body">
			<div class="left_bar">
				<div class="one">
				</div>
				<ul>
					<li class="active"><img src="img/9.png" />用户管理</li>
					<li><img src="img/10.png" />商品管理</li>
				</ul>
			</div>
			<div class="right_play">
				<div class="use_play">
					<center>
						<div class="find_key">
							<input type="text" name="" class="" placeholder="帐号查询" />
							<input type="text" name="" class="" placeholder="昵称查询" />
							<input type="text" name="" class="" placeholder="性别查询" />
							<button class="find">搜索</button>
						</div>
						<div class="play_context">
							<table cellpadding="0" cellspacing="0" border="1"  style="text-align: right;">
								<tr style="text-align: center;">
									<th>id</th>
									<th>account</th>
									<th>password</th>
									<th>email</th>
									<th>ipaddress</th>
									<th>ban</th>
								</tr>
								<tr>
									<td>1</td>
									<td>asdfa</td>
									<td>asdgadg</td>
									<td>sdfgsdfgsa</td>
									<td>sdfgsdddddddddd</td>
									<td>1</td>
								</tr>
							</table>
						</div>
					</center>
				</div>
			</div>
		</div>
	</body>
</html>
<script src="js/jquery-3.4.1.min.js"></script>
<script src="js/administrator_pyl.js"></script>
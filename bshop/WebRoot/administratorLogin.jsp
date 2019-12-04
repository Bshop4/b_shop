<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'administratorLogin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/administratorLogin.css"/>
  </head>
  
  <body>
   <center>
			<div id="admi_top">
			</div>
			<img src="img/bg-logo2-black.png"/>
			<form action="" class="admi_form">
				<div>
					<span>管理员：</span><input type="text" name="account" class="users"/>
					<span class="mymsg"></span>
				</div>
				<div>
					<span>密　码：</span><input type="password" name="password" class="pass"/>
				</div>
				<button class="admi_btn" onclick="admi_login()"><span class="admi_anim">登录</span></button>
			</form>
		</center>
  </body>
</html>
<script src="js/jquery-3.4.1.min.js"></script>
<script src="js/administratorLogin.js"></script>
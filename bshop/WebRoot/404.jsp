<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<title>404错误页面演示_dowebok</title>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/my404.css">
  </head>
  
  <body>
<svg viewBox="0 0 960 300">
	<symbol id="s-text">
		<text text-anchor="middle" x="50%" y="80%">404</text>
	</symbol>
	<g class="g-ants">
		<use xlink:href="#s-text" class="text"></use>
		<use xlink:href="#s-text" class="text"></use>
		<use xlink:href="#s-text" class="text"></use>
		<use xlink:href="#s-text" class="text"></use>
		<use xlink:href="#s-text" class="text"></use>
	</g>
</svg>
<div class="dowebok">
	<h1>很抱歉，页面找不到了</h1>
	<a href="/bshop/index.jsp">返回首页</a>
</div>

</body>
</html>

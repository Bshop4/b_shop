<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>500</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/my500.css">
  </head>
  
 <body>

<div class="centered">
	<p class="wode">500</p>
	<div class="mj">
		<div class="full-head">
			<div class="hat"></div>
			<div class="hat-part"></div>
			<div class="m-head"></div>
		</div>
		
		<div class="m-body"></div>
	
		<div class="arms">
			<div class="arm"></div>
			<div class="arm-right"></div>
			<div class="arm-left"></div>
		</div>
	
		<div class="legs">
			<div class="leg-right">
				<div class="upper-right"></div>
				<div class="lower-right"></div>
			</div>
			<div class="leg-left">
				<div class="upper-left"></div>
				<div class="lower-left"></div>
			</div>
		</div>
	
		<div class="foot">
			<div class="feet feet-right"></div>
			<div class="feet feet-left"></div>
		</div>
	
	</div>  
	
</div>

</body>
</html>

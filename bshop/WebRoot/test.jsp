<%@page import="bshow.dao.Basedao"%>
<%@page import="bshow.dao.impl.Basedaoimpl"%>
<%@page import="bshow.pojo.Account_table"%>
<%@page import="bshow.db.DBhelper"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%=DBhelper.getConnection()%>
    <a href="pageBranchAction.do">haha</a>
    <%
    	Account_table a= new Account_table();
    	a.setAccount("4894654");
    	a.setBan(1);
    	a.setEmail("8721@ds.com");
    	a.setPassword("123456");
    	a.setIpaddress("湖南");
    	Basedao b=new Basedaoimpl();
    	b.saveObject("insertone", a);
     %>
  </body>
</html>

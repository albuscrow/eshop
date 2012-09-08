<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>增加付款方式</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <script type="text/javascript" src="js/jquery/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="js/jquery/jquery-ui-1.10.3.custom.js"></script>

    <link rel="stylesheet" type="text/css" href="css/screen.css" />
    <link rel="stylesheet" type="text/css" href="css/ui-lightness/jquery-ui-1.10.3.css">
  </head>
  
  <body>
        <form action="back/AddPayWay.action">
                            请填写新增付款方式信息：<br><br>
                              请输入付款方式<input name="name"><br><br>
                              请输入公司名称<input name="comp"><br><br>
                            请输入url<input name="url"><br><br>                  
        <input type="submit" value="点击确认增加此付款方式">
  </body>
</html>

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
    
    <title>配送方式管理</title>
    
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
        操作：
  <button onclick="javascript:location.href='view/back/CarriageManager/add.jsp'">增加配送方式</button>
  <button onclick="javascript:location.href='view/back/CarriageManager/delete.jsp'">删除配送方式</button>
     <display:table name="${carriages}" pagesize="10" id = "carriage">
		<display:column property="carriageId" title="配送方式ID" />
		<display:column property="start" title="起始地" />
		<display:column property="destination" title="目的地" />
		<display:column property="company" title="配送公司" />
		<display:column property="cost" title="花费" />
	</display:table>
    
  </body>
</html>

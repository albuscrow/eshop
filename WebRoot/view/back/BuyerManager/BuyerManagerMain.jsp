<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'Buyer.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="css/screen.css" />
</head>

<body>
	<display:table name="${buyers}" pagesize="5" id = "buyer">
		<display:column property="user" title="用户名"  href="back/BuyerDetail.action" paramId="buyerId" paramProperty="buyerId"/>
		<display:column property="sex" title="性别" />
		<display:column property = "password" title = "密码"></display:column>
		<display:column property="registerDate" title="注册时间" />
	</display:table>
</body>
</html>

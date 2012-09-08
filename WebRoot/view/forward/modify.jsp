<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.lang.*,java.util.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'main.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript" src="js/jquery/jquery-1.9.1.js"></script>
<script type="text/javascript"
	src="js/jquery/jquery-ui-1.10.3.custom.js"></script>

<link rel="stylesheet" type="text/css" href="css/screen.css" />
<link rel="stylesheet" type="text/css"
	href="css/ui-lightness/jquery-ui-1.10.3.css">



<script type="text/javascript" src="js/forward/regester.js?random=<%= (new Random()).nextInt()%>"></script>


</head>

<body>
	<s:form theme="xhtml" onsubmit="return validate()" action="Modify">
	<s:textfield name = "buyer.user" label = "用户名" id = "user" value="%{#session.buyer.user}"></s:textfield>
	<s:password name = "buyer.password" label = "密码" id = "password" value=""></s:password>
	<s:password name = "password"  label = "密码确认" id = "passwordconfirm" ></s:password>
	<s:textfield name = "buyer.name" label="姓名" id = "name"  value="%{#session.buyer.name}"></s:textfield>
	<s:textfield name = "buyer.email" label = "email" id = "email"  value="%{#session.buyer.email}"></s:textfield>
	<s:select list="{'男', '女'}" name= "buyer.sex" label="性别" id = "sex"></s:select>
	<s:submit></s:submit>
	</s:form>

</body>
</html>

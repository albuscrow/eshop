<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>后台登录</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery/jquery-1.9.1.js"></script>
<script type="text/javascript"
	src="js/jquery/jquery-ui-1.10.3.custom.js"></script>
<script type="text/javascript"
	src="js/back/StatisticsManager/ImportList.js"></script>

<link rel="stylesheet" type="text/css"
	href="css/ui-lightness/jquery-ui-1.10.3.css">

<link rel="stylesheet" type="text/css"
	href="css/back/StatisticsManager/BackLogin.css">

<link rel="stylesheet" type="text/css" href="css/screen.css" />

<STYLE TYPE="text/Css">
<!--
BODY {background-image: URL(images/tolley.jpg);
background-position: center;
background-repeat: no-repeat;
background-attachment: fixed;}
-->
</STYLE>

</head>

<body>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
	<div class="div1">
	<s:form action="main" namespace="/back">
		<div align="center">
			<h1>欢迎来到Ego后台登录页面</h1>
		</div>
		<br />
		<p align="center">
			 <label> 用户名<s:textfield name="userId" type="text" size="20" /> </label>
		</p>
		<p align="center">
			 <label> 密码<s:password name="password" type="password" size="20" /> </label>
		</p>
		<br />
		<p align="center">
			<s:submit value="登录"></s:submit>
		</p>

	</s:form>
	</div>
</body>
</html>

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

<title>买家信息管理</title>

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
相关操作：
     <button onclick="javascript:location.href='view/back/BM/add.jsp'">增加买家</button>
     <button onclick="javascript:location.href='view/back/BM/delete.jsp'">删除买家</button>
     <button onclick="javascript:location.href='view/back/BM/modify_info.jsp'">修改买家基本信息</button>
     <button onclick="javascript:location.href='view/back/BM/modify_pass.jsp'">修改买家密码</button>
     <button onclick="javascript:location.href='view/back/BM/query.jsp'">查询买家</button>
	<display:table name="${buyers}" pagesize="5" id = "buyer">
	    <display:column property="buyerId" title="买家ID" />
		<display:column property="name" title="买家姓名" />
		<display:column property="sex" title="性别" />
		<display:column property="user" title="买家用户名" />
		<display:column property="email" title="邮箱" />
		<display:column property="registerDate" title="注册时间" />
	</display:table>
</body>
</html>

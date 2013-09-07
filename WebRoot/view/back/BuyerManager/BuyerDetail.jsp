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

<title>My JSP 'BuyerDetail.jsp' starting page</title>

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

<script type="text/javascript" src="js/back/BuyerDetail.js"></script>


</head>

<body>

	<input type="text" value="${buyer.password}" id="newPassWord" />
	<input type="button" onclick="modifyUserPassword()" value="修改密码" />
	<input type="reset" />

	<display:table name="${commoditys}" pagesize="5" id = "buyer">
		<display:column property="commodity.name" title="商品名" />
		<display:column property="commodity.price" title="价格" />
		<display:column property = "quantity" title = "数量"/>
		<display:column property="total" title="总价"/>
	</display:table>

</body>
</html>

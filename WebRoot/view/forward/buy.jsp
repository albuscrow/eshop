<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.lang.*,java.util.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'buy.jsp' starting page</title>

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



</head>

<body>
	<s:form theme="xhtml" action="forward/buy.action" onsubmit="return check()">
	<s:textfield name="orderList.quantity" label="数量"></s:textfield>
	<s:textfield name="orderList.address" label="地址"></s:textfield>
	<s:textfield name="orderList.postcode" label="邮编"></s:textfield>
	<s:textfield name="orderList.phone" label="联系电话"></s:textfield>
	<s:select list="{'货到付款','网银支付'}" name="payType" label="付款方式"></s:select>
	<s:select list="{'顺风快递','平邮'}" name="postType" label="快递方式"></s:select>
	<s:submit></s:submit>
	</s:form>
</body>
</html>

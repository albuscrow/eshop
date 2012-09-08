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

<title>My JSP 'comment.jsp' starting page</title>

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

<link rel="stylesheet" type="text/css" href="css/screen.css" />
<link rel="stylesheet" type="text/css"
	href="css/ui-lightness/jquery-ui-1.10.3.css">
	
	<script type="text/javascript">
	</script>

</head>

<body>

	<s:form theme="xhtml"  action="addComment">
	<s:hidden value="%{#parameters.orderid}" name = "oid"></s:hidden>
	<s:select list="{1,2,3,4,5}" name = "order.isMatched" id = "match" label="宝贝与描述相符度"></s:select>
	<s:select list="{1,2,3,4,5}" name = "order.logisticsSpeed" id = "speed" label="快递速度"></s:select>
	<s:select list="{1,2,3,4,5}" name = "order.attitude" id = "attitude" label="买家态度" ></s:select>
	<s:select list="{1,2,3,4,5}" name = "order.total" id = "total" label="总分" ></s:select>
	<s:textarea name = "order.comment" id = "total" label="总分" ></s:textarea>
	<s:submit></s:submit>
	</s:form>
</body>
</html>

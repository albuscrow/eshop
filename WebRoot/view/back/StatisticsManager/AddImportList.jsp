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

<title>添加进货单</title>

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
	src="js/back/StatisticsManager/AddImportList.js"></script>

<link rel="stylesheet" type="text/css"
	href="css/ui-lightness/jquery-ui-1.10.3.css">

<link rel="stylesheet" type="text/css"
	href="css/back/StatisticsManager/AddImportList.css">

<link rel="stylesheet" type="text/css" href="css/screen.css" />

</head>

<body>
	<s:form action="AddImportList" namespace="/back">
		<div align="center">
			<p class="STYLE4">添加进货单</p>
		
		<table width="156%" class="bordered" align="center">
			<thead>
				<tr>
					<th>商品名称</th>
					<th>数量(单位：件)</th>
					<th>每件商品成本(单位：元)</th>
				</tr>
				<tr>
					<td><s:textfield name="name" type="text" size="20" />
					</td>
					<td><s:textfield name="quantity" type="text" size="10" />
					</td>
					<td><s:textfield name="price" type="text" size="10" />
					</td>
				</tr>
			</thead>
		</table>
		<p align="center">
			<label> <s:submit  value="提交"></s:submit> </label>
			<label> <input type="button" value="取消" 
			onclick="location.href='back/ImportList.action'"></label>
		</p>
		<p>&nbsp;</p>
		</div>
	</s:form>

</body>
</html>

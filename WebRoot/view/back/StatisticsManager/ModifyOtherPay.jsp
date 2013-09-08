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

<title>更改其他支出</title>

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
	src="js/back/StatisticsManager/AddOtherPay.js"></script>

<link rel="stylesheet" type="text/css"
	href="css/ui-lightness/jquery-ui-1.10.3.css">

<link rel="stylesheet" type="text/css"
	href="css/back/StatisticsManager/AddOtherPay.css">

<link rel="stylesheet" type="text/css" 
	href="css/screen.css" />
  </head>
  
  <body>
    <s:form action="ModifyOtherPayEX" namespace="/back">
		<div align="center">
			<p class="STYLE4">更改其他支出单</p>
		
		<table width="156%" class="bordered" align="center">
			<thead>
				<tr>
					<th>负责人</th>
					<th>描述</th>
					<th>总额(单位：元)</th>
				</tr>
				<tr>
					<td><s:textfield name="name" type="text" size="20" value="%{#session.otherPay.user.name}"/>
					</td>
					<td><s:textfield name="note" type="text" size="10" value="%{#session.otherPay.note}"/>
					</td>
					<td><s:textfield name="amount" type="text" size="10" value="%{#session.otherPay.amount}"/>
					</td>
				</tr>
			</thead>
		</table>
		<p align="center">
			<label> <s:submit  value="提交"></s:submit> </label>
			<label> <input type="button" value="取消" 
			onclick="location.href='back/OtherPay.action'"></label>
		</p>
		<p>&nbsp;</p>
		</div>
	</s:form>
  </body>
</html>

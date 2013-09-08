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

<title>其他支出</title>

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
	src="js/back/StatisticsManager/OtherPay.js"></script>

<link rel="stylesheet" type="text/css"
	href="css/ui-lightness/jquery-ui-1.10.3.css">

<link rel="stylesheet" type="text/css"
	href="css/back/StatisticsManager/OtherPay.css">

<link rel="stylesheet" type="text/css" 
	href="css/screen.css" />

  </head>
  
  <body>
    <s:form action="QueryOtherPay" namespace="/back">
		<div align="center">
			<p class="STYLE4">其他支出</p>
		</div>
		<br />
		<p align="center">注：其他支出单号、负责人姓名、支出时间可选一至多项填写</p>
		<br />
		<p align="center">
			其他支出单号 <label> <s:textfield name="opayId" type="text" size="10" /> </label>
			 负责人姓名<label> <s:textfield type="text" name="name" /> </label> 
			 支出时间 <label> <s:textfield name="years" type="text" size="4" /> 年</label> 
			 <label> <s:textfield name="months" type="text" size="4" /> 月 </label>
			 <label> <s:textfield name="days" type="text" size="4"/> 日</label> 
			 <label> 到 </label> 
			 <label> <s:textfield name="yeare" type="text" size="4"/> 年 </label> 
			 <label> <s:textfield name="monthe" type="text" size="4"/> 月</label> 
			 <label> <s:textfield name="daye" type="text" size="4"/> 日</label>
		</p>
		<br />
		<p align="center">
			<s:submit value="查询"></s:submit>
			<label><input type="button" value="添加其他支出单" 
			onclick="location.href='back/AddOtherPayEX.action'"></label>
			<label><input type="button" value="重置" 
			onclick="location.href='back/OtherPay.action'"></label>
		</p>

	</s:form>
	<p>&nbsp;</p>
	<p>&nbsp;</p>

<div align="center">
	<display:table name="${otherPays}" pagesize="5" id="otherPays">
		<display:setProperty name="basic.msg.empty_list" value="无记录可供显示" />
		<display:column property="opayId" title="支出单编号" />
		<display:column property="user.name" title="负责人" />
		<display:column property="note" title="描述" />
		<display:column property="amount" sortable="true"
			headerClass="sortable" title="总额" />
		<display:column property="opayDate" sortable="true"
			headerClass="sortable" title="进货日期" />
		<display:column title="操作">
			<a
				href="back/ModifyOtherPay.action?opayId=${otherPays.opayId}">编辑</a>
			<p>&nbsp;</p>
			<a
				href="back/DeleteOtherPay.action?opayId=${otherPays.opayId}">删除</a>
		</display:column>
	</display:table>
</div>
  </body>
</html>

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

<title>进货单</title>

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
	href="css/back/StatisticsManager/ImportList.css">

<link rel="stylesheet" type="text/css" href="css/screen.css" />

</head>

<body>
	<s:form action="back/QueryImportList.action">
		<div align="center">
			<p class="STYLE4">进货单</p>
		</div>
		<br />
		<p align="center">注：货单号、商品名称、进货时间可选一至多项填写</p>
		<br />
		<p align="center">
			货单号 <label> <s:textfield name="importId" type="text" size="10" /> </label>
			 商品名称 <label> <s:textfield type="text" name="name" /> </label> 
			 进货时间 <label> <s:textfield name="years" type="text" size="4" /> 年</label> <label> <s:textfield
						name="months" type="text" size="4" /> 月 <input name="days"
					type="text" size="4"> 日</label> 到 <label></label> <label> <input
					name="yeare" type="text" size="4"> 年 <input name="monthe"
					type="text" size="4"> 月</label> <label> <input name="daye"
					type="text" size="4"> 日</label>
		</p>
		<br />
		<p align="center">
			<s:submit value="查询"></s:submit>
			<label></label>
		</p>

	</s:form>
	<p>&nbsp;</p>
	<p>&nbsp;</p>

	<display:table name="${importLists}" pagesize="5" id="importLists">
		<display:setProperty name="basic.msg.empty_list" value="无记录可供显示" />
		<display:column property="importId" title="货单编号" />
		<display:column property="commodity.name" title="商品名" />
		<display:column property="quantity" title="数量" />
		<display:column property="price" sortable="true"
			headerClass="sortable" title="价格" />
		<display:column property="importDate" sortable="true"
			headerClass="sortable" title="进货日期" />
		<display:column title="操作">
			<a
				href="back/ModifyImportList.action?importId=${importLists.importId}">编辑</a>
			<p>&nbsp;</p>
			<a
				href="back/DeleteImportList.action?importId=${importLists.importId}">删除</a>
		</display:column>
	</display:table>

</body>
</html>

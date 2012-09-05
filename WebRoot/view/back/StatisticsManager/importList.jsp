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

</head>

<body>
	<form>
		<div align="center">
			<p class="STYLE4">进货单</p>
		</div>
		<p align="center">
			<span class="STYLE6">货单号 <label> <input
					name="textfield" type="text" size="10"> </label> <label></label> <label></label>
				商品名称 <label> <input type="text" name="textfield9"> </label>
				进货时间 <label> <input name="textfield2" type="text" size="4">
					年</label> <label> <input name="textfield4" type="text" size="4">
					月 <input name="textfield5" type="text" size="4"> 日</label> 到 <label></label>
				<label> <input name="textfield6" type="text" size="4">
					年 <input name="textfield7" type="text" size="4"> 月</label> <label>
					<input name="textfield8" type="text" size="4"> 日</label> <label>
					<input type="submit" name="Submit" value="查询"> </label> <label></label>
				<label></label> </span> <label> </label>
		</p>
		<table width="156%" class="bordered">
			<thead>

				<tr>
					<th>货单号</th>
					<th>商品名称</th>
					<th>数量</th>
					<th>进货时间</th>
					<th>操作</th>
				</tr>
				<tr>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
					<th><a href="#" title="商品编辑页面"> 编辑 </a><a href="#"
						title="商品删除页面"> 删除</a>
					</th>
				</tr>
			</thead>
		</table>
		<p align="center">
			共XX页 每页10条 页数 <label> <input name="textfield3" type="text"
				size="4"> </label> /XX页 <a href="#" title="商品管理首页">首页</a><a href="#"></a>
			<a href="#" title="商品管理上一页">上一页</a> <a href="#" title="商品管理下一页">下一页</a>
			<a href="#" title="商品管理尾页">尾页</a> <a href="#" title="商品管理刷新">刷新</a>&nbsp;<a
				href="#">返回</a>
		</p>
		<p align="center">
			<label> <input type="submit" name="Submit2" value="添加">
			</label>
		</p>
		<p>&nbsp;</p>
	</form>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	
	<display:table name="${buyers}" pagesize="5">
		<display:column property="name" title="姓名" />
		<display:column property="sex" title="性别" />
		<display:column property="registerDate" title="注册时间" />
	</display:table>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Commodity.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<style>
<!--
body {
	width: 1000px;
	margin: 40px auto;
	font-family: 'trebuchet MS', 'Lucida sans', Arial;
	font-size: 14px;
	color: #444;
}

table {
	*border-collapse: collapse; /* IE7 and lower */
	border-spacing: 0;
	width: 100%;
}

.bordered {
	border: solid #ccc 1px;
	-moz-border-radius: 6px;
	-webkit-border-radius: 6px;
	border-radius: 6px;
	-webkit-box-shadow: 0 1px 1px #ccc;
	-moz-box-shadow: 0 1px 1px #ccc;
	box-shadow: 0 1px 1px #ccc;
}

.bordered tr:hover {
	background: #fbf8e9;
	-o-transition: all 0.1s ease-in-out;
	-webkit-transition: all 0.1s ease-in-out;
	-moz-transition: all 0.1s ease-in-out;
	-ms-transition: all 0.1s ease-in-out;
	transition: all 0.1s ease-in-out;
}

.bordered td,.bordered th {
	border-left: 1px solid #ccc;
	border-top: 1px solid #ccc;
	padding: 10px;
	text-align: left;
}

.bordered th {
	background-color: #dce9f9;
	background-image: -webkit-gradient(linear, left top, left bottom, from(#ebf3fc),
		to(#dce9f9) );
	background-image: -webkit-linear-gradient(top, #ebf3fc, #dce9f9);
	background-image: -moz-linear-gradient(top, #ebf3fc, #dce9f9);
	background-image: -ms-linear-gradient(top, #ebf3fc, #dce9f9);
	background-image: -o-linear-gradient(top, #ebf3fc, #dce9f9);
	background-image: linear-gradient(top, #ebf3fc, #dce9f9);
	-webkit-box-shadow: 0 1px 0 rgba(255, 255, 255, .8) inset;
	-moz-box-shadow: 0 1px 0 rgba(255, 255, 255, .8) inset;
	box-shadow: 0 1px 0 rgba(255, 255, 255, .8) inset;
	border-top: none;
	text-shadow: 0 1px 0 rgba(255, 255, 255, .5);
}

.bordered td:first-child,.bordered th:first-child {
	border-left: none;
}

.bordered th:first-child {
	-moz-border-radius: 6px 0 0 0;
	-webkit-border-radius: 6px 0 0 0;
	border-radius: 6px 0 0 0;
}

.bordered th:last-child {
	-moz-border-radius: 0 6px 0 0;
	-webkit-border-radius: 0 6px 0 0;
	border-radius: 0 6px 0 0;
}

.bordered th:only-child {
	-moz-border-radius: 6px 6px 0 0;
	-webkit-border-radius: 6px 6px 0 0;
	border-radius: 6px 6px 0 0;
}

.bordered tr:last-child td:first-child {
	-moz-border-radius: 0 0 0 6px;
	-webkit-border-radius: 0 0 0 6px;
	border-radius: 0 0 0 6px;
}

.bordered tr:last-child td:last-child {
	-moz-border-radius: 0 0 6px 0;
	-webkit-border-radius: 0 0 6px 0;
	border-radius: 0 0 6px 0;
}

#Layer1 {
	position: absolute;
	left: 378px;
	top: 197px;
	width: 82px;
	height: 22px;
	z-index: 1;
}

#Layer2 {
	position: absolute;
	left: 518px;
	top: 195px;
	width: 99px;
	height: 23px;
	z-index: 2;
}

.STYLE4 {
	font-size: 24px
}

.STYLE6 {
	font-size: 18
}
-->
</style>
</head>
<body>
	<form>
		<div align="center">
			<p class="STYLE4">商品管理</p>
		</div>
		<p align="center">
			<span class="STYLE6">商品编号 <label> <input
					name="textfield" type="text" size="10"> </label> <label></label>
				商品名称 <label> <input type="text" name="textfield2"> </label>
				分类 <label> <select name="select">
						<option>食品</option>
						<option>家具</option>
						<option>电器</option>
				</select> </label> <label> <input type="submit" name="Submit" value="查询">
			</label> </span> <label> </label>
		</p>
		<table width="156%" class="bordered">
			<thead>

				<tr>
					<th>商品编号</th>
					<th>商品名称</th>
					<th>分类</th>
					<th>销量</th>
					<th>价格</th>
					<th>优惠价</th>
					<th>是否推荐</th>
					<th>剩余数量</th>
					<th>图片</th>
					<th>平均分数</th>
					<th>简介</th>
					<th>产地</th>
					<th>市场价</th>
					<th>上市日期</th>
					<th>操作</th>
				</tr>
				<tr>
					<th> "${commodities[0].commodityId}" </th>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
					<th><a href="#" title="图片查看页面">查看图片</a>
					</th>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
					<th><a href="#" title="商品编辑页面">编辑 </a><a href="#"
						title="商品删除页面"> 删除</a>
					</th>
				</tr>
			</thead>
		</table>
		"${commodities[0].commodityId}"
		<p align="center">
			共XX页 每页10条 页数 <label> <input name="textfield3" type="text"
				size="4"> </label> /XX页 <a href="#" title="商品管理首页">首页</a><a href="#"></a>
			<a href="#" title="商品管理上一页">上一页</a> <a href="#" title="商品管理下一页">下一页</a>
			<a href="#" title="商品管理尾页">尾页</a> <a href="#" title="商品管理刷新">刷新</a>&nbsp;<a
				href="#">返回</a>
		</p>
		<p align="center"></p>
		<p>&nbsp;</p>
	</form>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
</body>
</html>

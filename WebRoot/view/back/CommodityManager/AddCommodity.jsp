<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'AddCommodity.jsp' page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript" src="js/jquery/jquery-1.9.1.js"></script>
<script type="text/javascript"src="js/jquery/jquery-ui-1.10.3.custom.js"></script>
<link rel="stylesheet" type="text/css" href="css/ui-lightness/jquery-ui-1.10.3.css">
<link rel="stylesheet" type="text/css" href="css/back/addgoods.css" />

 <script>
$(function() {
var spinner = $( ".MySpinner" ).spinner();
	spinner.spinner("value",0);
	spinner.spinner("option","min",0);
$( "button" ).button();
});
$(function() {
$( ".datepicker" ).datepicker();
});
</script>
</head>

<body>
	<form enctype="multipart/form-data">
		<p align="center" class="STYLE4">添加商品</p>
		<div align="center">
			<table class="bordered">
				<tr>
					<th>商品名称 <input name="name" type="text"
						size="15"></th>
					<th>优惠价  <input class="MySpinner" name="price" size="5"/>(元)</th>
					<th>价格 <input class="MySpinner" name="discountprice" size="5"/>（元）</th>
					<th>销量 <input name="sales" class="MySpinner" size="5">(件)</th>	
					<th>剩余数量<input name="rest" size="5" class ="MySpinner">(件)</th>
				</tr>
				<tr>
					<th>是否推荐<input name="isRecommend" type="text" size="15"></th>
					<th>平均分数<input name="averagemark" class ="MySpinner"	 size="15"></th>
					<th>产地<input name="origin" type="text" size="15"></th>
					<th colspan="2">上市日期<input size="10" class="datepicker"></th>
				</tr>
				<tr>
					<th colspan="2">简介<input name="introduction" type="text" size="15"></th>
					<th colspan="3"><div align="center">图片</div></th>
				</tr>
			</table>
		</div>
		<p align="center">
			<label> <input type="submit" name="Submit" value="添加">
			</label> <label></label> <label> <input type="submit" name="Submit2"
				value="返回"> </label>
		</p>
	</form>
	<form name="form1" method="post" action=""></form>
	<p>&nbsp;</p>
</body>
</html>

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
<title>EGO</title>
<style>
<!--
body {
	width: 600px;
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
-->
</style>
</head>
<body>
	<form enctype="multipart/form-data">
		<p align="center" class="STYLE4">添加商品</p>
		<div align="center">
			<table width="156%" class="bordered">
				<thead>

					<tr>
						<th>商品编号</th>
						<th>商品名称</th>
						<th>销量</th>
						<th>价格</th>
						<th>优惠价</th>
					</tr>

					<tr>
						<th><label> <input name="textfield" type="text"
								size="10"> </label>
						</th>
						<th><label> <input name="textfield2" type="text"
								size="20"> </label>
						</th>
						<th><label> <input name="textfield3" type="text"
								size="6"> 件</label>
						</th>
						<th><label> <input name="textfield4" type="text"
								size="6"> 元</label>
						</th>
						<th><label> <input name="textfield5" type="text"
								size="6"> 元</label>
						</th>
					</tr>
					<tr>
						<th>剩余数量</th>
						<th>是否推荐</th>
						<th>平均分数</th>
						<th>简介</th>
						<th>产地</th>
					</tr>
					<tr>
						<th><label> <input name="textfield6" type="text"
								size="6"> 件</label>
						</th>
						<th><label> <select name="select">
									<option>推荐</option>
									<option></option>
							</select> </label>
						</th>
						<th><label> <input name="textfield7" type="text"
								size="6"> 分</label>
						</th>
						<th><label> <textarea name="textfield8"></textarea> </label>
						</th>
						<th><label> <input name="textfield13" type="text"
								size="6"> </label>
						</th>
					</tr>
					<tr>
						<th>上市日期</th>
						<th>市场价</th>
						<th colspan="3"><div align="center">图片</div>
						</th>
					</tr>
					<tr>
						<th><label> <input name="textfield9" type="text"
								size="4"> 年</label> <label> <input name="textfield10"
								type="text" size="4"> 月 <input name="textfield11"
								type="text" size="4"> 日</label>
						</th>
						<th><label> <input name="textfield12" type="text"
								size="6"> 元</label>
						</th>
						<th colspan="3"><label></label> <label></label> <label></label>
						</th>
					</tr>
				</thead>
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

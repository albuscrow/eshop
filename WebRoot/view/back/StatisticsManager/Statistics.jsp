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

<title>相关统计</title>

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
	src="js/back/StatisticsManager/Statistics.js"></script>

<link rel="stylesheet" type="text/css"
	href="css/ui-lightness/jquery-ui-1.10.3.css">

<link rel="stylesheet" type="text/css"
	href="css/back/StatisticsManager/Statistics.css">

<link rel="stylesheet" type="text/css" href="css/screen.css" />

</head>

<body>
	<s:form action="Statistics" namespace="/back">
		<div align="center" class="STYLE5">营业统计</div>
		<p align="center">
			时间 ：<label> <s:textfield name="years" type="text" size="4" />
				年</label> <label> <s:textfield name="months" type="text" size="4" />
				月 </label> <label> <s:textfield name="days" type="text" size="4" />
				日</label> <label> 到 </label> <label> <s:textfield name="yeare"
					type="text" size="4" /> 年 </label> <label> <s:textfield
					name="monthe" type="text" size="4" /> 月</label> <label> <s:textfield
					name="daye" type="text" size="4" /> 日</label><s:submit value="查询"></s:submit>
		</p>
		<div align="center">
			<table width="156%" class="bordered">
				<thead>
					<tr>
						<th><div align="center">此时间段的营业额为${requestScope.result}</div></th>
					</tr>
				</thead>
			</table>
		</div>
		<p>&nbsp;</p>
	</s:form>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
<base href="<%=basePath%>">

<title>My JSP 'BuyerDetail.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<sx:head parseContent="true"/>

<script type="text/javascript" src="js/back/BuyerDetail.js"></script>

</head>

<body>
	<s:form action="ModifyBuyerPassword">
		<s:textfield label="密码" value="%{buyer.password}" name="password"></s:textfield>
		<sx:submit afterNotifyTopics="handleModifyPasswordResult" indicator="indicator"></sx:submit>
		<s:reset></s:reset>
	</s:form>
</body>
</html>

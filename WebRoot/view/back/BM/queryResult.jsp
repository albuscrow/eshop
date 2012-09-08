<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>买家用户查询结果</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <script type="text/javascript" src="js/jquery/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="js/jquery/jquery-ui-1.10.3.custom.js"></script>

    <link rel="stylesheet" type="text/css" href="css/screen.css" />
    <link rel="stylesheet" type="text/css" href="css/ui-lightness/jquery-ui-1.10.3.css">
  </head>
  
  <body>
    <display:table name="${buyer}" pagesize="10" id = "buyer">
	    <display:column property="buyerId" title="买家ID" />
		<display:column property="name" title="买家姓名" />
		<display:column property="sex" title="性别" />
		<display:column property="user" title="买家用户名" />
		<display:column property="email" title="邮箱" />
		<display:column property="registerDate" title="注册时间" />
	</display:table>
	 (  角色代号对应的角色： 1：买家   2：商品编辑    3：系统管理员    4：普通员工     5：仓库管理员       6：财务  )
  </body>
</html>

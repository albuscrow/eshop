<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>系统用户信息管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
		-->
    <link rel="stylesheet" type="text/css" href="css/screen.css" />
    
    <script type="text/javascript" src="js/back/SystemUserManager/SystemUserManager.js"></script>

    <link rel="stylesheet" type="text/css"href="css/ui-lightness/jquery-ui-1.10.3.css">
    <link rel="stylesheet" type="text/css" href="css/back/main.css">
    
  </head>
  
  <body>
   <display:table name="${users}" pagesize="3" id = "user">
		<display:column property="userId" title="用户ID" />
		<display:column property="user" title="用户名" />
		<display:column property="roleList.role" title="用户角色" />
		
		<display:column title="删除系统用户名"><button id="DeleteSyetemUser"  value="${user.userId}" >删除此用户</button></display:column>
		<display:column title="修改用户信息"><button id="ModifyUserInfo"  value="${user.userId}" >修改用户信息</button></display:column>
		
		
		<display:column><input type="button" value="删除" onClick="javascript:location.href='view/SystemUserManager/delete.jsp'"></display:column>
	
	
	
	</display:table>
	 (  角色代号对应的角色： 1：买家   2：商品编辑    3：系统管理员    4：普通员工     5：仓库管理员       6：财务  )
  </body>
</html>

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
    
    <title>系统用户信息管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    
    <script type="text/javascript" src="js/jquery/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="js/jquery/jquery-ui-1.10.3.custom.js"></script>

    <link rel="stylesheet" type="text/css" href="css/screen.css" />
    <link rel="stylesheet" type="text/css" href="css/ui-lightness/jquery-ui-1.10.3.css">
    
    <script type="text/javascript" src="js/back/SUM/SUM.js"></script>
  </head>
  
  <body>
  
   <display:table name="${users}" pagesize="3" id = "user">
		<display:column property="userId" title="用户ID" />
		<display:column property="user" title="用户名" />
		<display:column property="roleList.role" title="用户角色" />
		<display:column property="roleList.authority" title="用户权限" />
	</display:table>
	 (  角色代号对应的角色： 1：买家   2：商品编辑    3：系统管理员    4：普通员工     5：仓库管理员       6：财务  )<br><br><br>
	 
	    <button onclick="javascript:location.href='view/back/SUM/delete.jsp'">点击此处删除系统用户</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    <button onclick="javascript:location.href='view/back/SUM/modify_info.jsp'">点击此处修改系统用户信息</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    <button onclick="javascript:location.href='view/back/SUM/modify_pass.jsp'">点击此处修改系统用户密码</button>
  </body>
</html>

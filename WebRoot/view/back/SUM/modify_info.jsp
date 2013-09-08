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
    
    <title>My JSP 'delete.jsp' starting page</title>
    
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
        <form action="back/MSUI.action">
                        请输入要修改信息的系统用户ID <input name="userId"><br><br>
                       如果要修改此用户角色，请输入具体角色ID<input name="role_id"><br><br>
                      如果要修改用户名，请输入新用户名<input name="username"><br><br>
                     如果要修改用户名，请输入新的用户姓名<input name="name"><br><br>            
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            <input type="submit" value="确认修改">                     
        
        </form>
  </body>
</html>

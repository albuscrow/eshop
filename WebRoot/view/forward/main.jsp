<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ page import="java.lang.*,java.util.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'main.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript" src="js/jquery/jquery-1.9.1.js"></script>
<script type="text/javascript"
	src="js/jquery/jquery-ui-1.10.3.custom.js"></script>

<link rel="stylesheet" type="text/css" href="css/screen.css" />
<link rel="stylesheet" type="text/css"
	href="css/ui-lightness/jquery-ui-1.10.3.css">



<link rel="stylesheet" type="text/css" href="css/forward/main.css">
<script type="text/javascript" src="js/forward/main.js?random=<%= (new Random()).nextInt() %>"></script>

<script type="text/javascript">

function zhanghu(){
	location.href="forward/mine.action";
}

function order(){
	location.href="forward/trolley.action";
}

function pinglun(data) {
	location.href="forward/Comment.action?cid="+data;
}


</script>

<STYLE TYPE="text/Css">
<!--
BODY {background-image: URL(images/forward3.jpg);
background-position: 100% 70%;
background-repeat: no-repeat;
background-attachment: fixed;}
-->
</STYLE>


</head>

<body>
	<table width="1024" border="0" align="center">
  <tr>
    <td width="30%" class="HY">welcome</td>
    <td align="right">
    <input type="hidden" value="${flag}" id = "flag">
    <input type = "hidden" value = "${buyer.user}" id = "userName"/>
    <span class="HY" id = "inf">您好！欢迎来到Ego</span>
    <input type = "text" value = "" id = "buyerUserName" > 
    <input type = "text" value = "" id = "password" >
    <input type="button"onclick="login()" class="HY" value="[登录]" id = "login">
    <input type="button" onclick="window.location.href('regesterPage.action')"class="HY" value="[注册]"id = "regester" >    
    <input type="button" class="HY" value="我的账户" id = "zhanghu" onclick = "zhanghu()">
    <input type="button" class="HY"value="我的订单" id = "order" onclick="order()"></td>
  </tr>
</table>
<br />


<table width="1024" border="0" align="center">
  <tr>
    <td width="540" rowspan="2"> 
    <p><span class="Ego" style="font-size: 70px">Ego </span>
      <input name="txt" type="text" class="txt" id="serachContent" style="margin-left:10%; width: 30%;" />
      <input type="button" name="but" id="search" value="搜索" onclick = "search()" />
      <input type="button" name="but" id="search" value="查看全部" onclick = "location.href = 'forward/main.action'" />
    </p>

    </td>
  </tr>
  <tr>
    <td align="center" valign="bottom">&nbsp;</td>
  </tr>
</table>
<br/>
<HR style="FILTER: alpha(opacity=100,finishopacity=0,style=2)" width="1024" color=#000 SIZE=10 align="center">
<br />
<table width="1024" border="0"  align="center">
  <tr>
    <td width="20%" height="39" align="center" class="lb">全部商品分类</td>
    <td width="80%">&nbsp;</td>
  </tr>
  <tr>
    <td height="100%" align="center" valign="top"><ul id="MenuBar2" class="MenuBarVertical">
      <li><a class="MenuBarItemSubmenu" href="forward/searchByK.action?K=1">食品酒水</a>
       
      </li>
      <li>
      <a class="MenuBarItemSubmenu" href="forward/searchByK.action?K=2">电子数码</a>
    
      </li>
      <li>
      <a class="MenuBarItemSubmenu" href="forward/searchByK.action?K=3">服饰鞋帽</a>
     
      </li>
      <li>
      <a class="MenuBarItemSubmenu" href="forward/searchByK.action?K=4">个人护理</a>
     
      </li>
    </ul></td>
    <td><display:table name = "${commodities}" pagesize="5" id = "commodity">
    	<display:column property="name" title="商品名" />
		<display:column property="price" title="价格" />
		<display:column property = "introduction" title = "简介"/>
		<display:column property="brand" title="品牌" />
		<display:column>
			<a onclick = "buy(${commodity.commodityId})" >购买</a>   <a onclick = "addToTrolley(${commodity.commodityId})">加入到购物车</a>
			<a onclick= "pinglun(${commodity.commodityId})">查看评论</a>
		</display:column>
    </display:table></td>
  </tr>
</table>
<br />

</body>
</html>

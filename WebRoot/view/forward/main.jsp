<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
<script type="text/javascript" src="js/forward/main.js"></script>


</head>

<body>
	<table width="1024" border="0" align="center">
  <tr>
    <td width="30%" class="HY">welcome</td>
    <td align="right">
    <span class="HY" id = "inf">您好！欢迎来到Ego</span>
    <input type = "text" value = "用户名" id = "buyerUserName" > 
    <input type = "text" value = "密码" id = "password" >
    <input type="button"onclick="login()" class="HY" value="[登录]" id = "login">
    <input type="button" onclick="window.location.href('file:///H:/dreamwaver/注册页.html')"class="HY" value="[注册]"id = "regester" >    
    <input type="button" class="HY" value="我的账户" id = "zhanghu" >
    <input type="button" class="HY"value="我的订单" id = "order"></td>
  </tr>
</table>
<br />


<table width="1024" border="0" align="center">
  <tr>
    <td width="540" rowspan="2"> 
    <p><span class="Ego" style="font-size: 70px">Ego </span>
      <input name="txt" type="text" class="txt" id="txt"style="margin-left:10%; width: 50%;" />
      <input type="submit" name="but" id="but" value="搜索" />
    </p>
    </p>
    </td>
    <td width="169" height="83" align="center" valign="bottom">
<!--    <form id="form1" name="form1" method="post" action="">
      <input type="submit" name="gr" id="gr" value="我的Ego" style="height:30px;width:100px" />
    </form>      <form id="form2" name="form2" method="post" action="">
        <input type="submit" name="gr2" id="gr2" value="购物车" style="height:30px;width:100px"/>
    </form>    <form id="form3" name="form3" method="post" action="">
      <input type="submit" name="gr3" id="gr3" value="我的订单" style="height:30px;width:100px"/>
    </form>-->
    <ul id="MenuBar1" class="MenuBarHorizontal">
      <li><a class="MenuBarItemSubmenu" href="#">我的索引</a>
        <ul>
          <li><a href="#" class="index">我的Ego</a></li>
          <li><a href="file///H//dreamwaver/购物车	.html" class="index">购物车</a></li>
        </ul>
      </li>
      </ul>
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
      <li><a class="MenuBarItemSubmenu" href="#">食品酒水</a>
        <ul>
          <li><a href="#">项目 1.1</a></li>
          <li><a href="#">项目 1.2</a></li>
          <li><a href="#">项目 1.3</a></li>
        </ul>
      </li>
      <li>
      <a class="MenuBarItemSubmenu" href="#">电子数码</a>
      <ul>
          <li><a href="#">项目 1.1</a></li>
          <li><a href="#">项目 1.2</a></li>
          <li><a href="#">项目 1.3</a></li>
        </ul>
      </li>
      <li>
      <a class="MenuBarItemSubmenu" href="#">服饰鞋帽</a>
        <ul>
          <li><a href="#">项目 3.1</a>
          </li>
          <li><a href="#">项目 3.2</a></li>
          <li><a href="#">项目 3.3</a></li>
        </ul>
      </li>
      <li>
      <a class="MenuBarItemSubmenu" href="#">个人护理</a>
      <ul>
          <li><a href="#">项目 1.1</a></li>
          <li><a href="#">项目 1.2</a></li>
          <li><a href="#">项目 1.3</a></li>
        </ul>
      </li>
    </ul></td>
    <td><input name="商品图" type="image" value="商品" src="捕获1.PNG" /></td>
  </tr>
</table>
<br />

</body>
</html>

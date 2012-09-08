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

<title>添加订单</title>

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
	src="js/back/OrderListManager/AddOrderList.js"></script>

<link rel="stylesheet" type="text/css"
	href="css/ui-lightness/jquery-ui-1.10.3.css">

<link rel="stylesheet" type="text/css"
	href="css/back/OrderListManager/AddOrderList.css">

<link rel="stylesheet" type="text/css" 
	href="css/screen.css" />

  </head>
  
  <body>
    <s:form action="AddOrderList" namespace="/back">
		<div align="center">
			<p class="STYLE4">添加订单</p>
		
		<table width="156%" class="bordered" align="center">
			<thead>
				<tr>
					<th>商品名称</th>
					<th>买家ID</th>
					<th>数量</th>
					<th>付款方式</th>
					<th>订单状态</th>
					<th>物流状态</th>
					<th>派送方式</th>
					<th>邮编</th>
					<th>地址</th>
					<th>电话</th>
					<th>运费(单位：元)</th>
				</tr>
				<tr>
					<td><s:textfield name="name" type="text" size="20" value="%{#session.orderList.commodity.name}"/>
					</td>
					<td><s:textfield name="buyerId" type="text" size="10" value="%{#session.orderList.buyer.buyerId}"/>
					</td>
					<td><s:textfield name="quantity" type="text" size="10" value="%{#session.orderList.quantity}"/>
					</td>
					<td><s:textfield name="payType" type="text" size="20" value="%{#session.orderList.payType}"/>
					</td>
					<td><s:textfield name="state" type="text" size="10" value="%{#session.orderList.state}"/>
					</td>
					<td><s:textfield name="logisticsState" type="text" size="10" value="%{#session.orderList.logisticsState}"/>
					</td>
					<td><s:textfield name="postType" type="text" size="20" value="%{#session.orderList.postType}"/>
					</td>
					<td><s:textfield name="postcode" type="text" size="10" value="%{#session.orderList.postcode}"/>
					</td>
					<td><s:textfield name="address" type="text" size="10" value="%{#session.orderList.address}"/>
					</td>
					<td><s:textfield name="phone" type="text" size="20" value="%{#session.orderList.phone}"/>
					</td>
					<td><s:textfield name="carriageFee" type="text" size="10" value="%{#session.orderList.carriageFee}"/>
					</td>
				</tr>
			</thead>
		</table>
		<p align="center">
			<label> <s:submit  value="提交"></s:submit> </label>
			<label> <input type="button" value="取消" 
			onclick="location.href='back/OrderList.action'"></label>
		</p>
		<p>&nbsp;</p>
		</div>
	</s:form>
  </body>
</html>

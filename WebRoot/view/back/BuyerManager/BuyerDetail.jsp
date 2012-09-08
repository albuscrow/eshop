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

<title>My JSP 'BuyerDetail.jsp' starting page</title>

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

<script type="text/javascript" src="js/back/BuyerDetail.js"></script>


</head>

<body>

	<%-- <input type="text" value="${buyer.password}" id="newPassWord" />
	<input type="button" onclick="modifyUserPassword()" value="修改密码" />
	<input type="reset" /> --%>

<%-- 	<display:table name="${commoditys}" pagesize="5" id = "buyer">
		<display:column property="commodity.name" title="商品名" />
		<display:column property="commodity.price" title="价格" />
		<display:column property = "quantity" title = "数量"/>
		<display:column property="total" title="总价"/>
	</display:table> --%>

	<p>以下为您所要查询的买家订单：</p>
	
	<display:table name="${orderLists}" pagesize="5" id = "orderLists">
		<display:setProperty name="basic.msg.empty_list" value="该买家现暂无订单" />
		<display:column property="orderId" title="订单号" />
		<display:column property="commodity.name" title="商品名" />
		<display:column property="buyer.buyerId" title="买家ID" />
		<display:column property="buyer.name" title="买家姓名" />
		<display:column property="quantity" title="数量" />
		<display:column property="payType" title="付款方式" />
		<display:column property="state" title="订单状态" />
		<display:column property="logisticsState" title="物流状态" />
		<display:column property="postType" title="派送方式" />
		<display:column property="postcode" title="邮编" />
		<display:column property="address" title="地址" />
		<display:column property="phone" title="电话" />
		<display:column property="carriageFee" title="运费" />
		<display:column property="registerDate" sortable="true"
			headerClass="sortable" title="下单日期" />
		<display:column title="操作">
			<a
				id="SendConfirm" href="back/ModifyOrderList.action?orderId=${orderLists.orderId}">确认发货</a>
		</display:column>
	</display:table>

</body>
</html>

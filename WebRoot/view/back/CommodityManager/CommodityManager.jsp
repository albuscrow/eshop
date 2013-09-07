<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>

<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'Commodity.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link rel="stylesheet" type="text/css" href="css/screen.css" />
<link rel="stylesheet" type="text/css" href="css/back/commodityMain.css" />

<script type="text/javascript">

$("#CommodityManager").click(function() {
		$(".content").attr("src","back/CommodityManager.action");
	});
	
</script>
	

</head>
<body>
	<form>
		<div align="center">
			<p class="STYLE4">商品管理</p>
		</div>
		<p align="center">
			<span class="STYLE6">
		<s:form action="/back/CommodityManager.action" method="post" enctype="multipart/form-data" >
			商品编号：
			<s:textfield 
            label="商品编号" 
            name="goodsId"  />
            
          	  商品名称：
			<s:textfield 
            label="商品名称" 
            name="goodsName" />
            
          	  分类:
			<s:select
            label="分类"
            list="category"
            listValue="name"
            listKey="categoryId"
            name="categorySelect"
            headerKey="null"
            headerValue="全部"/>
            
            <s:submit value="查询" />            
		</s:form>
		</span>
		</p>
		<display:table name="${commodities}" pagesize="10">
			<display:column property="commodityId" title="商品编号" />
			<display:column property="name" title="商品名称" />
			<display:column property="category.name" title="分类" />
			<display:column property="price" title="价格" />
			<display:column property="discountPrice" title="市场价" />
			<display:column property="sales" title="销量" />
			<display:column property="isRecommend" title="是否推荐" />
			<display:column property="rest" title="剩余数量" />
			<display:column property="picture" title="图片" />
			<display:column property="averageMark" title="平均分数" />
			<display:column property="introduction" title="简介" />
			<display:column property="origin" title="产地" />
			<display:column property="registerDate" title="上市日期" />
		</display:table>
	</form>
	<p align="center">
		<a href="back/CommodityManager.action" title="商品管理刷新">刷新</a>
	</p>
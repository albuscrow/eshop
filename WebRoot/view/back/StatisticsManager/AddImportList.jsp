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

<title>添加进货单</title>

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
	src="js/back/StatisticsManager/AddImportList.js"></script>

<link rel="stylesheet" type="text/css"
	href="css/ui-lightness/jquery-ui-1.10.3.css">

<link rel="stylesheet" type="text/css"
	href="css/back/StatisticsManager/AddImportList.css">

<link rel="stylesheet" type="text/css" href="css/screen.css" />

</head>

<body>
	<s:form>
		<div align="center">
			<p class="STYLE4">添加进货单</p>
		</div>
		<table width="156%" class="bordered">
			<thead>
				<tr>
					<th>商品名称</th>
					<th>数量</th>
					<th>每件商品成本</th>
				</tr>
				<tr>
					<td><textfield name="name" type="text" size="20" label="" />
					</td>
					<td><textfield name="quantity" type="text" size="6" />
					</td>
					<td><textfield name="price" type="text" size="20" />
					</td>
				</tr>
			</thead>

		</table>
		<p align="center">
			<label> <input type="submit" name="Submit" value="提交"
				onclick="location.href='back/AddImportList.action'"> </label> <label>
				<input type="submit" name="Submit2" value="取消"
				onclick="location.href='view/back/StatisticsManager/ImportList.jsp'">
			</label>
		</p>
		<p>&nbsp;</p>
	</s:form>
	<s:form>
	<table border="1">
  <tr>
    <th>Month</th>
    <th>Savings</th>
    <th>input</th>
  </tr>
  <tr>
    <td>January</td>
    <td>$100</td>
    <td><s:textfield></s:textfield></td>
  </tr>
</table>
</s:form>
	<p>&nbsp;</p>
	<p>&nbsp;</p>



	<s:actionerror />
	<s:actionmessage />
	<s:fielderror />

	<s:form action="exampleSubmit" method="post"
		enctype="multipart/form-data"
		tooltipConfig="#{'jsTooltipEnabled':'true'}">
		<s:textfield label="Name" name="name" tooltip="Enter your Name here" />

		<s:textarea tooltip="Enter your Biography" label="Biograph" name="bio"
			cols="20" rows="3" />

		<s:select tooltip="Choose Your Favourite Color" label="Favorite Color"
			list="{'Red', 'Blue', 'Green'}" name="favoriteColor"
			emptyOption="true" headerKey="None" headerValue="None" />

		<s:checkboxlist tooltip="Choose your Friends" label="Friends"
			list="{'Patrick', 'Jason', 'Jay', 'Toby', 'Rene'}" name="friends" />

		<s:checkbox tooltip="Confirmed that your are Over 18" label="Age 18+"
			name="legalAge" />

		<s:doubleselect tooltip="Choose Your State" label="State"
			name="region" list="{'North', 'South'}" value="'South'"
			doubleValue="'Florida'"
			doubleList="top == 'North' ? {'Oregon', 'Washington'} : {'Texas', 'Florida'}"
			doubleName="state" headerKey="-1"
			headerValue="---------- Please Select ----------" emptyOption="true" />

		<s:file tooltip="Upload Your Picture" label="Picture" name="picture" />

		<s:optiontransferselect
			tooltip="Select Your Favourite Cartoon Characters"
			label="Favourite Cartoons Characters"
			name="leftSideCartoonCharacters" leftTitle="Left Title"
			rightTitle="Right Title" list="{'Popeye', 'He-Man', 'Spiderman'}"
			multiple="true" headerKey="headerKey"
			headerValue="--- Please Select ---" emptyOption="true"
			doubleList="{'Superman', 'Mickey Mouse', 'Donald Duck'}"
			doubleName="rightSideCartoonCharacters"
			doubleHeaderKey="doubleHeaderKey"
			doubleHeaderValue="--- Please Select ---" doubleEmptyOption="true"
			doubleMultiple="true" />

		<s:textarea label="Your Thougths" name="thoughts"
			tooltip="Enter your thoughts here" />

		<s:submit onclick="alert('aaaa');" />
		<s:reset onclick="alert('bbbb');" />
	</s:form>


</body>
</html>

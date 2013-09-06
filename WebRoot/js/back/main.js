$(function init() {
	//添加菜单栏的那个控件
	$("#operation").accordion();
	
	//添加各个菜单项的相应事件
	$("#addCommodity").click(function() {
		$(".content").attr("src","back/addCommodity.action");
	});
	
	$("#BuyerManager").click(function() {
		$(".content").attr("src","back/BuyerManager.action");
	});
});




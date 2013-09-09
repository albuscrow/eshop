$(function init() {

	$("#operation").accordion();
	
	$("#addCommodity").click(function() {
		$(".content").attr("src","back/addCommodity.action");
	});
	
	$("#ImportListManagement").click(function() {
		$(".content").attr("src","back/ImportList.action");
	});
	
	$("#OtherPayManagement").click(function() {
		$(".content").attr("src","back/OtherPay.action");
	});
	
	$("#Statistics").click(function() {
		$(".content").attr("src","back/StatisticsEX.action");
	});
	
	$("#OrderListManagement").click(function() {
		$(".content").attr("src","back/OrderListManagement.action");
	});
	
	$("#CommodityManager").click(function() {
		$(".content").attr("src","back/CommodityManager.action");
	});
	
	$("#BuyerManager").click(function() {
		$(".content").attr("src","back/BuyerManager.action");
	});
	$("#SUM").click(function() {
		$(".content").attr("src","back/SUM.action");
	});
});




$(function init() {
	//��Ӳ˵������Ǹ��ؼ�
	$("#operation").accordion();
	
	//��Ӹ����˵������Ӧ�¼�
	$("#addCommodity").click(function() {
		$(".content").attr("src","back/addCommodity.action");
	});
	
	$("#BuyerManager").click(function() {
		$(".content").attr("src","back/BuyerManager.action");
	});
});




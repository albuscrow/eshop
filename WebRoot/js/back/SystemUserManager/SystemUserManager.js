$(function init() {
	    //ɾ��ϵͳ�û���ť����Ӧ�¼�
	    $("#DeleteSyetemUser").click(function() {
	    	var id = this.attr("value");
		    $(".content").attr("src","back/DeleteSyetemUser.action?userId="+id);
	});
});




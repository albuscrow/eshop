$(function SystemUserManager() {
	    //ɾ��ϵͳ�û���ť����Ӧ�¼�
	    $("#DSU").click(function() {
	    	var id = this.attr("value");
		    $(".content").attr("src","back/DSU.action?userId="+id);
	});
	
});




$(function SystemUserManager() {
	    //ɾ��ϵͳ�û���ť����Ӧ�¼�
	    $("#DeleteSyetemUser").click(function() {
	    	var id = this.attr("value");
		    $(".content").attr("src","back/DeleteSyetemUser.action?userId="+id);
	});
	
//	    $("#DeleteSyetemUser").click(function() {
//	    	var id = this.attr("value");
//		    $(".content").attr("src","view/back/SystemUserManager/delete.jsp");
//	});
	
	   //href("view/back/SystemUserManager/delete.jsp");
});




$(function SystemUserManager() {
	    //删除系统用户按钮的相应事件
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




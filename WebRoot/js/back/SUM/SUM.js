$(function SystemUserManager() {
	    //删除系统用户按钮的相应事件
	    $("#DSU").click(function() {
	    	var id = this.attr("value");
		    $(".content").attr("src","back/DSU.action?userId="+id);
	});
	
});




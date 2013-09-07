$(function init() {
	    //删除系统用户按钮的相应事件
	    $("#DeleteSyetemUser").click(function() {
	    	var id = this.attr("value");
		    $(".content").attr("src","back/DeleteSyetemUser.action?userId="+id);
	});
});




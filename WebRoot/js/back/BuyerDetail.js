function modifyUserPassword() {

	$.get("back/ModifyBuyerPassword.action","password="+$("#newPassWord").val(),function(data){
		alert(data);
	});
};


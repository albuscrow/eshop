$(function(){
	if($("#inf").val() == ""){
		$("#inf").hide();
	}
});



function validate(){
	var password = $("#password").val();
	var passwordConfirm = $("#passwordconfirm").val();
	var user = $("#user").val();
	var name = $("#name").val();
	var email = $("#email").val();
	var sex = $("#sex").val();
	if(user != "" && name != "" && email != "" && sex != "" && password == passwordConfirm){
		return true;
	}else{
		alert("输入有误，请重新输入");
		return false;
	}
}
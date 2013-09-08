function check(){
	var quantity = $("#quantity").val();
	var address = $("#address").val();
	var postcode = $("#postcode").val();
	var phone = $("#phone").val();
	if(quantity != "" && address != "" && postcode != "" && phone != ""
		&& $.isNumeric(postcode+quantity+phone)){
		return true;
	}else{
		alert("输入有误，请重新输入");
		return false;
	}
}
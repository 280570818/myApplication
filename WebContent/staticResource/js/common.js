/**
 * 通用js常用函数
 */
function isNull(str) {
	if (str == "")
		return true;
	var regu = "^[ ]+$";
	var re = new RegExp(regu);
	return re.test(str);
}

function isCardNo(str) { 
  	var reg = /(^\d{17}(\d|X|x)$)/; 
  	return reg.test(str);
}

function isPhoneNo(str){
	var reg = /^1\d{10}$/;
	return reg.test(str);
}

function isEmail(str){
	var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+$/ ;
	return reg.test(str);
}
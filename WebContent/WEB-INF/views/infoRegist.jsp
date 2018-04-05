<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>帐号信息完善</title>
	<link href="${pageContext.request.contextPath}/staticResource/css/model/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/staticResource/font/css/font-awesome.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/staticResource/css/model/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/staticResource/css/model/style-responsive.css" rel="stylesheet">
    <style type="text/css">
    	.contentInput{
    		margin-bottom: 10px;
    	}
    </style>
</head>
<body>
	<div id="login-page">
  		<div class="container">
      		<form class="form-login" action="${pageContext.request.contextPath}/login/infoRegist.html" 
      			method="post" onsubmit="return registCheck();" id="infoRegistForm" style="max-width: 800px;">
		        <h2 class="form-login-heading">您好！${requestScope.user.userName}，请首先完善帐号信息</h2>
		        <div class="login-wrap">
		        	<input type="hidden" name="id" value="${user.id}">
		        	<div class="col-md-6 contentInput">
		            	<input type="text" class="form-control" name="name" value="${requestScope.user.name}" placeHolder="真实姓名">
		            </div>
		            <div class="col-md-6 contentInput">
		            	<input type="text" class="form-control" name="phoneNo" value="${user.phoneNo}" placeHolder="手机号" onchange="checkPhone();">
		            </div>
		            <div class="col-md-6 contentInput">
		            	<input type="text" class="form-control" name="idCardNo" value="${user.idCardNo}" placeHolder="身份证号码" onchange="idCardNoChange();">
		            </div>
		            <div class="col-md-6 contentInput">
		            	<input type="text" class="form-control" name="qqAccount" value="${user.qqAccount}" placeHolder="QQ号码" onchange="qqAccountChange();">
		            </div>
		            <div class="col-md-6 contentInput">
		            	<input type="text" class="form-control" name="birthday" value="${user.birthday}" placeHolder="生日">
		            </div>
		            <div class="col-md-6 contentInput">
		            	<input type="text" class="form-control" name="weiChatAccount" value="${user.weiChatAccount}" placeHolder="微信号码">
		            </div>
		            <div class="col-md-6 contentInput">
		            	<input type="text" class="form-control" name="email" value="${user.email}" placeHolder="电子邮件">
		            </div>
		            <div class="col-md-6 contentInput">
		            	<input type="text" class="form-control" name="sex" value="${user.sex}" placeHolder="性别">
		            </div>
		            <div class="col-md-6 contentInput">
		            	<input type="text" class="form-control" name="schoolName" value="${user.schoolName}" placeHolder="学校名称">
		            </div>
		            <div class="col-md-6 contentInput">
		            	<input type="text" class="form-control" name="className" value="${user.className}" placeHolder="班级（专业）名称">
		            </div>
		            <div class="col-md-12 contentInput">
			            <a id="registStatus" style="color: red;">
			            </a>
		            </div>
		            <button class="btn btn-theme btn-block" type="submit">
		            	<i class="fa fa-lock"></i> 信息提交
		            </button>
		        </div>
			</form>
	  	</div>
  	</div>
    <script src="${pageContext.request.contextPath}/staticResource/js/model/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/staticResource/js/model/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/staticResource/js/model/jquery.backstretch.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/staticResource/js/common.js"></script>
    <script>
        $.backstretch("${pageContext.request.contextPath}/staticResource/img/login-bg.jpg", {speed: 500});
    </script>
</body>
<script type="text/javascript">
	function registCheck() {
		$("#registStatus").text("");
		if(!checkPhone())
			return false;
		var info = $("#infoRegistForm").serializeArray();
		for ( var key in info) {
			if(isNull(info[key].value)){
				$("#registStatus").text("请填写完整个人信息！");
				return false;
			}
		}
		return true;
	}
	function checkPhone(){
		$("#registStatus").text("");
		var phoneNo = $("#infoRegistForm input[name='phoneNo']").val();
		if(!isPhoneNo(phoneNo)){
			$("#registStatus").text("请填写正确的手机号码！");
			return false;
		}
		return true;
	}
	function idCardNoChange() {
		$("#registStatus").text("");
		var idCardNo = $("#infoRegistForm input[name='idCardNo']").val();
		if(!isCardNo(idCardNo)){
			$("#registStatus").text("请填写正确的身份证号码！");
			return;
		}
		var birthday = idCardNo.substring(6,14);
		birthday = birthday.substring(0,4)+"-"+birthday.substring(4,6)+"-"+birthday.substring(6,8);
		$("#infoRegistForm input[name='birthday']").val(birthday);
		var sex = idCardNo.substring(16,17);
		console.log(sex);
		$("#infoRegistForm input[name='sex']").val((parseInt(sex)%2 == 0)?"女":"男");
	}
	
	function qqAccountChange() {
		$("#registStatus").text("");
		var qqAccount = $("#infoRegistForm input[name='qqAccount']").val();
		if(isNull(qqAccount) || qqAccount.length < 5){
			$("#registStatus").text("请填写正确的QQ号码！");
			return;
		}
		$("#infoRegistForm input[name='email']").val(qqAccount+"@qq.com");
	}
</script>
</html>
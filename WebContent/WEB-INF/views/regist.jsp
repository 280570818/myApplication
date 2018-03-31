<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>帐号注册</title>
	<link href="${pageContext.request.contextPath}/staticResource/css/model/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/staticResource/font/css/font-awesome.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/staticResource/css/model/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/staticResource/css/model/style-responsive.css" rel="stylesheet">
</head>
<body>
	<div id="login-page">
  		<div class="container">
      		<form class="form-login" action="${pageContext.request.contextPath}/login/regist.html" 
      			method="post" onsubmit="return registCheck();" id="registForm">
		        <h2 class="form-login-heading">帐号注册</h2>
		        <div class="login-wrap">
		            <input type="text" class="form-control" placeholder="用户名（支持中文哦）" name="userName" autofocus onblur="checkUserName();">
		            <br/>
		            <input type="password" class="form-control" placeholder="密码" name="password">
		            <br/>
		            <input type="password" class="form-control" placeholder="重复密码" name="password2">
		            <label class="checkbox">
		                <span class="pull-left" style="color: red;" id="registStatus">
		                   
		                </span>
		            </label>
		            <button class="btn btn-theme btn-block" type="submit">
		            	<i class="fa fa-lock"></i> 注&nbsp;&nbsp;册
		            </button>
		            <hr>
		            <div class="registration">
		             	 已有帐号？<a href="${pageContext.request.contextPath}/login/loginUI.html">前往登录</a>
		            </div>
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
		if(checkUserName() == 0 || checkUserName() == "0"){
			var password = $("#registForm input[name='password']").val();
			var password2 = $("#registForm input[name='password2']").val();
			if(isNull(password)){
				$("#registStatus").text("密码不能为空！");
				return false;
			}
			if(password != password2){
				$("#registStatus").text("两次密码输入不一致！");
				return false;
			}
			return true;
		}
		return false;
	}
	function checkUserName() {
		$("#registStatus").text("");
		var userName = $("#registForm input[name='userName']").val();
		if(isNull(userName)){
			$("#registStatus").text("用户名不能为空！");
			return false;
		}
		var msg;
		$.ajax({
			url:"${pageContext.request.contextPath}/login/usernameisexists.html",
			async:false,
			type:"post",
			data:{userName:userName},
			success:function (data){
				msg = data;
				if(data !="0" && data != 0){
					$("#registStatus").text("该用户名已被使用!");
				}
			}
		});
		return msg;
	}
</script>
</html>
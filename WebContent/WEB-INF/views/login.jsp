<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>欢迎登录</title>
	<link href="${pageContext.request.contextPath}/staticResource/css/model/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/staticResource/font/css/font-awesome.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/staticResource/css/model/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/staticResource/css/model/style-responsive.css" rel="stylesheet">
</head>
<body>
	<div id="login-page">
  		<div class="container">
      		<form class="form-login" action="${pageContext.request.contextPath}/login/login.html" 
      			method="post" onsubmit="return loginCheck();" id="loginForm">
		        <h2 class="form-login-heading">欢迎登录</h2>
		        <div class="login-wrap">
		        
		            <input type="text" class="form-control" placeholder="用户名" name="userName" autofocus>
		            <br>
		            <input type="password" class="form-control" placeholder="密码" name="password">
		            <label class="checkbox">
		                <span class="pull-left" style="color: red;">
		                    <a style="color: red;" id="loginWarn">${loginStatus}</a>
		                    <a style="color: green;" id="loginNotice">${registStatus}</a>
		                </span>
		                <span class="pull-right">
		                    <a data-toggle="modal" href="login.html#myModal">忘记密码 ？</a>
		                </span>
		            </label>
		            <button class="btn btn-theme btn-block" type="submit">
		            	<i class="fa fa-lock"></i> 登&nbsp;&nbsp;录
		            </button>
		            <hr>
		            <div class="registration">
		             	  还没有帐号？<a href="${pageContext.request.contextPath}/login/registUI.html">创建一个</a>
		            </div>
		        </div>
		
		  		<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
		         	<div class="modal-dialog">
		              	<div class="modal-content">
		                    <div class="modal-header">
		                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                        <h4 class="modal-title">忘记密码 ？</h4>
		                    </div>
		                   	<div class="modal-body">
		                       	<p>请输入您注册帐号时填写的Email地址</p>
		                       	<input type="text" name="email" placeholder="电子邮件地址" autocomplete="off" class="form-control placeholder-no-fix">
		                  	</div>
		                  	<div class="modal-footer">
		                      	<button data-dismiss="modal" class="btn btn-default" type="button">取消</button>
		                      	<button data-dismiss="modal" class="btn btn-theme" type="button" id="forgetSubmit" >提交</button>
		                	</div>
		           		</div>
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
	$("#forgetSubmit").click(function(){
		$("#loginWarn").text("");
		$("#loginNotice").text("");
		var email = $("#loginForm input[name='email']").val();
		if(!isEmail(email)){
			$("#loginWarn").text("请填写正确的邮箱地址！");
			return;
		}
		$.post(
			"${pageContext.request.contextPath}/login/forget.json",
			{email: email},
			function (msg){
				if(msg.success){
					$("#loginNotice").text("重置密码邮件已发送至您的邮箱！");
				}else{
					$("#loginWarn").text(msg.message);
				}
			}
		);
	});
	function loginCheck() {
		$("#loginWarn").text("");
		$("#loginNotice").text("");
		var userName = $("#loginForm input[name='userName']").val();
		var password = $("#loginForm input[name='password']").val();
		if(isNull(userName)){
			$("#loginWarn").text("用户名不能为空！");
			return false;
		}
		if(isNull(password)){
			$("#loginWarn").text("密码不能为空！");
			return false;
		}
		return true;
	}
</script>
</html>
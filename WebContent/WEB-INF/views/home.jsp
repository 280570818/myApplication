<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>主页</title>
	<link href="${pageContext.request.contextPath}/staticResource/css/bootstrap.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="navbar navbar-default">
			<div class="navbar-header">
				<a class="navbar-brand" href="">主页</a>
				<button class="navbar-toggle" data-toggle="collapse" data-target="#shownav">
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span>
				</button>
			</div>
			<ul id="shownav" class="nav navbar-nav collapse navbar-collapse">
				<li><a href="">电影</a></li>
				<li><a href="">游戏</a></li>
				<li><a href="${pageContext.request.contextPath}/escape.html">退出</a></li>
				<li><a href="">小说</a></li>
				<li><a href="">小说</a></li>
				<li><a href="">小说</a></li>
				<li><a href="">小说</a></li>
				<li><a href="">小说</a></li>
				<li><a href="">小说</a></li>
				<li><a href="">小说</a></li>
				<li><a href="">小说</a></li>
				<li><a href="">小说</a></li>
				<li><a href="">音乐</a></li>
				<li>
					<a class="dropdown" data-toggle="dropdown">其他<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="">漫画</a></li>
						<li><a href="">软件</a></li>
						<li><a href="">视频</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
	<script src="${pageContext.request.contextPath}/staticResource/js/jquery.min.js" type="text/javascript" />
	<script src="${pageContext.request.contextPath}/staticResource/js/bootstrap.js" type="text/javascript"/>
</body>
</html>
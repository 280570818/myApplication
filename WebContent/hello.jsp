<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
	<title>主页</title>
</head>
<body style="background-color: #545454;">
 	<div class="container">
 		<br/>
		<nav class="navbar navbar-inverse">
            <div class="navbar-header">
			    <a class="navbar-brand" href="#">首页导航</a>
			</div>
			<!-- <div class="navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">Home</a></li>
                    <li><a href="#">Page One</a></li>
                    <li><a href="#">Page Two</a></li>
                </ul>
            </div> -->
        </nav>
        <div id="content" class="row-fluid">
			<div class="col-md-3">
		   		<h2>菜单栏</h2>  
			    <ul class="nav nav-tabs nav-stacked">
			        <li><a href='#'>菜单1</a></li>
			        <li><a href='#'>菜单2</a></li>
			        <li><a href='#'>菜单3</a></li>
			    </ul>    
		  	</div>
      		<div class="col-md-9">
          		<h2>Main Content Section</h2>
	      	</div>
		</div>
	</div>
</body>
</html>
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"/>
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"/>
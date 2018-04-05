<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>主页</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/staticResource/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/home/css/nav.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/home/fonts/iconfont.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/home/css/home.css">
</head>
<body>
	<div class="contentDiv">
		<div class="headerDiv">
			<table>
				<tr>
					<td id="headerTitle">swing科技技术有限公司</td>
					<td id="headerUserZone">
						<ul class="nav navbar-nav">
							<li class="dropdown">
								<a href="javascript:void(0);" id="userZone" class="dropdown-toggle" data-toggle="dropdown">
									&nbsp;
									<img alt="error" src="${pageContext.request.contextPath}/home/images/contact.png">
									个人中心
									<b class="caret"></b>
									&nbsp;&nbsp;&nbsp;
								</a>
								<ul class="dropdown-menu">
									<li><a href="#">完善个人资料</a></li>
									<li><a href="#">修改个人信息</a></li>
									<li><a href="#">修改密码</a></li>
									<li><a href="${pageContext.request.contextPath}/home/escape.html">退出登录</a></li>
								</ul>
							</li>
						</ul>
					</td>
				</tr>
			</table>
		</div>
		<div class="bodyDiv">
			<div class="tabbable">
				<ul class="nav nav-tabs" id="tabParent">
					<li id="tab_f" class="active">
						<a href="#panel-f" data-toggle="tab">首页</a>
					</li>
					<li id="tab_s" onmouseover="showCloseImg('closeImg-s');" onmouseout="hideCloseImg('closeImg-s');">
						<a href="#panel-s" data-toggle="tab">第二页</a>
						<span class="tabCloseIcon" onclick="closeTab(this);" data="s" id="closeImg-s"></span>
					</li>
				</ul>
				<div class="tab-content" id="contentParent">
					<div class="tab-pane active" id="panel-f">
						123
					</div>
					<div class="tab-pane " id="panel-s">
						<p>
							第二页内容.
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 左侧菜单部分 -->
	<div class="nav">
		<div class="nav-top">
		    <div id="mini" style="border-bottom:1px solid rgba(255,255,255,.1)">
		    	<img src="${pageContext.request.contextPath}/home/images/mini.png" >
		    </div>
		</div>
        <ul>
        	<c:forEach items="${menus}" var="menu">
	            <li class="nav-item">
	                <a href="javascript:void(0);">
	                	<i class="my-icon nav-icon icon_1"></i>
	                	<span>${menu.name}</span>
	                	<i class="my-icon nav-more"></i>
	                </a>
	                <ul>
	                	<c:forEach items="${menu.children}" var="m">
	                    	<li><a href="javascript:openTab('${pageContext.request.contextPath}${m.url }','${m.name}','${m.id}');">
	                    		<span>${m.name}</span>
	                    	</a></li>
	                	</c:forEach>
	                </ul>
	            </li>
			</c:forEach>
        </ul>
	</div>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/home/js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/home/js/home.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
</body>
</html>
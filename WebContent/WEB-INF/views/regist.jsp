<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/save.html"
		method="post">
		name:<input type="text" name="name" /><br /> age:<input type="text"
			name="age" /><br /> cid:<input type="text" name="cid" /><br /> <input
			type="submit" value="regist" />
	</form>
</body>
</html>
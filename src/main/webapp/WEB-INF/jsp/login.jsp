<%@ page language="java" contentType="text/html; charset=utf-8"pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录页面</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/doLogin" method="post">
	          用户名:<input type="text" name="userName"/><br/>
	          密码:<input type="password" name="password"/><br/>
	     <input type="submit" value="登录"> ${error}
    </form>
</body>
</html>
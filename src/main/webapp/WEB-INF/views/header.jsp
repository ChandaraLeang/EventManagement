<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="resources/css/header.css" rel="stylesheet" type="text/css" />

</head>
<body>
	<div class="header">
	</div>
	<div>
		<c:if test="${!empty user}">
			<a id="lnkLogout" href="logout" class="actionButton">Logout</a>
		</c:if>

		<c:if test="${empty user}">
			<a id="lnkLogin" href="login" class="actionButton">LogIn</a>
		</c:if>
		
	</div>
	<div class="userInfo">
		<h1>Welcome ${user.userName}</h1>
		<h2>${message}</h2>
	</div>
</body>
</html>
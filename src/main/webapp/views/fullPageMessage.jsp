<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link href="resources/css/style.css" rel="stylesheet" type="text/css" />
<title>Hello!!</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="viewport">
		<div class="fullPageMessage">
			<p>
			<c:out value="${fullPageMessage}" /> <a href="home">  Happy Day.</a>
			</p>
		</div>
	</div>

</body>
</html>
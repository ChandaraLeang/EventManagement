<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link href="resources/css/style.css" rel="stylesheet" type="text/css" />
<title>Upcoming Events</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="viewport">
		<div class="fullPageMessage">
			<h1>Upcoming Event List</h1>
			<div>
				<c:forEach var="event" items="${events}">
					<a href="upcomingEventDetail/${event.id}">
						<span>Title: ${event.name}</span><br>
						<span>Start Date: ${event.startDate}</span><br>
						<span>End Date: ${event.endDate}</span><br>
						<span>Facility: ${event.facility.name}</span><br>
						<span>No of People: ${event.noOfPeople}</span><br>
						<span>Category: ${event.category.name}</span>
					</a>
					<br><br>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>
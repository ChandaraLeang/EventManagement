<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">


<title>Upcoming Event Detail</title>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h1>Event Detail</h1>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Please Enter Details</h3>
					</div>
					<div class="panel-body">
						<table class="table table-responsive">
						<thead>
							<tr>
								<th>Name</th>
								<th>Start Date</th>
								<th>End Date</th>
								<th>Facility</th>
								<th>Number of People</th>
								<th>Category</th>
							</tr>
						</thead>
						
							<tr>
								<td>${event.name}</td>
								<td>${event.startDate}</td>
								<td>${event.endDate}</td>
								<td>${event.facility.name}</td>
								<td>${event.noOfPeople}</td>
								<td>${event.category.name}</td>
							</tr>
						<tr>
							<td>
								<span class="pull-right"> <a href="addComment"
									class="btn btn-info"> Add Comment</a>
								</span>
							</td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							
						</tr>
					</table>
					
					<h2>Comments</h2>
					
					<table class="table table-responsive">
						<thead>
							<tr>
								<th>Description</th>
								<th>Rating</th>
								<th>Date</th>
							</tr>
						</thead>
						<c:forEach var="comment" items="${comments}">
							<tr>
								<td>${comment.description}</td>
								<td>${comment.rating}</td>
								<td>${comment.commentDate}</td>
							</tr>
						</c:forEach>
					</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
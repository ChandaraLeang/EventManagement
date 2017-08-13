<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">

<title>Buildings</title>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h1 style="display: inline;">Building List</h1>
				<span class="pull-right"> <a href="addBuilding"
					class="btn btn-info"> Add Building</a>
				</span>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="panel panel-default">
				<div class="panel-body">

					<table class="table table-responsive">
						<thead>
							<tr>
								<th>Building code</th>
								<th>Name</th>
								<th>Type</th>
								<th>Description</th>
							</tr>
						</thead>
						<c:forEach var="building" items="${buildings}">
							<tr>
								<td>${building.code}</td>
								<td>${building.name}</td>
								<td>${building.type}</td>
								<td>${building.description}</td>
								<td><a href="buildings/${building.id}"
									class="btn btn-primary">Edit</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
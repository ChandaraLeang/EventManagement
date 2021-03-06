<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">


<title>Building Detail</title>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h1>Building Detail</h1>
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
						<form:form action="../buildings/${building.id}" method="post"
							modelAttribute="building">

							<div class="form-group">
								<label><span>Code:</span> <form:input path="code"
										cssClass="form-control" /></label>
							</div>
							<div class="form-group">
								<label><span>Name:</span> <form:input path="name"
										cssClass="form-control" /></label>
							</div>
							<div class="form-group">
								<label><span>Type:</span> <form:select path="type"
										cssClass="form-control">
										<form:option value="${type}"></form:option>
										<form:options items="${buildingTypes}" />
									</form:select> </label>
							</div>
							<div class="form-group">
								<label><span>Description:</span> <form:input
										path="description" cssClass="form-control" /></label>
							</div>
							<c:if test="${building.id!=0}">
								<input type="submit" value="Update" class="btn btn-primary" />
							</c:if>
							<c:if test="${building.id==0}">
								<input type="submit" value="Save" class="btn btn-primary" />
							</c:if>
							<a class="btn btn-primary" href="/buildings">Back to List</a>
							<c:if test="${building.id!=0}">
								<button form="bldDelete" type="submit" class="btn btn-warning">Delete</button>
							</c:if>
						</form:form>

						<form id="bldDelete" action="/buildings/${building.id}" method="delete"></form>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">

<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="resources/bootstrap/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">

<title>Event Detail</title>
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
						<form:form action="../events/${event.id}" method="post"
							modelAttribute="event">

							<div class="form-group">
								<label><span>Name:</span> <form:input path="name"
										cssClass="form-control" /></label>
							</div>
							
							<div class="form-group">
								<label><span>Start Date:</span> <form:input path="startDate" id="startDate" cssClass="form-control" /></label>
							</div>
							
							<div class="form-group">
								<label><span>End Date:</span> <form:input path="endDate" id="endDate" cssClass="form-control" /></label>
							</div>
							
							<div class="form-group">
								<label><span>Facility:</span> 
								<form:select path="facility" cssClass="form-control">
										<form:option value="-1" label="--Please Select"/>
      									<form:options items="${facilities}" itemValue="id" itemLabel="name"/>
									</form:select> </label>
							</div>
							
							<div class="form-group">
								<label><span>Number of People:</span> <form:input path="noOfPeople"
										cssClass="form-control" /></label>
							</div>
							
							<div class="form-group">
								<label><span>Category:</span> 
								<form:select path="category" cssClass="form-control">
										<form:option value="-1" label="--Please Select"/>
      									<form:options items="${categories}" itemValue="id" itemLabel="name"/>
									</form:select> </label>
							</div>
							
							<div class="form-group">
								<label><span>Status:</span>
								<form:checkbox path="status" cssClass="form-control" checked="checked" />
								</label>
							</div>
							
							<c:if test="${event.id!=0}">
								<input type="submit" value="Update" class="btn btn-primary" />
							</c:if>
							<c:if test="${event.id==0}">
								<input type="submit" value="Save" class="btn btn-primary" />
							</c:if>
							<a class="btn btn-primary" href="/events">Back to List</a>
							<c:if test="${event.id!=0}">
								<button form="bldDelete" type="submit" class="btn btn-warning">Delete</button>
							</c:if>
						</form:form>

						<form:form id="bldDelete" action="/events/delete/${event.id}" method="post" modelAttribute="event"></form:form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="resources/jquery/jquery-1.8.3.min.js" charset="UTF-8"></script>
	<script type="text/javascript" src="resources/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
	<script type="text/javascript" src="resources/js/locales/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
	<script type="text/javascript">
		 $('#startDate').datetimepicker({
        	weekStart: 1,
        	todayBtn:  1,
			autoclose: 1,
			todayHighlight: 1,
			startView: 2,
			forceParse: 0,
        	showMeridian: 1
    	});
		
		$('#endDate').datetimepicker({
        	weekStart: 1,
        	todayBtn:  1,
			autoclose: 1,
			todayHighlight: 1,
			startView: 2,
			forceParse: 0,
        	showMeridian: 1
    	}); 
	</script>
</body>
</html>
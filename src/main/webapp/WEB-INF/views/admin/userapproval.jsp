<%@ include file="/resources/common/header.jspf"%>
<%@ include file="/resources/common/navigation.jspf"%>
<div class="container">

	<spring:url value="/admin/approval/" var="saveApproval" />

	<form:form modelAttribute="approvalForm" method="POST" action="${saveApproval}">
		
		<table class="table table-striped">
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email(s)</th>
				<th align="right"></th>
			</tr>
			 
			<c:forEach items="${userList}" var="users">
				<tr>
					<td width="150px">${users.name}</td>
					<td width="150px">${users.lastName}</td>
					<td width="40px">${users.email}</td>
					<td align="right">
						<spring:url value="/admin/userapprove?id=${users.id}" var="userApprove" />
						<a type="button" class="btn btn-primary" href="${userApprove}">Approve</a>
						<spring:url value="/admin/notapprove?id=${users.id}" var="notApproved" />
						<a type="button" class="btn btn-large btn-primary btn-warning" href="${notApproved}">Not Approve</a>
							
							<%-- <div id="myModal_${users.id}" class="modal fade">
							    <div class="modal-dialog">
							        <div class="modal-content">
							            <div class="modal-header">
							                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							                <h4 class="modal-title">Confirm</h4>
							            </div>
							
							            <div class="modal-body">
							                <p>Are you sure you want to approve this Applicant? </p>
							            </div>
							            <div class="modal-footer">
											<spring:url value="/admin/notapprove?id=${users.id}" var="notApproved" />
							                <button type="button" class="btn btn-primary" data-dismiss="modal">Cane</button>
							                <a type="button" class="btn btn-warning" href="${notApproved}" title="Delete"><i class="fa fa-trash-o"></i>Not approve</a>
							            </div>
							        </div>
							    </div>
							</div> 
							
							
						<a href="#myModal_${users.id}" role="button" class="btn btn-large btn-primary btn-warning" data-toggle="modal">Not approve</a>
 --%>

					</td>
				</tr>
			</c:forEach>
			
		</table>
	</form:form>
 
	
</div>
<script type="text/javascript">
	function myFunc() {
    var  selectedValue= $("#categoryId").val();
    alert(selectedValue);
   }
</script>

<%@ include file="/resources/common/footer.jspf"%>

<script>
$(document).ready(function () {
    var url = window.location;
    $('ul.nav > li').removeClass('active');
    $('ul.nav a[href="'+ url +'"]').parent().addClass('active');
    $('ul.nav a').filter(function() {
         return this.href == url;
    }).parent().addClass('active');
});
</script>
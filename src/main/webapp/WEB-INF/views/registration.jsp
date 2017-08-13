<%@ include file="/resources/common/header.jspf"%>
<div align = "center" class="container" style="margin:10% auto; 
	padding: 25 25; width:400px; border-radius: 25px;
	border:2px solid #73AD21">
<div><h1>User Registration</h1></div>
	<div class="alert-danger">
		<form:errors path="user.*"></form:errors>
	</div>
	
	<spring:url value="/registration/" var="saveRegistration" />
	
	<form:form modelAttribute="RegistrationForm" method="POST" action="${saveRegistration}">
		<f:hidden path="id" />
		<table>
			<tr>
				<td><label>Email Address :</label></td>
				<td style="width: 200px;padding:10px">
					<f:input path="email"  />
				</td>	
			</tr>
			<tr>
				<td><label>First Name :</label></td>
				<td style="width: 200px;padding:10px">
					<f:input path="name"  />
				</td>				
			</tr>	
			<tr>
				<td><label>Last Name :</label></td>
				<td style="width: 200px;padding:10px">
					<f:input path="lastName"  />
				</td>				
			</tr>		
			<tr>
				<td><label>Password :</label></td>
				<td style="padding:10px;">
					<f:input path="password"/>
       			</td>		
			</tr>	
			<tr>
				<td><label>Verify Password</label> </td>
				<td>
					<div>
						<input type="password" class="style-4" name="verifypassword"
							placeholder="Password" />
					</div>
				</td>
			</tr>
			<tr>		
					
			</tr>			
			<tr>
				<td><button type="submit" class="btn btn-success">Save</button></td>
			</tr>
		</table>
	</form:form>

	

</div>
<%@ include file="/resources/common/footer.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!doctype html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/admin-sidebar.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/fonts/base.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/viewemployees.css">
<title>Employees Details</title>
<script>
	function employeeDeletionConfirmation(){
  		var x = confirm("Once you delete this employee, all of it's data will be permanently removed.");
  		if (x)
      		return true;
  		else
    		return false;
}
</script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/admin/adminSidebar.jsp"></jsp:include>
	<div style="margin-left: 16%">
		<div class="w3-container">
			<h3 id="dashboard-heading">Employee Details</h3>
		<div>
			<div style="float:left;">
				<a href="/app/admdashboard/employee/add"><button id="register-new-emp">Register New Employee</button></a>
			</div>
		</div>
		<div>
		<c:if test="${!empty listEmployees}">
			<table width="100%" class="table table-sm" style="margin-top: 60px;">
					<tr>
						<th width="50">EID</th>
						<th width="90">FIRSTNAME</th>
						<th width="90">LASTNAME</th>
						<th width="140">EMAIL</th>
						<th width="90">DOB</th>
						<th width="60">GENDER</th>
						<th width="140">ADDRESS</th>
						<th width="70">CITY</th>
						<th width="60">UPDATE</th>
						<th width="60">DELETE</th>
						<th width="60">MAILING</th>
					</tr>
					<c:forEach items="${listEmployees}" var="employee">
					<tr>
						<td>${employee.eid}</td>
						<td>${employee.firstname}</td>
						<td>${employee.lastname}</td>
						<td>${employee.email}</td>
						<td>${employee.dob}</td>
						<td>${employee.gender}</td>
						<td>${employee.address}</td>
						<td>${employee.city}</td>
						<td><a id="edit" href="<c:url value='/admdashboard/employee/edit/${employee.eid}' />"><i class="fa fa-edit" style="font-size:22px;"></i></a></td>
						<td><a id="remove" onclick="return employeeDeletionConfirmation()" href="<c:url value='/admdashboard/employee/delete/${employee.eid}' />"><i class="fa fa-trash" style="font-size:22px;"></i></a></td>
						<td><a id="mail" href="<c:url value='/admdashboard/employee/email/${employee.eid}' />"><i class="fa fa-envelope" style="font-size:22px;"></i></a></td>
					</tr>
					</c:forEach>
				</table>
			</c:if>
			</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
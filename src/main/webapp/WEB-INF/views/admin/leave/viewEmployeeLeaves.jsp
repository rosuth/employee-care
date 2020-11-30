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
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/employeeleaves.css">
<title>Pending Employee Leaves</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/admin/adminsidebar.jsp"></jsp:include>
	<div style="margin-left: 16%">
		<div class="w3-container">
			<h3 id="topbar-heading">Pending Employee Leaves</h3>
		<div>
		<div>
		<c:if test="${!empty listEmployeesLeaves}">
	<table width="100%" class="table table-sm" style="margin-top:30px;">
	<tr>
		<th width="60">Leave ID</th>
		<th width="60">EID</th>
 		<th width="90">Leave Type</th>
		<th width="90">Full Name</th>
		<th width="90">Leave Start</th>
		<th width="90">Leave End</th>
		<th width="40">Days</th>
		<th width="200">Reason</th>
      	<th width="50">Approve</th>
        <th width="50">Reject</th>
	</tr>
	<c:forEach items="${listEmployeesLeaves}" var="employeeLeave">
	<tr>
		<td>${employeeLeave.lid}</td>
		<td>${employeeLeave.eid}</td>
 		<td>${employeeLeave.leave_type}</td>
		<td>${employeeLeave.fullname}</td>
		<td>${employeeLeave.leave_start}</td>
		<td>${employeeLeave.leave_end}</td>
		<td>${employeeLeave.days}</td>
		<td>${employeeLeave.reason}</td>
	    <td><a href="<c:url value='/approveleave/${employeeLeave.lid}' />" ><span style='font-size:20px; color:green;'>&#10004;</span></a></td>
	    <td><a href="<c:url value='/rejectleave/${employeeLeave.lid}' />" ><span style='font-size:20px; color:red;'>&#10008;</span></a></td>
	</tr>
	</c:forEach>
	</table>
	</c:if>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>

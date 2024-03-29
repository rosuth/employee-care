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
	<jsp:include page="/WEB-INF/views/common/admin/adminSidebar.jsp"></jsp:include>
	<div style="margin-left: 16%">
		<div class="w3-container">
			<h3 id="dashboard-heading">Pending Employee Leaves</h3>
		<div>
		<div>
		<c:if test="${!empty listEmployeesLeaves}">
	<table width="100%" class="table table-sm" style="margin-top:30px;">
	<tr>
		<th width="60">LID</th>
		<th width="60">EID</th>
 		<th width="90">LEAVE TYPE</th>
		<th width="90">FULLNAME</th>
		<th width="90">LEAVE START</th>
		<th width="90">LEAVE END</th>
		<th width="40">DAYS</th>
		<th width="200">REASON</th>
      	<th width="50">APPROVE</th>
        <th width="50">REJECT</th>
	</tr>
	<c:forEach items="${listEmployeesLeaves}" var="employeeLeave">
	<tr>
		<td>${employeeLeave.id}</td>
		<td>${employeeLeave.id}</td>
 		<td>${employeeLeave.leave_type}</td>
		<td>${employeeLeave.fullname}</td>
		<td>${employeeLeave.leave_start}</td>
		<td>${employeeLeave.leave_end}</td>
		<td>${employeeLeave.days}</td>
		<td>${employeeLeave.reason}</td>
	    <td><a href="<c:url value='/admdashboard/employeeleave/approve/${employeeLeave.id}' />" ><i class="fa fa-check" style="font-size:22px;"></i></a></td>
	    <td><a href="<c:url value='/admdashboard/employeeleave/reject/${employeeLeave.id}' />" ><i class="fa fa-close" style="font-size:22px;"></i></a></td>
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

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
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/employee/employee-sidebar.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/fonts/base.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/findemployee.css">
<title>Find Employee</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/employee/employeeSidebar.jsp"></jsp:include>
	<div style="margin-left: 16%">
		<div class="w3-container">
			<h3 id="dashboard-heading">Find Employee</h3>
		<div>
				<div>
					<c:url var="addAction" value="/empdashboard/myprofile"></c:url>
					<form:form action="${addAction}" modelAttribute="employee" method="POST">
					<label>Enter EID</label><input type="number" name="eid" required="true">
						<br />
						<input id="submit-button" type="submit" value="Submit">
					</form:form>
				</div>
	</div> 
				<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>


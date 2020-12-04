<!doctype html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/employee/employee-sidebar.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/fonts/base.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/employee/dashboard.css">
<title>Employee Care</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/employee/employeeSidebar.jsp"></jsp:include>
	<div style="margin-left: 16%">
		<div class="w3-container">
			<h3 id="dashboard-heading">Dashboard(Demo)</h3>
		</div>
		<div id="dashboard-body">
			<div id="top-boxes">
				<div class="tb" id="tb1"><h4>Boarded On</h4><h1>100</h1></div>
				<div class="tb" id="tb2"><h4>Pending Leave Requests</h4><h1>40</h1></div>
				<div class="tb" id="tb3"><h4>Attendance</h4><h1>30</h1></div>
				<div class="tb" id="tb4"><h4>Total Projects</h4><h1>50%</h1></div>
			</div>
			<div id="bottom-boxes">
				<div class="bb" id="bb1"><h4>Pending Self Requests</h4><h1>100</h1></div>
				<div class="bb" id="bb2"><h4>Employee Code</h4><h1>40</h1></div>
				<div class="bb" id="bb3"><h4>Storage Used</h4><h1>30</h1></div>
				<div class="bb" id="bb4"><h4>Issues Raised</h4><h1>50%</h1></div>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
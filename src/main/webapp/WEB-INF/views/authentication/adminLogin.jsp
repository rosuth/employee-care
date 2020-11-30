<!doctype html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/fonts/base.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/admin-login.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common/login-bg.css">
<title>Employee Care</title>
</head>
<body>
	<div id="parent-div">
		<jsp:include page="/WEB-INF/views/common/login/app-info.jsp"></jsp:include>
		<div id="right-div">
			<h2 id="login-header">Login to your account</h2>
			<form action="admindashboard" method="POST">
				<table style="margin-left: 81px;">
					<tr><td id="id-label"><label>Admin ID </label></td><td><input type="number" size="10" name="aid" required="true"></td></tr>
					<tr><td id="password-label"><label>Password </label></td><td><input type="password" size="10" name="password" required="true"></td></tr>
					<tr><td colspan="2"><input type="submit" id="admin-login-button" value="Admin Login"></td></tr>
				</table>
			</form>
			<h4 id="login-as-employee-button-header"><a id="login-as-employee-button" href="employeelogin">Own an Employee account? Login here</a></h4>
			<h4 id="login-trouble-header"><a id="login-trouble" href="accountrecovery">Can't logging into your account? Recover here</a></h4>
		</div>
	</div>
</body>
</html>
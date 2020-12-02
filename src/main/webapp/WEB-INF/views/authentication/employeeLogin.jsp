<!doctype html>
<head>
<meta charset="ISO-8859-1"> 
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/fonts/base.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common/login-bg.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/employee/employee-login.css">
<title>Employee Login</title>
</head>
<body>
	<div id="parent-div">
		<jsp:include page="/WEB-INF/views/common/login/app-info.jsp"></jsp:include>
		<div id="right-div">
			<h2 id="login-header">Login to your account</h2>
			<form action="/app/empdashboard" method="post">
				<table style="margin-left: 81px;">
					<tr>
						<td id="email-label"><label>Email </label></td>
						<td><input id="email" size="15" type="email" name="email"
							required="true"></td>
					</tr>
					<tr>
						<td id="password-label"><label>Password </label></td>
						<td><input size="15" type="password" name="password"
							required="true"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit"
							id="employee-login-button" value="Employee Login"></td>
					</tr>
				</table>
			</form>
			<h4 id="login-page-bottom-links"><a id="admin-login-link" href="/app/admlogin">Admin Login </a><a id="forgot-password-link" href="/app/forgotpassword"> Forgot Password</a></h4>
	</div>
</body>
</html>
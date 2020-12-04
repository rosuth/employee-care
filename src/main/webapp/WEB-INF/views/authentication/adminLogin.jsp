<!doctype html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/fonts/base.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/admin-login.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common/login-bg.css">
<title>Admin Login</title>
</head>
<body>
	<div id="parent-div">
		<jsp:include page="/WEB-INF/views/common/login/app-info.jsp"></jsp:include>
		<div id="right-div">
			<h2 id="login-header">Login to your account</h2>
			<form action="/app/admdashboard" method="POST">
				<table style="margin-left: 81px;">
					<tr>
						<td id="email-label"><label>Email </label></td>
						<td><input type="email" size="15" name="email"
							required="true"></td>
					</tr>
					<tr>
						<td id="password-label"><label>Password </label></td>
						<td><input type="password" size="15" name="password"
							required="true"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" id="admin-login-button"
							value="Admin Login"></td>
					</tr>
				</table>
			</form>
			<h4 id="login-page-bottom-links"><a id="employee-login-link" href="/app/emplogin">Employee Login </a></h4>
		</div>
	</div>
</body>
</html>
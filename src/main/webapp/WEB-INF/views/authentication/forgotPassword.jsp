<!doctype html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/fonts/base.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/admin-login.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common/login-bg.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common/accountrecovery.css">
<title>Forgot Password</title>
<script>
function systemAlert(){
	alert("Account recovery option is currently not working. Kindly wait for few days to get this feature back soon.");
}
function accountRecovery(){
	alert("You'll receive an email regarding the account information which you can use to login into your account. Kindly do not share this information with anyone else.")
}
</script>
</head>
<body">
	<div id="parent-div">
		<jsp:include page="/WEB-INF/views/common/login/app-info.jsp"></jsp:include>
		<div id="right-div">
			<h2 id="login-header">Recover Account</h2>
			<form action="/app/forgotpassword" method="POST" onsubmit="accountRecovery()">
				<table style="margin-left: 81px;">
					<tr>
						<td id="email-label"><label>Employee ID </label></td>
						<td><input type="number" size="15" name="eid" required="true"></td>
					</tr>
					<tr>
						<td id="firstname-label"><label>Firstname </label></td>
						<td><input type="text" size="15" name="firstname"
							required="true"></td>
					</tr>
					<tr>
						<td id="email-label"><label>Email </label></td>
						<td><input type="email" size="15" name="email"
							required="true"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit"
							id="forgot-password-button" value="Forgot Password"></td>
					</tr>
				</table>
			</form>
			<h4 id="login-page-bottom-links"><a id="admin-login-link" href="/app/admlogin">Admin Login</a><a id="employee-login-link" href="/app/emplogin">Employee Login</a></h4>
		</div>
	</div>
</body>
</html>
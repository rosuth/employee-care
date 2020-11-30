<!doctype html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/fonts/base.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/admin-login.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common/login-bg.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common/accountrecovery.css">
<title>Employee Care</title>
<script>
function systemAlert(){
	alert("Account recovery option is currently not working. Kindly wait for few days to get this feature back soon.");
}
function recoverSentAck(){
	alert("Your account information will be sent on your email.\nMake sure that your email account is accesible.")
}
</script>
</head>
<body onload="systemAlert()">
	<div id="parent-div">
		<jsp:include page="/WEB-INF/views/common/login/app-info.jsp"></jsp:include>
		<div id="right-div">
			<h2 id="login-header">Recover Account</h2>
			<form action="recoveraccount" method="POST" onsubmit="recoverSentAck()">
				<table style="margin-left: 81px;">
					<tr><td id="id-label"><label>Employee ID </label></td><td><input type="number" size="10" name="eid" required="true"></td></tr>
					<tr><td id="firstname-label"><label>Firstname </label></td><td><input type="text" size="10" name="firstname" required="true"></td></tr>
					<tr><td id="email-label"><label>Email </label></td><td><input type="email" size="10" name="email" required="true"></td></tr>
					<tr><td colspan="2"><input type="submit" id="recover-account-button" value="Recover Account"></td></tr>
				</table>
			</form>
			<h4 id="login-as-employee-button-header"><a id="login-as-employee-button" href="employeelogin">Own an Employee account? Login here</a></h4>
		</div>
	</div>
</body>
</html>
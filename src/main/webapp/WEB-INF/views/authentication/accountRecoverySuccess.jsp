<!doctype html>
<head>
<title>Employee Care</title>
<script>
function accountRecoverySuccess(){
	alert("Email has been sent on your registered email.\nKindly follow the steps given in the email to recover your account.");
	window.location.replace("/employeecare/");
}
</script>
</head>
<body onload="accountRecoverySuccess()">
</body>
</html>
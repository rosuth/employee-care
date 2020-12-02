<!doctype html>
<head>
<title>Forgot Password Email Failed</title>
<script>
function forgotPasswordFailedAlert(){
	alert("The information that you have provided doesn't match to any Employee.\nMake sure that you enter correct details or else contact system admin.");
	window.location.replace("/app/forgotpassword");
}
</script>
</head>
<body onload="forgotPasswordFailedAlert()">
</body>
</html>
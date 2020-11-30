<!doctype html>
<head>
<title>Employee Care</title>
<script>
function accountRecoveryFail(){
	alert("The information that you have provided doesn't match to any Employee.\nMake sure that you enter correct details or else contact system admin.");
	window.location.replace("/employeecare/accountrecovery");
}
</script>
</head>
<body onload="accountRecoveryFail()">
</body>
</html>
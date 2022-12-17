<!doctype html>
<head>
<title>Admin Login Error</title>
<script>
	function adminNotFoundAlert() {
		alert("You've entered incorrect email/password. Please login with correct credentials.");
		window.location.replace("/app/admlogin");
	}
</script>
</head>
<body onload="adminNotFoundAlert()">
</body>
</html>
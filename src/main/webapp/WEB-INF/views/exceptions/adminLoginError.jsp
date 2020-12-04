<!doctype html>
<head>
<title>Admin Login Error</title>
<script>
	function adminNotFoundAlert() {
		alert("Are you sure, you own an Admin account?");
		window.location.replace("/app/admlogin");
	}
</script>
</head>
<body onload="adminNotFoundAlert()">
</body>
</html>
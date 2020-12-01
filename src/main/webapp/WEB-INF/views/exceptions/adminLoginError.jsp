<!doctype html>
<head>
<title>Employee Care</title>
<script>
function adminNotFound(){
	alert("Are you sure, you own an Admin account?");
	window.location.replace("/app/adminlogin");
}
</script>
</head>
<body onload="adminNotFound()">
</body>
</html>
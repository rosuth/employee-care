<!doctype html>
<head>
<title>Employee Profile</title>
<script>
function profileNotFound(){
	alert("Employee Not Found. Redirecting to Dashboard");
	window.location.replace("/app/admdashboard");
}
</script>
</head>
<body onload="profileNotFound()">
</body>
</html>

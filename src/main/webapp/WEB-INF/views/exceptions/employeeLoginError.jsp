<!doctype html>
<head>
<title>Employee Care</title>
<script>
function employeeNotFound(){
	debugger
	alert("No Employee Record Found. \nMake sure you enter correct credentials");
	window.location.replace("/employeecare");
}
</script>
</head>
<body onload="employeeNotFound()">
</body>
</html>

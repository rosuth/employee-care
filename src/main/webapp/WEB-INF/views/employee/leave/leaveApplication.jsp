<!doctype html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/employee/employee-sidebar.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/fonts/base.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/employee/attendance.css">
<title>Apply Leave</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/employee/employeeSidebar.jsp"></jsp:include>
	<div style="margin-left: 16%">

<div class="w3-container">
  <h3>Apply Leave</h3>
</div>

<div style="margin-left:10px; margin-top:10px;">

<form method="post" action="leaveapplication">
Leave Type : <select name="leave_type">
<option value="Casual Leave">Casual Leave</option>
<option value="Medical Leave">Medical Leave</option>
<option value="Vacation Leave">Vacation Leave</option>
</select>

<table>
<tr>
<td>Emp ID : </td><td><input type="number" name="eid" required></td>

</tr>

<tr>
<td>Enter Full Name : </td><td><input type="text" name="fullname" required></td></tr>
<tr>
<td>Leave Start Date (DD/MM/YYYY) : </td><td><input type="text" name="leave_start" required></td></tr>
<tr>
<td>Leave End Date (DD/MM/YYYY) : </td><td><input type="text" name="leave_end" required></td></tr>
<tr>
<td>Total Days : </td><td><input type="number" name="days" required></td>
</tr>
<tr>
<td>Your Email : </td><td><input type="text" name="email" required></td>
</tr>
<tr>
<td>Reason : </td><td><textarea name="reason" rows="5" cols="50" required></textarea></td></tr>
</table>

<input type="submit" value="Apply for Leave">
</form>
</div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>



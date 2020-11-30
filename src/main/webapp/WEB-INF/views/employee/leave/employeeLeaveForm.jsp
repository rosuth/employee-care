<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

   
    <title>Hello, world!</title>
    <style>
     .w3-bar-item{
    font-size:16px;
    font-family:helvetica;
    font-weight:bold;
    margin-top:20px;
    }
    .w3-button{
    font-size:15px;
    font-family:helvetica;
    color:white;
    text-decoration:none;
    margin-top:1px;
    }
    .w3-button:hover{
    background-color:grey;
    font-size:15px;
    font-family:helvetica;
    text-decoration:none;
    }
    .w3-sidebar{
     background-color:#303331;
     color:white;
    }
    h3{
    font-family:helvetica;
    font-size:22px;
    font-weight:bold;
    margin-top:20px;
    border-bottom:2px solid black;
    margin:0px;
    margin-right:-20px;
    margin-left:-20px;
    padding-left:20px;
    padding-top:10px;
    padding-bottom:10px;
    
    }
    </style>
  </head>
  <body>
 <!--  
<nav class="navbar navbar-expand-lg">
  <a class="navbar-brand" href="#">Employee Management</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="homepage">Home<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="persons">View Employees</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Pricing</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
      </li>
    </ul>
  </div>
</nav>
 -->


<!-- Sidebar -->
<div class="w3-sidebar w3-bar-block" style="width:15%">
  <a href="employeeProfile" class="w3-bar-item w3-button">View My Profile</a>
  <a href="homepage" class="w3-bar-item w3-button">Logout</a>
</div>

<!-- Page Content -->
<div style="margin-left:15%">

<div class="w3-container">
  <h3>Employee Management</h3>
</div>

<div style="margin-left:10px; margin-top:10px;">

<form method="post" action="leave_applied">
Leave Type : <select name="leave_type">
<option value="Casual Leave">Casual Leave</option>
<option value="Medical Leave">Medical Leave</option>
<option value="Maternity Leave">Maternity Leave</option>
<option value="Vacation Leave">Vacation Leave</option>
</select>

<table>
<tr>
<td>Emp ID : </td><td><input type="text" name="eid"></td>

</tr>

<tr>
<td>Enter Full Name : </td><td><input type="text" name="fullname"></td></tr>
<tr>
<td>Leave Start Date (DD/MM/YYYY) : </td><td><input type="text" name="leave_start"></td></tr>
<tr>
<td>Leave End Date (DD/MM/YYYY) : </td><td><input type="text" name="leave_end"></td></tr>
<tr>
<td>Total Days : </td><td><input type="text" name="days"></td>
</tr>
<tr>
<td>Your Email : </td><td><input type="text" name="email"></td>
</tr>
<tr>
<td>Reason : </td><td><textarea name="reason" rows="5" cols="50"></textarea></td></tr>
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

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
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
    input{
    margin-top:10px;
    }
    </style>
  </head>
  <body>


<!-- Sidebar -->
<div class="w3-sidebar w3-bar-block" style="width:15%">
<!--   <h4 class="w3-bar-item">Manage Employees</h4>
 -->    <a href="goHome" class="w3-bar-item w3-button">Dashboard</a>
  <a href="persons" class="w3-bar-item w3-button">View Employees</a>
 <!--  <a href="viewEmpProfile" class="w3-bar-item w3-button">Find Employee</a>
  <a href="homepage" class="w3-bar-item w3-button">Logout</a> -->
</div>

<!-- Page Content -->
<div style="margin-left:15%">

<div class="w3-container">
  <h3>Employee Management</h3>
  
  <div>

<div style="margin-top:20px;" style="float:left;">

<h6>Email Sent Successfully!</h6>
  
</div>




    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>

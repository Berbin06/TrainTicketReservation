<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Admin home</title>
</head>
    <style>
    body{
    background: url(Assests/adminhome.jpg);
    background-size: cover;
    filter: blur();
    
}
  #logo{
    width: 105px;
    position: absolute;
    left: 0px;
    top: -41px;
    margin-left: -20px;
}
   /*     *{
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: Arial, Helvetica, sans-serif;
        }
        #adminhome{
            border: 1px solid black;
            height: 85px;
            background-color:  rgb(238, 241, 241);
           
        }
        #adminhome ul li {
            list-style: none;
            display: inline-block;
            padding: 30px;
            padding-left: 170px;
            }
        a{
            text-decoration: none;
        } */
    </style>
</head>
<body>
    <!-- <div id="adminhome">
        <ul>
            <li><a href="AdminHome.jsp">Home</a></li>
            <li><a href="AddTrain.jsp">Add Train</a></li>            
            <li><a href="TrainList.jsp">Train list</a></li>            
            <li><a href="UserList.jsp">User list</a></li>
           <li><a href="BookingListforAdmin.jsp">Booking list</a></li>
          <li><a href="login.jsp">Logout</a></li>
           
        </ul>
    </div> -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" id="logo" href="Assests/trainlogo.png"></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="AdminHome.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="AddTrain.jsp">Add Train</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="TrainList.jsp">Train List</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="UserList.jsp">User List</a>
        </li>
         <li class="nav-item">
          <a class="nav-link" href="BookingListforAdmin.jsp">Booking list</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="login.jsp">LogOut</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
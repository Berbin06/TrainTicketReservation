<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
    <style>
    body{
    background: url(https://media.istockphoto.com/photos/india-maharashtra-prospective-image-of-two-indian-train-with-rail-picture-id1194091335?k=20&m=1194091335&s=612x612&w=0&h=78_5uNES-C7z6eQoG0d-AkF9_9HX7GHyeJ420jaTk4w=);
    background-size: cover;
    filter: blur();
    
}
       *{
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
        }
    </style>
</head>
<body>
    <div id="adminhome">
        <ul>
            <li><a href="AdminHome.jsp">Home</a></li>
            <li><a href="AddTrain.jsp">Add Train</a></li>            
            <li><a href="TrainList.jsp">Train list</a></li>            
            <li><a href="UserList.jsp">User list</a></li>
           <li><a href="BookingListforAdmin.jsp">Booking list</a></li>
          <li><a href="login.jsp">Logout</a></li>
           
        </ul>
    </div>
</body>
</html>
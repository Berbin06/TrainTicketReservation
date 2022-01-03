<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="in.berbin.model.Users"%>
    <%@page import="java.util.*"%>
            <%@page import="in.berbin.daoimpl.UserDaoImpl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
    <style>
       *{
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: Arial, Helvetica, sans-serif;
        }
        #userlist{
            border: 1px solid black;
            height: 85px;
            background-color:  rgb(238, 241, 241);
           
        }
        #userlist ul li {
            list-style: none;
            display: inline-block;
            padding: 30px;
            padding-left: 170px;
            }
        a{
            text-decoration: none;
        }
           #allusers table,th,tr,td{
        border: 1px solid black;
        border-collapse: collapse;
        padding: 5px;
        }
    </style>
</head>
<body>
    <div id="userlist">
        <ul>
            <li><a href="AdminHome.jsp">Profile</a></li>
            <li><a href="AddTrain.jsp">Add Train</a></li>            
            <li><a href="TrainList.jsp">Train list</a></li>            
            <li><a href="UserList.jsp">User list</a></li>
            <li><a href="BookingList.jsp">Booking list</a></li>
        </ul>
    </div>
           <% UserDaoImpl userDao = new UserDaoImpl();
           List<Users> userList = new ArrayList<Users>();
           userList = userDao.showAllUsers();%>
           
           <table border="2" id="allusers">
<h1><b>Users List</b></h1>
<thead>
<tr>
<th>No</th>
 <th >User ID</th>
<th>User Name</th>
<th>User DOB</th>
<th>User Email</th>
<th>User MobileNO</th>
<th>User Gender</th>
<th>User Password</th>
<th>User Wallet</th>
</tr>
</thead>
<br>
<br>
<tbody>
<%
int i = 0;
for (Users showUsers : userList) {
i++;
%>
<tr>
<td><%=i%></td>
<td><%=showUsers.getUserId()%></td>
<td><%= showUsers.getUserName()%></td>
<td><%=showUsers.getUserDob()%></td>
<td> <%=showUsers.getUserEmail()%></td>
<td> <%=showUsers.getUserMobileNumber()%></td>
<td> <%=showUsers.getUserGender()%></td>
<td> <%=showUsers.getUserPassword()%></td>
<td> <%=showUsers.getUserwallet()%></td>

</tr>
<%
}
%>
</tbody>
</table>    
</body>
</html>
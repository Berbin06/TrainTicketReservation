<%@page import="java.time.format.DateTimeFormatter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import="in.berbin.model.Trains"%>
    <%@page import="java.util.*"%>
            <%@page import="in.berbin.daoimpl.TrainDaoImpl"%>
           <%  DateTimeFormatter formatter =
     DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");%>
            
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Train List</title>
</head>
    <style>
       *{
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: Arial, Helvetica, sans-serif;
        }
        #trainlist{
            border: 1px solid black;
            height: 85px;
            background-color:  rgb(238, 241, 241);
           
        }
        #trainlist ul li {
            list-style: none;
            display: inline-block;
            padding: 30px;
            padding-left: 170px;
            }
        a{
            text-decoration: none;
        }
        #alltrains table,th,tr,td{
        border: 1px solid black;
        border-collapse: collapse;
        padding: 5px;
        }
    </style>
</head>
<body>

    <div id="trainlist">
        <ul>
            <li><a href="AdminHome.jsp">Profile</a></li>
            <li><a href="AddTrain.jsp">Add Train</a></li>            
            <li><a href="TrainList.jsp">Train list</a></li>            
            <li><a href="UserList.jsp">User list</a></li>
            <li><a href="BookingList.jsp">Booking list</a></li>
        </ul>
    </div>
        <% TrainDaoImpl trainDao = new TrainDaoImpl();
    List<Trains> trainList = new ArrayList<Trains>();
    trainList = trainDao.showAllTrains();%>


<table border="2" id="alltrains">
<h1><b>Train List</b></h1>
<thead>
<tr>
<th>No</th>
 <th >Train ID</th>
<th>Train Name</th>
<th>Train Class</th>
<th>Train Number</th>
<th>Train Source</th>
<th>Train Destination</th>
<th>Departure time</th>
<th>Arrival Time</th>
<th>Total Seat</th>
<th>Ticket Price</th>
</tr>
</thead>
<br>
<br>
<tbody>
<%
int i = 0;
for (Trains showTrain : trainList) {
i++;
%>
<tr>
<td><%=i%></td>
<td><%=showTrain.getTrainId()%></td>
<td><%= showTrain.getTrainName()%></td>
<td><%=showTrain.getTrainClass()%></td>
<td> <%=showTrain.getTrainNumber()%></td>
<td> <%=showTrain.getTrainSource()%></td>
<td> <%=showTrain.getTrainDestination()%></td>
<td> <%=showTrain.getTrainDepartureTime().format(formatter)%></td>
<td> <%=showTrain.getTrainArraivalTime().format(formatter)%></td>
<td> <%=showTrain.getTotalseat()%></td>
<td> <%=showTrain.getTicketPrice()%></td>
<td><a href="updateTrain.jsp?TrainName=<%=showTrain.getTrainName()%> &TrainClass=<%=showTrain.getTrainClass()%>&Departuretrain=
<%=showTrain.getTrainDepartureTime()%>&TrainNumber=<%=showTrain.getTrainNumber()%>&Arrival=<%= showTrain.getTrainArraivalTime()%>&source=<%=showTrain.getTrainSource() %>
&destination=<%= showTrain.getTrainDestination()%>&totalseat=<%=showTrain.getTotalseat()%>&ticketprice<%=showTrain.getTicketPrice()%>">Update</a>
    
    
    
    
    <!-- <a href="deletetrain.jsp"><button type="button">Delete</button></td></a> -->
</tr>
<%
}
%>
</tbody>
</table>    
</body>
</html>
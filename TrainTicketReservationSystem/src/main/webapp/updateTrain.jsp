<%@page import="javax.websocket.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
        #addtrains{
            border: 1px solid black;
            height: 85px;
            background-color:  rgb(238, 241, 241);
           
        }
        #addtrains ul li {
            list-style: none;
            display: inline-block;
            padding: 30px;
            padding-left: 170px;
            }
        a{
            text-decoration: none;
        }
          body{
    background: url(images/lgbackground.jpg);
    background-size: cover;
    filter: blur();
    
}
.addtrain{
    background-color:rgb(238, 241, 241);
    margin-left: 120px;
    margin-top: 5px;
    height: 550px;
    width: 500px;
    text-align: center;
    position: absolute;
    left: 310px;
    top: 100px;
    padding-left: 40px;
    padding-top: 20px;
    box-shadow: 0 0 5px 5px  rgba(141, 133, 128, 0.849);

}
.Entertrdetails{
    
    padding-left: 0px;
    
}
input{
    border-top: none;
    border-left: none;
    border-right: none;
    background:transparent;
    outline: none;

}
.buttonadd{
    height: 35px;
    width: 80px;
    background-color: rgb(127, 127, 221);
    outline: none;
    border: none;
}
.buttonadd:hover{
    background-color: rgb(247, 112, 112);
}
#addtr{
    margin-right: 80px;
    position: relative;
    top: 20px;
}
#addtrres{
    margin-right: 80px;
    position: relative;
    top: 20px;
}
.addtrain input::target-text{
    height: 40px;
    
}

.addtrain inout{
position: relative;
left: 30px;
}
        
    </style>
</head>
<body>
    <div id="addtrains">
        <ul>
            <li><a href="AdminHome.jsp">Profile</a></li>
            <li><a href="AddTrain.jsp">Add Train</a></li>            
            <li><a href="TrainList.jsp">Train list</a></li>            
            <li><a href="UserList.jsp">User list</a></li>
            <li><a href="BookingList.jsp">Booking list</a></li>
        </ul>
    </div>
    <div class="addtrain">
        <form action="updatetrainpage">
        <h2 class="Entertrdetails">Enter Train Details</h2>
        <table id="logintable">
    <%
    String error  = (String)session.getAttribute("updateerror");

    
    %>        
            
            <tr>
               <th><label for="trainname">Train Name:</label>
                <input type="text" name="trainname" id="trainname" value="<%=request.getParameter("TrainName") %>" required><br><br></th>
            </tr>
            <tr>
                <th><label for="trainclass">Train Class:</label>
                <input type="text" name="trainclass" id="trclass" value="<%=request.getParameter("TrainClass") %>" ><br><br></th>
            </tr>
            <tr>
                <th>
                    <label  for="trainnumber">Train Number:</label>
                    <input type="number" name="trainnumber" id="trnumber" value="<%=request.getParameter("TrainNumber")%>" placeholder="Enter trainnumber" readonly="readonly" required="required"><br><br>
                </th>
            </tr>
           
                <tr>
                    <th>
                        <label for="trainsource">Train Source:</label>
                        <input type="text" name="trainsource" id="trainsource" value="<%=request.getParameter("source") %> " ><br><br>
                    </th>
                </tr>
                <tr>
                    <th>
                        <label for="traindestination">Train Destination:</label>
                        <input type="text" name="traindestination" id="trdestination"  value="<%=request.getParameter("destination") %>"  placeholder="Enter train destination" ><br><br>
                    </th>
                </tr>
                <tr>
                    <th>
                        <label for="traindeparturetime">Train Departure Time:</label>
                        <input type="datetime-local" name="traindeparturetime" id="trdestime" value="<%=request.getParameter("Departuretrain") %>" ><br><br>
                    </th>
                </tr>
                <tr>
                    <th>
                        <label for="trainarrivaltime">Train Arrival Time:</label>
                        <input type="datetime-local" name="trainarrivaltime" id="trarrtime" value="<%=request.getParameter("Arrival") %>" placeholder="Enter arrival time" ><br><br>
                    </th>
                </tr>
                <tr>
                    <th>
                        <label for="totalseat">Total Seat:</label>
                        <input type="number" name="totalseat" id="trtotalseat" min="0" value="<%=request.getParameter("totalseat") %>" placeholder="Enter total seat" ><br><br>
                    </th>
                </tr>
                <tr>
                    <th>
                        <label for="ticketprice">Ticket Price:</label>
                        <input type="number" name="ticketprice" id="trticketprice" min="0" value="<%=request.getParameter("ticketprice") %>" placeholder="Enter ticket price" ><br><br>
                    </th>
                </tr>
                <br>
                <tr>
               <th> <button class="buttonadd" id="addtr" type="submit">Submit</button></th>
           <!--     <th> <button class="buttonadd"id="addtrres" type="reset">Reset</button></th> -->
            </tr>
        </table>
    
    	</form>
    	  <a href="AdminHome.jsp"><button type="submit" class="buttonadd"id="addtrres" >Back to HomePage</button></a>
</body>
</html>
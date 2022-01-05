<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="in.berbin.model.*"%>
    <%@page import="in.berbin.daoimpl.TrainDaoImpl"%>
      <%@page import="in.berbin.daoimpl.UserDaoImpl"%>
    <%@page import="java.time.LocalDate"%>
    <% TrainDaoImpl trainDao=new TrainDaoImpl();
    UserDaoImpl userDao=new UserDaoImpl();
     Users userData=(Users)session.getAttribute("userdata");
     //to get train details
     int trainid=Integer.parseInt(request.getParameter("traindetails"));
     
     session.setAttribute("presenttrain", trainid);
     Trains trainModel=trainDao.findTrainsDetailsUsingID(trainid);
     Users userModel=userDao.getUserDetailsById(userData.getUserId());
     %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
    <style>
        body{
            background: url(images/lgbackground.jpg);
            background-size: cover;
            filter: blur();
            
        }
        .signup{
            background-color:rgb(238, 241, 241);
            margin-left: 120px;
            margin-top: 5px;
            height: 600px;
            width: 500px;
            text-align: center;
            position: absolute;
            left: 310px;
            top: 50px;
            padding-left: 40px;
            padding-top: 20px;
            box-shadow: 0 0 5px 5px  rgba(141, 133, 128, 0.849);
        
        }
        .bookticket{
            
            padding-left: 0px;
            
        }
        input{
            border-top: none;
            border-left: none;
            border-right: none;
            background:transparent;
            outline: none;
        
        }
        .buttonsignup{
            height: 35px;
            width: 80px;
            background-color: rgb(241, 241, 237);
            outline: none;
            border: none;
        }
        .buttonsignup:hover{
            background-color: rgb(228, 17, 17);
        }
        #subsignup{
            margin-right: 80px;
            position: relative;
            top: 20px;
        }
        #ressignup{
            margin-right: 80px;
            position: relative;
            top: 20px;
        }
        .signup input::target-text{
            height: 40px;
            
        }</style>
</head>
<body>
<div class="signup">
        <form action="booking">
        <h2 class="bookticket">Book your ticket</h2>
        <table id="logintable" onmouseover="check()">
            
            <!-- <tr>
                <th> <label for="usn">User Name:</label>
                <input type="text" name=""id="usn" placeholder="Enter UserName" required autofocus><br><br></th>
            </tr> -->
            <tr>
               <th><label for="trainname">TrainName:</label>
                <input type="text" name="trainname" id="fullname" value="<%=trainModel.getTrainName() %>" disabled="disabled" required><br><br></th>
            </tr>
            <tr>
                <th><label for="trainnumber">TrainNumber:</label>
                <input type="number" name="trainnumber"  value="<%=trainModel.getTrainNumber() %>" disabled="disabled" id="regage" placeholder="" required><br><br></th>
            </tr>
             <tr>
                <th>
                    <label  for="trainclass">Class:</label>
                    <input type="text" name="trainclass" value="<%=trainModel.getTrainClass() %>"  disabled="trainclass" placeholder="" required><br><br>
                </th>
            </tr>
            <tr>
                <th>
                    <label  for="trainsource">Source:</label>
                    <input type="text" name="trainsource" value="<%=trainModel.getTrainSource() %>" disabled="disabled"  id="trainsource" placeholder="" required><br><br>
                </th>
            </tr>
           
                <tr>
                    <th>
                        <label for="traindestination">Destination:</label>
                        <input type="text" name="traindestination" value="<%=trainModel.getTrainDestination() %>" disabled="traindestination" placeholder="" required><br><br>
                    </th>
                </tr>
                <tr>
                    <th>
                        <label for="deptime">Departure time:</label>
                        <input type="text" name="deptime" value="<%=trainModel.getTrainDepartureTime() %>"   id="deptime" disabled="disabled" placeholder="" required><br><br>
                    </th>
                </tr>
                <tr>
                    <th>
                        <label for="arrtime">Arrival time:</label>
                        <input type="text" name="arrtime" value="<%=trainModel.getTrainArraivalTime() %>" disabled="disabled" id="arrtime" placeholder="" required><br><br>
                    </th>
                </tr>
                <tr>
                    <th>
                        <label for="totalseat">Available seat:</label>
                        <input type="number" name="totalseat" value="<%=trainModel.getTotalseat() %>" disabled="disabled" id="totalseat" placeholder="" required><br><br>
                    </th>
                </tr>
                 <tr>
                    <th>
                        <label for="ticketprice">Ticket Price:</label>
                        <input type="number" name="ticketprice" value="<%=trainModel.getTicketPrice()%>" disabled="disabled" id="ticketprice" placeholder="" required><br><br>
                    </th>
                </tr>
                <tr>
                    <th>
                        <label for="seatcount">Enter seat count:</label>
                        <input type="number" name="seatcount" value="<% %>" id="Numberseat" placeholder="Up to 6 tickets" required><br><br>
                    </th>
                </tr>
                <tr>
                    <th>	
                        <label for="totalprice">Total price:</label>
                        <input type="text" name="totalprice" id="totalprice" placeholder="" readonly="readonly" required><br><br>
                    </th>
                </tr>
                <br>
                <tr>
               <th> <button class="buttonsignup" id="subsignup" type="submit">confirm Booking</button></th>
               <th> <button class="buttonsignup"id="ressignup" type="reset">Reset</button></th>
            </tr>
        </table>
    </form>
    </div>
</body>

<script type="text/javascript">

function check(){


var numberSeats=document.getElementById('Numberseat');
var price=document.getElementById('totalprice');


var count=numberSeats.value;
console.log(count);

numberSeats.value=count;
price.value=<%=trainModel.getTicketPrice()%>*count;

}



</script>

</html>
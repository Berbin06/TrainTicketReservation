<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="in.berbin.daoimpl.TrainDaoImpl"%>
        <%@page import="in.berbin.daoimpl.UserDaoImpl"%>
    
    <%@page import="in.berbin.model.*"%>
        <%@page import="javax.servlet.http.HttpSession" %>
         <%HttpSession session2=request.getSession();%> 
             <% Users userData=(Users)session2.getAttribute("userdata");%>
             <%UserDaoImpl userDao=new UserDaoImpl();
               Users userModel=userDao.getUserDetailsById(userData.getUserId());  %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Wallet</title>
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
    height: 480px;
    width: 500px;
    text-align: center;
    position: absolute;
    left: 310px;
    top: 50px;
    padding-left: 40px;
    padding-top: 20px;
    box-shadow: 0 0 5px 5px  rgba(141, 133, 128, 0.849);

}
.SignUphere{
    
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
    background-color: rgb(127, 127, 221);
    outline: none;
    border: none;
}
.buttonsignup:hover{
    background-color: rgb(247, 112, 112);
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
    
}
</style>
</head>
<body>
<div class="signup">
        <form action="toAddAmount.jsp">
        <h2 class="SignUphere">Manage Wallet</h2>
        <table id="logintable">
            
            <!-- <tr>
                <th> <label for="usn">User Name:</label>
                <input type="text" name=""id="usn" placeholder="Enter UserName" required autofocus><br><br></th>
            </tr> -->
            <tr>
                <th><label for="UserName">UserName:</label>
                 <input type="text" name="username" value=<%=userModel.getUserName() %> disabled="disabled" id="username"  required><br><br></th>
             </tr>
            <tr>
               <th><label for="available balance">Available Balance:</label>
                <input type="text" name="" id="availablebalance" value=<%=userModel.getUserwallet() %> disabled="disabled" required><br><br></th>
            </tr>
            
                <th>
                     <h6>To Add Wallet</h6>

                </th>
            </tr>
           
           
                <!-- <tr>
                    <th>
                        <label for="addwallet">Enter Amount:</label>
                        <input type="number" id="addwallet" name="ammounttoaddinwallet" placeholder="Enter amount to add" required><br><br>
                    </th>
                </tr>
       -->
                <br>
               <tr>
               <th> <button class="buttonsignup" id="subsignup" type="submit" >click to add amount</button></th>
            <!--    <th> <button class="buttonsignup"id="ressignup" type="reset">Reset</button></th> -->
            </tr>
        </table>
    </form>
     <a href="UserHomePage.jsp"><button type="submit" class="buttonsignup">Back to HomePage</button></a>
    </div>
</body>
</html>
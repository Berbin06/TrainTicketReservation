<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="in.berbin.daoimpl.TrainDaoImpl"%>
        <%@page import="in.berbin.daoimpl.UserDaoImpl"%>
    
    <%@page import="in.berbin.model.*"%>
        <%@page import="javax.servlet.http.HttpSession" %>
        <%HttpSession session2=request.getSession();%> 
             <% Users userData=(Users)session2.getAttribute("userdata");
             UserDaoImpl userDao=new UserDaoImpl();
               Users userModel=userDao.getUserDetailsById(userData.getUserId());
              
               int amountEntered=Integer.parseInt(request.getParameter("ammounttoaddinwallet"));
               System.out.println(amountEntered);
               int totalAmount=amountEntered+userData.getUserwallet();
               userDao.updateWallet(amountEntered,userData.getUserId() );
             
               
               Users userModel1=new Users(userModel.getUserId(),userModel.getUserName(),userModel.getUserDob(),userModel.getUserEmail(),
             		  userModel.getUserMobileNumber(),userModel.getUserGender(),userModel.getUserPassword(),totalAmount);
               session.setAttribute("userdata2", userModel1);
           
             %> 
             <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Amount Add sucessfully</title>
<style>
body{
    background: url(Assests/Defaultbg.jpg);
    background-size: cover;
    filter: blur();
    
}
.signup {
    background-color: rgb(238, 241, 241);
    margin-left: 110px;
    margin-top: 7px;
    height: 317px;
    width: 341px;
    text-align: center;
    position: absolute;
    left: 310px;
    top: 50px;
    padding-left: 40px;
    padding-top: 20px;
    box-shadow: 0 0 5px 5px rgb(141 133 128 / 85%);
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
    margin-left: 173px;
}
.buttonsignup:hover{
    background-color: rgb(247, 112, 112);
}
#subsignup{
    margin-right:-128px;
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
        <form action="UserHomePage.jsp">
        <h2 class="SignUphere">Manage Wallet</h2>
        <table id="logintable">
            <h6>Added sucessful</h6>
          
      
      
                <br>
               <tr>
               <th> <button class="buttonsignup" id="subsignup" type="submit" >click to add</button></th>
             <!--   <th> <button class="buttonsignup"id="ressignup" type="reset">Reset</button></th> -->
            </tr>
        </table>
    </form>
     <a href="UserHomePage.jsp"><button type="submit" id="ressignup" class="buttonsignup">Back to HomePage</button></a>
    </div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="in.berbin.daoimpl.TrainDaoImpl"%>
        <%@page import="in.berbin.daoimpl.UserDaoImpl"%>
    
    <%@page import="in.berbin.model.*"%>
   <%--      <%@page import="javax.servlet.http.HttpSession" %>
        <%HttpSession session2=request.getSession();%> 
             <% Users userData=(Users)session2.getAttribute("userdata");%>
             <%UserDaoImpl userDao=new UserDaoImpl();
               Users userModel=userDao.getUserDetailsById(userData.getUserId());
               int amountEntered=Integer.parseInt(request.getParameter("ammounttoaddinwallet"));
               int totalAmount=amountEntered+userData.getUserwallet();
               userDao.updateWallet(totalAmount, userData.getUserwallet());
               
               
               Users userModel1=new Users(userModel.getUserId(),userModel.getUserName(),userModel.getUserDob(),userModel.getUserEmail(),
             		  userModel.getUserMobileNumber(),userModel.getUserGender(),userModel.getUserPassword(),totalAmount);
               session.setAttribute("userdata2", userModel1);
             %>  --%>
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
 <form action="amountaddsucessfully.jsp" >
<div class="signup">
       
        <h2 class="SignUphere">Manage Wallet</h2>
        <table id="logintable">
            
          
                <th>
                     <h6>To Add Wallet</h6>

                </th>
            </tr>
           
           
                <tr>
                    <th>
                        <label for="addwallet">Enter Amount:</label>
                        <input type="number" min="0" id="addwallet" name="ammounttoaddinwallet" placeholder="Enter amount to add" required><br><br>
                    </th>
                </tr>
      
                <br>
               <tr>
               <th> <button class="buttonsignup" id="subsignup" type="submit" >click to add</button></th>
              
            </tr>
             
        </table>
   
    </div>
    </form>
     <a href="UserHomePage.jsp"><button type="submit" class="buttonsignup">Back to HomePage</button></a>
</body>
</html>
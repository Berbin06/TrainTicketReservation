<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <title>Login Page</title>
    <link rel="stylesheet" href="login.css">
</head>
<body>
    <div class="login">
        <form action="loginusers">
        
        <img id="trainpng" class="pngtitle" src="images/Train.png.png" alt="">
        <h2 class="loginhere" >LogIn Here!!</h2>

        <table id="logintable">
            <tr>
                <th><img src="images/user.png.png" alt="" ></th>
                <th><input type="text" name="logincredentials"  placeholder="Enter your Mobile Number" required ><br><br></th>
            </tr>
            <tr>
                <th><img src="images/pswd.png.png" alt=""></th>
                <th><input type="password" name="password" placeholder="Enter your Password" required><br><br></th>
            </tr>
            
        </table>
            
            <button id="buttonlogin">Login</button><br><br>
            <!-- <a href="forgetPassword.html">Forget Password?</a><br><br> -->

            <label for="signup">Don't have an account ? </label>
            <a id="signup" href="signup.jsp">SignUp</a>

        </form>  
 </div>



</html>
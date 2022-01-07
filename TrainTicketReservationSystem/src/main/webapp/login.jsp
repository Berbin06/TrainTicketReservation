<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <title>Login Page</title>
    <style>
    body{
    background: url(https://images.unsplash.com/photo-1442570468985-f63ed5de9086?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8OHx8dHJhaW58ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60);
    background-size: cover;
    filter: blur();
    
}
div,img{
    width: 20px;
    height: 25px;
}
div,input{
    height: 30px;
    width: 200px;
    border-top: none;
    border-left: none;
    border-right: none;
    outline: none;
    background: transparent;
}
.login{
    margin-left: 120px;
    margin-top: 50px;
    height: 420px;
    width: 300px;
    padding-left: 40px;
    padding-top: 20px;
    background-color: rgb(238, 241, 241);
    border-radius: 30px ;  
    position: absolute;
    left: 400px;
    top: 50px;
    box-shadow: 0 0 5px 5px rgba(141, 133, 128, 0.849); 
       
}
.pngtitle{
    margin-left: 100px;
   
}
.loginhere{
    margin-left: 60px;
}
#trainpng{
    border-radius: 50%;
    border: 1px solid black;
    height: 70px;
    width: 60px;
}
#buttonlogin{
    margin-left: 80px;
}
button{
    height: 35px;
    width: 80px;
    background-color: rgb(127, 127, 221);
    outline: none;
    border: none;

}
table,th{
    border-spacing: 5px;
}
button:hover{
    background-color: rgb(247, 112, 112);
}
a:hover{
    background-color:  rgb(247, 112, 112);
}
a{
    text-decoration: none;
}
#signup{
    border: 2px solid black;
   font-weight:bolder;
   font-size: 20px;

}
    </style>
</head>
<body>
     <marquee width="60%" direction="right" height="300px">
Welcome to train ticket reservation system.
</marquee>
    <div class="login">
        <form action="loginusers">
   
        <img id="trainpng" class="pngtitle" src="https://images.unsplash.com/photo-1552823477-7d95b3b3f480?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTd8fHRyYWlufGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60" alt="">
        <h2 class="loginhere" >LogIn Here!!</h2>

        <table id="logintable">
            <tr>
                <th><img src="images/user.png.png" alt="" ></th>
                <th><input type="text" name="logincredentials" pattern="[6-9][0-9]+{9}"  placeholder="Enter your Mobile Number" required ><br><br></th>
            </tr>
            <tr>
                <th><img src="images/pswd.png.png" alt=""></th>
                <th><input type="password" name="password" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+{8,15}$" placeholder="Enter your Password" required><br><br></th>
            </tr>
            
        </table>
            
            <button id="buttonlogin">Login</button><br><br>
            <!-- <a href="forgetPassword.html">Forget Password?</a><br><br> -->

            <label for="signup">Don't have an account ? </label>
            <a id="signup" href="signup.jsp">SignUp</a>

        </form>  
 </div>



</html>
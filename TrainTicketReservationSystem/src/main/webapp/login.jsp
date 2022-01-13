<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous"> -->
    <title>Login Page</title>
    <style>
    body{
    background: url(https://images.squarespace-cdn.com/content/v1/5a3bb03b4c326d76de73ddaa/1622559786569-F4UVF7274QAKJHWD00UM/The_Common_Wanderer_india_train_travel_tips-17_1.jpg?format=1500w);
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
    position:absolute;
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
    border: none; */
     
 
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
.trainmarquee{
width:250px;
height:100px;
}
    </style>
</head>
<body>


     <marquee width="100%" direction="right" height="300px">
<img alt="" class="trainmarquee" src="https://clipart-best.com/img/train/train-clip-art-39.png">
Welcome to Train Ticket Reservation System.
Special Trains will available on special occasion!!
</marquee>
    <div class="login">
        <form action="loginusers">
   
        <img id="trainpng" class="pngtitle" src="https://images.unsplash.com/photo-1552823477-7d95b3b3f480?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTd8fHRyYWlufGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60" alt="">
        <h2 class="loginhere" >LogIn Here!!</h2>

        <table id="logintable">
            <tr>
                <th><img src="https://www.logolynx.com/images/logolynx/90/90ae65b2d63dcc5776e4b8da976cc604.jpeg" alt="" ></th>
                <th><input type="text" name="logincredentials"  placeholder="Enter your Mobile Number" required ><br><br></th>
            </tr>
            <tr>
                <th><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT_6WSwA5jhKurNXgM4KyrYeUGlho634NeXTQ&usqp=CAU" alt=""></th>
                <th><input type="password" name="password" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+{8,15}$" placeholder="Enter your Password" required><br><br></th>
            </tr>
            
        </table>
            
            <button class="btn btn-primary btn-block" id="buttonlogin">Login</button><br><br>
            <!-- <a href="forgetPassword.html">Forget Password?</a><br><br> -->

            <label for="signup">Don't have an account ? </label>
            <a id="signup" href="signup.jsp">SignUp</a>

<%String erroruserid=(String)session.getAttribute("erroruserid");
if(erroruserid!=null){ %>
<h4> id="errorcontent"><%=erroruserid %></h4>
<%} session.removeAttribute("erroruserid"); %> 
        </form> 
        

 </div>

<!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script> -->
</body>
</html>
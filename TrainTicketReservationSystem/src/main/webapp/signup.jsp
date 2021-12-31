<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
    <title></title>
    <link rel="stylesheet" href="signup.css">
</head>
<body>
<div class="signup">
    <form action="signuppage">
    <h2 class="SignUphere">Sign Up!!</h2>
    <table id="logintable">
        
        <!-- <tr>
            <th> <label for="usn">User Name:</label>
            <input type="text" name=""id="usn" placeholder="Enter UserName" required autofocus><br><br></th>
        </tr> -->
        <tr>
           <th><label for="fullname">FullName:</label>
            <input type="text" name="fullname" id="fullname" placeholder="Enter your FullName" required><br><br></th>
        </tr>
        <tr>
            <th><label for="regage">Age:</label>
            <input type="text" name="age" pattern="[0-9]{2}" title="contain two numbers only" id="regage" placeholder="Enter your age" required><br><br></th>
        </tr>
        <tr>
            <th>
                <label  for="regemail">Email:</label>
                <input type="email" name="email" id="regemail" placeholder="Enter your MailID" required><br><br>
            </th>
        </tr>
       
            <tr>
                <th>
                    <label for="regpswd">Password:</label>
                    <input type="password" name="password" id="regpswd" placeholder="Enter your Password" required><br><br>
                </th>
            </tr>
            
            <tr>
                <th>
                    <label for="regmobilenum">MobileNo:</label>
                    <input type="number" name="mobileno" id="regmobilenum" placeholder="Enter your MobileNumber" required><br><br>
                </th>
            </tr>
            <tr>
                <th>
                    <label for="reggender">Gender:</label>
                    <input  type="radio"name="gender" id="reggender" value="Male" required><label  for="">Male</label>
                    <input  type="radio" name="gender"id="reggender" value="Female" required><label  for="">Female</label>
                </th>
            </tr>
            
            <tr>
           <th> <button class="buttonsignup" id="subsignup" type="submit">Submit</button></th>
           <th> <button class="buttonsignup"id="ressignup" type="reset">Reset</button></th>
        </tr>
    </table>
</form>
</div>
</body>

</html>
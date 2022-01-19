package in.berbin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.berbin.daoimpl.AdminDaoImpl;
import in.berbin.daoimpl.UserDaoImpl;
import in.berbin.exception.LoginPasswordException;
import in.berbin.exception.LoginUserNameException;
import in.berbin.model.Admins;
import in.berbin.model.Users;


@WebServlet("/loginusers")
public class LoginController extends HttpServlet{

public void service(HttpServletRequest req,HttpServletResponse res) {

HttpSession session=req.getSession();

String loginId=req.getParameter("logincredentials");
String password=req.getParameter("password");

 System.out.println(password);
 System.out.println(loginId);
AdminDaoImpl adminDao=new AdminDaoImpl();
UserDaoImpl userDao=new UserDaoImpl();
Admins adminModel;
Users userModel=new Users();

//admin Login
if(loginId.endsWith("@admin.com")) {

try {

adminModel=adminDao.adminLogin(loginId);
System.out.println(adminModel);
if(adminModel!=null) {
	
try {
res.sendRedirect("AdminHome.jsp");
session.setAttribute("AdminHome", "HomeSession");
} catch (IOException e) {
System.out.println(e.getMessage());
}
}


else
{
throw new LoginUserNameException();
}
}
catch(LoginUserNameException e) {
session.setAttribute("erroruserid",e.getUserNameLoginMessage());
try {
res.sendRedirect("login.jsp");
}  catch (IOException e1) {
System.out.println(e1.getMessage());
}
}

}
else if (loginId.contains("@admin.com") == false && loginId.matches("[0-9]+") == false) {
try {
// session.setAttribute("erroruserid", "user name mismatch");
throw new LoginUserNameException();
}
catch(LoginUserNameException e) {
session.setAttribute("erroruserid",e.getUserNameLoginMessage());
try {
res.sendRedirect("login.jsp");
}  catch (IOException e1) {
System.out.println(e1.getMessage());
}
}

}

//userLogin
else {
boolean userCheckFlag;
long userId=Long.parseLong(loginId);

System.out.println(userId);
userCheckFlag=userDao.checkUser(userId);
try {
if(userCheckFlag) {
userModel=userDao.loginUser(userId);
System.out.println(userModel.getUserPassword());

if(userModel.getUserPassword().equals(password)) {
try {
session.setAttribute("userdata", userModel);
session.setAttribute("userHome", "loginSession");
res.sendRedirect("UserHomePage.jsp");
} catch (IOException e) {
System.out.println(e.getMessage());
}
}
else
{
throw new LoginPasswordException();
}


}
else
{
throw new LoginUserNameException();
}
}
catch(LoginUserNameException e) {
session.setAttribute("erroruserid",e.getUserNameLoginMessage());
try {
res.sendRedirect("login.jsp");

} catch (IOException e1) {
System.out.println(e1.getMessage());
}

}
catch(LoginPasswordException e) {
session.setAttribute("erroruserid",e.getPasswordLoginMessage());
try {
res.sendRedirect("login.jsp");
}  catch (IOException e1) {
System.out.println(e1.getMessage());
}
}


}
}


}

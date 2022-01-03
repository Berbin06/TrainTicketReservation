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
import in.berbin.model.Admins;
import in.berbin.model.Users;




@WebServlet("/loginusers")
public class LoginController extends HttpServlet{

	public void service(HttpServletRequest req,HttpServletResponse res) {
		
		HttpSession session=req.getSession();
		
		String loginId=req.getParameter("logincredentials");
		String password=req.getParameter("password");
		

		AdminDaoImpl adminDao=new AdminDaoImpl();
		UserDaoImpl userDao=new UserDaoImpl();
		Admins adminModel;
		Users userModel=new Users();
		
		//admin Login		
		if(loginId.endsWith("admin@admin.com")) {
			boolean adminCheckFlag;
			adminCheckFlag=adminDao.checkadmin(loginId);
			if(adminCheckFlag) {
				adminModel=adminDao.adminLogin(loginId);
				if(adminModel.getAdminPassword().equals(password)) {
					try {
						res.sendRedirect("AdminHome.jsp");
					} catch (IOException e) {
						System.out.println(e.getMessage());
					}
				}
			}
					
		}
		//userLogin
		else {
			boolean userCheckFlag;
			long userId=Long.parseLong(loginId);
			userCheckFlag=userDao.checkUser(userId);
			if(userCheckFlag) {
				userModel=userDao.loginUser(userId);
				if(userModel.getUserPassword().equals(password)) {
					try {
						res.sendRedirect("UserHomePage.jsp");
					} catch (IOException e) {
						System.out.println(e.getMessage());
					}
				}
				else
				{
					session.setAttribute("erroruserid", "password is incorrect");
					try {
						req.getRequestDispatcher("Login.jsp").forward(req,res);
					} catch (ServletException e) {
						System.out.println(e.getMessage());
					} catch (IOException e) {
						System.out.println(e.getMessage());
					}
				}
			}
			else {
				session.setAttribute("erroruserid", "user name mismatch");
				try {
					req.getRequestDispatcher("Login.jsp").forward(req,res);
				} catch (ServletException e) {
					System.out.println(e.getMessage());
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
					
	}
	}
}
	






package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trainticketreservation.dao.AdminDao;
import com.trainticketreservation.dao.UserDao;
import com.trainticketreservation.model.AdminModel;
import com.trainticketreservation.model.UserModel;




@WebServlet("/loginusers")
public class Login extends HttpServlet{

	public void service(HttpServletRequest req,HttpServletResponse res) {
		
		HttpSession session=req.getSession();
		
		String loginId=req.getParameter("LoginID");
		String password=req.getParameter("password");
		

		AdminDao adminDao=new AdminDao();
		UserDao userDao=new UserDao();
		AdminModel adminModel;
		UserModel userModel=new UserModel();
		
		//admin Login
		if(loginId.endsWith("admin@gmail.com")) {
			boolean adminCheckFlag;
			adminCheckFlag=adminDao.checkadmin(loginId);
			if(adminCheckFlag) {
				adminModel=adminDao.adminLogin(loginId);
				if(adminModel.getAdminPassword().equals(password)) {
					try {
						res.sendRedirect("adminHomePage.jsp");
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
	






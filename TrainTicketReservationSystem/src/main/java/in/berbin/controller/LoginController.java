package in.berbin.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
		PrintWriter out=null;
		res.setContentType("text/html");
		try {
			out = res.getWriter();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
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
				System.out.println(userModel.getUserId());
				if(userModel.getUserPassword().equals(password)) {
					try {
						session.setAttribute("userdata", userModel);
						res.sendRedirect("UserHomePage.jsp");
					} catch (IOException e) {
						System.out.println(e.getMessage());
					}
				}
				else
				{
					session.setAttribute("erroruserid", "password is incorrect");
					try {
						out.print("Invalid username or password");
						req.getRequestDispatcher("login.jsp").include(req,res);
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
					out.print("hello");
					req.getRequestDispatcher("login.jsp").include(req,res);
				} catch (ServletException e) {
					System.out.println(e.getMessage());
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
					
	}
	}
}
	






package com.controller;

import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trainticketreservation.dao.UserDao;
import com.trainticketreservation.model.UserModel;






@WebServlet("/signuppage")
public class Signup extends HttpServlet{

	public void service(HttpServletRequest req,HttpServletResponse res) {
	
		String name=req.getParameter("fullname");
		System.out.println(name);
		String email=req.getParameter("email");
		System.out.println(email);
		long mobile=Long.parseLong(req.getParameter("mobileno"));
		System.out.println(mobile);
		String password=req.getParameter("password");
		System.out.println(password);
		int age=Integer.parseInt(req.getParameter("age"));
		System.out.println(age);
		String gender=req.getParameter("gender");
		System.out.println(gender);
		UserModel userModel=new UserModel(name,age,email,mobile,gender,password);
		System.out.println(userModel);
		UserDao userDao=new UserDao();
		
		try {
			userDao.insert(userModel);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
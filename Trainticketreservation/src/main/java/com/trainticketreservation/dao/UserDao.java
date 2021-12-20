package com.trainticketreservation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.trainticketreservation.connectionutil.ConnectionUtil;
import com.trainticketreservation.module.UserModule;

public class UserDao {
public void login(UserModule userModule) throws ClassNotFoundException, SQLException {
		
		String loginquery="select user_name from users where user_mobilenumber='"+userModule.getUserMobileNumber()+"' and user_password='"+userModule.getUserPassword()+"'";
		Connection con=ConnectionUtil.getDBconnect();
		PreparedStatement ps=con.prepareStatement(loginquery);
	
ResultSet rs=ps.executeQuery(loginquery);
if(rs.next()) {

	System.out.println("Welcome "+rs.getString(1));
	
}
else {
	System.out.println("Invalid user please register");
}
	}
	
	public void insert(UserModule UserModule) throws ClassNotFoundException, SQLException {
		
		String insertquery="insert into users (user_name,user_age,user_email,user_mobilenumber,user_gender,user_password) values (?,?,?,?,?,?)";
		Connection con=ConnectionUtil.getDBconnect();
		PreparedStatement ps=con.prepareStatement(insertquery);
	
		ps.setString(1,UserModule.getUserName());
		ps.setInt(2,UserModule.getUserAge());
		ps.setString(3, UserModule.getUserEmail());
		ps.setLong(4,UserModule.getUserMobileNumber());
		ps.setString(5,UserModule.getUserGender());
		ps.setString(6, UserModule.getUserPassword());
	
		int result=ps.executeUpdate();
		System.out.println(result + " user detail inserted !!");
		ps.close();
		con.close();
	}
	
	
	
    public void update (UserModule UserModule) throws ClassNotFoundException, SQLException {
    	
    	String update="update users set user_name=?, user_age=?, user_mobilenumber=?, user_gender=?, user_password=? where user_email='"+UserModule.getUserEmail()+"'";
    	
    	Connection con=ConnectionUtil.getDBconnect();
		PreparedStatement ps=con.prepareStatement(update);
		
		ps.setString(1,UserModule.getUserName());
		ps.setInt(2,UserModule.getUserAge());
		ps.setLong(3,UserModule.getUserMobileNumber());
		ps.setString(4,UserModule.getUserGender());
		ps.setString(5, UserModule.getUserPassword());
		
		int result=ps.executeUpdate();
		System.out.println(result+ " is updated !!");
		ps.close();
		con.close();
    }
	
    
    public void delete (UserModule UserModule) throws ClassNotFoundException, SQLException {
		
		String del="delete from users where user_id=?";
		
		Connection con=ConnectionUtil.getDBconnect();
		PreparedStatement ps=con.prepareStatement(del);
		
		ps.setInt(1, UserModule.getUserId());
		int res=ps.executeUpdate();
		System.out.println(res + "is deleted");
		ps.close();
		con.close();		
	}
    
   
}




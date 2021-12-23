package com.trainticketreservation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.trainticketreservation.connectionutil.ConnectionUtil;
import com.trainticketreservation.model.UserModel;

public class UserDao {
public void login(UserModel userModule) throws ClassNotFoundException, SQLException {
		
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
	
	public void insert(UserModel UserModule) throws ClassNotFoundException, SQLException {
		
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
	
	
	
    public void update (UserModel UserModule) throws ClassNotFoundException, SQLException {
    	
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
	
    
    public void delete (UserModel UserModule) throws ClassNotFoundException, SQLException {
		
		String del="delete from users where user_id=?";
		
		Connection con=ConnectionUtil.getDBconnect();
		PreparedStatement ps=con.prepareStatement(del);
		
		ps.setInt(1, UserModule.getUserId());
		int res=ps.executeUpdate();
		System.out.println(res + "is deleted");
		ps.close();
		con.close();		
	}
    
//   public void showusers(UserModel UserModule) throws ClassNotFoundException, SQLException {
//	  String showusersquery="select*from users";
//	  Connection con=ConnectionUtil.getDBconnect();
//		PreparedStatement ps=con.prepareStatement(showusersquery);
//		 ResultSet rs=ps.executeQuery();
//		 while(rs.next())
//		 {
//			 System.out.println("\n" +rs.getInt(1)+"\n"+rs.getString(2)+"\n" +rs.getInt(3)+"\n" +rs.getString(4)+"\n" +rs.getLong(5)+"\n" +rs.getString(6)+"\n" +rs.getString(7));
//		 }
//   }
    public List<UserModel> showAllUsers()
    {
    	List<UserModel> userList = new ArrayList<UserModel>();
    	String showusersquery="select*from users";
    	Connection con = null;
    	PreparedStatement ps;
    	try {
			con = ConnectionUtil.getDBconnect();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			ps = con.prepareStatement(showusersquery);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				UserModel userModel =new UserModel(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),(long)rs.getInt(5),rs.getString(6),rs.getString(7));
				userList.add(userModel);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return userList;
    }
    //find userId 
    public static int findUserId(UserModel userModel) {
    	String findUserIdQuery="select user_id from users where user_email='" + userModel.getUserEmail()+"'";
    	Connection con = null;
		try {
			con = ConnectionUtil.getDBconnect();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Statement stmt = null;
    	int userId = 0;
    	try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			ResultSet rs=stmt.executeQuery(findUserIdQuery);
			if(rs.next()) {
				userId = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userId;
    }
}




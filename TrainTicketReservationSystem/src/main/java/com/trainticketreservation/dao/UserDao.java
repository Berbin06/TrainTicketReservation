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
	public UserModel loginUser(long UserMobileNumber ) {

		String userLogin = "select * from users where user_mobileNumber='" + UserMobileNumber + "'";
		Connection con;
		UserModel userModel = null;
		try {
			con = ConnectionUtil.getDBconnect();
			PreparedStatement pstatement = con.prepareStatement(userLogin);

			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(userLogin);

			rs.next();
			userModel = new UserModel(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getLong(5),
					rs.getString(6), rs.getString(7), rs.getInt(8));
			con.close();
			pstatement.close();
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return userModel;
	}
	
	public void insert(UserModel UserModule) throws ClassNotFoundException, SQLException {
		
		String insertquery="insert into users (user_name,user_age,user_email,user_mobilenumber,user_gender,user_password) values (?,?,?,?,?,?)";
		Connection con=ConnectionUtil.getDBconnect();
		PreparedStatement ps=con.prepareStatement(insertquery);
	    System.out.println(UserModule);
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
				UserModel userModel =new UserModel(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),(long)rs.getInt(5),rs.getString(6),rs.getString(7),rs.getInt(8));
				userList.add(userModel);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return userList;
    }
    //find userId 
    public static UserModel findUserDetails(long userContact) {
    	String findUserDetailsQuery="select * from users where user_mobilenumber='" + userContact+"'";
    	Connection con = null;
    	Statement stmt = null;
    	UserModel userModel = null;
			try {
				con = ConnectionUtil.getDBconnect();
				stmt = con.createStatement();
				ResultSet rs=stmt.executeQuery(findUserDetailsQuery);
				if(rs.next()) {
					userModel=new UserModel(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getLong(5),rs.getString(6),rs.getString(7),rs.getInt(8));
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return userModel;
    }
	public boolean updateWallet(int updatedWallet, long userMobileNumber) {
		String wallet = "update users set user_wallet=? where user_mobilenumber=?";

		Connection con;
		PreparedStatement pstatement;
		int result = 0;
		try {
			con =ConnectionUtil.getDBconnect();
			pstatement = con.prepareStatement(wallet);

			pstatement.setInt(1, updatedWallet);
			pstatement.setLong(2, userMobileNumber);
			result = pstatement.executeUpdate();
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result > 0;

	}
	public UserModel getUserDetailsById(int userId) 
	{ 

		String getUser = "select * from users where user_id=?";
		Connection con = null;
		PreparedStatement pstatement = null;
		UserModel userModel = null;

		try {
			con = ConnectionUtil.getDBconnect();
			pstatement = con.prepareStatement(getUser);
			pstatement.setInt(1, userId);
			ResultSet rs = pstatement.executeQuery();

			if (rs.next()) {
				userModel = new UserModel(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getLong(5),
						rs.getString(6), rs.getString(7), rs.getInt(8));
			}
			con.close();
			pstatement.close();
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return userModel;

	}
	public boolean checkUser(long userMobileNumber ) {

		String userLogin = "select * from user_details where user_contact='" + userMobileNumber;
		Connection con;
		boolean checkUserFlag = true;
		try {
			con = ConnectionUtil.getDBconnect();
			PreparedStatement pstatement = con.prepareStatement(userLogin);

			int i = pstatement.executeUpdate(userLogin);
			if (i > 0) {
				checkUserFlag = true;
			} else {
				checkUserFlag = false;
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		}

		return checkUserFlag;
	}
}




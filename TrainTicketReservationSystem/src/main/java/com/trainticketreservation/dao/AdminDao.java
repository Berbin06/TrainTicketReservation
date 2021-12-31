package com.trainticketreservation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.trainticketreservation.connectionutil.ConnectionUtil;
import com.trainticketreservation.model.AdminModel;
import com.trainticketreservation.model.TrainModel;
import com.trainticketreservation.model.UserModel;

public class AdminDao {

	public AdminModel adminLogin(String AdminEmailId)  {
	String loginadmin="select * from admins where admin_email='"+AdminEmailId+"'";
	Connection con;
	AdminModel adminmodule=null;
	try {
		con =ConnectionUtil.getDBconnect();
		PreparedStatement pstatement=con.prepareStatement(loginadmin);
		ResultSet rs=pstatement.executeQuery();
		
		rs.next() ;
			adminmodule=new AdminModel(rs.getString(2),rs.getLong(3),rs.getString(4),rs.getString(5));
		
		
	} catch (ClassNotFoundException e) {
		System.out.println(e.getMessage());
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}
	
	return adminmodule;
}

public boolean checkadmin(String AdminEmailId)  {
	 
	String loginadmin="select * from admins where admin_email='"+AdminEmailId+"'";
	Connection con;
	boolean checkAdminFlag=true;
	try {
		con = ConnectionUtil.getDBconnect();
		PreparedStatement ps=con.prepareStatement(loginadmin);
		int i=ps.executeUpdate();
		
		if(i>0) {
			checkAdminFlag= true;
		}
		else {
			checkAdminFlag= false;	
		}
	} catch (ClassNotFoundException e) {
		System.out.println(e.getMessage());
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}
	return checkAdminFlag;
}


public void updateAdmin (AdminModel AdminModel) {
	
	String adminUpdate="update admins set admin_name=?,admin_MobileNumber=?, admin_password=? where admin_email='"+AdminModel.getAdminEmail()+"'";
	
	Connection con;
	try {
		con = ConnectionUtil.getDBconnect();
		PreparedStatement pstatement=con.prepareStatement(adminUpdate);
		
		pstatement.setString(1, AdminModel.getAdminName());
		pstatement.setLong(2, AdminModel.getAdminMobileNumber());
		pstatement.setString(3, AdminModel.getAdminPassword());
		
		pstatement.executeUpdate();
		System.out.println("for "+AdminModel.getAdminEmail()+ "profile is updated !!");
		pstatement.close();
		con.close();
	} catch (ClassNotFoundException e) {
		System.out.println(e.getMessage());
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}
	
}


public List<AdminModel> viewAdmin(){
	
	String adminView="select * from admins";
	
	Connection con;
	List<AdminModel> adminList=new ArrayList<AdminModel>();
	try {
		con = ConnectionUtil.getDBconnect();
		PreparedStatement pstatement=con.prepareStatement(adminView);
		
		ResultSet rs=pstatement.executeQuery();
		
		while(rs.next()) {
			AdminModel adminModel=new AdminModel(rs.getString(2),rs.getLong(3),rs.getString(4),rs.getString(5));
			adminList.add(adminModel);
		}
		
	} catch (ClassNotFoundException e) {
		System.out.println(e.getMessage());
	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}
	
	return adminList;
	
}


}


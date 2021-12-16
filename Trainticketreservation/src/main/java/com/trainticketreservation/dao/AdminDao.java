//package com.trainticketreservation.dao;
//
//import java.beans.Statement;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import com.trainticketreservation.connectionutil.ConnectionUtil;
//import com.trainticketreservation.module.AdminModule;
//import com.trainticketreservation.module.UserModule;
//
//public class AdminDao {
//
//		public AdminModule admin(String contact) throws ClassNotFoundException, SQLException {
//			AdminModule adminmodule;
//			String loginadmin="select * from admins where admin_email='"+contact+"'";
//			Connection con=ConnectionUtil.getDBconnect();
//			PreparedStatement ps=con.prepareStatement(loginadmin);
//			
////			Statement st=  con.createStatement();
//			ResultSet rs=ps.executeQuery(loginadmin);
//			
//			rs.next() ;
//				adminmodule=new AdminModule(rs.getString(2),rs.getString(3),rs.getString(4));
//			
//			
//			return adminmodule;
//		}
//		
//		
//		
//		 public void delete (UserModule UserModule) throws ClassNotFoundException, SQLException {
//				
//				String del="delete from users where user_id=?";
//				
//				Connection con=ConnectionUtil.getDBconnect();
//				PreparedStatement ps=con.prepareStatement(del);
//				
//				ps.setInt(1, UserModule.getUserId());
//				int res=ps.executeUpdate();
//				System.out.println(res + "is deleted");
//				ps.close();
//				con.close();		
//			}
//		    
//	
//
//}


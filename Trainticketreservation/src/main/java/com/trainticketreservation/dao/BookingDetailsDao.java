package com.trainticketreservation.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.trainticketreservation.connectionutil.ConnectionUtil;
import com.trainticketreservation.model.BookingDetailsModel;
import com.trainticketreservation.model.TrainModel;
import com.trainticketreservation.model.UserModel;

public class BookingDetailsDao {
	TrainDao tDao=new TrainDao();
	UserDao uDao=new UserDao();
public boolean bookTicket(UserModel userModel,TrainModel trainModel, BookingDetailsModel bookingDetailsModel)
{
	String bookTicketQuery="insert into booking_details(user_id,train_id,journey_date,ticket_count,total_price)values(?,?,?,?,?)";
	Connection con;
	int result=0;
	 SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	try {
		con=ConnectionUtil.getDBconnect();
		PreparedStatement pstmt=con.prepareStatement(bookTicketQuery);
		pstmt.setInt(1, userModel.getUserId());
		pstmt.setInt(2,trainModel.getTrainId());
		//pstmt.setLong(3, bookingDetailsModel.getPnrNumber());
		pstmt.setDate(3, java.sql.Date.valueOf(trainModel.getTrainDepartureTime().toLocalDate()));
		pstmt.setInt(4,bookingDetailsModel.getTicketCount());
		//pstmt.setString(6,bookingDetailsModel.getSeatNo());
		pstmt.setInt(5,bookingDetailsModel.getTotalPrice());
		result=	pstmt.executeUpdate();
	
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result>0;
}
	



public boolean cancelTicket(UserModel userModel,BookingDetailsModel bookingDetailsModel) {
	String ticketCancel="update booking_Details set Ticket_status='Cancelled' where user_id='"+userModel.getUserId()+"' and to_char(journey_date,'yyyy-mm-dd')='"+bookingDetailsModel.getJourneyDate()+"'";
	System.out.println(ticketCancel);
	int result = 0;
	try {
		Connection con=ConnectionUtil.getDBconnect();
		PreparedStatement pstatement=con.prepareStatement(ticketCancel);
		result=pstatement.executeUpdate();
	} catch (ClassNotFoundException e) {
		e.getMessage();
	} catch (SQLException e) {
		e.getMessage();
		System.out.println("invalid Ticket number");
	}
	return result>0;
}
	



//show pnr number to user 
//public int findPnrNumber(UserModel userModel,TrainModel trainModel)
//{ 
//	String findPnrNumber="select pnr_number from booking_Details where user_id='"+userModel.getUserId()+"' and to_char(journey_date,'dd-mm-yyyy')='"+trainModel.getTrainDepartureTime() + "' ";
//	System.out.println(findPnrNumber);
//	Connection con;
//	PreparedStatement pstmt;
//	int pnrNumber=0;
//	try {
//		con=ConnectionUtil.getDBconnect();
//		pstmt=con.prepareStatement(findPnrNumber);
//		ResultSet rs=pstmt.executeQuery();
//		if(rs.next()) {
//			pnrNumber=rs.getInt(3);
//		}
//	} catch (ClassNotFoundException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	System.out.println(pnrNumber);
//	return pnrNumber;
//}

//to show booking history of particular user

public List<BookingDetailsModel>getBookingDetailsForCurrentUser(UserModel userModel){
	String Query="select*from booking_details where user_id='"+userModel.getUserId()+"'";
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	TrainModel trainModel=null;
	UserModel userModel1=null;
	List<BookingDetailsModel>bookingList=new ArrayList<BookingDetailsModel>();
    try {
		con=ConnectionUtil.getDBconnect();
		pstmt=con.prepareStatement(Query);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			trainModel=TrainDao.findTrainDetailsUsingTrainNumber(rs.getInt(1));
			userModel1= UserDao.findUserDetails(userModel.getUserMobileNumber());
			BookingDetailsModel bookingDetailsModel=new BookingDetailsModel(userModel1,trainModel,rs.getLong(3),rs.getDate(4).toLocalDate(),rs.getDate(5).toLocalDate(),rs.getInt(6),rs.getInt(7),rs.getString(8));
			bookingList.add(bookingDetailsModel);
			
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return bookingList;
	
}

public int findPnrNumber(UserModel userModel, BookingDetailsModel bookingDetailsModel) {
	
	String bookingPnrFinder="select pnr_number from booking_details where user_id='"+userModel.getUserId()+"' and to_char(journey_date,'yyyy-mm-dd')='"+bookingDetailsModel.getJourneyDate()+"'";
	Connection con;
	PreparedStatement pstatement;
	int bookingPnr = 0;
	try {
		con=ConnectionUtil.getDBconnect();
		pstatement=con.prepareStatement(bookingPnrFinder);
		ResultSet rs=pstatement.executeQuery();
		if(rs.next()) {
			bookingPnr=rs.getInt(1);
		}
		
	} catch (ClassNotFoundException e) {
		e.getMessage();
	} catch (SQLException e) {
		e.getMessage();
	}
	return bookingPnr;
	
}

//to find booking details
public BookingDetailsModel findBookedTicketsDetails(long pnrNumber) {
	String findTicketDetails="select * from booking_Details where pnr_number='"+pnrNumber+"'";
	
	Connection con;
	PreparedStatement pstatement;
	ResultSet rs;
	TrainModel trainModel=null;
	UserModel userModel=null;
	BookingDetailsModel bookingDetailsModel=null;
	try {
		con=ConnectionUtil.getDBconnect();
		pstatement=con.prepareStatement(findTicketDetails);
		rs=pstatement.executeQuery();
		
		if(rs.next()) {
			trainModel=tDao.findTrainsDetailsUsingID(rs.getInt(2));
			
			userModel=uDao.getUserDetailsById(rs.getInt(1));
			System.out.println(rs.getString(8));
			
			bookingDetailsModel=new BookingDetailsModel(userModel,trainModel,rs.getLong(3),rs.getDate(4).toLocalDate(),rs.getDate(5).toLocalDate(),rs.getInt(6),rs.getInt(7),rs.getString(8));
			
		}	
		
	} catch (ClassNotFoundException e) {
		e.getMessage();
	} catch (SQLException e) {
		e.getMessage();
	}
	
	return bookingDetailsModel;
}
	
}

package com.trainticketreservation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.trainticketreservation.connectionutil.ConnectionUtil;
import com.trainticketreservation.model.BookingDetailsModel;
import com.trainticketreservation.model.TrainModel;
import com.trainticketreservation.model.UserModel;

public class BookingDetailsDao {
public boolean bookTicket(UserModel userModel,TrainModel trainModel, BookingDetailsModel bookingDetailsModel)
{
	String bookTicketQuery="insert into booking_details(user_id,train_id,pnr_number,journey_date,ticket_count,seat_no,total_price)values(?,?,?,?,?,?)";
	Connection con;
	int result=0;
	 SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	try {
		con=ConnectionUtil.getDBconnect();
		PreparedStatement pstmt=con.prepareStatement(bookTicketQuery);
		pstmt.setInt(1, userModel.getUserId());
		pstmt.setInt(2,trainModel.getTrainId());
		pstmt.setLong(3, bookingDetailsModel.getPnrNumber());
		pstmt.setDate(4, java.sql.Date.valueOf(trainModel.getTrainDepartureTime().toLocalDate()));
		pstmt.setInt(5,bookingDetailsModel.getTicketCount());
		pstmt.setString(6,bookingDetailsModel.getSeatNo());
		pstmt.setInt(7,bookingDetailsModel.getTotalPrice());
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
	
	
}

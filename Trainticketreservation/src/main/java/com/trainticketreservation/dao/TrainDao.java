package com.trainticketreservation.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.trainticketreservation.connectionutil.ConnectionUtil;
import com.trainticketreservation.module.TrainModule;

public class TrainDao {
 public void insertTrain(TrainModule trainmodule) throws ClassNotFoundException, SQLException {
	String inserttrainquery="insert into trains (train_name,train_class,train_number,train_source,train_destination,train_departure_time,train_arraival_time,total_seat,ticket_price) values (?,?,?,?,?,?,?,?,?)";
	Connection con=ConnectionUtil.getDBconnect();
	PreparedStatement ps=con.prepareStatement(inserttrainquery);
	ps.setString(1, trainmodule.getTrainName());
	ps.setString(2, trainmodule.getTrainClass());
	ps.setInt(3, trainmodule.getTrainNumber());
	ps.setString(4,trainmodule.getTrainSource() );
	ps.setString(5,trainmodule.getTrainDestination());
	ps.setDate(6, new java.sql.Date(trainmodule.getTrainDepartureTime().getTime()));
	ps.setDate(7, new java.sql.Date(trainmodule.getTrainArraivalTime().getTime()));
	ps.setInt(8,trainmodule.getAvailability());
	ps.setInt(9,trainmodule.getTicketPrice());
	
	
	int result=ps.executeUpdate();
	System.out.println(result+ "train details inserted");
	ps.close();
	con.close();
}
 public void updatetrain(TrainModule trainmodule) {
	 String updatetrainquery="update trains set  train_name=?, train_class=?, train_source=?, train_destination=?,source_time=?, destination_time=?, total_seat=?,ticket_price=? where train_number='"+trainmodule.getTrainNumber()+"'";
	 try {
		Connection con=ConnectionUtil.getDBconnect();
	
 
 PreparedStatement ps=con.prepareStatement(updatetrainquery);
 ps.setString(1, trainmodule.getTrainName());
	ps.setString(2, trainmodule.getTrainClass());
	ps.setString(3,trainmodule.getTrainSource() );
	ps.setString(4,trainmodule.getTrainDestination());
	ps.setDate(5, new java.sql.Date(trainmodule.getTrainDepartureTime().getTime()));
	ps.setDate(6, new java.sql.Date(trainmodule.getTrainArraivalTime().getTime()));
	ps.setInt(7,trainmodule.getAvailability());
	ps.setInt(8,trainmodule.getTicketPrice());
	int result=ps.executeUpdate();
	System.out.println(result+ "train details updated");
	ps.close();
	con.close();
 }catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
 public void deletetrain(TrainModule trainmodule) {
	 String deletetrainquery="delete from trains where train_number=?";
	 try {
		Connection con=ConnectionUtil.getDBconnect();
		 PreparedStatement ps=con.prepareStatement(deletetrainquery);
		 ps.setInt(1, trainmodule.getTrainNumber());
		 int result=ps.executeUpdate();
		 System.out.println(result+ "train deleted");
		 ps.close();
		 con.close();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
 }
 public void showtrains(TrainModule trainmodule) {
	 
 }
}

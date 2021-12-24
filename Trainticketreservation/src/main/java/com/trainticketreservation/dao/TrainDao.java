package com.trainticketreservation.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.trainticketreservation.connectionutil.ConnectionUtil;
import com.trainticketreservation.model.TrainModel;
import com.trainticketreservation.model.UserModel;

public class TrainDao {

 public void insertTrain(TrainModel trainmodule) throws ClassNotFoundException, SQLException {
	 SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
	String inserttrainquery="insert into trains (train_name,train_class,train_number,train_source,train_destination,train_departure_time,train_arraival_time,total_seat,ticket_price) values (?,?,?,?,?,?,?,?,?)";
	Connection con=ConnectionUtil.getDBconnect();
	PreparedStatement ps=con.prepareStatement(inserttrainquery);
	ps.setString(1, trainmodule.getTrainName());
	ps.setString(2, trainmodule.getTrainClass());
	ps.setInt(3, trainmodule.getTrainNumber());
	ps.setString(4,trainmodule.getTrainSource() );
	ps.setString(5,trainmodule.getTrainDestination());
	Timestamp departureDateTime = Timestamp.valueOf(trainmodule.getTrainDepartureTime());
	ps.setTimestamp(6,departureDateTime );
	Timestamp arrivalDateTime = Timestamp.valueOf(trainmodule.getTrainArraivalTime());
	ps.setTimestamp(7,arrivalDateTime);
	ps.setInt(8,trainmodule.getTotalseat());
	ps.setInt(9,trainmodule.getTicketPrice());
	
	
	int result=ps.executeUpdate();
	System.out.println(result+ "train details inserted");
	ps.close();
	con.close();
}
 public void updatetrain(TrainModel trainmodule) {
	 String updatetrainquery="update trains set  train_name=?, train_class=?, train_source=?, train_destination=?,train_departure_time=?,train_arraival_time=?, total_seat=?,ticket_price=? where train_number='"+trainmodule.getTrainNumber()+"'";
	 try {
		Connection con=ConnectionUtil.getDBconnect();
	
 
 PreparedStatement ps=con.prepareStatement(updatetrainquery);
 ps.setString(1, trainmodule.getTrainName());
	ps.setString(2, trainmodule.getTrainClass());
	ps.setString(3,trainmodule.getTrainSource() );
	ps.setString(4,trainmodule.getTrainDestination());
	Timestamp departureDateTime = Timestamp.valueOf(trainmodule.getTrainDepartureTime());
	ps.setTimestamp(5,departureDateTime );
	Timestamp arrivalDateTime = Timestamp.valueOf(trainmodule.getTrainArraivalTime());
	ps.setTimestamp(6,arrivalDateTime);
	ps.setInt(7,trainmodule.getTotalseat());
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
 public void deletetrain(TrainModel trainmodule) {
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
// public void showtrains(TrainModel trainmodule) throws ClassNotFoundException, SQLException {
//	 String query ="select*from trains";
//			 Connection con=ConnectionUtil.getDBconnect();
//			 PreparedStatement ps =con.prepareStatement(query);
//			 ResultSet rs=ps.executeQuery();
//			 while(rs.next())
//			 {
//				System.out.println("\n" +rs.getInt(1)+"\n"+rs.getString(2)+"\n"+rs.getString(3)+"\n"+rs.getInt(4)+"\n"+rs.getString(5)+"\n"+rs.getString(6)+"\n"+rs.getDate(7)+"\n"+rs.getDate(8)+"\n"+rs.getInt(9)+"\n"+rs.getInt(10));
//			 }
//	
//
// }
       //to show all trains
 public List<TrainModel> showAllTrains()
 {
	 List<TrainModel> trainList = new ArrayList<TrainModel>();
	 String listquery="select*from trains";
	 Connection con=null;
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
		ps = con.prepareStatement(listquery);
		 ResultSet rs=ps.executeQuery();
		 while(rs.next())
		 {
			 TrainModel trainModel= new TrainModel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getTimestamp(7).toLocalDateTime(),rs.getTimestamp(8).toLocalDateTime(),rs.getInt(9),rs.getInt(10));
			 trainList.add(trainModel);
		 }
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return trainList;
	 
 }
//to find train id
 public static int findTrainId(TrainModel trainModel) {
 	String findTrainIdQuery="select train_id from trains where train_number = "+trainModel.getTrainNumber();
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
 	int trainId = 0;
 	try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 	try {
			ResultSet rs=stmt.executeQuery(findTrainIdQuery);
			if(rs.next()) {
				//System.out.println(rs.getInt(1));
				trainId = rs.getInt(1);
				//System.out.println(trainId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trainId;
 }
 //to find train details
 public static TrainModel findTrainDetails(int trainModel) {
	 	String findTrainDetails="select*from trains where train_number = "+trainModel;
	 	//System.out.println(findTrainDetails);
	 	Connection con = null;
	 	TrainModel trainDetail = null;
	 	Statement ps=null;
	 	
			try {
				con = ConnectionUtil.getDBconnect();
				ps= con.createStatement();
				
				 ResultSet rs=ps.executeQuery(findTrainDetails);
				 while(rs.next())
				 {
					 trainDetail= new TrainModel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getTimestamp(7).toLocalDateTime(),rs.getTimestamp(8).toLocalDateTime(),rs.getInt(9),rs.getInt(10));
					 
				 }
			}
				
			 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return trainDetail;

			
	 }
 
 
 
 
 
 
 
 
 
 
 public List<TrainModel>searchTrain(LocalDate givenDepartureDate,String source,String destination)
 {
	 String findTrain="select*from trains where to_char(train_departure_time,'yyyy-mm-dd')='"+givenDepartureDate+"'and train_source='"+source+"' and train_destination='"+destination+"'";
	 Connection con=null;
	 Statement stmt=null;
	 TrainModel trainModel;
	 List<TrainModel>trainsearchList=new ArrayList<TrainModel>();
	 
	 try {
		con=ConnectionUtil.getDBconnect();
		stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(findTrain);
		while(rs.next()) {
			trainModel = new TrainModel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getTimestamp(7).toLocalDateTime(),rs.getTimestamp(8).toLocalDateTime(),rs.getInt(9),rs.getInt(10));
			trainsearchList.add(trainModel);
	//		trainModel.toString();
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return trainsearchList;
 }
 
 
 
 
 
 //to show all train and select on user's wish date
 
 public List<TrainModel>searchAllTrain(String source,String destination)
 {
	 String findTrain="select*from trains where train_source='"+source+"' and train_destination='"+destination+"'";
	 Connection con=null;
	 Statement stmt=null;
	 TrainModel trainModel;
	 List<TrainModel>trainsearchList=new ArrayList<TrainModel>();
	 
	 try {
		con=ConnectionUtil.getDBconnect();
		stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(findTrain);
		while(rs.next()) {
			trainModel = new TrainModel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getTimestamp(7).toLocalDateTime(),rs.getTimestamp(8).toLocalDateTime(),rs.getInt(9),rs.getInt(10));
			trainsearchList.add(trainModel);
	//		trainModel.toString();
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return trainsearchList;
 }
 
 
 
 
 public List<TrainModel>searchTrain1(LocalDate givenDepartureDate1,String source2,String destination2)
 {
	 String findTrain="select*from trains where to_char(train_departure_time,'yyyy-mm-dd')='"+givenDepartureDate1+"'and train_source='"+source2+"' and train_destination='"+destination2+"'";
	 Connection con=null;
	 Statement stmt=null;
	 TrainModel trainModel;
	 List<TrainModel>trainsearchList=new ArrayList<TrainModel>();
	 
	 try {
		con=ConnectionUtil.getDBconnect();
		stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(findTrain);
		while(rs.next()) {
			trainModel = new TrainModel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getTimestamp(7).toLocalDateTime(),rs.getTimestamp(8).toLocalDateTime(),rs.getInt(9),rs.getInt(10));
			trainsearchList.add(trainModel);
	//		trainModel.toString();
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return trainsearchList;
 }
 
 
 
 
 
 
}

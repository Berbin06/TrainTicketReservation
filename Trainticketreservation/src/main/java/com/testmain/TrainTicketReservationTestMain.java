package com.testmain;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.trainticketreservation.dao.TrainDao;
import com.trainticketreservation.dao.UserDao;
import com.trainticketreservation.model.TrainModel;
import com.trainticketreservation.model.UserModel;

public class TrainTicketReservationTestMain {
	public static void main(String args []) throws ClassNotFoundException, SQLException, ParseException {
	UserDao ud=new UserDao();
	TrainDao td=new TrainDao();
	 SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
	 DateTimeFormatter format=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
	
	Scanner scan=new Scanner(System.in);
	
	boolean boo;
	while(boo=true) {
	
	System.out.println("select the operation:  ");
	System.out.println("1.To login \t");
	System.out.println("2.To Register \t");
	System.out.println("3.To update user details \t");
	System.out.println("4.To delete the user \t");
	System.out.println("5.To insert train \t");
	System.out.println("6.To update train \t");
	System.out.println("7.To show all trains");
	System.out.println("8.To show all users");
	System.out.println("9.To delete train");
	int choice=scan.nextInt();
	scan.nextLine();
	
	switch(choice)  {

	case 1: 
		//System.out.println("Enter your mobile number");
			//long UserMobileNumber=Long.parseLong(scan.nextLine());
			long UserMobileNumber=0;
			boolean mobileflag=true;
			do {
			System.out.println("enter usermobile");
			String tempMobile=scan.nextLine();
			if(tempMobile.matches("[6-9][0-9]{9}"))
			{
				UserMobileNumber=Long.parseLong(tempMobile);
			mobileflag=false;
			}
			else
			System.out.println("Invalid Mobile Number");
			}while(mobileflag);
			String password = null;
			boolean flagpswd = true;
			do {
			System.out.println("enter password");
			password = scan.nextLine();
			if (password.matches(
			"^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,15}$")) {
			flagpswd = false;
			System.out.println(password);
			} else {
			System.out.println("password must have 8 to 15 characters only \n"
			+ "contains one upper case \n" + "atleast one lower case \n"
			+ "atleast one number  \n" + "atleast one special character \n");
			}
			}while(flagpswd);
		UserModel usermodule=new UserModel(UserMobileNumber,password);
			UserDao loginud=new UserDao();
			loginud.login(usermodule);
			
	
		break;
	
		case 2:
			//To Insert 
			String userName=null;
			boolean b=true;
			do {
			System.out.println("enter fullname");
			userName=scan.nextLine();
			if(userName.matches("[A-Za-z]{3,}"))
			{
			b=false;
			}

			}
			while(b);
			String tempAge=null;
			boolean flag=true;
			int age=0;
			do {
			System.out.println("enter age");
			tempAge=scan.nextLine();
			if(tempAge.matches("[0-9]{2,3}"))
			{
			age=Integer.parseInt(tempAge);
			if(age>16 && age<=100)
			flag=false;

			}
			else
			System.out.println("Age must be greater than 16");
			}while(flag);
			String userMail;
			boolean mailFlag = true;
			do {
			System.out.println("enter email");
			userMail=scan.nextLine();
			if(userMail.matches("[a-zA_z][A-Za-z0-9]+[@][a-zA-Z]+[.][A-Za-z]{2,3}") && !userMail.endsWith("medhub.com"))
			{
			mailFlag = false;
			userMail = userMail.trim().toLowerCase();
			}
			else
			System.out.println("email should be like abc@domain.com");
			}while(mailFlag);
			//long userMobilenumber=Long.parseLong(scan.nextLine());
			long userMobilenumber=0;
			boolean mobileflaglog=true;
			do {
			System.out.println("enter usermobilenumber");
			String tempMobile=scan.nextLine();
			if(tempMobile.matches("[6-9][0-9]{9}"))
			{
				userMobilenumber=Long.parseLong(tempMobile);
			mobileflaglog=false;
			}
			else
			System.out.println("Invalid Mobile Number");
			}while(mobileflaglog);
			String userGender =null;
			boolean genderflag=false;
			do {
			System.out.println("Enter the user gender");
			 userGender=scan.nextLine();
			boolean flagpswdlog = true;
			}while(genderflag);
			String userPassword = null;
			boolean flagpswdlog = true;
			do {
			System.out.println("enter password");
			userPassword = scan.nextLine();
			if (userPassword.matches(
					"^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,15}$")) {
				flagpswdlog=false;
			
			} else {
			System.out.println("password must have 8 to 15 characters only \n"
			+ "contains one upper case \n" + "atleast one lower case \n"
			+ "atleast one number  \n" + "atleast one special character \n");
			}
			}while(flagpswdlog);
			
			UserModel usermodule1=new UserModel(userName,age,userMail,userMobilenumber,userGender,userPassword);
			ud.insert(usermodule1);
			break;
			
		case 3:
			System.out.println("To Update user details");
			System.out.println("Enter your emailid");
			String userEmail1=scan.nextLine();
			System.out.println("Enter the user name ");
			String userName1=scan.nextLine();
			System.out.println("Enter the user age ");
			int userAge1=Integer.parseInt(scan.nextLine());
			System.out.println("Enter the user mobilenumber ");
			long userMobileNumber1=Long.parseLong(scan.nextLine());
			System.out.println("Enter the user gender");
			String userGender1=scan.nextLine();
			System.out.println("Enter the user password");
			String userPassword1=scan.nextLine();
			
			UserModel usermodule11=new UserModel(  userName1,userAge1,userEmail1,userMobileNumber1,
					userGender1,userPassword1);
			ud.update(usermodule11);
			break;
			
		case 4:
			System.out.println("To Delete query");
			System.out.println("Enter the id to delete ");
			int userId=scan.nextInt();
			UserModel usermodule2=new UserModel(userId);
			ud.delete(usermodule2);
			break;
			
		case 5:
			
			System.out.println("to insert train ");
			System.out.println("Enter train name");
			String trainName=scan.nextLine();
			System.out.println("Enter train class");
			String trainClass=scan.nextLine();
			System.out.println("Enter train number");
			int trainNumber=Integer.parseInt(scan.nextLine());
			System.out.println("Enter train source");
			String trainSource=scan.nextLine();
			System.out.println("Enter train Destination");
			String trainDestination=scan.nextLine();
			System.out.println("Enter train departure time");
			String departureDate=scan.nextLine();
			LocalDateTime departureDateTime = LocalDateTime.parse(departureDate, format);
			System.out.println("Enter train arraival time");
			String arrivalDate=scan.nextLine();
			LocalDateTime arrivalDateTime = LocalDateTime.parse(arrivalDate, format);
					System.out.println("Enter total seat");
			int totalSeat=Integer.parseInt(scan.nextLine());
			System.out.println("Enter ticket price");
			int ticketPrice=Integer.parseInt(scan.nextLine());
			
			TrainModel trainmoduleinsert=new TrainModel(trainName,trainClass,trainNumber,trainSource,
		trainDestination,departureDateTime,arrivalDateTime,totalSeat,ticketPrice);
			td.insertTrain(trainmoduleinsert);
			
			break;
		case 6:
			System.out.println("Update train details");

			System.out.println("Enter train number");
			int trainNumber1=Integer.parseInt(scan.nextLine());
				System.out.println("Enter train name");
				String trainName1=scan.nextLine();
				System.out.println("Enter train class");
				String trainClass1=scan.nextLine();				
				System.out.println("Enter train source");
				String trainSource1=scan.nextLine();
				System.out.println("Enter train Destination");
				String trainDestination1=scan.nextLine();
				System.out.println("Enter train departure time");
				String departureDate1=scan.nextLine();
				LocalDateTime departureDateTime1 = LocalDateTime.parse(departureDate1, format);
				System.out.println("Enter train arraival time");
				String arrivalDate1=scan.nextLine();
				LocalDateTime arrivalDateTime1 = LocalDateTime.parse(arrivalDate1, format);
				int totalSeat1=Integer.parseInt(scan.nextLine());
				System.out.println("Enter ticket price");
				int ticketPrice1=Integer.parseInt(scan.nextLine());
				TrainModel trainmoduleupdate=new TrainModel(trainName1,trainClass1,trainNumber1,trainSource1,
						trainDestination1,departureDateTime1,arrivalDateTime1,totalSeat1,ticketPrice1);
				td.updatetrain(trainmoduleupdate);
				break;
		case 7:
			System.out.println("To view all trains");
			TrainDao listTrains = new TrainDao();
			List<TrainModel> trainList = listTrains.showAllTrains();
			for(int i=0;i<trainList.size();i++)
			{
				System.out.println(trainList.get(i));
			}
			break;
		case 8:
			System.out.println("To view all users");
			UserDao listUsers = new UserDao();
			List<UserModel> userList = listUsers.showAllUsers();
			for(int i=0;i<userList.size();i++)
			{
				System.out.println(userList.get(i));
			}
			break;
		case 9:
			System.out.println("To delete train");
			System.out.println("Enter train number to delete");
			int TrainNumber=scan.nextInt();
			TrainModel trainmodule1= new TrainModel(TrainNumber);
			td.deletetrain(trainmodule1);
			break;
	}
	
	

}
	}}


package com.testmain;

import java.sql.SQLException;
import java.util.Scanner;

import com.trainticketreservation.dao.TrainDao;
import com.trainticketreservation.dao.UserDao;
import com.trainticketreservation.module.UserModule;

public class TrainTicketReservationTestMain {
	public static void main(String args []) throws ClassNotFoundException, SQLException {
	UserDao ud=new UserDao();
	TrainDao td=new TrainDao();
	
	Scanner scan=new Scanner(System.in);
	
	boolean boo;
	while(boo=true) {
	
	System.out.println("select the operation:  ");
	System.out.println("1.To login \t");
	System.out.println("2.To Register \t");
	System.out.println("3.To update user details \t");
//	System.out.println("4.To delete the value \t");
//	System.out.println("5.To fetch the data \t");
	System.out.println("Enter your option \t");
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
		UserModule usermodule=new UserModule(UserMobileNumber,password);
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
			
			UserModule usermodule1=new UserModule(userName,age,userMail,userMobilenumber,userGender,userPassword);
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
			
			UserModule usermodule11=new UserModule(  userName1,userAge1,userEmail1,userMobileNumber1,
					userGender1,userPassword1);
			ud.update(usermodule11);
			break;
			
		case 4:
			System.out.println("To Delete query");
			System.out.println("Enter the id to delete ");
			int userId=scan.nextInt();
			UserModule usermodule2=new UserModule(userId);
			ud.delete(usermodule2);
			
		case 5:
			System.out.println("to insert train ");
			
			
			
		case 6:
			System.exit(0);
	}
	
	

}
	}}

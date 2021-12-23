package com.trainticketreservation.model;

import java.util.Objects;

public class UserModel {
	private int userId;
	private String userName;
	private int userAge;
	private String userEmail;
	private long userMobileNumber;
	private String userGender;
	private String userPassword;
	private int wallet;
	@Override
	public String toString() {
		return "UserModule [userId=" + userId + ", userName=" + userName + ", userAge=" + userAge + ", userEmail="
				+ userEmail + ", userMobileNumber=" + userMobileNumber + ", userGender=" + userGender
				+ ", userPassword=" + userPassword + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(userAge, userEmail, userGender, userId, userMobileNumber, userName, userPassword);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserModel other = (UserModel) obj;
		return userAge == other.userAge && Objects.equals(userEmail, other.userEmail)
				&& Objects.equals(userGender, other.userGender) && userId == other.userId
				&& userMobileNumber == other.userMobileNumber && Objects.equals(userName, other.userName)
				&& Objects.equals(userPassword, other.userPassword);
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserModel(int userId, String userName, int userAge, String userEmail, long userMobileNumber,
			String userGender, String userPassword) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userAge = userAge;
		this.userEmail = userEmail;
		this.userMobileNumber = userMobileNumber;
		this.userGender = userGender;
		this.userPassword = userPassword;
	}
	public UserModel(String userName1, int userAge1, long userMobileNumber1, String userGender1, String userPassword1) {
		super();
		this.userName=userName1;
		this.userAge=userAge1;
		this.userMobileNumber=userMobileNumber1;
		this.userPassword=userPassword1;
		
	}
	public UserModel(int userId2) {
		super();
		this.userId=userId2;
	}
	public UserModel(long userMobileNumber, String userPassword) {
		super();
		this.userMobileNumber = userMobileNumber;
		this.userPassword = userPassword;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public long getUserMobileNumber() {
		return userMobileNumber;
	}
	public void setUserMobileNumber(long userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public UserModel(String userName, int userAge, String userEmail, long userMobileNumber, String userGender,
			String userPassword) {
		super();
		this.userName = userName;
		this.userAge = userAge;
		this.userEmail = userEmail;
		this.userMobileNumber = userMobileNumber;
		this.userGender = userGender;
		this.userPassword = userPassword;
	}
	public UserModel(String userEmail) {
		super();
		this.userEmail = userEmail;
	}
	
	
	

}

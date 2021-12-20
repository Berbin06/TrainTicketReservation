package com.trainticketreservation.module;

import java.util.Objects;

public class AdminModule {
private int AdminId;
private String AdminName;
private String AdminPassword;
private String AdminEmail;
public int getAdminId() {
	return AdminId;
}
public void setAdminId(int adminId) {
	AdminId = adminId;
}
public String getAdminName() {
	return AdminName;
}
public void setAdminName(String adminName) {
	AdminName = adminName;
}
public String getAdminPassword() {
	return AdminPassword;
}
public void setAdminPassword(String adminPassword) {
	AdminPassword = adminPassword;
}
public String getAdminEmail() {
	return AdminEmail;
}
public void setAdminEmail(String adminEmail) {
	AdminEmail = adminEmail;
}
@Override
public int hashCode() {
	return Objects.hash(AdminEmail, AdminId, AdminName, AdminPassword);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	AdminModule other = (AdminModule) obj;
	return Objects.equals(AdminEmail, other.AdminEmail) && AdminId == other.AdminId
			&& Objects.equals(AdminName, other.AdminName) && Objects.equals(AdminPassword, other.AdminPassword);
}
@Override
public String toString() {
	return "AdminModule [AdminId=" + AdminId + ", AdminName=" + AdminName + ", AdminPassword=" + AdminPassword
			+ ", AdminEmail=" + AdminEmail + "]";
}
public AdminModule(int adminId, String adminName, String adminPassword, String adminEmail) {
	super();
	AdminId = adminId;
	AdminName = adminName;
	AdminPassword = adminPassword;
	AdminEmail = adminEmail;
}
public AdminModule() {
	super();
	// TODO Auto-generated constructor stub
}
public AdminModule(String string, String string2, String string3) {
	// TODO Auto-generated constructor stub
	this.AdminEmail=string;
	this.AdminName=string2;
	this.AdminPassword=string3;
}


}

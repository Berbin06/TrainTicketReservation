package com.trainticketreservation.model;


import java.time.LocalDate;
import java.util.Objects;

public class BookingDetailsModel {
private int bookingId;
private UserModel usermodel;
private TrainModel trainmodel;
private long pnrNumber;
private LocalDate journeyDate;
private LocalDate bookingDate;
private int ticketCount;
private String seatNo;
private int totalPrice;
private String ticketStatus;
public int getBookingId() {
	return bookingId;
}
public void setBookingId(int bookingId) {
	this.bookingId = bookingId;
}
public UserModel getUsermodel() {
	return usermodel;
}
public void setUsermodel(UserModel usermodel) {
	this.usermodel = usermodel;
}
public TrainModel getTrainmodel() {
	return trainmodel;
}
public void setTrainmodel(TrainModel trainmodel) {
	this.trainmodel = trainmodel;
}
public long getPnrNumber() {
	return pnrNumber;
}
public void setPnrNumber(long pnrNumber) {
	this.pnrNumber = pnrNumber;
}
public LocalDate getJourneyDate() {
	return journeyDate;
}
public void setJourneyDate(LocalDate journeyDate) {
	this.journeyDate = journeyDate;
}
public LocalDate getBookingDate() {
	return bookingDate;
}
public void setBookingDate(LocalDate bookingDate) {
	this.bookingDate = bookingDate;
}
public int getTicketCount() {
	return ticketCount;
}
public void setTicketCount(int ticketCount) {
	this.ticketCount = ticketCount;
}
public String getSeatNo() {
	return seatNo;
}
public void setSeatNo(String seatNo) {
	this.seatNo = seatNo;
}
public int getTotalPrice() {
	return totalPrice;
}
public void setTotalPrice(int totalPrice) {
	this.totalPrice = totalPrice;
}
public String getTicketStatus() {
	return ticketStatus;
}
public void setTicketStatus(String ticketStatus) {
	this.ticketStatus = ticketStatus;
}
@Override
public int hashCode() {
	return Objects.hash(bookingDate, bookingId, journeyDate, pnrNumber, seatNo, ticketCount, ticketStatus, totalPrice,
			trainmodel, usermodel);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	BookingDetailsModel other = (BookingDetailsModel) obj;
	return Objects.equals(bookingDate, other.bookingDate) && bookingId == other.bookingId
			&& Objects.equals(journeyDate, other.journeyDate) && pnrNumber == other.pnrNumber
			&& Objects.equals(seatNo, other.seatNo) && ticketCount == other.ticketCount
			&& Objects.equals(ticketStatus, other.ticketStatus) && totalPrice == other.totalPrice
			&& Objects.equals(trainmodel, other.trainmodel) && Objects.equals(usermodel, other.usermodel);
}
@Override
public String toString() {
	return "BookingDetailsModel [bookingId=" + bookingId + ", usermodel=" + usermodel + ", trainmodel=" + trainmodel
			+ ", pnrNumber=" + pnrNumber + ", journeyDate=" + journeyDate + ", bookingDate=" + bookingDate
			+ ", ticketCount=" + ticketCount + ", seatNo=" + seatNo + ", totalPrice=" + totalPrice + ", ticketStatus="
			+ ticketStatus + "]";
}
public BookingDetailsModel(int bookingId, UserModel usermodel, TrainModel trainmodel, long pnrNumber,
		LocalDate journeyDate, LocalDate bookingDate, int ticketCount, String seatNo, int totalPrice,
		String ticketStatus) {
	super();
	this.bookingId = bookingId;
	this.usermodel = usermodel;
	this.trainmodel = trainmodel;
	this.pnrNumber = pnrNumber;
	this.journeyDate = journeyDate;
	this.bookingDate = bookingDate;
	this.ticketCount = ticketCount;
	this.seatNo = seatNo;
	this.totalPrice = totalPrice;
	this.ticketStatus = ticketStatus;
}
public BookingDetailsModel() {
	super();
	// TODO Auto-generated constructor stub
}


}

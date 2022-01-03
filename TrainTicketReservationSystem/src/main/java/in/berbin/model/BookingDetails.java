package in.berbin.model;


import java.time.LocalDate;
import java.util.Objects;

public class BookingDetails {

private Users usermodel;
private Trains trainmodel;
private long pnrNumber;
private LocalDate journeyDate;
private LocalDate bookingDate;
private int ticketCount;
//private String seatNo;
private int totalPrice;
private String ticketStatus;



public BookingDetails() {
	super();
	// TODO Auto-generated constructor stub
}



public BookingDetails(Users usermodel, Trains trainmodel, long pnrNumber, LocalDate journeyDate,
		LocalDate bookingDate, int ticketCount, int totalPrice, String ticketStatus) {
	super();
	this.usermodel = usermodel;
	this.trainmodel = trainmodel;
	this.pnrNumber = pnrNumber;
	this.journeyDate = journeyDate;
	this.bookingDate = bookingDate;
	this.ticketCount = ticketCount;
	this.totalPrice = totalPrice;
	
	this.ticketStatus = ticketStatus;
}



public BookingDetails(Users userModel1, Trains trainModel1,LocalDate journeyDate,  int noOfPerson1, int ticketPriceForClass1) {
	this.usermodel=userModel1;
	this.trainmodel=trainModel1;
	this.journeyDate=journeyDate;
	this.ticketCount=noOfPerson1;
	this.totalPrice=ticketPriceForClass1;
}






public Users getUsermodel() {
	return usermodel;
}



public void setUsermodel(Users usermodel) {
	this.usermodel = usermodel;
}



public Trains getTrainmodel() {
	return trainmodel;
}



public void setTrainmodel(Trains trainmodel) {
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
public String toString() {
	return "BookingDetailsModel [usermodel=" + usermodel + ", trainmodel=" + trainmodel + ", pnrNumber=" + pnrNumber
			+ ", journeyDate=" + journeyDate + ", bookingDate=" + bookingDate + ", ticketCount=" + ticketCount
			+ ", totalPrice=" + totalPrice + ", ticketStatus=" + ticketStatus + "]";
}



@Override
public int hashCode() {
	return Objects.hash(bookingDate, journeyDate, pnrNumber, ticketCount, ticketStatus, totalPrice, trainmodel,
			usermodel);
}



@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	BookingDetails other = (BookingDetails) obj;
	return Objects.equals(bookingDate, other.bookingDate) && Objects.equals(journeyDate, other.journeyDate)
			&& pnrNumber == other.pnrNumber && ticketCount == other.ticketCount
			&& Objects.equals(ticketStatus, other.ticketStatus) && totalPrice == other.totalPrice
			&& Objects.equals(trainmodel, other.trainmodel) && Objects.equals(usermodel, other.usermodel);
}



}

package com.trainticketreservation.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class BookingDetailsModel{
    
	private int bookingId;
	private UserModel userModel;
	private TrainModel trainModel;
	private int pnrnumber;
	private LocalDateTime bookingDate;
	private int seatNo;
	private int ticketCount;
	private int ticketPrice;
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public UserModel getUserModel() {
		return userModel;
	}
	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
	public TrainModel getTrainModel() {
		return trainModel;
	}
	public void setTrainModel(TrainModel trainModel) {
		this.trainModel = trainModel;
	}
	public int getPnrnumber() {
		return pnrnumber;
	}
	public void setPnrnumber(int pnrnumber) {
		this.pnrnumber = pnrnumber;
	}
	public LocalDateTime getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public int getTicketCount() {
		return ticketCount;
	}
	public void setTicketCount(int ticketCount) {
		this.ticketCount = ticketCount;
	}
	public int getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	@Override
	public int hashCode() {
		return Objects.hash(bookingDate, bookingId, pnrnumber, seatNo, ticketCount, ticketPrice, trainModel, userModel);
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
				&& pnrnumber == other.pnrnumber && seatNo == other.seatNo && ticketCount == other.ticketCount
				&& ticketPrice == other.ticketPrice && Objects.equals(trainModel, other.trainModel)
				&& Objects.equals(userModel, other.userModel);
	}
	@Override
	public String toString() {
		return "BookingDetailsModel [bookingId=" + bookingId + ", userModel=" + userModel + ", trainModel=" + trainModel
				+ ", pnrnumber=" + pnrnumber + ", bookingDate=" + bookingDate + ", seatNo=" + seatNo + ", ticketCount="
				+ ticketCount + ", ticketPrice=" + ticketPrice + "]";
	}
	public BookingDetailsModel(int bookingId, UserModel userModel, TrainModel trainModel, int pnrnumber,
			LocalDateTime bookingDate, int seatNo, int ticketCount, int ticketPrice) {
		super();
		this.bookingId = bookingId;
		this.userModel = userModel;
		this.trainModel = trainModel;
		this.pnrnumber = pnrnumber;
		this.bookingDate = bookingDate;
		this.seatNo = seatNo;
		this.ticketCount = ticketCount;
		this.ticketPrice = ticketPrice;
	}
	public BookingDetailsModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

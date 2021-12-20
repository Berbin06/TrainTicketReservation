package com.trainticketreservation.module;

import java.util.Date;
import java.util.Objects;

public class bookingdetailsmodule {

	private int bookingId;
	private int pnrNumber;
	private int userId;
	private int trainId;
	private String trainSource;
	private String trainDestination;
	private Date journeyDate;
	private Date bookingDate;
	private int ticketCount;
	private int totalPrice;
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getPnrNumber() {
		return pnrNumber;
	}
	public void setPnrNumber(int pnrNumber) {
		this.pnrNumber = pnrNumber;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTrainId() {
		return trainId;
	}
	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}
	public String getTrainSource() {
		return trainSource;
	}
	public void setTrainSource(String trainSource) {
		this.trainSource = trainSource;
	}
	public String getTrainDestination() {
		return trainDestination;
	}
	public void setTrainDestination(String trainDestination) {
		this.trainDestination = trainDestination;
	}
	public Date getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
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
	@Override
	public int hashCode() {
		return Objects.hash(bookingDate, bookingId, journeyDate, pnrNumber, ticketCount, totalPrice, trainDestination,
				trainId, trainSource, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		bookingdetailsmodule other = (bookingdetailsmodule) obj;
		return Objects.equals(bookingDate, other.bookingDate) && bookingId == other.bookingId
				&& Objects.equals(journeyDate, other.journeyDate) && pnrNumber == other.pnrNumber
				&& ticketCount == other.ticketCount && totalPrice == other.totalPrice
				&& Objects.equals(trainDestination, other.trainDestination) && trainId == other.trainId
				&& Objects.equals(trainSource, other.trainSource) && userId == other.userId;
	}
	@Override
	public String toString() {
		return "bookingdetailsmodule [bookingId=" + bookingId + ", pnrNumber=" + pnrNumber + ", userId=" + userId
				+ ", trainId=" + trainId + ", trainSource=" + trainSource + ", trainDestination=" + trainDestination
				+ ", journeyDate=" + journeyDate + ", bookingDate=" + bookingDate + ", ticketCount=" + ticketCount
				+ ", totalPrice=" + totalPrice + "]";
	}
	public bookingdetailsmodule(int bookingId, int pnrNumber, int userId, int trainId, String trainSource,
			String trainDestination, Date journeyDate, Date bookingDate, int ticketCount, int totalPrice) {
		super();
		this.bookingId = bookingId;
		this.pnrNumber = pnrNumber;
		this.userId = userId;
		this.trainId = trainId;
		this.trainSource = trainSource;
		this.trainDestination = trainDestination;
		this.journeyDate = journeyDate;
		this.bookingDate = bookingDate;
		this.ticketCount = ticketCount;
		this.totalPrice = totalPrice;
	}
	public bookingdetailsmodule() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

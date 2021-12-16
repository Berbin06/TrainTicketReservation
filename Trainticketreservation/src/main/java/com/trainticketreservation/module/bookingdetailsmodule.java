package com.trainticketreservation.module;

import java.util.Date;
import java.util.Objects;

public class bookingdetailsmodule {

	private int bookingid;
	private int pnrnumber;
	private int userid;
	private int trainid;
	private String trainsource;
	private String traindestination;
	private Date journeydate;
	private Date bookingdate;
	private int ticketcount;
	private int totalprice;
	public int getBookingid() {
		return bookingid;
	}
	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}
	public int getPnrnumber() {
		return pnrnumber;
	}
	public void setPnrnumber(int pnrnumber) {
		this.pnrnumber = pnrnumber;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getTrainid() {
		return trainid;
	}
	public void setTrainid(int trainid) {
		this.trainid = trainid;
	}
	public String getTrainsource() {
		return trainsource;
	}
	public void setTrainsource(String trainsource) {
		this.trainsource = trainsource;
	}
	public String getTraindestination() {
		return traindestination;
	}
	public void setTraindestination(String traindestination) {
		this.traindestination = traindestination;
	}
	public Date getJourneydate() {
		return journeydate;
	}
	public void setJourneydate(Date journeydate) {
		this.journeydate = journeydate;
	}
	public Date getBookingdate() {
		return bookingdate;
	}
	public void setBookingdate(Date bookingdate) {
		this.bookingdate = bookingdate;
	}
	public int getTicketcount() {
		return ticketcount;
	}
	public void setTicketcount(int ticketcount) {
		this.ticketcount = ticketcount;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	@Override
	public int hashCode() {
		return Objects.hash(bookingdate, bookingid, journeydate, pnrnumber, ticketcount, totalprice, traindestination,
				trainid, trainsource, userid);
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
		return Objects.equals(bookingdate, other.bookingdate) && bookingid == other.bookingid
				&& Objects.equals(journeydate, other.journeydate) && pnrnumber == other.pnrnumber
				&& ticketcount == other.ticketcount && totalprice == other.totalprice
				&& Objects.equals(traindestination, other.traindestination) && trainid == other.trainid
				&& Objects.equals(trainsource, other.trainsource) && userid == other.userid;
	}
	@Override
	public String toString() {
		return "bookingdetailsmodule [bookingid=" + bookingid + ", pnrnumber=" + pnrnumber + ", userid=" + userid
				+ ", trainid=" + trainid + ", trainsource=" + trainsource + ", traindestination=" + traindestination
				+ ", journeydate=" + journeydate + ", bookingdate=" + bookingdate + ", ticketcount=" + ticketcount
				+ ", totalprice=" + totalprice + ", getBookingid()=" + getBookingid() + ", getPnrnumber()="
				+ getPnrnumber() + ", getUserid()=" + getUserid() + ", getTrainid()=" + getTrainid()
				+ ", getTrainsource()=" + getTrainsource() + ", getTraindestination()=" + getTraindestination()
				+ ", getJourneydate()=" + getJourneydate() + ", getBookingdate()=" + getBookingdate()
				+ ", getTicketcount()=" + getTicketcount() + ", getTotalprice()=" + getTotalprice() + ", hashCode()="
				+ hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}
	public bookingdetailsmodule(int bookingid, int pnrnumber, int userid, int trainid, String trainsource,
			String traindestination, Date journeydate, Date bookingdate, int ticketcount, int totalprice) {
		super();
		this.bookingid = bookingid;
		this.pnrnumber = pnrnumber;
		this.userid = userid;
		this.trainid = trainid;
		this.trainsource = trainsource;
		this.traindestination = traindestination;
		this.journeydate = journeydate;
		this.bookingdate = bookingdate;
		this.ticketcount = ticketcount;
		this.totalprice = totalprice;
	}
	public bookingdetailsmodule() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

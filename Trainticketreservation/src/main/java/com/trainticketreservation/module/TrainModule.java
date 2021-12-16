package com.trainticketreservation.module;

import java.util.Objects;

public class TrainModule {
private int trainid;
private String trainname;
private String trainclass;
private int trainnumber;
private String trainsource;
private String traindestination;
private String sourcetime;
private String destinationtime;
private int totalseat;
private int availableseat;
private int ticketprice;
public int getTrainid() {
	return trainid;
}
public TrainModule() {
	super();
	// TODO Auto-generated constructor stub
}
public TrainModule(int trainid, String trainname, String trainclass, int trainnumber, String trainsource,
		String traindestination, String sourcetime, String destinationtime, int totalseat, int availableseat,
		int ticketprice) {
	super();
	this.trainid = trainid;
	this.trainname = trainname;
	this.trainclass = trainclass;
	this.trainnumber = trainnumber;
	this.trainsource = trainsource;
	this.traindestination = traindestination;
	this.sourcetime = sourcetime;
	this.destinationtime = destinationtime;
	this.totalseat = totalseat;
	this.availableseat = availableseat;
	this.ticketprice = ticketprice;
}
@Override
public String toString() {
	return "TrainModule [trainid=" + trainid + ", trainname=" + trainname + ", trainclass=" + trainclass
			+ ", trainnumber=" + trainnumber + ", trainsource=" + trainsource + ", traindestination=" + traindestination
			+ ", sourcetime=" + sourcetime + ", destinationtime=" + destinationtime + ", totalseat=" + totalseat
			+ ", availableseat=" + availableseat + ", ticketprice=" + ticketprice + ", getTrainid()=" + getTrainid()
			+ ", hashCode()=" + hashCode() + ", getTrainname()=" + getTrainname() + ", getTrainclass()="
			+ getTrainclass() + ", getTrainnumber()=" + getTrainnumber() + ", getTrainsource()=" + getTrainsource()
			+ ", getTraindestination()=" + getTraindestination() + ", getSourcetime()=" + getSourcetime()
			+ ", getDestinationtime()=" + getDestinationtime() + ", getTotalseat()=" + getTotalseat()
			+ ", getAvailableseat()=" + getAvailableseat() + ", getTicketprice()=" + getTicketprice() + ", getClass()="
			+ getClass() + ", toString()=" + super.toString() + "]";
}
@Override
public int hashCode() {
	return Objects.hash(availableseat, destinationtime, sourcetime, ticketprice, totalseat, trainclass,
			traindestination, trainid, trainname, trainnumber, trainsource);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	TrainModule other = (TrainModule) obj;
	return availableseat == other.availableseat && Objects.equals(destinationtime, other.destinationtime)
			&& Objects.equals(sourcetime, other.sourcetime) && ticketprice == other.ticketprice
			&& totalseat == other.totalseat && Objects.equals(trainclass, other.trainclass)
			&& Objects.equals(traindestination, other.traindestination) && trainid == other.trainid
			&& Objects.equals(trainname, other.trainname) && trainnumber == other.trainnumber
			&& Objects.equals(trainsource, other.trainsource);
}
public void setTrainid(int trainid) {
	this.trainid = trainid;
}
public String getTrainname() {
	return trainname;
}
public void setTrainname(String trainname) {
	this.trainname = trainname;
}
public String getTrainclass() {
	return trainclass;
}
public void setTrainclass(String trainclass) {
	this.trainclass = trainclass;
}
public int getTrainnumber() {
	return trainnumber;
}
public void setTrainnumber(int trainnumber) {
	this.trainnumber = trainnumber;
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
public String getSourcetime() {
	return sourcetime;
}
public void setSourcetime(String sourcetime) {
	this.sourcetime = sourcetime;
}
public String getDestinationtime() {
	return destinationtime;
}
public void setDestinationtime(String destinationtime) {
	this.destinationtime = destinationtime;
}
public int getTotalseat() {
	return totalseat;
}
public void setTotalseat(int totalseat) {
	this.totalseat = totalseat;
}
public int getAvailableseat() {
	return availableseat;
}
public void setAvailableseat(int availableseat) {
	this.availableseat = availableseat;
}
public int getTicketprice() {
	return ticketprice;
}
public void setTicketprice(int ticketprice) {
	this.ticketprice = ticketprice;
}

}

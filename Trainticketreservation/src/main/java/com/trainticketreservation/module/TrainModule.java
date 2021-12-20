package com.trainticketreservation.module;


import java.util.Date;
import java.util.Objects;

public class TrainModule {
private int trainId;
private String trainName;
private String trainClass;
private int trainNumber;
private String trainSource;
private String trainDestination;
private Date trainDepartureTime;
private Date trainArraivalTime;
private int availability;
private int ticketPrice;
public int getTrainId() {
	return trainId;
}
public void setTrainId(int trainId) {
	this.trainId = trainId;
}
public String getTrainName() {
	return trainName;
}
public void setTrainName(String trainName) {
	this.trainName = trainName;
}
public String getTrainClass() {
	return trainClass;
}
public void setTrainClass(String trainClass) {
	this.trainClass = trainClass;
}
public int getTrainNumber() {
	return trainNumber;
}
public void setTrainNumber(int trainNumber) {
	this.trainNumber = trainNumber;
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
public Date getTrainDepartureTime() {
	return trainDepartureTime;
}
public void setTrainDepartureTime(Date trainDepartureTime) {
	this.trainDepartureTime = trainDepartureTime;
}
public Date getTrainArraivalTime() {
	return trainArraivalTime;
}
public void setTrainArraivalTime(Date trainArraivalTime) {
	this.trainArraivalTime = trainArraivalTime;
}
public int getAvailability() {
	return availability;
}
public void setAvailability(int availability) {
	this.availability = availability;
}
public int getTicketPrice() {
	return ticketPrice;
}
public void setTicketPrice(int ticketPrice) {
	this.ticketPrice = ticketPrice;
}
@Override
public int hashCode() {
	return Objects.hash(availability, ticketPrice, trainArraivalTime, trainClass, trainDepartureTime, trainDestination,
			trainId, trainName, trainNumber, trainSource);
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
	return availability == other.availability && ticketPrice == other.ticketPrice
			&& Objects.equals(trainArraivalTime, other.trainArraivalTime)
			&& Objects.equals(trainClass, other.trainClass)
			&& Objects.equals(trainDepartureTime, other.trainDepartureTime)
			&& Objects.equals(trainDestination, other.trainDestination) && trainId == other.trainId
			&& Objects.equals(trainName, other.trainName) && trainNumber == other.trainNumber
			&& Objects.equals(trainSource, other.trainSource);
}
@Override
public String toString() {
	return "TrainModule [trainId=" + trainId + ", trainName=" + trainName + ", trainClass=" + trainClass
			+ ", trainNumber=" + trainNumber + ", trainSource=" + trainSource + ", trainDestination=" + trainDestination
			+ ", trainDepartureTime=" + trainDepartureTime + ", trainArraivalTime=" + trainArraivalTime
			+ ", availability=" + availability + ", ticketPrice=" + ticketPrice + "]";
}
public TrainModule(int trainId, String trainName, String trainClass, int trainNumber, String trainSource,
		String trainDestination, Date trainDepartureTime, Date trainArraivalTime, int availability, int ticketPrice) {
	super();
	this.trainId = trainId;
	this.trainName = trainName;
	this.trainClass = trainClass;
	this.trainNumber = trainNumber;
	this.trainSource = trainSource;
	this.trainDestination = trainDestination;
	this.trainDepartureTime = trainDepartureTime;
	this.trainArraivalTime = trainArraivalTime;
	this.availability = availability;
	this.ticketPrice = ticketPrice;
}
public TrainModule() {
	super();
	// TODO Auto-generated constructor stub
}


}
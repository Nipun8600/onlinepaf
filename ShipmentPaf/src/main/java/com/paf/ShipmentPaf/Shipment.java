package com.paf.ShipmentPaf;

import javax.xml.bind.annotation.XmlRootElement;

//import java.sql.Date;

@XmlRootElement
public class Shipment {
	
	private int shipId;
	private String date;
	private String destination;
	
	
	public int getShipId() {
		return shipId;
	}
	public void setShipId(int shipId) {
		this.shipId = shipId;
	}
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	@Override
	public String toString() {
		return "Shipment [shipId=" + shipId + ", date=" + date + ", destination=" + destination + "]";
	}
	
	
	
}

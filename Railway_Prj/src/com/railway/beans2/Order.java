/**
 * 
 */
package com.railway.beans2;

import java.util.Calendar;


/**
 * @author Aleh_Litvinau
 */
public class Order {
	
	private int id;
	
	private Passenger passenger;
	private Calendar date;
	private String from;
	private String to;
	
	private Route route;
	private int price;
	private boolean pay;
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isPay() {
		return pay;
	}
	public void setPay(boolean pay) {
		this.pay = pay;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}

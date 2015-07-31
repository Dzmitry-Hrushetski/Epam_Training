/**
 * 
 */
package com.epam.web.aircompany.bean;

import java.util.GregorianCalendar;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class Route extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8426647497365969985L;
	private Airport departureAirport;
	private Airport arrivalAirport;
	private Airplane airplane;
	private Crew crew;
	private GregorianCalendar departure;
	private GregorianCalendar arrival;
	
	/**
	 * @return the departureAirport
	 */
	public Airport getDepartureAirport() {
		return departureAirport;
	}
	/**
	 * @param departureAirport the departureAirport to set
	 */
	public void setDepartureAirport(Airport departureAirport) {
		this.departureAirport = departureAirport;
	}
	/**
	 * @return the arrivalAirport
	 */
	public Airport getArrivalAirport() {
		return arrivalAirport;
	}
	/**
	 * @param arrivalAirport the arrivalAirport to set
	 */
	public void setArrivalAirport(Airport arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}
	/**
	 * @return the airplane
	 */
	public Airplane getAirplane() {
		return airplane;
	}
	/**
	 * @param airplane the airplane to set
	 */
	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
	}
	/**
	 * @return the crew
	 */
	public Crew getCrew() {
		return crew;
	}
	/**
	 * @param crew the crew to set
	 */
	public void setCrew(Crew crew) {
		this.crew = crew;
	}
	/**
	 * @return the departure
	 */
	public GregorianCalendar getDeparture() {
		return departure;
	}
	/**
	 * @param departure the departure to set
	 */
	public void setDeparture(GregorianCalendar departure) {
		this.departure = departure;
	}
	/**
	 * @return the arrival
	 */
	public GregorianCalendar getArrival() {
		return arrival;
	}
	/**
	 * @param arrival the arrival to set
	 */
	public void setArrival(GregorianCalendar arrival) {
		this.arrival = arrival;
	}
	
}

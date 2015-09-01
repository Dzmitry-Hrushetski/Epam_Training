package com.epam.aircompany.bean;

import java.util.GregorianCalendar;

/**
 * The Class Route is a Java Bean that contains information on number of flight, date/time of embarkation and an arrival, airport of departure and an arrival, the airplane, crew.
 *
 * @author Dzmitry Hrushetski
 */
public class Route extends Entity {
	private static final long serialVersionUID = -8426647497365969985L;
	private Airport departureAirport;
	private Airport arrivalAirport;
	private Airplane airplane;
	private Crew crew;
	private GregorianCalendar departure;
	private GregorianCalendar arrival;
	private String routeNumber;
	
	/**
	 * Gets the departure airport.
	 *
	 * @return Airport
	 * @see com.epam.aircompany.bean.Airport
	 */
	public Airport getDepartureAirport() {
		return departureAirport;
	}
	
	/**
	 * Sets the departure airport.
	 *
	 * @param Airport
	 * @see com.epam.aircompany.bean.Airport
	 */
	public void setDepartureAirport(Airport departureAirport) {
		this.departureAirport = departureAirport;
	}
	
	/**
	 * Gets the arrival airport.
	 *
	 * @return Airport
	 * @see com.epam.aircompany.bean.Airport
	 */
	public Airport getArrivalAirport() {
		return arrivalAirport;
	}
	
	/**
	 * Sets the arrival airport.
	 *
	 * @param Airport
	 * @see com.epam.aircompany.bean.Airport
	 */
	public void setArrivalAirport(Airport arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}
	
	/**
	 * Gets the airplane.
	 *
	 * @return Airplane
	 * @see com.epam.aircompany.bean.Airplane
	 */
	public Airplane getAirplane() {
		return airplane;
	}
	
	/**
	 * Sets the airplane.
	 *
	 * @param Airplane
	 * @see com.epam.aircompany.bean.Airplane
	 */
	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
	}
	
	/**
	 * Gets the crew.
	 *
	 * @return Crew
	 * @see com.epam.aircompany.bean.Crew
	 */
	public Crew getCrew() {
		return crew;
	}
	
	/**
	 * Sets the crew.
	 *
	 * @param Crew
	 * @see com.epam.aircompany.bean.Crew
	 */
	public void setCrew(Crew crew) {
		this.crew = crew;
	}
	
	/**
	 * Gets the departure date and time.
	 *
	 * @return GregorianCalendar
	 */
	public GregorianCalendar getDeparture() {
		return departure;
	}
	
	/**
	 * Sets the departure date and time.
	 *
	 * @param GregorianCalendar
	 */
	public void setDeparture(GregorianCalendar departure) {
		this.departure = departure;
	}
	
	/**
	 * Gets the arrival date and time.
	 *
	 * @return GregorianCalendar
	 */
	public GregorianCalendar getArrival() {
		return arrival;
	}
	
	/**
	 * Sets the arrival date and time.
	 *
	 * @param GregorianCalendar
	 */
	public void setArrival(GregorianCalendar arrival) {
		this.arrival = arrival;
	}
	
	/**
	 * Gets the route number.
	 *
	 * @return the route number
	 */
	public String getRouteNumber() {
		return routeNumber;
	}
	
	/**
	 * Sets the route number.
	 *
	 * @param routeNumber the new route number
	 */
	public void setRouteNumber(String routeNumber) {
		this.routeNumber = routeNumber;
	}
}

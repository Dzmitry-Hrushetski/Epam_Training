/**
 * 
 */
package com.epam.aircompany.bean;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class Airport extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8213532884205059798L;
	private City city;
	private String airportName;
	private String iataCode;
	private String icaoCode;
	/**
	 * @return the city
	 */
	public City getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(City city) {
		this.city = city;
	}
	/**
	 * @return the airportName
	 */
	public String getAirportName() {
		return airportName;
	}
	/**
	 * @param airportName the airportName to set
	 */
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	/**
	 * @return the iataCode
	 */
	public String getIataCode() {
		return iataCode;
	}
	/**
	 * @param iataCode the iataCode to set
	 */
	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}
	/**
	 * @return the icaoCode
	 */
	public String getIcaoCode() {
		return icaoCode;
	}
	/**
	 * @param icaoCode the icaoCode to set
	 */
	public void setIcaoCode(String icaoCode) {
		this.icaoCode = icaoCode;
	}
}

package com.epam.aircompany.bean;

/**
 * The Class Airport is a Java Bean that contains a name of the airport and its international codes.
 *
 * @author Dzmitry Hrushetski
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
	 * Gets the city.
	 *
	 * @return City
	 * @see com.epam.aircompany.bean.City
	 */
	public City getCity() {
		return city;
	}
	
	/**
	 * Sets the city.
	 *
	 * @param city the new City
	 * @see com.epam.aircompany.bean.City
	 */
	public void setCity(City city) {
		this.city = city;
	}
	
	/**
	 * Gets the airport name.
	 *
	 * @return the airport name
	 */
	public String getAirportName() {
		return airportName;
	}
	
	/**
	 * Sets the airport name.
	 *
	 * @param airportName the new airport name
	 */
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	
	/**
	 * Gets the international iata code.
	 *
	 * @return the iata code
	 */
	public String getIataCode() {
		return iataCode;
	}
	
	/**
	 * Sets the international iata code.
	 *
	 * @param iataCode the new iata code
	 */
	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}
	
	/**
	 * Gets the international icao code.
	 *
	 * @return the icao code
	 */
	public String getIcaoCode() {
		return icaoCode;
	}
	
	/**
	 * Sets the international icao code.
	 *
	 * @param icaoCode the new icao code
	 */
	public void setIcaoCode(String icaoCode) {
		this.icaoCode = icaoCode;
	}
}

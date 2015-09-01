package com.epam.aircompany.bean;

/**
 * The Class City is a Java Bean that contains a name of the city in which the airport is located.
 *
 * @author Dzmitry Hrushetski
 */
public class City extends Entity {
	private static final long serialVersionUID = -4792809552297087208L;
	private String cityName;
	
	/**
	 * Gets the city name.
	 *
	 * @return the city name
	 */
	public String getCityName() {
		return cityName;
	}
	
	/**
	 * Sets the city name.
	 *
	 * @param cityName the new city name
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
}

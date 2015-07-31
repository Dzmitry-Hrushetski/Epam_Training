/**
 * 
 */
package com.epam.web.aircompany.bean;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class City extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4792809552297087208L;
	private String cityName;
	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}
	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
}

package com.epam.aircompany.bean;

import java.util.HashMap;

/**
 * The Class CompositionCrew is a Java Bean that contains information on number of crew members for specific type of the airplane.
 *
 * @author Dzmitry Hrushetski
 */
public class CompositionCrew extends Entity {
	private static final long serialVersionUID = 1905339389654368810L;
	private AirplaneType airplaneType;
	private HashMap<Integer,Integer> crew;
	
	/**
	 * Gets the airplane type.
	 *
	 * @return AirplaneType
	 * @see com.epam.aircompany.bean.AirplaneType
	 */
	public AirplaneType getAirplaneType() {
		return airplaneType;
	}
	
	/**
	 * Sets the airplane type.
	 *
	 * @param AirplaneType the new airplane type
	 * @see com.epam.aircompany.bean.AirplaneType
	 */
	public void setAirplaneType(AirplaneType airplaneType) {
		this.airplaneType = airplaneType;
	}
	
	/**
	 * Gets HashMap in which key is position ID, value - number of employees.
	 *
	 * @return the HashMap<Integer,Integer> 
	 */
	public HashMap<Integer,Integer> getCrew() {
		return crew;
	}
	
	/**
	 * Sets HashMap in which key is position ID, value - number of employees.
	 *
	 * @param HashMap<Integer,Integer>
	 */
	public void setCrew(HashMap<Integer,Integer> crew) {
		this.crew = crew;
	} 
}

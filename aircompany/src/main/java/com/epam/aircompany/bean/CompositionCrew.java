/**
 * 
 */
package com.epam.aircompany.bean;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class CompositionCrew extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1905339389654368810L;
	private AirplaneType airplaneType;
	private HashMap<Integer,Integer> crew;
	
	/**
	 * @return the airplaneType
	 */
	public AirplaneType getAirplaneType() {
		return airplaneType;
	}
	/**
	 * @param airplaneType the airplaneType to set
	 */
	public void setAirplaneType(AirplaneType airplaneType) {
		this.airplaneType = airplaneType;
	}
	/**
	 * @return the crew
	 */
	public HashMap<Integer,Integer> getCrew() {
		return crew;
	}
	/**
	 * @param crew the crew to set
	 */
	public void setCrew(HashMap<Integer,Integer> crew) {
		this.crew = crew;
	} 
}

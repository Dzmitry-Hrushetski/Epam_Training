/**
 * 
 */
package com.epam.web.aircompany.bean;

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
	private HashSet<Position> crew;
	
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
	public HashSet<Position> getCrew() {
		return crew;
	}
	/**
	 * @param crew the crew to set
	 */
	public void setCrew(HashSet<Position> crew) {
		this.crew = crew;
	} 
}

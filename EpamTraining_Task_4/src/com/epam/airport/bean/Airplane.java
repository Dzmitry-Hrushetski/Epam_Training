/**
 * 
 */
package com.epam.airport.bean;


/**
 * @author Dzmitry Hrushetski
 *
 */
public class Airplane {
	private int passangerCount;
	private int airplaneID;

	/**
	 * @param passangerCount
	 * @param airplaneID
	 */
	public Airplane(int passangerCount, int airplaneID) {
		super();
		this.passangerCount = passangerCount;
		this.airplaneID = airplaneID;
	}

	/**
	 * @return the passangerCount
	 */
	public int getPassangerCount() {
		return passangerCount;
	}

	/**
	 * @param passangerCount the passangerCount to set
	 */
	public void setPassangerCount(int passangerCount) {
		this.passangerCount = passangerCount;
	}

	/**
	 * @return the airplaneID
	 */
	public int getAirplaneID() {
		return airplaneID;
	}
}

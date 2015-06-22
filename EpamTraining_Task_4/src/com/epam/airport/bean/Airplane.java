/**
 * 
 */
package com.epam.airport.bean;

import com.epam.airport.creator.CodeGenerator;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class Airplane {
	private int passangerCount;
	private int airplaneID;

	/**
	 * @param passangerCount
	 */
	public Airplane(int passangerCount) {
		super();
		this.passangerCount = passangerCount;
		airplaneID=CodeGenerator.getInstance().nextAirplaneNumber();
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

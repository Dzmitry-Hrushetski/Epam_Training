/**
 * 
 */
package com.epam.aircompany.beans;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class Airplane {
	private AirplaneModelName modelName;
	private int boardNumber;
	private int flyingRange;
	private int capacityFuelTank;
	private int fuelUsage;
	private int maxLoadCapacity;

	
	
	
	
	@Override
	public String toString() {
		return "Airplane [modelName=" + modelName + ", boardNumber="
				+ boardNumber + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + boardNumber;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Airplane other = (Airplane) obj;
		if (boardNumber != other.boardNumber)
			return false;
		return true;
	}
}

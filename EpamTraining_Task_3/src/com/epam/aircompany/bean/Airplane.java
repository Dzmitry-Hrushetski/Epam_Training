/**
 * 
 */
package com.epam.aircompany.bean;

import com.epam.aircompany.exeption.LogicalExeption;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class Airplane implements Comparable<Airplane>{
	private static final String MESSAGE_TO_STRING="Airplane %s, board number - %d, flying range %d";
	private AirplaneModelName modelName;
	private int boardNumber;
	private int flyingRange;
	private int capacityFuelTank;
	private int fuelUsage;
	private int maxLoadCapacity;
	
	public Airplane(AirplaneModelName modelName, int boardNumber,
			int flyingRange, int capacityFuelTank, int maxLoadCapacity) {
		
		super();
		this.modelName = modelName;
		this.boardNumber = boardNumber;
		this.flyingRange = flyingRange;
		this.capacityFuelTank = capacityFuelTank;
		this.maxLoadCapacity = maxLoadCapacity;
	}
	
	public int getFuelUsage() {
		return fuelUsage;
	}

	public void setFuelUsage(int fuelUsage) {
		this.fuelUsage = fuelUsage;
	}	
	
	public AirplaneModelName getModelName() {
		return modelName;
	}

	public int getBoardNumber() {
		return boardNumber;
	}

	public int getFlyingRange() {
		return flyingRange;
	}

	public int getCapacityFuelTank() {
		return capacityFuelTank;
	}

	public int getMaxLoadCapacity() {
		return maxLoadCapacity;
	}

	@Override
	public String toString() {
		return String.format(MESSAGE_TO_STRING, modelName, boardNumber, flyingRange);
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
		if (this == obj){
			return true;
		}
		if (obj == null){
			return false;
		}
		if (getClass() != obj.getClass()){
			return false;
		}
		Airplane other = (Airplane) obj;
		if (boardNumber != other.boardNumber){
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Airplane o) {
		if(o==null){
			return -1;
		}else {
			return flyingRange-o.flyingRange;
		}	
	}
}

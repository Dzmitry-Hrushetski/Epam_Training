/**
 * 
 */
package com.epam.aircompany.beans;

import com.epam.aircompany.exeptions.LogicalExeptions;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class Airplane {
	private static final int MIN_BOARD_NUMBER=1;
	private static final int MIN_FLYING_RANGE=100;
	private static final int MIN_CAP_FUEL_TANK=1;
	private static final int MIN_LOAD_CAPACITY=1;
	private static final int MIN_FUEL_USAGE=10;
	private static final int MAX_FUEL_USAGE=10_000;
	private static final int DEFAULT_FUEL_USAGE=200;
	private AirplaneModelName modelName;
	private int boardNumber;
	private int flyingRange;
	private int capacityFuelTank;
	private int fuelUsage;
	private int maxLoadCapacity;

	
	
	
	
	
	public int getFuelUsage() {
		return fuelUsage;
	}

	public void setFuelUsage(int fuelUsage) {
		if(MIN_FUEL_USAGE<=fuelUsage && fuelUsage<=MAX_FUEL_USAGE){
			this.fuelUsage = fuelUsage;
		} else{
			this.fuelUsage = DEFAULT_FUEL_USAGE;
		}
	}	
	
	public Airplane(AirplaneModelName modelName, int boardNumber,
			int flyingRange, int capacityFuelTank, int maxLoadCapacity) throws LogicalExeptions {
		
		super();
		this.modelName = modelName;
		
		if(MIN_BOARD_NUMBER<=boardNumber){
			this.boardNumber = boardNumber;
		} else{
			throw new LogicalExeptions("Incorrect boardNumber value");
		}
		
		if(flyingRange>=MIN_FLYING_RANGE){
			this.flyingRange = flyingRange;
		} else{
			throw new LogicalExeptions("Incorrect flyingRange value");
		}
		
		if(capacityFuelTank>=MIN_CAP_FUEL_TANK){
			this.capacityFuelTank = capacityFuelTank;
		} else{
			throw new LogicalExeptions("Incorrect capacityFuelTank value");
		}
		
		if(maxLoadCapacity>=MIN_LOAD_CAPACITY){
			this.maxLoadCapacity = maxLoadCapacity;
		} else{
			throw new LogicalExeptions("Incorrect maxLoadCapacity value");
		}		
	}

	@Override
	public String toString() {
		return "Airplane " + modelName + ", board number - "
				+ boardNumber;
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

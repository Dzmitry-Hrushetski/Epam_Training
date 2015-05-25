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
	private static final String AIRPLANE_STRING="Airplane %s, board number - %d, flying range %d";
	
	private AirplaneModelName modelName;
	private int boardNumber;
	private int flyingRange;
	private int capacityFuelTank;
	private int fuelUsage;
	private int maxLoadCapacity;

	
	
	public Airplane(AirplaneModelName modelName, int boardNumber,
			int flyingRange, int capacityFuelTank, int maxLoadCapacity) throws LogicalExeption {
		
		super();
		this.modelName = modelName;
		
		if(ConstantsBean.MIN_BOARD_NUMBER<=boardNumber){
			this.boardNumber = boardNumber;
		} else{
			throw new LogicalExeption("Incorrect boardNumber value");
		}
		
		if(flyingRange>=ConstantsBean.MIN_FLYING_RANGE){
			this.flyingRange = flyingRange;
		} else{
			throw new LogicalExeption("Incorrect flyingRange value");
		}
		
		if(capacityFuelTank>=ConstantsBean.MIN_CAP_FUEL_TANK){
			this.capacityFuelTank = capacityFuelTank;
		} else{
			throw new LogicalExeption("Incorrect capacityFuelTank value");
		}
		
		if(maxLoadCapacity>=ConstantsBean.MIN_LOAD_CAPACITY){
			this.maxLoadCapacity = maxLoadCapacity;
		} else{
			throw new LogicalExeption("Incorrect maxLoadCapacity value");
		}		
	}
	
	
	public int getFuelUsage() {
		return fuelUsage;
	}

	public void setFuelUsage(int fuelUsage) {
		if(ConstantsBean.MIN_FUEL_USAGE<=fuelUsage && fuelUsage<=ConstantsBean.MAX_FUEL_USAGE){
			this.fuelUsage = fuelUsage;
		} else{
			this.fuelUsage = ConstantsBean.DEFAULT_FUEL_USAGE;
		}
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
		return String.format(AIRPLANE_STRING, modelName, boardNumber, flyingRange);
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

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Airplane o) {
		if(o==null){
			return -1;
		}else{
			return flyingRange-o.flyingRange;
		}
		
	}
}

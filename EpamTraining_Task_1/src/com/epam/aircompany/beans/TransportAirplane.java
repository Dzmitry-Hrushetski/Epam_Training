/**
 * 
 */
package com.epam.aircompany.beans;

import com.epam.aircompany.exeptions.LogicalExeptions;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class TransportAirplane extends Airplane{
	private static final int MIN_CARGO_VALUE=1;
	private int cargoLong;
	private int cargoWidth;
	private int cargoHeight;
	private int maxCargoWeight;
	private int curCargoWeight;
	private int cargoHatchWidth;
	private int cargoHatchHeight;
	
	
	
	
	public int getCurCargoWeight() {
		return curCargoWeight;
	}




	public void setCurCargoWeight(int curCargoWeight) throws LogicalExeptions {
		
		if(curCargoWeight>=MIN_CARGO_VALUE){
			this.curCargoWeight = curCargoWeight;
		} else{
			throw new LogicalExeptions("Incorrect curCargoWeight value");
		}	
	}




	public TransportAirplane(AirplaneModelName modelName, int boardNumber,
			int flyingRange, int capacityFuelTank, int maxLoadCapacity,
			int cargoLong, int cargoWidth, int cargoHeight, int maxCargoWeight,
			int cargoHatchWidth, int cargoHatchHeight) throws LogicalExeptions {
		
		super(modelName, boardNumber, flyingRange, capacityFuelTank,
				maxLoadCapacity);
		
		if(cargoLong>=MIN_CARGO_VALUE){
			this.cargoLong = cargoLong;
		} else{
			throw new LogicalExeptions("Incorrect cargoLong value");
		}
		
		if(cargoWidth>=MIN_CARGO_VALUE){
			this.cargoWidth = cargoWidth;
		} else{
			throw new LogicalExeptions("Incorrect cargoWidth value");
		}
		
		if(cargoHeight>=MIN_CARGO_VALUE){
			this.cargoHeight = cargoHeight;
		} else{
			throw new LogicalExeptions("Incorrect cargoHeight value");
		}
		
		if(maxCargoWeight>=MIN_CARGO_VALUE){
			this.maxCargoWeight = maxCargoWeight;
		} else{
			throw new LogicalExeptions("Incorrect maxCargoWeight value");
		}
		
		if(cargoHatchWidth>=MIN_CARGO_VALUE){
			this.cargoHatchWidth = cargoHatchWidth;
		} else{
			throw new LogicalExeptions("Incorrect cargoHatchWidth value");
		}
		
		if(cargoHatchHeight>=MIN_CARGO_VALUE){
			this.cargoHatchHeight = cargoHatchHeight;
		} else{
			throw new LogicalExeptions("Incorrect cargoHatchHeighth value");
		}
	}
}

/**
 * 
 */
package com.epam.aircompany.bean;

import com.epam.aircompany.exeption.LogicalExeption;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class TransportAirplane extends Airplane{
	private int cargoLong;
	private int cargoWidth;
	private int cargoHeight;
	private int maxCargoWeight;
	private int curCargoWeight;
	private int cargoHatchWidth;
	private int cargoHatchHeight;
	
	public TransportAirplane(AirplaneModelName modelName, int boardNumber,
			int flyingRange, int capacityFuelTank, int maxLoadCapacity,
			int cargoLong, int cargoWidth, int cargoHeight, int maxCargoWeight,
			int cargoHatchWidth, int cargoHatchHeight) throws LogicalExeption {
		
		super(modelName, boardNumber, flyingRange, capacityFuelTank,
				maxLoadCapacity);
		
		if(cargoLong>=ConstantsBean.MIN_CARGO_VALUE){
			this.cargoLong = cargoLong;
		} else {
			throw new LogicalExeption("Incorrect cargoLong value");
		}
		
		if(cargoWidth>=ConstantsBean.MIN_CARGO_VALUE){
			this.cargoWidth = cargoWidth;
		} else {
			throw new LogicalExeption("Incorrect cargoWidth value");
		}
		
		if(cargoHeight>=ConstantsBean.MIN_CARGO_VALUE){
			this.cargoHeight = cargoHeight;
		} else {
			throw new LogicalExeption("Incorrect cargoHeight value");
		}
		
		if(maxCargoWeight>=ConstantsBean.MIN_CARGO_VALUE){
			this.maxCargoWeight = maxCargoWeight;
		} else {
			throw new LogicalExeption("Incorrect maxCargoWeight value");
		}
		
		if(cargoHatchWidth>=ConstantsBean.MIN_CARGO_VALUE){
			this.cargoHatchWidth = cargoHatchWidth;
		} else {
			throw new LogicalExeption("Incorrect cargoHatchWidth value");
		}
		
		if(cargoHatchHeight>=ConstantsBean.MIN_CARGO_VALUE){
			this.cargoHatchHeight = cargoHatchHeight;
		} else {
			throw new LogicalExeption("Incorrect cargoHatchHeighth value");
		}
	}
		
	public int getCurCargoWeight() {
		return curCargoWeight;
	}

	public void setCurCargoWeight(int curCargoWeight) throws LogicalExeption {
		
		if(curCargoWeight>=ConstantsBean.MIN_CARGO_VALUE){
			this.curCargoWeight = curCargoWeight;
		} else {
			throw new LogicalExeption("Incorrect curCargoWeight value");
		}	
	}

	public int getCargoLong() {
		return cargoLong;
	}

	public int getCargoWidth() {
		return cargoWidth;
	}

	public int getCargoHeight() {
		return cargoHeight;
	}

	public int getMaxCargoWeight() {
		return maxCargoWeight;
	}

	public int getCargoHatchWidth() {
		return cargoHatchWidth;
	}

	public int getCargoHatchHeight() {
		return cargoHatchHeight;
	}
}

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
			int cargoHatchWidth, int cargoHatchHeight) {
		
		super(modelName, boardNumber, flyingRange, capacityFuelTank,
				maxLoadCapacity);
		
		this.cargoLong = cargoLong;
		this.cargoWidth = cargoWidth;
		this.cargoHeight = cargoHeight;
		this.maxCargoWeight = maxCargoWeight;
		this.cargoHatchWidth = cargoHatchWidth;
		this.cargoHatchHeight = cargoHatchHeight;
	}
		
	public int getCurCargoWeight() {
		return curCargoWeight;
	}

	public void setCurCargoWeight(int curCargoWeight) {
		this.curCargoWeight = curCargoWeight;
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

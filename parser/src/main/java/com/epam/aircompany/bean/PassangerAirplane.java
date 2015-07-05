/**
 * 
 */
package com.epam.aircompany.bean;


/**
 * @author Dzmitry Hrushetski
 *
 */
public class PassangerAirplane extends Airplane {
	private int economPlace;
	private int businessPlace;
	private int maxBaggagePlace;
	private int maxBaggageWeight;
	private int curBaggagePlace;
	private int curBaggageWeight;
	
	public PassangerAirplane(AirplaneModelName modelName, int boardNumber,
			int flyingRange, int capacityFuelTank, int maxLoadCapacity,
			int maxBaggagePlace, int maxBaggageWeight) {
		
		super(modelName, boardNumber, flyingRange, capacityFuelTank,
				maxLoadCapacity);
		
		this.maxBaggagePlace = maxBaggagePlace;
		this.maxBaggageWeight = maxBaggageWeight;
	}
	
	public int getEconomPlace() {
		return economPlace;
	}

	public void setEconomPlace(int economPlace) {
		this.economPlace = economPlace;
	}

	public int getBusinessPlace() {
		return businessPlace;
	}

	public void setBusinessPlace(int businessPlace) {
		this.businessPlace = businessPlace;
	}

	public int getCurBaggagePlace() {
		return curBaggagePlace;
	}

	public void setCurBaggagePlace(int curBaggagePlace) {
		this.curBaggagePlace = curBaggagePlace;
	}

	public int getCurBaggageWeight() {
		return curBaggageWeight;
	}

	public void setCurBaggageWeight(int curBaggageWeight) {
		this.curBaggageWeight = curBaggageWeight;
	}

	public int getMaxBaggagePlace() {
		return maxBaggagePlace;
	}

	public int getMaxBaggageWeight() {
		return maxBaggageWeight;
	}
}

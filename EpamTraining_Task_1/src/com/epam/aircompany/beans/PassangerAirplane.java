/**
 * 
 */
package com.epam.aircompany.beans;

import com.epam.aircompany.exeptions.LogicalExeptions;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class PassangerAirplane extends Airplane {
	private static final int MAX_BAGGAGE_PLACE=100;
	private static final int MAX_BAGGAGE_WEIGHT=10_000;
	private int economPlace;
	private int businessPlace;
	private int maxBaggagePlace;
	private int maxBaggageWeight;
	private int curBaggagePlace;
	private int curBaggageWeight;
	
	
	
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



	public PassangerAirplane(AirplaneModelName modelName, int boardNumber,
			int flyingRange, int capacityFuelTank, int maxLoadCapacity,
			int maxBaggagePlace, int maxBaggageWeight) throws LogicalExeptions {
		
		super(modelName, boardNumber, flyingRange, capacityFuelTank,
				maxLoadCapacity);
		
		if(maxBaggagePlace<=MAX_BAGGAGE_PLACE){
			this.maxBaggagePlace = maxBaggagePlace;
		} else{
			throw new LogicalExeptions("Incorrect maxBaggagePlace value");
		}
		
		if(maxBaggageWeight<=MAX_BAGGAGE_WEIGHT){
			this.maxBaggageWeight = maxBaggageWeight;
		} else{
			throw new LogicalExeptions("Incorrect maxBaggageWeight value");
		}	
	}
}

/**
 * 
 */
package com.railway.beans;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class Train {

	private int numberTrain;
	private int totalPlaces;
	private int freelyPlaces;
	private Route route;
	
	
	
	
	
	
	public int getNumberTrain() {
		return numberTrain;
	}
	public void setNumberTrain(int numberTrain) {
		this.numberTrain = numberTrain;
	}
	public int getTotalPlaces() {
		return totalPlaces;
	}
	public void setTotalPlaces(int totalPlaces) {
		this.totalPlaces = totalPlaces;
	}
	public int getFreelyPlaces() {
		return freelyPlaces;
	}
	public void setFreelyPlaces(int freelyPlaces) {
		this.freelyPlaces = freelyPlaces;
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	
	
}

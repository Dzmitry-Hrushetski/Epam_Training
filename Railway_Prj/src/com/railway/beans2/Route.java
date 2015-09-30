/**
 * 
 */
package com.railway.beans2;


/**
 * @author Aleh_Litvinau
 */
public class Route {
	
	private int routeNumber; // 30
	private Station routeStations[];  // Minsk, Gomel, orel, Rostov, Socho, Adler
	private int distanceStations[];   // 0 , 300, 500,1650, 2100, 2180
	private int price[];   // 0 , 30, 50, 135, 21, 20
	
	public Route(int maxStation, int routeNumber){
		this.routeStations = new Station[maxStation];
		this.distanceStations = new int[maxStation];
		this.routeNumber = routeNumber;
	
	}


	public int getRouteNumber() {
		return routeNumber;
	}


	public void setRouteNumber(int routeNumber) {
		this.routeNumber = routeNumber;
	}


	public Station[] getRouteStations() {
		return routeStations;
	}


	public void setRouteStations(Station[] routeStations) {
		this.routeStations = routeStations;
	}


	public int[] getDistanceStations() {
		return distanceStations;
	}


	public void setDistanceStations(int[] distanceStations) {
		this.distanceStations = distanceStations;
	}


	/**
	 * @return the price
	 */
	public int[] getPrice() {
		return price;
	}


	/**
	 * @param price the price to set
	 */
	public void setPrice(int price[]) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Route [routeNumber=" + routeNumber + "]";
	}

}

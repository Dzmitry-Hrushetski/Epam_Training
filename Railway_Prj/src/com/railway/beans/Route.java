/**
 * 
 */
package com.railway.beans;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class Route  {
	
	private int routeNumber; // 30
	private Station routeStations[];  // Minsk, Gomel, orel, Rostov, Socho, Adler
	private int distanceStations[];   // 0 , 300, 500,1650, 2100, 2180
	
	
	public Route(int maxStation){
		this.routeStations = new Station[maxStation];
		this.distanceStations = new int[maxStation];
		/*
		 *    r[0]= 'Minsk';
		 *    r[1]= 'Gomel';
		 *    r[2]= 'Brest';
		 *    
		 *    d[0]= 0;
		 *    d[1]= 350;
		 *    d[2]= 500;
		 * 
		 */
		
		
		
	}
	

}

/**
 * 
 */
package com.railway.logic;

import com.railway.beans2.Route;
import com.railway.beans2.Station;

/**
 * @author Aleh_Litvinau
 */
public class Database {
	
	
	private Station[] stations;
	private Route[] route;
	
	public Database(){
		this.stations = new Station[6];
		this.route = new Route[2];
		
		stations[0] = new Station("Minsk", 0);
		stations[1] = new Station("Gomel", 1);
		stations[2] = new Station("Orel", 2);
		stations[3] = new Station("Rostov",3);
		stations[4] = new Station("Sochi",4);
		stations[5] = new Station("Adler",5);
		
		
		Station[] stations1 = new Station[5];
		stations1[0] = stations[0];
		stations1[1] = stations[1];
		stations1[2] = stations[2];
		stations1[3] = stations[3];
		stations1[4] = stations[4]; 

		
		Route r1 = new Route(5, 37);
		r1.setRouteStations(stations1);
		r1.setDistanceStations(new int[]{0,300,400,500,600});
		r1.setPrice(new int[]{0,30,40,50,60});

		
		Station[] stations2 = new Station[4];
		stations2[0] = stations[0];
		stations2[1] = stations[3];
		stations2[2] = stations[4];
		stations2[3] = stations[5]; 
		
		Route r2 = new Route(3, 178);
		r2.setRouteStations(stations2);
		r2.setDistanceStations(new int[]{0,500,600});
		r2.setPrice(new int[]{0,80,154});
		
		
		route[0] = r1;
		route[1] = r2;
	}

	public Station[] getStations() {
		return stations;
	}

	public Route[] getRoute() {
		return route;
	}
	


}

/**
 * 
 */
package com.railway.logic;

import com.railway.beans2.Route;
import com.railway.beans2.Station;

/**
 * @author Aleh_Litvinau
 */
public class ComplexFindImpl implements IRoutes{

	@Override
	public Route findRoute(String from, String to, Database db) {
		Route[] routes = db.getRoute();
		
		Route findR = null;
		
		for (Route r: routes){
			Station[] stations = r.getRouteStations();
			
			boolean flagFrom = false;
			boolean flagTo = false;
			for (Station s: stations){
				
				if (s.getName().equalsIgnoreCase(from)){
					flagFrom = true;
					continue;
				}
				if (s.getName().equalsIgnoreCase(to)){
					flagTo = true;
				}
				
				if (flagFrom && flagTo){
					break;
				}
			}
			
			if (flagFrom && flagTo){
				findR = r;
				break;
			}
			
		}
		
		return findR;
	}

	/* (non-Javadoc)
	 * @see com.railway.logic.IRoutes#calculate(com.railway.beans2.Route)
	 */
	@Override
	public Object calculate(Route tmp) {
		// TODO Auto-generated method stub
		return null;
	}

}

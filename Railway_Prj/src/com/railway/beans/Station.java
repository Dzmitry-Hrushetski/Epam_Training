/**
 * 
 */
package com.railway.beans;

import com.railway.logic.IAdministrator;
import com.railway.logic.ITicket;

import static com.railway.beans.RailwayConstants.*;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class Station implements IAdministrator, ITicket {
	
	private String stationName;
	private Route routes[]=new Route[MAX_ROUTES];

}

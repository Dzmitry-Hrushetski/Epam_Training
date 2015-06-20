/**
 * 
 */
package com.epam.airport.creator;

import java.util.LinkedList;

import com.epam.airport.bean.Airport;
import com.epam.airport.bean.Ladder;
import com.epam.airport.bean.Terminal;

import static com.epam.airport.constant.AirportConstants.*;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class CreateAirport {
	
	public static Airport createAirport() {
		LinkedList<Terminal> terminalQueue=new LinkedList<Terminal>();
		LinkedList<Ladder> ladderQueue=new LinkedList<Ladder>();
		
		for(int i=0;i<AIRPORT_TERMINAL_COUNT;i++) {
			terminalQueue.add(new Terminal());
		}
		
		for(int i=0;i<AIRPORT_LADDER_COUNT;i++) {
			ladderQueue.add(new Ladder());
		}
		return new Airport(terminalQueue, ladderQueue);
	}
}

/**
 * 
 */
package com.epam.airport.runner;

import org.apache.log4j.Logger;

import com.epam.airport.bean.Airplane;
import com.epam.airport.bean.Airport;
import com.epam.airport.creator.CreateAirport;
import com.epam.airport.creator.GenerateAirplane;
import com.epam.airport.logic.ProcessingAirplane;

import static com.epam.airport.constant.AirportConstants.*;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class Runner {
	private static final Logger LOG = Logger.getLogger(Runner.class);
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Airplane newAirplane=null;
		Airport airport=CreateAirport.createAirport();
		
		LOG.info("Job start");
		
		while(true) {	
			newAirplane=GenerateAirplane.generateNewAirplane();
			
			if(newAirplane==null) {
				LOG.info("Job finish");
				break;
			}
			
			new ProcessingAirplane(airport,newAirplane).start();
			
			try {
				Thread.sleep(AIRPLANE_GENERATOR_SPEED);
			} catch (InterruptedException e) {
				LOG.error(e.getMessage());
			}
		}
	}
}

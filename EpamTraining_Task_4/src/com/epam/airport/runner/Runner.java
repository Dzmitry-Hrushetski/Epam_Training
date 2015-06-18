/**
 * 
 */
package com.epam.airport.runner;

import org.apache.log4j.Logger;

import com.epam.airport.bean.Airplane;
import com.epam.airport.bean.Airport;
import com.epam.airport.exeption.BusinessExeption;
import com.epam.airport.logic.ProcessingAirplane;

import static com.epam.airport.logic.GenerateAirplane.*;
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
		
		Airport airport=null;
		Airplane newAirplane=null;
		// уберется при переделке на простую очередь
		try {
			airport=new Airport();
		} catch (BusinessExeption e) {
			LOG.error(e.getMessage());
		}
		
		
		while(true) {
			
			newAirplane=generateNewAirplane();
			
			if(MAX_GENERATED_AIRPLANE_COUNT<newAirplane.getAirplaneID()) {
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

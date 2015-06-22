/**
 * 
 */
package com.epam.airport.creator;

import java.util.Random;

import org.apache.log4j.Logger;

import com.epam.airport.bean.Airplane;
import com.epam.airport.logic.Statistics;

import static com.epam.airport.constant.AirportConstants.*;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class GenerateAirplane {
	private static final Logger LOG = Logger.getLogger(GenerateAirplane.class);
	private static Random rand=new Random();
	
	public static Airplane generateNewAirplane() {
		Airplane airplane=null;
		
		int countPassanger=MIN_PASSANGER_COUNT+ rand.nextInt(MAX_PASSANGER_COUNT-MIN_PASSANGER_COUNT);
		
		airplane=new Airplane(countPassanger);
		
		if(MAX_GENERATED_AIRPLANE_COUNT<airplane.getAirplaneID()) {
			return null;
		}
		
		LOG.info(String.format(AIRPLANE_LOG_MESSAGE,airplane.getAirplaneID(),countPassanger));
		
		Statistics.getInstance().incThreadsCount();
		
		return airplane;
	}
}
/**
 * 
 */
package com.epam.airport.creator;

import java.util.Random;

import org.apache.log4j.Logger;

import com.epam.airport.bean.Airplane;
import com.epam.airport.logic.StatisticsSingleton;

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
		
		int airplaneNumber=CodeGeneratorSingleton.getInstance().nextAirplaneNumber();
		
		if(MAX_GENERATED_AIRPLANE_COUNT<airplaneNumber) {
			return airplane;
		}
		
		int countPassanger=MIN_PASSANGER_COUNT+ rand.nextInt(MAX_PASSANGER_COUNT-MIN_PASSANGER_COUNT);
		
		airplane=new Airplane(countPassanger, airplaneNumber);
		
		LOG.info(String.format(AIRPLANE_LOG_MESSAGE,airplane.getAirplaneID(),countPassanger));
		
		StatisticsSingleton.getInstance().incThreadsCount();
		
		return airplane;
	}
}

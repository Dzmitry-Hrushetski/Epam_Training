/**
 * 
 */
package com.epam.airport.logic;

import java.util.Random;

import com.epam.airport.bean.Airplane;

import static com.epam.airport.constant.AirportConstants.*;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class GenerateAirplane {
	private static Random rand=new Random();
	
	public static Airplane generateNewAirplane() {
		return new Airplane(MIN_PASSANGER_COUNT+ rand.nextInt(MAX_PASSANGER_COUNT-MIN_PASSANGER_COUNT));
	}

}

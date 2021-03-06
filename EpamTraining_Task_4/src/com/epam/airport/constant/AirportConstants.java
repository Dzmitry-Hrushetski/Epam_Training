/**
 * 
 */
package com.epam.airport.constant;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class AirportConstants {
	public static final int AIRPORT_TERMINAL_COUNT=3;
	public static final int AIRPORT_LADDER_COUNT=5;
	public static final int MIN_PASSANGER_COUNT=10;
	public static final int MAX_PASSANGER_COUNT=100;
	
	public static final int AIRPLANE_GENERATOR_SPEED=500;
	public static final int MAX_GENERATED_AIRPLANE_COUNT=50;
	public static final int SPEED_FIT=100;
	
	public static final String AIRPLANE_LOG_MESSAGE="Generate new airplane ID-%d, passanger %d";
	public static final String PROCESSING_LOG_MESSAGE_START="Processing airplane ID-%d, passanger count %d, necessary time %d";
	public static final String PROCESSING_LOG_MESSAGE_END="Processing of the airplane ID-%d is complete";
	public static final String PROCESSING_LOG_MESSAGE_WAIT="The airplane ID-%d expects service";
	public static final String TERMINAL_USE_MESSAGE="Use terminal number %d, airplane ID-%d";
	public static final String LADDER_USE_MESSAGE="Use ladder number %d, airplane ID-%d";
	public static final String STATISTICS_MESSAGE="The airplane ID %3d expects service %6d milliseconds";
	public static final String STATISTICS_TIME_MESSAGE="The general operating time %d milliseconds";
}

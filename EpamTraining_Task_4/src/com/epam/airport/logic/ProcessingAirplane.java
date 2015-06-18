/**
 * 
 */
package com.epam.airport.logic;

import static com.epam.airport.constant.AirportConstants.*;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;

import com.epam.airport.bean.Airplane;
import com.epam.airport.bean.Airport;
import com.epam.airport.bean.Ladder;
import com.epam.airport.bean.Terminal;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class ProcessingAirplane extends Thread {
	private static final Logger LOG = Logger.getLogger(ProcessingAirplane.class);
	Airport currentAirport;
	Airplane currentAirplane;
	

	/**
	 * @param currentAirport
	 * @param currentAirplane
	 */
	public ProcessingAirplane(Airport currentAirport, Airplane currentAirplane) {
		super();
		this.currentAirport = currentAirport;
		this.currentAirplane = currentAirplane;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		BlockingQueue<Terminal> terminalQueue=currentAirport.getTerminalQueue();
		BlockingQueue<Ladder> ladderQueue=currentAirport.getLadderQueue();
		
		Terminal terminal;
		Ladder ladder;
		
		boolean workState=true;
		
		
		
		LOG.info(String.format(PROCESSING_LOG_MESSAGE_START,currentAirplane.getAirplaneID(),currentAirplane.getPassangerCount(),currentAirplane.getPassangerCount()*SPEED_FIT));
		
		while(workState) {
			
			try {
				terminal=terminalQueue.take();
				LOG.info(String.format(TERMINAL_USE_MESSAGE,terminal.getNumberTerminal(),currentAirplane.getAirplaneID()));
				Thread.sleep(SPEED_FIT*currentAirplane.getPassangerCount());
				terminalQueue.put(terminal);
				workState=false;
				
			} catch (InterruptedException e) {
				LOG.error(e.getMessage());
			}
			
			
			
		}
		
		LOG.info(String.format(PROCESSING_LOG_MESSAGE_END,currentAirplane.getAirplaneID()));
	}
}

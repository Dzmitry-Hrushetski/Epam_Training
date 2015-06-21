/**
 * 
 */
package com.epam.airport.logic;

import static com.epam.airport.constant.AirportConstants.*;

import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

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
	private static final ReentrantLock LOCK = new ReentrantLock(true);
	private Airport currentAirport;
	private Airplane currentAirplane;
	
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
		LinkedList<Terminal> terminalQueue=currentAirport.getTerminalQueue();
		LinkedList<Ladder> ladderQueue=currentAirport.getLadderQueue();
		
		Terminal terminal=null;
		Ladder ladder=null;
		
		long time=0;
		
		LOG.info(String.format(PROCESSING_LOG_MESSAGE_WAIT,currentAirplane.getAirplaneID()));
		
		time=System.currentTimeMillis();
		
		while(true) {
		
		LOCK.lock();
		try {
			if(!terminalQueue.isEmpty()) {
				terminal=terminalQueue.removeFirst();
				break;
			}
			
			if(!ladderQueue.isEmpty()) {
				ladder=ladderQueue.removeFirst();
				break;
			}	
		     } finally {
		       LOCK.unlock();
		     }
			Thread.yield();
		}
		
		time=System.currentTimeMillis()-time;
		Statistics.getInstance().addStatisticsData(time, currentAirplane.getAirplaneID());
		
		LOG.info(String.format(PROCESSING_LOG_MESSAGE_START,currentAirplane.getAirplaneID(),currentAirplane.getPassangerCount(),currentAirplane.getPassangerCount()*SPEED_FIT));
		
		if(terminal!=null) {
			LOG.info(String.format(TERMINAL_USE_MESSAGE,terminal.getNumberTerminal(),currentAirplane.getAirplaneID()));
		} else {
			LOG.info(String.format(LADDER_USE_MESSAGE,ladder.getNumberLadder(),currentAirplane.getAirplaneID()));
		}
		
		try {
			Thread.sleep(SPEED_FIT*currentAirplane.getPassangerCount());
		} catch (InterruptedException e) {
			LOG.error(e);
		}
		
		LOCK.lock();
		try {
			if(terminal!=null) {
				terminalQueue.add(terminal);		
			} else {
				ladderQueue.add(ladder);
			}	
		     } finally {
		       LOCK.unlock();
		     }
		
		LOG.info(String.format(PROCESSING_LOG_MESSAGE_END,currentAirplane.getAirplaneID()));
			
		Statistics.getInstance().decThreadsCount();
	}
}

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
	private final Logger LOG = Logger.getLogger(ProcessingAirplane.class);
	private static final ReentrantLock LOCK = new ReentrantLock(true);
	//private Airport currentAirport;
	private Airplane currentAirplane;
	
	private LinkedList<Terminal> terminalQueue;
	private LinkedList<Ladder> ladderQueue;
	
	/**
	 * @param currentAirport
	 * @param currentAirplane
	 */
	public ProcessingAirplane(Airport currentAirport, Airplane currentAirplane) {
		super();
		//this.currentAirport = currentAirport;
		this.currentAirplane = currentAirplane;
		
		terminalQueue=currentAirport.getTerminalQueue();
		ladderQueue=currentAirport.getLadderQueue();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		Terminal terminal=null;
		Ladder ladder=null;
		long time;
		
		LOG.info(String.format(PROCESSING_LOG_MESSAGE_WAIT,currentAirplane.getAirplaneID()));
		
		time=System.currentTimeMillis();
		
		while(true) {
			terminal=findTerminal();
			if(terminal!=null) {
				break;
			}
			
			ladder=findLadder();
			if(ladder!=null) {
				break;
			}
			
			Thread.yield();
		}
		
		time=System.currentTimeMillis()-time;
		StatisticsSingleton.getInstance().addStatisticsData(time, currentAirplane.getAirplaneID());
		
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
		
		if(terminal!=null) {
			releaseTerminal(terminal);
		} else {
			releaseLadder(ladder);
		}
			
		LOG.info(String.format(PROCESSING_LOG_MESSAGE_END,currentAirplane.getAirplaneID()));
			
		StatisticsSingleton.getInstance().decThreadsCount();
	}
	
	private Terminal findTerminal() {
		LOCK.lock();
		try {
			if(!terminalQueue.isEmpty()) {
				return terminalQueue.removeFirst();
			} else {
				return null;
			}
			 } finally {
		       LOCK.unlock();
		     }
	}
	
	private Ladder findLadder() {
		LOCK.lock();
		try {
			if(!ladderQueue.isEmpty()) {
				return ladderQueue.removeFirst();
			} else {
				return null;
			}
		     } finally {
		       LOCK.unlock();
		     }
	}
	
	private void releaseTerminal(Terminal terminal) {
		LOCK.lock();
		try {
			terminalQueue.add(terminal);		
			 } finally {
		       LOCK.unlock();
		     }
	}
	
	private void releaseLadder(Ladder ladder) {
		LOCK.lock();
		try {
			ladderQueue.add(ladder);	
		     } finally {
		       LOCK.unlock();
		     }
	}
}

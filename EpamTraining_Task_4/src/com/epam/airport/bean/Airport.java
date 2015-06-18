/**
 * 
 */
package com.epam.airport.bean;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;



import com.epam.airport.exeption.BusinessExeption;

import static com.epam.airport.constant.AirportConstants.*;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class Airport {
	private BlockingQueue<Terminal> terminalQueue=new LinkedBlockingQueue<Terminal>(AIRPORT_TERMINAL_COUNT);
	private BlockingQueue<Ladder> ladderQueue=new LinkedBlockingQueue<Ladder>(AIRPORT_LADDER_COUNT);
	/**
	 * @throws BusinessExeption 
	 * 
	 */
	public Airport() throws BusinessExeption {
		super();
		
		for(int i=0;i<AIRPORT_TERMINAL_COUNT;i++) {
			try {
				terminalQueue.put(new Terminal());
			} catch (InterruptedException e) {
				throw new BusinessExeption("Error create terminal queue",e);
			}
		}
		
		for(int i=0;i<AIRPORT_LADDER_COUNT;i++) {
			try {
				ladderQueue.put(new Ladder());
			} catch (InterruptedException e) {
				throw new BusinessExeption("Error create terminal queue",e);
			}
		}
		
	}
	/**
	 * @return the terminalQueue
	 */
	public BlockingQueue<Terminal> getTerminalQueue() {
		return terminalQueue;
	}
	/**
	 * @return the ladderQueue
	 */
	public BlockingQueue<Ladder> getLadderQueue() {
		return ladderQueue;
	}
	
	
	

}

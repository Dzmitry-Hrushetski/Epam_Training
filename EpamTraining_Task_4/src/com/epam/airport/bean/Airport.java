/**
 * 
 */
package com.epam.airport.bean;

import java.util.LinkedList;


/**
 * @author Dzmitry Hrushetski
 *
 */
public class Airport {
	private LinkedList<Terminal> terminalQueue;
	private LinkedList<Ladder> ladderQueue;
	
	/**
	 * @param terminalQueue
	 * @param ladderQueue
	 */
	public Airport(LinkedList<Terminal> terminalQueue, LinkedList<Ladder> ladderQueue) {
		super();
		this.terminalQueue = terminalQueue;
		this.ladderQueue = ladderQueue;
	}
	
	/**
	 * @return the terminalQueue
	 */
	public LinkedList<Terminal> getTerminalQueue() {
		return terminalQueue;
	}
	
	/**
	 * @return the ladderQueue
	 */
	public LinkedList<Ladder> getLadderQueue() {
		return ladderQueue;
	}
}

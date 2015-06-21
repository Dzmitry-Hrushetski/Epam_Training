/**
 * 
 */
package com.epam.airport.bean;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class Ladder {
	private static int createCount=0;
	private int numberLadder;
	private boolean state;
	
	/**
	 * 
	 */
	public Ladder() {
		super();
		numberLadder=++createCount;
	}

	/**
	 * @return the state
	 */
	public boolean isState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(boolean state) {
		this.state = state;
	}

	/**
	 * @return the numberLadder
	 */
	public int getNumberLadder() {
		return numberLadder;
	}
}

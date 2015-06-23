/**
 * 
 */
package com.epam.airport.bean;


/**
 * @author Dzmitry Hrushetski
 *
 */
public class Ladder {
	private int numberLadder;
	private boolean state;
	
	/**
	 * @param numberLadder
	 */
	public Ladder(int numberLadder) {
		super();
		this.numberLadder = numberLadder;
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

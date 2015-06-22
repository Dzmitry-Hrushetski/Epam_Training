/**
 * 
 */
package com.epam.airport.bean;

import com.epam.airport.creator.CodeGenerator;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class Ladder {
	private int numberLadder;
	private boolean state;
	
	/**
	 * 
	 */
	public Ladder() {
		super();
		numberLadder=CodeGenerator.getInstance().nextLadderNumber();
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

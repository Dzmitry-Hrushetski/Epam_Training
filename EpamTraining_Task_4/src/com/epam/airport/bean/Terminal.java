/**
 * 
 */
package com.epam.airport.bean;


/**
 * @author Dzmitry Hrushetski
 *
 */
public class Terminal {
	private int numberTerminal;
	private boolean state;
	
	/**
	 * @param numberTerminal
	 */
	public Terminal(int numberTerminal) {
		super();
		this.numberTerminal = numberTerminal;
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
	 * @return the numberTerminal
	 */
	public int getNumberTerminal() {
		return numberTerminal;
	}
}

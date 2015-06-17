/**
 * 
 */
package com.epam.airport.bean;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class Terminal {
	private static int createCount=0;
	private int numberTerminal;
	private boolean state;
	
	/**
	 * 
	 */
	public Terminal() {
		super();
		numberTerminal=++createCount;
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

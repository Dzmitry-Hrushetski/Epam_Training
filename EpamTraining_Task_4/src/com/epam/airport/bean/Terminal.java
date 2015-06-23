/**
 * 
 */
package com.epam.airport.bean;

import com.epam.airport.creator.CodeGeneratorSingleton;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class Terminal {
	private int numberTerminal;
	private boolean state;
	
	/**
	 * 
	 */
	public Terminal() {
		super();
		numberTerminal=CodeGeneratorSingleton.getInstance().nextTerminalNumber();
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

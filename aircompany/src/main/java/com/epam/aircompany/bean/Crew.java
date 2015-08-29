/**
 * 
 */
package com.epam.aircompany.bean;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class Crew extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4979490072285900467L;
	private ArrayList<Employee> crew;
	//private ArrayList<Employee> crew;
	/**
	 * @return the crew
	 */
	public ArrayList<Employee> getCrew() {
		return crew;
	}
	/**
	 * @param crew the crew to set
	 */
	public void setCrew(ArrayList<Employee> crew) {
		this.crew = crew;
	}
}

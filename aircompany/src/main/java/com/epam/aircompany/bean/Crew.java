/**
 * 
 */
package com.epam.aircompany.bean;

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
	private HashSet<Employee> crew;
	/**
	 * @return the crew
	 */
	public HashSet<Employee> getCrew() {
		return crew;
	}
	/**
	 * @param crew the crew to set
	 */
	public void setCrew(HashSet<Employee> crew) {
		this.crew = crew;
	}
}

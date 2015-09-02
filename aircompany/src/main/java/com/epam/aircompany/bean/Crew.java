package com.epam.aircompany.bean;

import java.util.ArrayList;

/**
 * The Class Crew is a Java Bean that contains information on crew of the airplane.
 *
 * @author Dzmitry Hrushetski
 */
public class Crew extends Entity {
	private static final long serialVersionUID = -4979490072285900467L;
	private ArrayList<Employee> crew;
	
	/**
	 * Gets the list of the Employee.
	 *
	 * @return ArrayList of Employee
	 * @see com.epam.aircompany.bean.Employee
	 */
	public ArrayList<Employee> getCrew() {
		return crew;
	}
	
	/**
	 * Sets the list of the Employee.
	 *
	 * @param crew ArrayList of Employee
	 * @see com.epam.aircompany.bean.Employee
	 */
	public void setCrew(ArrayList<Employee> crew) {
		this.crew = crew;
	}
}

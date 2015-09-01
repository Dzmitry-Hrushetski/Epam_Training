package com.epam.aircompany.bean;

import java.util.GregorianCalendar;

/**
 * The Class Employee is a Java Bean that contains information on a position and start date of operation.
 *
 * @author Dzmitry Hrushetski
 */
public class Employee extends Person {
	private static final long serialVersionUID = 6399419629743726133L;
	private Position position;
	private GregorianCalendar startDate;
	private boolean disable;
	
	/**
	 * Gets the employee's position.
	 *
	 * @return Position
	 * @see com.epam.aircompany.bean.Position
	 */
	public Position getPosition() {
		return position;
	}
	
	/**
	 * Sets the employee's position.
	 *
	 * @param Position 
	 * @see com.epam.aircompany.bean.Position
	 */
	public void setPosition(Position position) {
		this.position = position;
	}
	
	/**
	 * Gets the start of operation.
	 *
	 * @return GregorianCalendar
	 */
	public GregorianCalendar getStartDate() {
		return startDate;
	}
	
	/**
	 * Sets the start of operation.
	 *
	 * @param GregorianCalendar
	 */
	public void setStartDate(GregorianCalendar startDate) {
		this.startDate = startDate;
	}
	
	/**
	 * Checks if is disable.
	 *
	 * @return true, if is disable
	 */
	public boolean isDisable() {
		return disable;
	}
	
	/**
	 * Sets the disable.
	 *
	 * @param disable the new disable
	 */
	public void setDisable(boolean disable) {
		this.disable = disable;
	}
}

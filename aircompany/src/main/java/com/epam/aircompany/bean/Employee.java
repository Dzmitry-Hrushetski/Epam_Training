/**
 * 
 */
package com.epam.aircompany.bean;

import java.util.GregorianCalendar;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class Employee extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6399419629743726133L;
	private Position position;
	private GregorianCalendar startDate;
	private boolean disable;
	
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public GregorianCalendar getStartDate() {
		return startDate;
	}
	public void setStartDate(GregorianCalendar startDate) {
		this.startDate = startDate;
	}
	public boolean isDisable() {
		return disable;
	}
	public void setDisable(boolean disable) {
		this.disable = disable;
	}
}

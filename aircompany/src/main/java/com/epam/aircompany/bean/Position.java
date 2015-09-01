package com.epam.aircompany.bean;

/**
 * The Class Position is a Java Bean that contains a job title.
 *
 * @author Dzmitry Hrushetski
 */
public class Position extends Entity {
	private static final long serialVersionUID = -1689698190565948194L;
	private String positionName;
	
	/**
	 * Gets the position name.
	 *
	 * @return the position name
	 */
	public String getPositionName() {
		return positionName;
	}
	
	/**
	 * Sets the position name.
	 *
	 * @param positionName the new position name
	 */
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
}

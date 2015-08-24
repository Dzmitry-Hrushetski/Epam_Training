/**
 * 
 */
package com.epam.aircompany.bean;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class Position extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1689698190565948194L;
	private String positionName;
	
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
}

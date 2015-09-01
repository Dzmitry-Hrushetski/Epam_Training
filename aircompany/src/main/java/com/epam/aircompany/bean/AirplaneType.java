
package com.epam.aircompany.bean;


/**
 * The Class AirplaneType is a Java Bean that stores data on model of the airplane.
 * 
 * @author Dzmitry Hrushetski
 */
public class AirplaneType extends Entity {
	private static final long serialVersionUID = -1307349531979483501L;
	private String modelName;
	
	/**
	 * Gets the airplane model name.
	 *
	 * @return the model name
	 */
	public String getModelName() {
		return modelName;
	}
	
	/**
	 * Sets the airplane model name.
	 *
	 * @param modelName the new model name
	 */
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
}

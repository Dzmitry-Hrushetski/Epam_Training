/**
 * 
 */
package com.epam.aircompany.bean;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class AirplaneType extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1307349531979483501L;
	private String modelName;
	
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
}

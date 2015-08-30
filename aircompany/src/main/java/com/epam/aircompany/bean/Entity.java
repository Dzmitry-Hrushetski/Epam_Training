/**
 * 
 */
package com.epam.aircompany.bean;

import java.io.Serializable;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class Entity implements Cloneable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6531997150696885706L;
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}

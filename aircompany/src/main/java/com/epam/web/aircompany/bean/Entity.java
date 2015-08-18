/**
 * 
 */
package com.epam.web.aircompany.bean;

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
	/*public String getIdString() {
		Integer i=new Integer(id);
		return i.toString();
	}*/
}

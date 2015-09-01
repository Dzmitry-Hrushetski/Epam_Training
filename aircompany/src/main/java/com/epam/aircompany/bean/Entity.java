package com.epam.aircompany.bean;

import java.io.Serializable;

/**
 * Abstract Class Entity is a Java Bean that is a superclass to all
 * other entity classes.
 *
 * @author Dzmitry Hrushetski
 */
public abstract class Entity implements Cloneable, Serializable {
	private static final long serialVersionUID = 6531997150696885706L;
	private int id;
	
	/**
	 * Returns the unique ID of a given entity.
	 *
	 * @return Entity ID
	 */
	public int getId() {
		return id;
	}
	
	/**
	 *Sets the ID of a given entity.
	 *
	 * @param id the ID of a given entity
	 */
	public void setId(int id) {
		this.id = id;
	}
}

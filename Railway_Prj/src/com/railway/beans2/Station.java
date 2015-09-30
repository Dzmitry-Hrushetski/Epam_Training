/**
 * 
 */
package com.railway.beans2;

/**
 * @author Aleh_Litvinau
 */
public class Station {
	
	private int id;
	private String name;
	
	public Station(String name, int i){
		this.name = name;
		this.id = i;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}

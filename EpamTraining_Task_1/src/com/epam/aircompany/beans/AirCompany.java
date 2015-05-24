/**
 * 
 */
package com.epam.aircompany.beans;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import com.epam.aircompany.exeptions.LogicalExeptions;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class AirCompany {
	private String companyName;
	private Set<Airplane> airplanes;
	
	
	/*private Set<PassangerAirplane> passAirplanes;
	private Set<TransportAirplane> transAirplanes;*/
	
	
	
	
	
	public boolean add(Airplane e) {
		return airplanes.add(e);
	}


	public Set<Airplane> getAirplanes() {
		return airplanes;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) throws LogicalExeptions {
		
		if(companyName!=null){
			this.companyName = companyName;
		} else{
			throw new LogicalExeptions("Incorrect companyName");
		}
	}


	public AirCompany(String companyName) {
		super();
		this.companyName = companyName;
		
		//airplanes= new HashSet<Airplane>();
		airplanes= new TreeSet<Airplane>();
	}


	@Override
	public String toString() {
		
		return airplanes.isEmpty()? "The " + companyName + " has no airplanes." : "The " + companyName + " has " + airplanes.size() + " airplanes.";
				
		//return "The " + companyName + " has " + airplanes.size() + " airplanes.";
	}
}

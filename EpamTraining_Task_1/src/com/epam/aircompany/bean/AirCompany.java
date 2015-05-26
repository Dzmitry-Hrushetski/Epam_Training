/**
 * 
 */
package com.epam.aircompany.bean;

import java.util.Set;
import java.util.TreeSet;

import com.epam.aircompany.exeption.LogicalExeption;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class AirCompany {
	private static final String MESSAGE_TO_STRING_1="The %s has no airplanes.";
	private static final String MESSAGE_TO_STRING_2="The %s has %d airplanes.";
	private String companyName;
	private Set<Airplane> airplanes=new TreeSet<Airplane>();
	
	public AirCompany(String companyName) throws LogicalExeption {
		super();
		if(companyName!=null && !companyName.isEmpty()){
			this.companyName = companyName;
		} else {
			throw new LogicalExeption("Incorrect companyName");
		}
	}
		
	public boolean add(Airplane e) {
		return airplanes.add(e);
	}

	public Set<Airplane> getAirplanes() {
		return airplanes;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) throws LogicalExeption {
			if(companyName!=null && !companyName.isEmpty()){
			this.companyName = companyName;
		} else {
			throw new LogicalExeption("Incorrect companyName");
		}
	}

	@Override
	public String toString() {
		return airplanes.isEmpty()? String.format(MESSAGE_TO_STRING_1, companyName) : String.format(MESSAGE_TO_STRING_2, companyName, airplanes.size());
	}
}

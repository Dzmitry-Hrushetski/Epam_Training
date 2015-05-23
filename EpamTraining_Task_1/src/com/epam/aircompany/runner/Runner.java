/**
 * 
 */
package com.epam.aircompany.runner;

import java.util.Set;

import org.apache.log4j.Logger;

import com.epam.aircompany.beans.Airplane;
import com.epam.aircompany.creator.CompanyCreator;


/**
 * @author Dzmitry Hrushetski
 *
 */
public class Runner {

	public static Logger LOG = Logger.getLogger(Runner.class);
	
	private static final String COMPANY_NAME="TransExpress";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LOG.info("Create new air company");
		CompanyCreator creator = new CompanyCreator(COMPANY_NAME);
		
		LOG.info("Create airplanes in the company");
		creator.generateHardCoreCpompanyPark();
		
		Set<Airplane> airplanes=creator.getCompany().getAirplanes();
		
		System.out.println(creator.getCompany());
		for(Airplane a: airplanes){
			System.out.println(a);
		}
	}

}

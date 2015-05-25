/**
 * 
 */
package com.epam.aircompany.creator;


import org.apache.log4j.Logger;

import com.epam.aircompany.bean.AirCompany;
import com.epam.aircompany.bean.Airplane;
import com.epam.aircompany.bean.AirplaneModelName;
import com.epam.aircompany.bean.PassangerAirplane;
import com.epam.aircompany.bean.TransportAirplane;
import com.epam.aircompany.exeption.LogicalExeption;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class CompanyCreator {
	
	public static final Logger LOG = Logger.getLogger(CompanyCreator.class);
	
		
	public static AirCompany generateHardCoreCompany(String companyName){
		
		Airplane airplane=null;
		
		AirCompany company=null;
		try {
			company = new AirCompany (companyName);
		} catch (LogicalExeption e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}
		
		try {
			airplane = new PassangerAirplane(AirplaneModelName.BOING_737, 10, 200, 10, 15, 20, 6);
			airplane.setFuelUsage(11);
			((PassangerAirplane) airplane).setBusinessPlace(15);
			((PassangerAirplane) airplane).setEconomPlace(30);
			company.add(airplane);
			LOG.info("Create new PassangerAirplane");
			
		} catch (LogicalExeption e) {
			LOG.error(e.getMessage());
		}
		
		try {				
			airplane = new PassangerAirplane(AirplaneModelName.AIRBUS_A310, 11, 700, 20, 15, 20, 6);
			airplane.setFuelUsage(15);
			((PassangerAirplane) airplane).setBusinessPlace(25);
			((PassangerAirplane) airplane).setEconomPlace(50);
			company.add(airplane);
			LOG.info("Create new PassangerAirplane");
			
		} catch (LogicalExeption e) {
			LOG.error(e.getMessage());
		}
		
		try {
			airplane = new TransportAirplane(AirplaneModelName.AIRBUS_A400M, 12, 400, 50, 15, 20, 6, 2, 2, 2, 2);
			airplane.setFuelUsage(25);
			company.add(airplane);
			LOG.info("Create new TransportAirplane");
		} catch (LogicalExeption e) {
			LOG.error(e.getMessage());
		}
		
		try {
			airplane = new TransportAirplane(AirplaneModelName.AN_26D, 15, 420, 60, 16, 25, 6, 2, 2, 2, 2);
			airplane.setFuelUsage(27);
			company.add(airplane);
			LOG.info("Create new TransportAirplane");
		} catch (LogicalExeption e) {
			LOG.error(e.getMessage());
		}	
		
		return company;
	}
}

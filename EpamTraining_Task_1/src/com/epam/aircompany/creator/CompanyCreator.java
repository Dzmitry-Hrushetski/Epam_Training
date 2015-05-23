/**
 * 
 */
package com.epam.aircompany.creator;


import org.apache.log4j.Logger;

import com.epam.aircompany.beans.AirCompany;
import com.epam.aircompany.beans.Airplane;
import com.epam.aircompany.beans.AirplaneModelName;
import com.epam.aircompany.beans.PassangerAirplane;
import com.epam.aircompany.beans.TransportAirplane;
import com.epam.aircompany.exeptions.LogicalExeptions;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class CompanyCreator {
	
	public static Logger LOG = Logger.getLogger(CompanyCreator.class);
	
	private AirCompany company;
	
	
	public void generateHardCoreCpompanyPark(){
		
		AirplaneModelName modelName = AirplaneModelName.AIRBUS_A310;
		Airplane airplane=null;
		
		try {
			airplane = new PassangerAirplane(modelName.BOING_737, 10, 200, 10, 15, 20, 6);
			airplane.setFuelUsage(11);
			company.add(airplane);
			LOG.info("Create new PassangerAirplane");
						
			airplane = new PassangerAirplane(modelName.AIRBUS_A310, 11, 300, 20, 15, 20, 6);
			airplane.setFuelUsage(15);
			company.add(airplane);
			LOG.info("Create new PassangerAirplane");
		
			airplane = new TransportAirplane(modelName.AIRBUS_A400M, 12, 400, 50, 15, 20, 6, 2, 2, 2, 2);
			airplane.setFuelUsage(25);
			company.add(airplane);
			LOG.info("Create new TransportAirplane");
			
			airplane = new TransportAirplane(modelName.AN_26D, 15, 420, 60, 16, 25, 6, 2, 2, 2, 2);
			airplane.setFuelUsage(27);
			company.add(airplane);
			LOG.info("Create new TransportAirplane");
						
			
			airplane = new TransportAirplane(modelName.AN_26D, 0, 420, 60, 16, 25, 6, 2, 2, 2, 2);
			airplane.setFuelUsage(27);
			company.add(airplane);
			LOG.info("Test Exeption"); // This log message not logged
 			
			
		} catch (LogicalExeptions e) {
			LOG.error(e.getMessage());
		}
		
		
		
	}

	public AirCompany getCompany() {
		return company;
	}


	public CompanyCreator(String companyName) {
		super();
		company = new AirCompany (companyName);
	}
}

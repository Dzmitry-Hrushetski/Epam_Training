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
import com.epam.aircompany.parser.AbstractAirCompanyBuilder;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class CompanyCreator {
	private static final Logger LOG = Logger.getLogger(CompanyCreator.class);
		
	public static AirCompany generateXMLCompany(AbstractAirCompanyBuilder builder, String filePath) {
		builder.buildAirCompany(filePath);
		return builder.getAirCompany();
	}
}

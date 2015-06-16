/**
 * 
 */
package com.epam.aircompany.creator;

import com.epam.aircompany.bean.AirCompany;
import com.epam.aircompany.exeption.BusinessExeption;
import com.epam.aircompany.parser.AbstractAirCompanyBuilder;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class CompanyCreator {
	public static AirCompany generateXMLCompany(AbstractAirCompanyBuilder builder, String filePath) throws BusinessExeption {
		builder.buildAirCompany(filePath);
		return builder.getAirCompany();
	}
}

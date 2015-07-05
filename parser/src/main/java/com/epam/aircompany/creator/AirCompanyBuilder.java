/**
 * 
 */
package com.epam.aircompany.creator;

import com.epam.aircompany.exeption.BusinessExeption;
import com.epam.aircompany.parser.AbstractAirCompanyBuilder;
import com.epam.aircompany.parser.DOMAirCompanyBuilder;
import com.epam.aircompany.parser.ParserType;
import com.epam.aircompany.parser.SAXAirCompanyBuilder;
import com.epam.aircompany.parser.StAXAirCompanyBuilder;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class AirCompanyBuilder {
	public static AbstractAirCompanyBuilder createAirCompanyBuilder(ParserType parserType) throws BusinessExeption {
		AbstractAirCompanyBuilder builder=null;
		
		if(parserType==null) {
			throw new BusinessExeption("ParserType can't be null");
		}
		
		switch (parserType) {
		case SAX:
			builder = new SAXAirCompanyBuilder();
			break;
		case DOM:
			builder = new DOMAirCompanyBuilder();
			break;
		case STAX:
			builder = new StAXAirCompanyBuilder();
			break;
		}
		return builder;
	}
}

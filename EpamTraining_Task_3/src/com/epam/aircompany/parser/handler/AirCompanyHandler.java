/**
 * 
 */
package com.epam.aircompany.parser.handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.epam.aircompany.bean.AirCompany;
import com.epam.aircompany.bean.AirplaneModelName;
import com.epam.aircompany.bean.PassangerAirplane;
import com.epam.aircompany.bean.TransportAirplane;
import com.epam.aircompany.parser.enumeration.AirplaneEnum;
import static com.epam.aircompany.parser.constant.ParserConstant.*;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class AirCompanyHandler extends DefaultHandler {
	private AirCompany company=new AirCompany();
	private PassangerAirplane passangerAirplane;
	private TransportAirplane transportAirplane;
	private AirplaneEnum currentEnum;
	
	//Airplane fields
	private AirplaneModelName modelName;
	private int boardNumber;
	private int flyingRange;
	private int capacityFuelTank;
	private int fuelUsage;
	private int maxLoadCapacity;
	//PassangerAirplane fields
	private int economPlace;
	private int businessPlace;
	private int maxBaggagePlace;
	private int maxBaggageWeight;
	private int curBaggagePlace;
	private int curBaggageWeight;
	//TransportAirplane fields
	private int cargoLong;
	private int cargoWidth;
	private int cargoHeight;
	private int maxCargoWeight;
	private int curCargoWeight;
	private int cargoHatchWidth;
	private int cargoHatchHeight;
	
	/**
	 * @return the company
	 */
	public AirCompany getAirCompany() {
		return company;
	}

	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		switch (localName) {
		case PASSANGER_AIRPLANE:
		case TRANSPORT_AIRPLANE:
			boardNumber=Integer.parseInt(attributes.getValue(START_INDEX).substring(ID_SUBSTRING));
			break;
		default:
			if (!localName.equals(XML_ROOT)) {
				currentEnum = AirplaneEnum.valueOf(localName.replace(REPLACE_OLD_SYMBOL,REPLACE_NEW_SYMBOL).toUpperCase());
			}
			break;
		}
	}

	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (localName) {
		case PASSANGER_AIRPLANE:
			passangerAirplane=new PassangerAirplane(modelName,boardNumber,flyingRange,capacityFuelTank,maxLoadCapacity,maxBaggagePlace,maxBaggageWeight);
			passangerAirplane.setFuelUsage(fuelUsage);
			passangerAirplane.setEconomPlace(economPlace);
			passangerAirplane.setBusinessPlace(businessPlace);
			passangerAirplane.setCurBaggagePlace(curBaggagePlace);
			passangerAirplane.setCurBaggageWeight(curBaggageWeight);
			company.add(passangerAirplane);
			break;
		case TRANSPORT_AIRPLANE:
			transportAirplane=new TransportAirplane(modelName,boardNumber,flyingRange,capacityFuelTank,maxLoadCapacity,cargoLong,cargoWidth,cargoHeight,maxCargoWeight,cargoHatchWidth,cargoHatchHeight);
			transportAirplane.setFuelUsage(fuelUsage);
			transportAirplane.setCurCargoWeight(curCargoWeight);
			company.add(transportAirplane);
			break;
		default:	
			break;
		}
	}

	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
	 */
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String str = new String(ch, start, length).trim();
		if (currentEnum != null) {
			switch (currentEnum) {
			case COMPANY_NAME:
				company.setCompanyName(str);
				break;
			case MODEL_NAME:
				modelName=AirplaneModelName.valueOf(str.toUpperCase());
				break;
			case FLYING_RANGE:
				flyingRange=Integer.parseInt(str);
				break;
			case CAPACITY_FUEL_TANK:
				capacityFuelTank=Integer.parseInt(str);
				break;
			case FUEL_USAGE:
				fuelUsage=Integer.parseInt(str);
				break;
			case MAX_LOAD_CAPACITY:
				maxLoadCapacity=Integer.parseInt(str);
				break;
			case ECONOM_PLACE:
				economPlace=Integer.parseInt(str);
				break;
			case BUSINESS_PLACE:
				businessPlace=Integer.parseInt(str);
				break;
			case MAX_BAGGAGE_PLACE:
				maxBaggagePlace=Integer.parseInt(str);
				break;
			case MAX_BAGGAGE_WEIGHT:
				maxBaggageWeight=Integer.parseInt(str);
				break;
			case CUR_BAGGAGE_PLACE:
				curBaggagePlace=Integer.parseInt(str);
				break;
			case CUR_BAGGAGE_WEIGHT:
				curBaggageWeight=Integer.parseInt(str);
				break;
			case CARGO_LONG:
				cargoLong=Integer.parseInt(str);
				break;
			case CARGO_WIDTH:
				cargoWidth=Integer.parseInt(str);
				break;	
			case CARGO_HEIGHT:
				cargoHeight=Integer.parseInt(str);
				break;	
			case MAX_CARGO_WEIGHT:
				maxCargoWeight=Integer.parseInt(str);
				break;	
			case CUR_CARGO_WEIGHT:
				curCargoWeight=Integer.parseInt(str);
				break;
			case CARGO_HATCH_WIDTH:
				cargoHatchWidth=Integer.parseInt(str);
				break;	
			case CARGO_HATCH_HEIGHT:
				cargoHatchHeight=Integer.parseInt(str);
				break;			
			default:
				throw new EnumConstantNotPresentException(
						currentEnum.getDeclaringClass(), currentEnum.name());
			}
		}
		currentEnum = null;
	}
}

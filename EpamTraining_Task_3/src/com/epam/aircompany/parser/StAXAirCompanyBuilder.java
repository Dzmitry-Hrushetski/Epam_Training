/**
 * 
 */
package com.epam.aircompany.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.log4j.Logger;

import com.epam.aircompany.bean.AirplaneModelName;
import com.epam.aircompany.bean.PassangerAirplane;
import com.epam.aircompany.bean.TransportAirplane;
import com.epam.aircompany.exeption.BusinessExeption;
import com.epam.aircompany.parser.enumeration.AirplaneEnum;

import static com.epam.aircompany.parser.constant.ParserConstant.*;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class StAXAirCompanyBuilder extends AbstractAirCompanyBuilder {
	private static final Logger LOG = Logger.getLogger(StAXAirCompanyBuilder.class);
	private XMLInputFactory inputFactory;
	private PassangerAirplane passangerAirplane;
	private TransportAirplane transportAirplane;
	
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
	 * 
	 */
	public StAXAirCompanyBuilder() {
		super();
		this.inputFactory = XMLInputFactory.newInstance();
	}


	/* (non-Javadoc)
	 * @see com.epam.aircompany.parser.AbstractAirCompanyBuilder#buildAirCompany(java.lang.String)
	 */
	@Override
	public void buildAirCompany(String filePath) throws BusinessExeption {
		XMLStreamReader reader = null;
		String elementName;
		
		if(filePath==null || filePath.isEmpty()) {
			throw new BusinessExeption("File name cannot be null or empty");
		}
		try {
			FileInputStream inputStream = new FileInputStream(new File(filePath));
			reader = inputFactory.createXMLStreamReader(inputStream);
			
			while (reader.hasNext()) {
				int type = reader.next();
				if (type == XMLStreamConstants.START_ELEMENT) {
					elementName = reader.getLocalName();
					switch (elementName) {
					case COMPANY_NAME:
						airCompany.setCompanyName(getXMLText(reader).trim());
						break;
					case PASSANGER_AIRPLANE:
						passangerAirplane=buildPassangerAirplane(reader);
						airCompany.add(passangerAirplane);
						break;
					case TRANSPORT_AIRPLANE:
						transportAirplane=buildTransportAirplane(reader);
						airCompany.add(transportAirplane);
						break;
					default:
						break;
					}
				}
			}
		} catch (XMLStreamException exception) {
			LOG.error("StAX parser error", exception);
			throw new BusinessExeption("StAX parser error",exception);
		}  catch (IOException exception) {
			LOG.error("IO error", exception);
			throw new BusinessExeption("IO error",exception);
		}

	}
	
	private PassangerAirplane buildPassangerAirplane(XMLStreamReader reader) throws XMLStreamException {
		
		boardNumber=Integer.parseInt(reader.getAttributeValue(START_INDEX).substring(ID_SUBSTRING));
		
		String elementName;
		while (reader.hasNext()) {
			int type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				elementName = reader.getLocalName();
				switch (AirplaneEnum.valueOf(elementName.replace(REPLACE_OLD_SYMBOL,REPLACE_NEW_SYMBOL).toUpperCase())) {
				case MODEL_NAME:
					modelName=AirplaneModelName.valueOf(getXMLText(reader).toUpperCase());
					break;
				case FLYING_RANGE:
					flyingRange=Integer.parseInt(getXMLText(reader));
					break;
				case CAPACITY_FUEL_TANK:
					capacityFuelTank=Integer.parseInt(getXMLText(reader));
					break;
				case FUEL_USAGE:
					fuelUsage=Integer.parseInt(getXMLText(reader));
					break;
				case MAX_LOAD_CAPACITY:
					maxLoadCapacity=Integer.parseInt(getXMLText(reader));
					break;
				case ECONOM_PLACE:
					economPlace=Integer.parseInt(getXMLText(reader));
					break;
				case BUSINESS_PLACE:
					businessPlace=Integer.parseInt(getXMLText(reader));
					break;
				case MAX_BAGGAGE_PLACE:
					maxBaggagePlace=Integer.parseInt(getXMLText(reader));
					break;
				case MAX_BAGGAGE_WEIGHT:
					maxBaggageWeight=Integer.parseInt(getXMLText(reader));
					break;
				case CUR_BAGGAGE_PLACE:
					curBaggagePlace=Integer.parseInt(getXMLText(reader));
					break;
				case CUR_BAGGAGE_WEIGHT:
					curBaggageWeight=Integer.parseInt(getXMLText(reader));
					break;
				default:
					break;
				}
				break;
			case XMLStreamConstants.END_ELEMENT:
				elementName = reader.getLocalName();
				if (elementName.equals(PASSANGER_AIRPLANE)) {
					PassangerAirplane passangerAirplane=new PassangerAirplane(modelName,boardNumber,flyingRange,capacityFuelTank,maxLoadCapacity,maxBaggagePlace,maxBaggageWeight);
					passangerAirplane.setFuelUsage(fuelUsage);
					passangerAirplane.setEconomPlace(economPlace);
					passangerAirplane.setBusinessPlace(businessPlace);
					passangerAirplane.setCurBaggagePlace(curBaggagePlace);
					passangerAirplane.setCurBaggageWeight(curBaggageWeight);
					return passangerAirplane;
				}
				break;
			}
		}
		throw new XMLStreamException("Unknown element in a 'air-company'");
	}
	
	private TransportAirplane buildTransportAirplane(XMLStreamReader reader) throws XMLStreamException {
		
		boardNumber=Integer.parseInt(reader.getAttributeValue(0).substring(1));
		
		String elementName;
		while (reader.hasNext()) {
			int type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				elementName = reader.getLocalName();
				switch (AirplaneEnum.valueOf(elementName.replace(REPLACE_OLD_SYMBOL,REPLACE_NEW_SYMBOL).toUpperCase())) {
				case MODEL_NAME:
					modelName=AirplaneModelName.valueOf(getXMLText(reader).toUpperCase());
					break;
				case FLYING_RANGE:
					flyingRange=Integer.parseInt(getXMLText(reader));
					break;
				case CAPACITY_FUEL_TANK:
					capacityFuelTank=Integer.parseInt(getXMLText(reader));
					break;
				case FUEL_USAGE:
					fuelUsage=Integer.parseInt(getXMLText(reader));
					break;
				case MAX_LOAD_CAPACITY:
					maxLoadCapacity=Integer.parseInt(getXMLText(reader));
					break;
				case CARGO_LONG:
					cargoLong=Integer.parseInt(getXMLText(reader));
					break;
				case CARGO_WIDTH:
					cargoWidth=Integer.parseInt(getXMLText(reader));
					break;	
				case CARGO_HEIGHT:
					cargoHeight=Integer.parseInt(getXMLText(reader));
					break;	
				case MAX_CARGO_WEIGHT:
					maxCargoWeight=Integer.parseInt(getXMLText(reader));
					break;	
				case CUR_CARGO_WEIGHT:
					curCargoWeight=Integer.parseInt(getXMLText(reader));
					break;
				case CARGO_HATCH_WIDTH:
					cargoHatchWidth=Integer.parseInt(getXMLText(reader));
					break;	
				case CARGO_HATCH_HEIGHT:
					cargoHatchHeight=Integer.parseInt(getXMLText(reader));
					break;		
				default:
					break;
				}
				break;
			case XMLStreamConstants.END_ELEMENT:
				elementName = reader.getLocalName();
				if (elementName.equals(TRANSPORT_AIRPLANE)) {
					transportAirplane=new TransportAirplane(modelName,boardNumber,flyingRange,capacityFuelTank,maxLoadCapacity,cargoLong,cargoWidth,cargoHeight,maxCargoWeight,cargoHatchWidth,cargoHatchHeight);
					transportAirplane.setFuelUsage(fuelUsage);
					transportAirplane.setCurCargoWeight(curCargoWeight);
					return transportAirplane;
				}
				break;
			}
		}
		throw new XMLStreamException("Unknown element in a 'air-company'");
	}
	
	private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
		String text = null;
		if (reader.hasNext()) {
			reader.next();
			text = reader.getText();
		}
		return text;
	}

}

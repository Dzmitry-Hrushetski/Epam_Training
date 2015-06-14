/**
 * 
 */
package com.epam.aircompany.parser;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.epam.aircompany.bean.AirplaneModelName;
import com.epam.aircompany.bean.PassangerAirplane;
import com.epam.aircompany.bean.TransportAirplane;
import com.epam.aircompany.parser.enumeration.AirplaneEnum;



import static com.epam.aircompany.parser.constant.ParserConstant.*;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class DOMAirCompanyBuilder extends AbstractAirCompanyBuilder {
	private static final Logger LOG=Logger.getLogger(DOMAirCompanyBuilder.class);
	private DocumentBuilder documentBuilder;

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
	public DOMAirCompanyBuilder() {
		super();
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		factory.setValidating(false);
		try {
			this.documentBuilder=factory.newDocumentBuilder();
		} catch (ParserConfigurationException exception) {
			LOG.error("Error configuration parser", exception);
		}
	}

	/* (non-Javadoc)
	 * @see com.epam.aircompany.parser.AbstractAirCompanyBuilder#buildAirCompany(java.lang.String)
	 */
	@Override
	public void buildAirCompany(String filePath) {
		Document document;
		try {
			document=documentBuilder.parse(new File(filePath));
			//document.getDocumentElement().normalize();
			Element root=document.getDocumentElement();
			
			/*String str1=root.getTagName();
			
			NodeList child=root.getChildNodes();
			int len=child.getLength();
			
			
			String strt;
			for(int i=0;i<child.getLength();i++) {
				Node e=child.item(i);
				strt=e.getNodeName();
			}
			*/
			
			NodeList companyName=root.getElementsByTagName("company-name");
			//NodeList companyName=root.getElementsByTagName(COMPANY_NAME);
			NodeList passangerAirplaneList=root.getElementsByTagName(PASSANGER_AIRPLANE);
			NodeList transportAirplaneList=root.getElementsByTagName(TRANSPORT_AIRPLANE);

			Element name=(Element) companyName.item(0);
			//airCompany.setCompanyName(getElementTextContent(name, AirplaneEnum.COMPANY_NAME.getValue()).replace(REPLACE_OLD_SYMBOL,REPLACE_NEW_SYMBOL).toUpperCase().trim());
			
			String str=getElementTextContent(name, COMPANY_NAME);
			
			for (int i=0;i<passangerAirplaneList.getLength();i++) {
				Element passangerAirplaneElement=(Element) passangerAirplaneList.item(i);
				PassangerAirplane passangerAirplane = buildPassangerAirplane(passangerAirplaneElement);
				airCompany.add(passangerAirplane);
			}
			
			for (int i=0;i<transportAirplaneList.getLength();i++) {
				Element transportAirplaneElement=(Element) transportAirplaneList.item(i);
				TransportAirplane transportAirplane=buildTransportAirplane(transportAirplaneElement);
				airCompany.add(transportAirplane);
			}
		} catch (SAXException exception) {
			LOG.error("Document parsing error", exception);
		} catch (IOException exception) {
			LOG.error("I/O error", exception);
		}
	}
	
	private PassangerAirplane buildPassangerAirplane(Element passangerAirplaneElement) {
		boardNumber=Integer.parseInt(passangerAirplaneElement.getAttribute(ID).substring(1));
		
		//String str=getElementTextContent(passangerAirplaneElement,(AirplaneEnum.MODEL_NAME).getValue().replace(REPLACE_OLD_SYMBOL,REPLACE_NEW_SYMBOL).toUpperCase());
		modelName=AirplaneModelName.valueOf(getElementTextContent(passangerAirplaneElement,getElementTextContent(passangerAirplaneElement,AirplaneEnum.MODEL_NAME.getValue().replace(REPLACE_OLD_SYMBOL,REPLACE_NEW_SYMBOL).toUpperCase())));
		
		flyingRange=Integer.parseInt(getElementTextContent(passangerAirplaneElement,getElementTextContent(passangerAirplaneElement,AirplaneEnum.FLYING_RANGE.getValue().replace(REPLACE_OLD_SYMBOL,REPLACE_NEW_SYMBOL).toUpperCase())));
		
		capacityFuelTank=Integer.parseInt(getElementTextContent(passangerAirplaneElement,getElementTextContent(passangerAirplaneElement,AirplaneEnum.CAPACITY_FUEL_TANK.getValue().replace(REPLACE_OLD_SYMBOL,REPLACE_NEW_SYMBOL).toUpperCase())));
	
		fuelUsage=Integer.parseInt(getElementTextContent(passangerAirplaneElement,getElementTextContent(passangerAirplaneElement,AirplaneEnum.FUEL_USAGE.getValue().replace(REPLACE_OLD_SYMBOL,REPLACE_NEW_SYMBOL).toUpperCase())));
		
		maxLoadCapacity=Integer.parseInt(getElementTextContent(passangerAirplaneElement,getElementTextContent(passangerAirplaneElement,AirplaneEnum.MAX_LOAD_CAPACITY.getValue().replace(REPLACE_OLD_SYMBOL,REPLACE_NEW_SYMBOL).toUpperCase())));
		
		economPlace=Integer.parseInt(getElementTextContent(passangerAirplaneElement,getElementTextContent(passangerAirplaneElement,AirplaneEnum.ECONOM_PLACE.getValue().replace(REPLACE_OLD_SYMBOL,REPLACE_NEW_SYMBOL).toUpperCase())));
		
		businessPlace=Integer.parseInt(getElementTextContent(passangerAirplaneElement,getElementTextContent(passangerAirplaneElement,AirplaneEnum.BUSINESS_PLACE.getValue().replace(REPLACE_OLD_SYMBOL,REPLACE_NEW_SYMBOL).toUpperCase())));
		
		maxBaggagePlace=Integer.parseInt(getElementTextContent(passangerAirplaneElement,getElementTextContent(passangerAirplaneElement,AirplaneEnum.MAX_BAGGAGE_PLACE.getValue().replace(REPLACE_OLD_SYMBOL,REPLACE_NEW_SYMBOL).toUpperCase())));
		
		maxBaggageWeight=Integer.parseInt(getElementTextContent(passangerAirplaneElement,getElementTextContent(passangerAirplaneElement,AirplaneEnum.MAX_BAGGAGE_WEIGHT.getValue().replace(REPLACE_OLD_SYMBOL,REPLACE_NEW_SYMBOL).toUpperCase())));
		
		curBaggagePlace=Integer.parseInt(getElementTextContent(passangerAirplaneElement,getElementTextContent(passangerAirplaneElement,AirplaneEnum.CUR_BAGGAGE_PLACE.getValue().replace(REPLACE_OLD_SYMBOL,REPLACE_NEW_SYMBOL).toUpperCase())));
		
		curBaggageWeight=Integer.parseInt(getElementTextContent(passangerAirplaneElement,getElementTextContent(passangerAirplaneElement,AirplaneEnum.CUR_BAGGAGE_WEIGHT.getValue().replace(REPLACE_OLD_SYMBOL,REPLACE_NEW_SYMBOL).toUpperCase())));
		
		PassangerAirplane passangerAirplane=new PassangerAirplane(modelName,boardNumber,flyingRange,capacityFuelTank,maxLoadCapacity,maxBaggagePlace,maxBaggageWeight);
		passangerAirplane.setFuelUsage(fuelUsage);
		passangerAirplane.setEconomPlace(economPlace);
		passangerAirplane.setBusinessPlace(businessPlace);
		passangerAirplane.setCurBaggagePlace(curBaggagePlace);
		passangerAirplane.setCurBaggageWeight(curBaggageWeight);
		return passangerAirplane;
	}
	
	private TransportAirplane buildTransportAirplane(Element transportAirplaneElement) {
		boardNumber=Integer.parseInt(transportAirplaneElement.getAttribute(ID).substring(1));
		
		//String str=getElementTextContent(passangerAirplaneElement,(AirplaneEnum.MODEL_NAME).getValue().replace(REPLACE_OLD_SYMBOL,REPLACE_NEW_SYMBOL).toUpperCase());
		modelName=AirplaneModelName.valueOf(getElementTextContent(transportAirplaneElement,getElementTextContent(transportAirplaneElement,AirplaneEnum.MODEL_NAME.getValue().replace(REPLACE_OLD_SYMBOL,REPLACE_NEW_SYMBOL).toUpperCase())));
		
		flyingRange=Integer.parseInt(getElementTextContent(transportAirplaneElement,getElementTextContent(transportAirplaneElement,AirplaneEnum.FLYING_RANGE.getValue().replace(REPLACE_OLD_SYMBOL,REPLACE_NEW_SYMBOL).toUpperCase())));
		
		capacityFuelTank=Integer.parseInt(getElementTextContent(transportAirplaneElement,getElementTextContent(transportAirplaneElement,AirplaneEnum.CAPACITY_FUEL_TANK.getValue().replace(REPLACE_OLD_SYMBOL,REPLACE_NEW_SYMBOL).toUpperCase())));
	
		fuelUsage=Integer.parseInt(getElementTextContent(transportAirplaneElement,getElementTextContent(transportAirplaneElement,AirplaneEnum.FUEL_USAGE.getValue().replace(REPLACE_OLD_SYMBOL,REPLACE_NEW_SYMBOL).toUpperCase())));
		
		maxLoadCapacity=Integer.parseInt(getElementTextContent(transportAirplaneElement,getElementTextContent(transportAirplaneElement,AirplaneEnum.MAX_LOAD_CAPACITY.getValue().replace(REPLACE_OLD_SYMBOL,REPLACE_NEW_SYMBOL).toUpperCase())));
		
		cargoLong=Integer.parseInt(getElementTextContent(transportAirplaneElement,getElementTextContent(transportAirplaneElement,AirplaneEnum.CARGO_LONG.getValue().replace(REPLACE_OLD_SYMBOL,REPLACE_NEW_SYMBOL).toUpperCase())));
		
		cargoWidth=Integer.parseInt(getElementTextContent(transportAirplaneElement,getElementTextContent(transportAirplaneElement,AirplaneEnum.CARGO_WIDTH.getValue().replace(REPLACE_OLD_SYMBOL,REPLACE_NEW_SYMBOL).toUpperCase())));
		
		cargoHeight=Integer.parseInt(getElementTextContent(transportAirplaneElement,getElementTextContent(transportAirplaneElement,AirplaneEnum.CARGO_HEIGHT.getValue().replace(REPLACE_OLD_SYMBOL,REPLACE_NEW_SYMBOL).toUpperCase())));	
	
		maxCargoWeight=Integer.parseInt(getElementTextContent(transportAirplaneElement,getElementTextContent(transportAirplaneElement,AirplaneEnum.MAX_CARGO_WEIGHT.getValue().replace(REPLACE_OLD_SYMBOL,REPLACE_NEW_SYMBOL).toUpperCase())));
		
		curCargoWeight=Integer.parseInt(getElementTextContent(transportAirplaneElement,getElementTextContent(transportAirplaneElement,AirplaneEnum.CUR_CARGO_WEIGHT.getValue().replace(REPLACE_OLD_SYMBOL,REPLACE_NEW_SYMBOL).toUpperCase())));
		
		cargoHatchWidth=Integer.parseInt(getElementTextContent(transportAirplaneElement,getElementTextContent(transportAirplaneElement,AirplaneEnum.CARGO_HATCH_WIDTH.getValue().replace(REPLACE_OLD_SYMBOL,REPLACE_NEW_SYMBOL).toUpperCase())));
		
		cargoHatchHeight=Integer.parseInt(getElementTextContent(transportAirplaneElement,getElementTextContent(transportAirplaneElement,AirplaneEnum.CARGO_HATCH_HEIGHT.getValue().replace(REPLACE_OLD_SYMBOL,REPLACE_NEW_SYMBOL).toUpperCase())));
		
		TransportAirplane transportAirplane=new TransportAirplane(modelName,boardNumber,flyingRange,capacityFuelTank,maxLoadCapacity,cargoLong,cargoWidth,cargoHeight,maxCargoWeight,cargoHatchWidth,cargoHatchHeight);
		transportAirplane.setFuelUsage(fuelUsage);
		transportAirplane.setCurCargoWeight(curCargoWeight);
		return transportAirplane;	
	}
		
	private String getElementTextContent(Element element, String elementName) {
		NodeList nList = element.getElementsByTagName(elementName);
		Node node = nList.item(0);
		String text = node.getTextContent();
		return text;
	}

}

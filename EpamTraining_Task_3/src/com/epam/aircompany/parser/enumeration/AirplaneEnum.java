/**
 * 
 */
package com.epam.aircompany.parser.enumeration;

/**
 * @author Dzmitry Hrushetski
 *
 */
public enum AirplaneEnum {
	COMPANY_NAME("tns:company-name"),
	MODEL_NAME("tns:model-name"),
	FLYING_RANGE("tns:flying-range"),
	CAPACITY_FUEL_TANK("tns:capacity-fuel-tank"),
	FUEL_USAGE("tns:fuel-usage"),
	MAX_LOAD_CAPACITY("tns:max-load-capacity"),
	
	ECONOM_PLACE("tns:econom-place"),
	BUSINESS_PLACE("tns:business-place"),
	MAX_BAGGAGE_PLACE("tns:max-baggage-place"),
	MAX_BAGGAGE_WEIGHT("tns:max-baggage-weight"),
	CUR_BAGGAGE_PLACE("tns:cur-baggage-place"),
	CUR_BAGGAGE_WEIGHT("tns:cur-baggage-weight"),
	
	CARGO_LONG("tns:cargo-long"),
	CARGO_WIDTH("tns:cargo-width"),
	CARGO_HEIGHT("tns:cargo-height"),
	MAX_CARGO_WEIGHT("tns:max-cargo-weight"),
	CUR_CARGO_WEIGHT("tns:cur-cargo-weight"),
	CARGO_HATCH_WIDTH("tns:cargo-hatch-width"),
	CARGO_HATCH_HEIGHT("tns:cargo-hatch-height");
	
	private String value;

	private AirplaneEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}

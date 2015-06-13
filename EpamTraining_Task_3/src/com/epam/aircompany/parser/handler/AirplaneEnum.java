/**
 * 
 */
package com.epam.aircompany.parser.handler;

/**
 * @author Dzmitry Hrushetski
 *
 */
public enum AirplaneEnum {
	COMPANY_NAME("company-name"),
	MODEL_NAME("model-name"),
	FLYING_RANGE("flying-range"),
	CAPACITY_FUEL_TANK("capacity-fuel-tank"),
	FUEL_USAGE("fuel-usage"),
	MAX_LOAD_CAPACITY("max-load-capacity"),
	
	ECONOM_PLACE("econom-place"),
	BUSINESS_PLACE("business-place"),
	MAX_BAGGAGE_PLACE("max-baggage-place"),
	MAX_BAGGAGE_WEIGHT("max-baggage-weight"),
	CUR_BAGGAGE_PLACE("cur-baggage-place"),
	CUR_BAGGAGE_WEIGHT("cur-baggage-weight"),
	
	CARGO_LONG("cargo-long"),
	CARGO_WIDTH("cargo-width"),
	CARGO_HEIGHT("cargo-height"),
	MAX_CARGO_WEIGHT("max-cargo-weight"),
	CUR_CARGO_WEIGHT("cur-cargo-weight"),
	CARGO_HATCH_WIDTH("cargo-hatch-width"),
	CARGO_HATCH_HEIGHT("cargo-hatch-height");
	
	private String value;

	private AirplaneEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}

/**
 * 
 */
package com.epam.aircompany.bean;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class Airplane extends Entity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5802957980716076898L;
	private AirplaneType airplaneType;
	private String boardNumber;
	/**
	 * @return the airplaneType
	 */
	public AirplaneType getAirplaneType() {
		return airplaneType;
	}
	/**
	 * @param airplaneType the airplaneType to set
	 */
	public void setAirplaneType(AirplaneType airplaneType) {
		this.airplaneType = airplaneType;
	}
	/**
	 * @return the boardNumber
	 */
	public String getBoardNumber() {
		return boardNumber;
	}
	/**
	 * @param boardNumber the boardNumber to set
	 */
	public void setBoardNumber(String boardNumber) {
		this.boardNumber = boardNumber;
	}
}

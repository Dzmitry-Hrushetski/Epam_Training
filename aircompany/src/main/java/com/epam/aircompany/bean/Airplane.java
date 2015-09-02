
package com.epam.aircompany.bean;

/**
 * The Class Airplane is a Java Bean that stores data on model and board number of the airplane.
 * 
 * @author Dzmitry Hrushetski
 */
public class Airplane extends Entity{
	private static final long serialVersionUID = 5802957980716076898L;
	private AirplaneType airplaneType;
	private String boardNumber;
	
	/**
	 * Gets the airplane type.
	 *
	 * @return AirplaneType
	 * @see com.epam.aircompany.bean.AirplaneType
	 */
	public AirplaneType getAirplaneType() {
		return airplaneType;
	}
	
	/**
	 * Sets the airplane type.
	 *
	 * @param airplaneType the new airplane type
	 * @see com.epam.aircompany.bean.AirplaneType
	 */
	public void setAirplaneType(AirplaneType airplaneType) {
		this.airplaneType = airplaneType;
	}
	
	/**
	 * Gets the board number of airplane.
	 *
	 * @return the board number
	 */
	public String getBoardNumber() {
		return boardNumber;
	}
	
	/**
	 * Sets the board number of airplane.
	 *
	 * @param boardNumber the new board number
	 */
	public void setBoardNumber(String boardNumber) {
		this.boardNumber = boardNumber;
	}
}

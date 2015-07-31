/**
 * 
 */
package com.epam.web.aircompany.bean;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class Airplane extends AirplaneType {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5802957980716076898L;
	private String boardNumber;
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

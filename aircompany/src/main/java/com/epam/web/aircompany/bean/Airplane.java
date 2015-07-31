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
	
	public String getBoardNumber() {
		return boardNumber;
	}
	public void setBoardNumber(String boardNumber) {
		this.boardNumber = boardNumber;
	}
}

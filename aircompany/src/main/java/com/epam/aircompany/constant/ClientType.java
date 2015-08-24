/**
 * 
 */
package com.epam.aircompany.constant;

/**
 * @author Dzmitry Hrushetski
 *
 */
public enum ClientType {
	CHEEF (1),
	ADMIN (2),
	MANAGER (3);
	
	private int clientType;
	
	private ClientType(int clientType) {
		this.clientType = clientType;
	}
}

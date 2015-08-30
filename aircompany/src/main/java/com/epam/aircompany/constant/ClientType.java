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
		this.setClientType(clientType);
	}

	/**
	 * @return the clientType
	 */
	public int getClientType() {
		return clientType;
	}

	/**
	 * @param clientType the clientType to set
	 */
	public void setClientType(int clientType) {
		this.clientType = clientType;
	}
}

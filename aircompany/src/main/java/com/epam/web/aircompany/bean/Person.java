/**
 * 
 */
package com.epam.web.aircompany.bean;

/**
 * @author Dzmitry Hrushetski
 *
 */
public class Person extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6286194673635091293L;
	private String firstName;
	private String lastName;
	private String addres;
	private String phone;
	private String userName;
	private String password;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddres() {
		return addres;
	}
	public void setAddres(String addres) {
		this.addres = addres;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

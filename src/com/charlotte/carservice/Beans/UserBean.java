/**
 * 
 */
package com.charlotte.carservice.Beans;

/**
 * @author Pritam
 *
 */
public class UserBean {
	private String emailId;
	private String fName;
	private String lName;
	private String address;
	private String password;
	private String contact;
	public UserBean()
	{
		
	}
	
	public UserBean(String fName, String lName, String email, String add,
			String password2, String contact2) {
		// TODO Auto-generated constructor stub
		this.fName = fName;
		this.lName = lName;
		this.emailId = email;
		this.address = add;
		this.password = password2;
		this.contact = contact2;
	}
	/**
	 * @return the email_id
	 */
	public String getEmailId() {
		return emailId;
	}
	/**
	 * @param email_id the email_id to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	/**
	 * @return the fName
	 */
	public String getfName() {
		return fName;
	}
	/**
	 * @param fName the fName to set
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}
	/**
	 * @return the lName
	 */
	public String getlName() {
		return lName;
	}
	/**
	 * @param lName the lName to set
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		address = address;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}
	/**
	 * @param contact the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	
}

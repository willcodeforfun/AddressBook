package com.au.data;

/**
 * Single contact that contains the name, phone number and address
 */
public class Contact {

	/**
	 * The first name of the contact
	 */
	private String firstName;
	
	/**
	 * The last name of the contact
	 */
	private String lastName;
	
	/**
	 * The mobile number of the contact
	 */
	private String mobileNumber;
	
	/** 
	 * Default constructor
	 */
	public Contact() {	}
	
	/**
	 * Create a contact with first name, last name and mobile number
	 * 
	 * @param firstName
	 * @param lastName
	 * @param mobileNumber
	 */
	public Contact(String firstName, String lastName, String mobileNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
	}
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber
	 *            the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * The hashcode for the Contact class
	 */
	@Override
	public int hashCode() {
		return ((this.firstName.hashCode() + this.lastName.hashCode() + this.mobileNumber
				.hashCode()));
	}
	
	/**
	 * The equals method for the contact class
	 */
	@Override
	public boolean equals(Object obj) {
		if(null != obj && obj instanceof Contact) {
			Contact compareContact = (Contact)obj;
			return (this.firstName.equalsIgnoreCase(compareContact.getFirstName())
					&& this.lastName.equalsIgnoreCase(compareContact.getLastName())
					&& this.mobileNumber.equalsIgnoreCase(compareContact.getMobileNumber())) ? true : false;
		}
		return false;
	}

	/**
	 * This method displays the contact details in String format
	 */
	@Override
	public String toString() {
		StringBuffer display = new StringBuffer();
		display.append("First Name : " + this.firstName + "\n");
		display.append("Last Name : " + this.lastName + "\n");
		display.append("Mobile Number : " + this.mobileNumber + "\n");
		
		return display.toString();
	}
}

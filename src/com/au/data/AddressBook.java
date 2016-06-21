package com.au.data;

import java.util.HashSet;

/**
 * Address book that will contain the contacts
 */
@SuppressWarnings("rawtypes")
public class AddressBook implements Comparable {
	
	/**
	 * The name of the address book
	 */
	private String addressBookName;
	
	/**
	 * The contact list for the address book
	 */
	private HashSet<Contact> contacts = new HashSet<Contact>();
	
	/**
	 * Default constructor
	 */
	public AddressBook(){
	}
	
	/**
	 * Setting addressBook name
	 */
	public AddressBook (String bookName){
		this.addressBookName = bookName;
	}
	
	/**
	 * @return the addressBookName
	 */
	public String getAddressBookName() {
		return addressBookName;
	}
	/**
	 * @param addressBookName the addressBookName to set
	 */
	public void setAddressBookName(String addressBookName) {
		this.addressBookName = addressBookName;
	}
	/**
	 * @return the contacts
	 */
	public HashSet<Contact> getContacts() {
		return contacts;
	}
	/**
	 * @param contacts the contacts to set
	 */
	public void setContacts(HashSet<Contact> contacts) {
		this.contacts = contacts;
	}
	
	public boolean removeAllContacts(){
		if(null != contacts && !contacts.isEmpty()) {
			contacts.clear();
		}  
		return (null == contacts || contacts.isEmpty()) ? true : false;
	}
	
	/**
	 * This method displays the address book name and contact list details in String format 
	 */
	@Override
	public String toString() {
		
		StringBuffer display = new StringBuffer();
		display.append("Address Book Name : " + this.addressBookName + "\n");
		display.append("Contact List : \n " + this.contacts.toString()+ "\n");
		
		return display.toString();
	}

	@Override
	public int compareTo(Object obj) {
		// compares the string lexicographically
		return this.addressBookName.compareTo(((AddressBook)obj).getAddressBookName());
	}
}

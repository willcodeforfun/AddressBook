package com.au.data;

import java.util.TreeMap;

import org.apache.log4j.Logger;

/**
 * Books class contains the addressBook hashmap
 */
public class Books {
	
	/**
	 * logger for the Books class
	 */
	Logger log = Logger.getLogger(Books.class);
	
	/**
	 * The map that contains all the address books
	 */
	private TreeMap<String, AddressBook> addressBooks = new TreeMap<String, AddressBook>();

	/**
	 * @return the addressBooks
	 */
	public TreeMap<String, AddressBook> getAddressBooks() {
		return addressBooks;
	}

	/**
	 * @param addressBooks the addressBooks to set
	 */
	public void setAddressBooks(TreeMap<String, AddressBook> addressBooks) {
		this.addressBooks = addressBooks;
	}
	
	/**
	 * @param addressBookName the address book name
	 * @return the address book based on name
	 */
	public AddressBook getAddressBook(String addressBookName) {
		return this.addressBooks.get(addressBookName);
	}
	
	/**
	 * Method to remove all the address books
	 * 
	 * @return if the address books are removed
	 */
	public boolean removeAllAddressBooks() {
		this.addressBooks.clear();
		this.addressBooks = null;
		log.debug("removed all address books");
		return (null == addressBooks)? true : false;
	}
	
	/**
	 * This method displays the address book names and details in String format
	 * 
	 * @return the output in String format
	 */
	@Override
	public String toString() {
		
		StringBuffer display = new StringBuffer();
		display.append("Address Books : \n " + this.addressBooks.toString());
		return display.toString();
	}

}

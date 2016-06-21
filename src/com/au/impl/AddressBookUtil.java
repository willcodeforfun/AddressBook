package com.au.impl;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.au.data.AddressBook;
import com.au.data.Books;
import com.au.data.Contact;

/**
 * The class that contains all the criteria for the address book
 */
public class AddressBookUtil implements AddressBookConstants {

	/**
	 * Logger for AddressBookUtil
	 */
	Logger log = Logger.getLogger(AddressBookUtil.class);

	/**
	 * The list of address books
	 */
	private Books books;
	
	/**
	 * @return the books
	 */
	public Books getBooks() {
		return books;
	}

	/**
	 * @param books the books to set
	 */
	public void setBooks(Books books) {
		this.books = books;
	}
	
	// Create and maintain multiple Address Books

	/**
	 * Method to create new AddressBook
	 * 
	 * @param bookName
	 */
	public void createAddressBook(String bookName) {
		if (books == null) {
			books = new Books();
		}
		AddressBook newBook = new AddressBook(bookName);
		books.getAddressBooks().put(bookName, newBook);
		log.debug("Added address book: " + bookName);
	}

	/**
	 * Method to remove the address book from the list of books
	 * 
	 * @param bookName
	 */
	public void removeAddressBook(String bookName) {
		if (null != books) {
			books.getAddressBooks().remove(bookName);
			log.debug("Removed address book: " + bookName);
		}
	}
	
	/**
	 * Method to remove all the address book
	 * 
	 * @return true if all the address books are successfully removed
	 */
	public boolean removeAllAddressBooks(){
		return (null != books && books.removeAllAddressBooks()) ? true : false;
	}
	
	/**
	 * Sort all the address books 
	 * 
	 * @return the collection of sorted books
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AddressBook> sortAddressBooks() {
		
		List listofAddressBooks = new LinkedList<AddressBook>(books.getAddressBooks().values());
		
		// Sort the address books
		Collections.sort(listofAddressBooks);
		books.getAddressBooks().clear();
		AddressBook sortedAddressBook = new AddressBook();
		Iterator itr = listofAddressBooks.iterator();
		
		// Add the sorted list to the map
		while(itr.hasNext()) {
			sortedAddressBook = (AddressBook) itr.next();
			books.getAddressBooks().put(sortedAddressBook.getAddressBookName(), sortedAddressBook);
		}
		log.debug("Address books sorted");
		return listofAddressBooks;
	}
	
	// Add and remove contact details in Address Book

	/**
	 * Method to add a new contact to the address book
	 * 
	 * @param addressBookName
	 * @param firstName
	 * @param lastName
	 * @param mobilePhone
	 */
	public void addContactDetails(String addressBookName, String firstName,
			String lastName, String mobilePhone) {

		Contact newContact = new Contact(firstName, lastName, mobilePhone);
		AddressBook addressBook = books.getAddressBook(addressBookName);
		
		// Add the contact to the address book
		addressBook.getContacts().add(newContact);
		log.debug("Added new contact to address book " + addressBookName);
	}

	/**
	 * Method to remove the contact details from the address book
	 * 
	 * @param addressBookName
	 * @param criteria
	 * @param contactDetail
	 */
	public void removeContactDetails(String addressBookName, String criteria,
			String contactDetail) {

		AddressBook addressBook = books.getAddressBook(addressBookName);
		Contact matchingContact = searchContact(addressBook, criteria,
				contactDetail);
		if (null != matchingContact) {
			// remove contact from the address books
			addressBook.getContacts().remove(matchingContact);
			log.debug("Removed contact from address book " + addressBookName);
		}
	}

	/**
	 * Method to search the contact from the address book
	 * 
	 * @param addressBook
	 * @param criteria
	 * @param searchValue
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private Contact searchContact(AddressBook addressBook, String criteria,
			String searchValue) {
		if(null != addressBook) {
			HashSet contacts = addressBook.getContacts();
			Iterator itr = contacts.iterator();
			Contact comparingContact = new Contact();
			while (itr.hasNext()) {
				comparingContact = (Contact) itr.next();
				if(criteria.toUpperCase().equalsIgnoreCase(FIRST_NAME)) {
					return comparingContact.getFirstName().equalsIgnoreCase(searchValue)? comparingContact : null;
				} else if (criteria.toUpperCase().equalsIgnoreCase(LAST_NAME)) {
					return comparingContact.getLastName().equalsIgnoreCase(searchValue)? comparingContact : null;
				} else {
					return  comparingContact.getMobileNumber().equalsIgnoreCase(searchValue)? comparingContact : null;
				}
			}
			return null;
		} else {
			return null;
		}
	}

	// Print All Contacts and Unique contacts
	
	/**
	 * Method to print the contacts in the address book in an address book
	 * 
	 * @param addressBookName
	 * @return if the printing was successful
	 */
	public boolean printAddressBookContacts(String addressBookName) {
		if (null != books
				&& books.getAddressBooks().containsKey(addressBookName)) {
			System.out.println(books.getAddressBooks().get(addressBookName).toString());
			log.debug("Print the contacts of the address book");
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Method to print all the contacts in the address book
	 * 
	 * @return if the printing was successful
	 */
	@SuppressWarnings("rawtypes")
	public boolean printAddressBookContacts() {
		if (null != books) {
			Iterator itr = books.getAddressBooks().values().iterator();
			while (itr.hasNext()) {
				System.out.println(((AddressBook) itr.next()).toString());
			}
			log.debug("Print the contacts of the address book/s ");
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Method to print all the unique contacts in all the address books
	 * 
	 * @return if the printing was successful
	 */
	@SuppressWarnings("rawtypes")
	public boolean printUniqueAddressBookContacts() {
		if (null != books) {
			HashSet<Contact> uniqueContacts = new HashSet<Contact>();
			Iterator itr = books.getAddressBooks().values().iterator();
			while (itr.hasNext()) {
				uniqueContacts.addAll(((AddressBook) itr.next()).getContacts());
			}

			System.out.println(uniqueContacts.toString());
			log.debug("Print the unique contacts across all the address books ");
			return true;
		} else {
			return false;
		}
	}
}


package com.au.test;

import java.util.List;

import junit.framework.TestCase;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.au.data.AddressBook;
import com.au.impl.AddressBookUtil;

/**
 * Test class to test all the cases in the AddressBookUtil class
 */
public class AddressBookTest extends TestCase {
	
	/**
	 * The class to be tested
	 */
	private AddressBookUtil addressBookUtils = new AddressBookUtil();
	
	/**
	 * Setup before the tests run
	 */
	@BeforeClass
	@Override
	public void setUp() {
		addressBookUtils.createAddressBook("NewAddressBook");
		addressBookUtils.addContactDetails("NewAddressBook", "hello", "World", "0400925896");
		
		addressBookUtils.createAddressBook("NewAddressBook2");
		addressBookUtils.addContactDetails("NewAddressBook2", "hello2", "World2", "0400925896");
	}

	// Adding and removing contact
	
	/**
	 * Test to create a new contact
	 */
	@Test
	public void testAddNewContact() {
		addressBookUtils.addContactDetails("NewAddressBook", "hello", "World", "0400925896");
		assertTrue("New contact is added successfully", addressBookUtils.getBooks().getAddressBook("NewAddressBook").getContacts().size() == 1);
	}
	
	/**
	 * Test to remove a contact
	 */
	@Test
	public void testRemoveContact() {
		assertTrue("New contact is added successfully", addressBookUtils.getBooks().getAddressBook("NewAddressBook2").getContacts().size() == 1);
		addressBookUtils.removeContactDetails("NewAddressBook2", "firstName", "hello2");
		assertTrue("New contact is added successfully", addressBookUtils.getBooks().getAddressBook("NewAddressBook2").getContacts().size() == 0);
	}
	
	// Printing contacts from address book and unique set of contacts
	
	/**
	 *  Test to print the contact details for all contacts in an address list
	 */
	@Test
	public void testPrintContactList() {
		addressBookUtils.addContactDetails("NewAddressBook", "contact1", "business", "0400925896");
		addressBookUtils.addContactDetails("NewAddressBook", "contact2", "florist", "0400925896");
		addressBookUtils.addContactDetails("NewAddressBook", "contact1", "cafe", "0400925896");
		assertTrue("Print the contacts", addressBookUtils.printAddressBookContacts("NewAddressBook"));
	}
	
	/**
	 *  Test to print the contact details for all contacts in an address list
	 */
	@Test
	public void testPrintAllContactList() {
		assertTrue("Print the contacts", addressBookUtils.printAddressBookContacts());
	}
	
	/**
	 *  Test to print the contact details for all contacts in an address list
	 */
	public void testPrintUniqueContactList() {
		assertTrue("Print the contacts", addressBookUtils.printUniqueAddressBookContacts());
	}
	
	
	// Maintaining Address books
	
	/**
	 * Test to create a new Address book so that there are multiple address books
	 */
	@Test
	public void testAddNewAddressBook() {
		addressBookUtils.createAddressBook("MyAddressBook");
		AddressBook searchedBook = addressBookUtils.getBooks().getAddressBook("MyAddressBook");
		assertTrue("Address book is added successfully", (null != searchedBook)	);
	}
	
	/**
	 * Test to sort the address books
	 */
	@SuppressWarnings("rawtypes")
	@Test
	public void testSortAddressBooks() {
		addressBookUtils.createAddressBook("Delta");
		addressBookUtils.createAddressBook("Alpha");
		addressBookUtils.createAddressBook("Tango");
		List sortedBooks = addressBookUtils.sortAddressBooks();
		addressBookUtils.printAddressBookContacts();
		assertTrue("Address book is added successfully", (null != sortedBooks)	);
	}
	
	/**
	 * Remove the objects from memory and set to null
	 */
	@AfterClass
	@Override
	public void tearDown() {
		assertTrue("Address books removed successfully", addressBookUtils.removeAllAddressBooks());
	}
	
}

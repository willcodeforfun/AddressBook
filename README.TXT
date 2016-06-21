##############################################################################################################################################

									READ ME
									
##############################################################################################################################################											
Java version 1.7.0.75
Junit version 4.12
Logger Apache Log4j
IDE Eclipse Helios - supports upto Java version 1.6

Assumtions

Maintaining address book involves, 
1) creating multiple address books. 
2) removing either one address book by name or deleting the entire set.
3) Sorting the address lists

Removing a contact from an address list requires the following details
1) name of the address list
2) the type of detail of the contact, i.e, if the spplied parameter is the first name, last name or the mobile number
3) the value to be deleted 

Values are printed on the console
while printing a contact list, if no addresslist name has been specified, all the contacts in all the address list will be printed


Test cases
Removing the addresslists is handled in the tear down, as the sequence of test cases cannot be fixed and can causes other cases to fail if it runs earlier





 
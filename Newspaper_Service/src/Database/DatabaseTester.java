package Database;

import Customer.Customer;
import Customer.CustomerHandler;
import junit.framework.TestCase;

public class DatabaseTester extends TestCase{
	/*
	Test #: 1
	Test Objective: Create a customer
	Inputs: name = "Alice", address = "Wonderland", phoneNo = "987654321", isAway = false
	Expected Output: true
	*/
	public void testCreateCustomer() 
	{
		try {
			Database db = new Database();
		    Customer customer = new Customer("Alice", "Wonderland", 987654321, false);
		    boolean isInserted = db.insertCustomerDetailsAccount(customer);
		    assertTrue(isInserted);
		}
		catch (Exception e) {
			fail("Exception not expected");
		}
	}
	
	/*
	Test #: 2
	Test Objective: Get all customers
	Inputs: 
	Expected Output: Row number?
	*/
	public void testGetAllCustomers() 
	{
		try {
			 Database db = new Database();
			 assertNotNull(db.getAllCustomers());
		}
		catch (Exception e) {
			fail("Exception not expected");
		}
	}
	
	/*
	Test #: 3
	Test Objective: Update customer successfully
	Inputs: id = 1, name = "John", address = "Damn", phoneNo = "987654321", isAway = false
	Expected Output: True
	*/
	
	public void testUpdateCustomer() {
		
		//Test to catch invalid customer name
		try {
			Database db = new Database();
			assertTrue(db.updateCustomerById(1, new Customer("John", "Damn", 987654321, false)));
		}
		catch (Exception e) {
			fail("Exception: Customer doesnt exist or test is wrong");
		}
		
	}
	
	/*
	Test #: 4
	Test Objective: Delete customer successfully
	Inputs: id = 1
	Expected Output: True
	*/
	
	public void testDeleteCustomer() {
		
		//Test to catch invalid customer name
		try {
			Database db = new Database();
			assertTrue(db.deleteCustomerById(1));
		}
		catch (Exception e) {
			fail("Exception: Customer doesnt exist or test is wrong");
		}
	}
	
}

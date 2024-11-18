package Database;

import Customer.Customer;
import Customer.CustomerHandler;
import junit.framework.TestCase;

public class DatabaseTester extends TestCase{
	/*
	Test #: 1
	Test Objective: Create a customer
	Inputs: name = "John Doe", address = "Athlone", phoneNo = "123456789", isAway = false
	Expected Output: true
	*/
	public void testCreateCustomer001() 
	{
		try {
			Customer custObj = new Customer("John Doe", "Athlone", 123456789, false);
			
			// Use getters to check for object creation
			assertEquals(custObj.getId(), custObj.getId());
			assertEquals("John Doe", custObj.getName());
			assertEquals("Athlone", custObj.getAddress());
			assertEquals(123456789, custObj.getPhoneNo());
			assertEquals(false, custObj.getIsAway());
		}
		catch (CustomerHandler e) {
			fail("Exception not expected");
		}
	}
}

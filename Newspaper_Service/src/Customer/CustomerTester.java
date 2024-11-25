package Customer;

import org.junit.Test;

import junit.framework.TestCase;
public class CustomerTester extends TestCase {

	/*
	Test #: 1
	Test Objective: Create a Customer
	Inputs: name = "John Doe", address = "Athlone", phoneNo = "123456789", isAway = false, subscriptions = irish & forbes
	Expected Output: Customer Object created with id = 0, "John Doe", custAddr = "Athlone", phoneNo = "123456789", isAway = false, subscriptions = irish & forbes
	*/
	
public void testCustomer001() {
		
		//Create the Customer Object
		try {
			Customer custObj = new Customer("John Doe", "Athlone", 123456789, false);
			
			// Use getters to check for object creation
			assertEquals(0, custObj.getId());
			assertEquals("John Doe", custObj.getName());
			assertEquals("Athlone", custObj.getAddress());
			assertEquals(123456789, custObj.getPhoneNo());
			assertEquals(false, custObj.getIsAway());
		}
		catch (CustomerHandler e) {
			fail("Exception not expected");
		}
		
	}

	/*
	Test #: 2
	Test Objective: Catch invalid customer name
	Inputs: name = "J"
	Expected Output: Exception Message -> "Customer name cannot be less than 3 characters."
	*/
	
	public void testValidateName001() throws CustomerHandler {
		
		//Test to catch invalid customer name
		try {
			
			//Call method under test
			Customer.validateName("J");
			fail("Exception not expected");
		}
		catch (CustomerHandler e) {
			assertEquals("Customer name cannot be less than 3 characters.", e.getMessage());
		}
		
	}
	
	/*
	Test #: 3
	Test Objective: Catch invalid customer name
	Inputs: name = "123456789101112131415"
	Expected Output: Exception Message -> "Customer name cannot be more than 15 characters."
	*/
	
	public void testValidateName002() throws CustomerHandler {
		
		//Test to catch invalid customer name
		try {
			
			//Call method under test
			Customer.validateName("123456789101112131415");
			fail("Exception not expected");
		}
		catch (CustomerHandler e) {
			assertEquals("Customer name cannot be more than 15 characters.", e.getMessage());
		}
		
	}
	
	/*
	Test #: 4
	Test Objective: Catch invalid customer name
	Inputs: name = "" (nothing!)
	Expected Output: Exception Message -> "Customer name cannot be empty!"
	*/
	
	public void testValidateName003() throws CustomerHandler {
		
		//Test to catch invalid customer name
		try {
			
			//Call method under test
			Customer.validateName("");
			fail("Exception not expected");
		}
		catch (CustomerHandler e) {
			assertEquals("Customer name cannot be empty!", e.getMessage());
		}
		
	}
	
	/*
	Test #: 5
	Test Objective: Catch invalid customer address
	Inputs: name = "a"
	Expected Output: Exception Message -> "Customer name cannot be less than 5 characters."
	*/
	
	public void testValidateAddress001() throws CustomerHandler {
		
		//Test to catch invalid customer name
		try {
			
			//Call method under test
			Customer.validateAddress("a");
			fail("Exception not expected");
		}
		catch (CustomerHandler e) {
			assertEquals("Customer name cannot be less than 5 characters.", e.getMessage());
		}
		
	}
	
	/*
	Test #: 6
	Test Objective: Catch invalid customer address
	Inputs: name = "thisisatestforthevalidateaddress"
	Expected Output: Exception Message -> "Customer name cannot be more than 25 characters."
	*/
	
	public void testValidateAddress002() throws CustomerHandler {
		
		//Test to catch invalid customer name
		try {
			
			//Call method under test
			Customer.validateAddress("thisisatestforthevalidateaddress");
			fail("Exception not expected");
		}
		catch (CustomerHandler e) {
			assertEquals("Customer name cannot be more than 25 characters.", e.getMessage());
		}
		
	}
	
	/*
	Test #: 7
	Test Objective: Catch invalid customer address
	Inputs: name = "" (empty!)
	Expected Output: Exception Message -> "Customer address cannot be empty!"
	*/
	
	public void testValidateAddress003() throws CustomerHandler {
		
		//Test to catch invalid customer name
		try {
			
			//Call method under test
			Customer.validateAddress("");
			fail("Exception not expected");
		}
		catch (CustomerHandler e) {
			assertEquals("Customer address cannot be empty!", e.getMessage());
		}
		
	}
	
	/*
	Test #: 8
	Test Objective: Catch invalid customer phone number
	Inputs: name = 1
	Expected Output: Exception Message -> "Customer phone number cannot be less than 9 characters."
	*/
	
	public void testValidatePhoneNo001() throws CustomerHandler {
		
		//Test to catch invalid customer name;
		try {
			
			//Call method under test
			Customer.validatePhone(12345678);
			fail("Exception not expected");
		}
		catch (CustomerHandler e) {
			assertEquals("Customer phone number can't be less than 9 digits.", e.getMessage());
		}
		
	}
	
	/*
	Test #: 9
	Test Objective: Catch invalid customer phone number
	Inputs: name = 1234567891
	Expected Output: Exception Message -> "Customer phone number can't be more than 9 digits."
	*/
	
	public void testValidatePhoneNo002() throws CustomerHandler {
		
		//Test to catch invalid customer name
		try {
			
			//Call method under test
			Customer.validatePhone(1234567891);
			fail("Exception not expected");
		}
		catch (CustomerHandler e) {
			assertEquals("Customer phone number can't be more than 9 digits.", e.getMessage());
		}
		
	}
//	
//	Test #: 10
//	Test Objective: Catch invalid customer phone number
//	Inputs: name = ""(empty)
//	Expected Output: Exception Message -> "Customer phone number cannot be empty".
	
	public void testValidatePhoneNo003() throws CustomerHandler {
	    // Test to catch invalid customer phone number (empty string)
	    try {
	        Customer.validatePhone(0);  // Assuming validatePhone accepts a String
	        fail("Exception expected for empty phone number");
	    } catch (CustomerHandler e) {
	        assertEquals("Customer phone number can't be empty", e.getMessage());
	    }
	}
	
	@Test
	public void testLowerBoundaryValidAddress() throws CustomerHandler {
	    // Assume the minimum valid address length is 5 characters
	    Customer.validateAddress("12345");  // Lower boundary valid case (5 characters)
	}

	@Test
	public void testUpperBoundaryValidAddress() throws CustomerHandler {

	    Customer.validateAddress("1234567890123456789012345");  // Upper boundary valid case (25 characters)
	}



	



	public static void main(String[] args) {
		

	}

}

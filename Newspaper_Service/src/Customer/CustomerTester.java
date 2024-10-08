package Customer;
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
			Customer custObj = new Customer("John Doe", "Athlone", 123456789, false, "irish & forbes");
			
			// Use getters to check for object creation
			assertEquals(0, custObj.getId());
			assertEquals("John Doe", custObj.getName());
			assertEquals("Athlone", custObj.getAddress());
			assertEquals(123456789, custObj.getPhoneNo());
			assertEquals(false, custObj.getIsAway());
			assertEquals("irish & forbes", custObj.getSubscriptions());
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
	
	
	public static void main(String[] args) {
		

	}

}

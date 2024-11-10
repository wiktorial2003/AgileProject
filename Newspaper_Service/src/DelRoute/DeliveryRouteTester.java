package DelRoute;

import junit.framework.TestCase;

class DeliveryRouteTester extends TestCase {

	/*
	 * 
	 * Test #: 1 
	 * Test Objective: Create a Delivery route
	 * 
	 * Inputs: name = "Monksland", route_id =1, driver_id = 2
	 * 
	 * Expected Output: Delivery Route Object created with name = "Monksland",
	 * 
	 * 
	 */
	
	public void testDeliveryRoute001() throws DeliveryRouteHandler{
		try {
			DeliveryRoute delRoute = new DeliveryRoute("Monksland", 1, 2);
			assertEquals("Monksland",delRoute.getRouteName() );
			assertEquals(1 ,delRoute.getRoute_id() );
			assertEquals(2 ,delRoute.getDriver_id() );
			
		}catch (DeliveryRouteHandler e) {
			fail("Exception not expected");
		}
	}
	
	/*
	 * Test #: 2 
	 * Test Objective: Catch invalid del route name 
	 * Inputs: name = "" 
	 * Expected Output: Exception Message -> "DeliveryRoute name cannot be empty!"
	 */
	public void testValidateName001() throws DeliveryRouteHandler {
		// Test to catch invalid route name
		try {

			// Call method under test
			DeliveryRoute.validateName("");
			fail("Exception not expected");
		
		} catch (DeliveryRouteHandler e) {
			
			assertEquals("Delivery Route name cannot be empty!", e.getMessage());
		
		}
	}

	/*
	 * Test #: 3
	 *  Test Objective: Catch invalid route name 
	 * Inputs: name = "At"
	 *  Expected Output: Exception Message ->
	 * "DeliveryRoute name cannot be less than 3 characters."
	 */
	public void testValidateName002() throws DeliveryRouteHandler {
		// Test to catch invalid route name
		try {

			// Call method under test
			DeliveryRoute.validateName("At");
			fail("Exception not expected");
		
		} catch (DeliveryRouteHandler e) {
			
			assertEquals("Delivery Route name cannot be less than 3 characters.", e.getMessage());
		
		}
	}

	/*
	 * Test #: 4 
	 * Test Objective: Catch invalid route name 
	 * Inputs: name = abcdefghijklmnopqrstu
	 * Expected Output: Exception Message ->
	 * "DeliveryRoute name cannot be more than 20 characters.."
	 */
	public void testValidateName003() throws DeliveryRouteHandler {
		// Test to catch invalid route name
		try {

			// Call method under test
			DeliveryRoute.validateName("abcdefghijklmnopqrstu");
			fail("Exception not expected");
		
		} catch (DeliveryRouteHandler e) {
			
			assertEquals("Delivery Route name cannot be more than 20 characters.", e.getMessage());
		
		}
	}
	
	/*
	 * Test #: 5 
	 * Test Objective: Catch invalid route id 
	 * Inputs: id = 0
	 * Expected Output: Exception Message ->
	 * "ID must not be less than 1"
	 */
	
	public void testValidateID001() throws DeliveryRouteHandler {
		// Test to catch invalid route id
		try {

			// Call method under test
			DeliveryRoute.validateID(0);
			fail("Exception not expected");
		
		} catch (DeliveryRouteHandler e) {
			
			assertEquals("ID must not be less than 1", e.getMessage());
		
		}
	}
	
	/*
	 * Test #: 6 
	 * Test Objective: Catch invalid route id 
	 * Inputs: id = 25
	 * Expected Output: Exception Message ->
	 * "ID must be less than 25"
	 */
	
	public void testValidateID002() throws DeliveryRouteHandler {
		// Test to catch invalid route id
		try {

			// Call method under test
			DeliveryRoute.validateID(25);
			fail("Exception not expected");
		
		} catch (DeliveryRouteHandler e) {
			
			assertEquals("ID must be less than 25", e.getMessage());
		
		}
	}
	
	/*
	 * Test #: 7 
	 * Test Objective: Catch invalid driver id 
	 * Inputs: id = 0
	 * Expected Output: Exception Message ->
	 * "ID must not be less than 1"
	 */
	
	public void testValidateDriver001() throws DeliveryRouteHandler {
		// Test to catch invalid driver id
		try {

			// Call method under test
			DeliveryRoute.validateDriver(0);
			fail("Exception not expected");
		
		} catch (DeliveryRouteHandler e) {
			
			assertEquals("ID must not be less than 1", e.getMessage());
		
		}
	}
	
	/*
	 * Test #: 8 
	 * Test Objective: Catch invalid driver id 
	 * Inputs: id = 25
	 * Expected Output: Exception Message ->
	 * "ID must be less than 25"
	 */
	
	public void testValidateDriver002() throws DeliveryRouteHandler {
		// Test to catch invalid driver id
		try {

			// Call method under test
			DeliveryRoute.validateDriver(25);
			fail("Exception not expected");
		
		} catch (DeliveryRouteHandler e) {
			
			assertEquals("ID must be less than 25", e.getMessage());
		
		}
	}

}

package Order;

import junit.framework.TestCase;

public class OrderTest extends TestCase {

	/*
	 * 
	 * Test #: 1 Test Objective: Create an Order Inputs: id = 1, price = 4.50,
	 * 
	 * quantity = 4, del date = "10/11/24" publications = "irish times" Expected
	 * 
	 * Output: Order Object created with d = 1, price = 11.50, quantity = 4, del
	 * 
	 * date = "10/11/24" publications = "irish times"
	 * 
	 */

	public void testOrder001() throws OrderHandler {

		Order ordObj = new Order(1, 4.50, 4, "10/11/24", 14);

// Use getters to check for object creation 

		assertEquals(1, ordObj.getOrder_id());

		assertEquals(4.50, ordObj.getPrice());

		assertEquals(4, ordObj.getQuantity_pub());

		assertEquals("10/11/24", ordObj.getDel_date());

		assertEquals(14, ordObj.getpub_id());

	}

	/*
	 * 
	 * Test #: 2 Test Objective: Catch invalid order ID Inputs: id = 0 Expected
	 * 
	 * Output: Exception Message ->
	 * 
	 * "Order Id must be be at least 1 digit long and starts at 1"
	 * 
	 */

	public void testValidateID001() throws OrderHandler {

//  

		try {

// Call method under test 

			Order.validateID(0);

			fail("Exception not expected");

		} catch (OrderHandler e) {

			assertEquals("Order Id must be be at least 1 digit long and starts at 1", e.getMessage());

		}

	}

	/*
	 * 
	 * Test #: 3 Test Objective: Catch invalid order ID Inputs: id = 1000000001
	 * 
	 * Expected Output: Exception Message ->
	 * 
	 * "Order Id cannot be more than 10 digits long and msut be less than 1000000000"
	 * 
	 */

	public void testValidateID002() throws OrderHandler {

//Test to catch invalid customer name 

		try {

// Call method under test 

			Order.validateID(1000000001);

			fail("Exception not expected");

		} catch (OrderHandler e) {

			assertEquals("Order Id cannot be more than 10 digits long and msut be less than 1000000000",

					e.getMessage());

		}

	}

	/*
	 * 
	 * Test #: 3 Test Objective: Catch invalid order ID Inputs:
	 * 
	 * id = 15
	 * 
	 * Expected Output:Cus_id = 15
	 * 
	 * 
	 * 
	 */

	public void testValidateID003() {



		try {

// Call method under test 

			Order.validateID(15);

//still need try catch?	 

		} catch (OrderHandler e) {

			assertEquals("Order Id cannot be more than 10 digits long and msut be less than 1000000000",

					e.getMessage());

		}

	}

	/*
	 * 
	 * Test #: 5 Test Objective: Catch invalid Price
	 * 
	 * Inputs: price = 0
	 * 
	 * Expected Output:Exception Message -> "Price must be greater than 0"
	 * 
	 */

	public void testValidatePrice001() throws OrderHandler {

//Test to catch invalid customer name 

		try {

// Call method under test 

			Order.validatePrice(0);

			fail("Exception not expected");

		} catch (OrderHandler e) {

			assertEquals("Price must be greater than 0", e.getMessage());

		}

	}

	/*
	 * 
	 * Test #: 6 Test Objective: Catch invalid Price Inputs: id = 1000000001
	 * 
	 * Expected Output: Exception Message -> Price msut be less than 1000000000
	 * 
	 */

	public void testValidatePrice002() throws OrderHandler {

//Test to catch invalid customer name 

		try {

// Call method under test 

			Order.validatePrice(1000000001);

			fail("Exception not expected");

		} catch (OrderHandler e) {

			assertEquals("Price must be less than 1000000000", e.getMessage());

		}

	}

	/*
	 * 
	 * Test #: 7 Test Objective: Catch invalid Price
	 * 
	 * Inputs: 10.50
	 * 
	 * Expected Output: Price = 10.50
	 * 
	 */

	public void testValidatePrice003() {

//Test to catch invalid customer name 

		try {

// Call method under test 

			Order.validatePrice(10.50);

		} catch (OrderHandler e) {

			assertEquals("Price must be less than 1000000000", e.getMessage());

		}

	}

	/*
	 * 
	 * Test #: 8 Test Objective: Catch invalid Quantity Inputs: id = 0 Expected
	 * 
	 * Output: Exception Message -> Quantity must be greater than 0
	 * 
	 */

	public void testValidateQuantity001() throws OrderHandler {

//Test to catch invalid customer name 

		try {

// Call method under test 

			Order.validateQuantity(0);

			fail("Exception not expected");

		} catch (OrderHandler e) {

			assertEquals("Quantity must be greater than 0", e.getMessage());

		}

	}

	/*
	 * 
	 * Test #: 9 Test Objective: Catch invalid Quantity
	 * 
	 * Inputs: 4
	 * 
	 * Expected Output: quantity = 4
	 * 
	 */

	public void testValidateQuantity002() throws OrderHandler {

//Test to catch invalid customer name 

		try {

// Call method under test 

			Order.validateQuantity(4);

		} catch (OrderHandler e) {

			assertEquals("Quantity must be less than 11", e.getMessage());

		}

	}

	/*
	 * 
	 * Test #: 10 Test Objective: Catch invalid Quantity
	 * 
	 * Inputs: 11
	 * 
	 * Expected Output: Exception Message -> Quantity must be less than 11
	 * 
	 */

	public void testValidateQuantity003() {

//Test to catch invalid customer name 

		try {

// Call method under test 

			Order.validateQuantity(11);

			fail("Exception not expected");

		} catch (OrderHandler e) {

			assertEquals("Quantity must be less than 11", e.getMessage());

		}

	}

	/*
	 * 
	 * Test #: 11 Test Objective: Catch invalid publication Inputs: id = "" Expected
	 * 
	 * Output: Exception Message ->Publication Id must be at least 1 digit long and starts at 1"
	 * 
	 */

	public void testvalidatepub_id001() throws OrderHandler {

		try {

// Call method under test 

			Order.validatepub_id(0);

			fail("Exception not expected");

		} catch (OrderHandler e) {


			assertEquals("Publication Id must be at least 1 digit long and starts at 1", e.getMessage());

		}

	}

	/*
	 * 
	 * Test #: 12 Test Objective: Catch invalid publication Inputs: id = 1000000001
	 * 
	 * Expected Output: Exception Message -> Publication Id cannot be more than 10 digits long and msut be less than 1000000000"
	 * 
	 * characters!
	 * 
	 */

	public void testvalidatepub_id002() throws OrderHandler {

		try {

// Call method under test 

			Order.validatepub_id(1000000001);

			fail("Exception not expected");

		} catch (OrderHandler e) {

			assertEquals("Publication Id cannot be more than 10 digits long and msut be less than 1000000000", e.getMessage());

		}

	}

	/*
	 * 
	 * Test #: 13 Test Objective: Catch invalid publication
	 * 
	 * Inputs: id =1
	 * 
	 * Expected Output: id =1
	 * 
	 */

	public void testvalidatepub_id003() throws OrderHandler {

//Test to catch invalid customer name 

		try {

// Call method under test 

			Order.validatepub_id(1);


		} catch (OrderHandler e) {

			assertEquals("Publication name can't be more than 15 characters.", e.getMessage());

		}

	}


}
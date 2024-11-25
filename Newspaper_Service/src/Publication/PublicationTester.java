package Publication;

import junit.framework.TestCase;

public class PublicationTester extends TestCase {

	/*
	 * 
	 * Test #: 1 Test Objective: Create a Publication
	 * 
	 * Inputs: name = "irish Times", pubType = "Newspaper", Frequency = "daily",
	 * price = 4.50, stock = 20
	 * 
	 * Expected Output: Publication Object created with name = "Irish Times",
	 * pubType = "Newspaper", Frequency = "daily", price = 4.50, stock = 20
	 * 
	 */
	public void testPublication001() throws PublicationHandler {
		try {
			Publication pubObj = new Publication("Irish Times",  20, "Newspaper",  4.50, "daily");
			assertEquals("Irish Times", pubObj.getPubName());
			assertEquals("Newspaper", pubObj.getPubType());
			assertEquals("daily", pubObj.getFrequency());
			assertEquals(4.50, pubObj.getPubPrice());
			assertEquals(20, pubObj.getStock());
		
		} catch (PublicationHandler e) {
			
			fail("Exception not expected");

		}
	}

	/*
	 * Test #: 2 Test Objective: Catch invalid pub name Inputs: name = "" Expected
	 * Output: Exception Message -> "Publication name cannot be empty!"
	 */
	public void testValidateName001() throws PublicationHandler {
		// Test to catch invalid pub name
		try {

			// Call method under test
			Publication.validateName("");
			fail("Exception not expected");
		
		} catch (PublicationHandler e) {
			
			assertEquals("Publication name cannot be empty!", e.getMessage());
		
		}
	}

	/*
	 * Test #: 3 Test Objective: Catch invalid pub name Inputs: name = "Jo" Expected
	 * Output: Exception Message ->
	 * "Publication name cannot be less than 3 characters."
	 */
	public void testValidateName002() throws PublicationHandler {
		// Test to catch invalid pub name
		try {

			// Call method under test
			Publication.validateName("Jo");
			fail("Exception not expected");
		
		} catch (PublicationHandler e) {
			
			assertEquals("Publication name cannot be less than 3 characters.", e.getMessage());
		
		}
	}

	/*
	 * Test #: 4 Test Objective: Catch invalid pub name Inputs: name =
	 * "abcdefghijklmnopqrstuv" Expected Output: Exception Message ->
	 * "Publication name cannot be more than 20 characters.."
	 */
	public void testValidateName003() throws PublicationHandler {
		// Test to catch invalid pub name
		try {

			// Call method under test
			Publication.validateName("abcdefghijklmnopqrstuv");
			fail("Exception not expected");
		
		} catch (PublicationHandler e) {
			
			assertEquals("Publication name cannot be more than 20 characters.", e.getMessage());
		
		}
	}

	/*
	 * Test #: 5 Test Objective: Catch invalid pub type Inputs: type = "" Expected
	 * Output: Exception Message -> "Publication name cannot be empty!"
	 */
	public void testValidatePubType001() throws PublicationHandler {
		try {

			// Call method under test
			Publication.validatePubType("");
			fail("Exception not expected");
		
		} catch (PublicationHandler e) {
			
			assertEquals("Publication type cannot be empty!", e.getMessage());
		
		}
	}

	/*
	 * Test #: 6 Test Objective: Catch invalid pub type Inputs: type = "mags"
	 * Expected Output: Exception Message ->
	 * "Publication type cannot be less than 5 characters."
	 */
	public void testValidatePubType002() throws PublicationHandler {
		try {

			// Call method under test
			Publication.validatePubType("mags");
			fail("Exception not expected");
		
		} catch (PublicationHandler e) {
			
			assertEquals("Publication type cannot be less than 5 characters.", e.getMessage());
		
		}
	}

	/*
	 * Test #: 7 Test Objective: Catch invalid pub type Inputs: type =
	 * "qwertyuioplkjhgfdsazxcvbnmnbvcxzas" Expected Output: Exception Message ->
	 * "Publication type cannot be more than 30 characters.."
	 */
	public void testValidatePubType003() throws PublicationHandler {
		try {

			// Call method under test
			Publication.validatePubType("qwertyuioplkjhgfdsazxcvbnmnbvcxzas");
			fail("Exception not expected");
		
		} catch (PublicationHandler e) {
			
			assertEquals("Publication type cannot be more than 30 characters.", e.getMessage());
		
		}
	}

	/*
	 * Test #: 8 Test Objective: Catch invalid frequency Inputs: freq = "" Expected
	 * Output: Exception Message -> "Publication frequency cannot be empty!"
	 */
	public void testValidateFrequency001() throws PublicationHandler {
		try {

			// Call method under test
			Publication.validateFrequency("");
			fail("Exception not expected");
			
		} catch (PublicationHandler e) {
			
			assertEquals("Publication frequency cannot be empty!", e.getMessage());
			
		}
	}

	/*
	 * Test #: 9 Test Objective: Catch invalid frequency Inputs: freq = "fortnight"
	 * Expected Output: Exception Message ->
	 * "Publication frequency must be daily, weekly or monthly."
	 */
	public void testValidateFrequency002() throws PublicationHandler {
		try {

			// Call method under test
			Publication.validateFrequency("fortnight");
			fail("Exception not expected");
			
			} catch (PublicationHandler e) {
				
			assertEquals("Publication frequency must be daily, weekly or monthly.", e.getMessage());
		
		}
	}

	/*
	 * 
	 * Test #: 10 Test Objective: Catch invalid Price
	 * 
	 * Inputs: price = 0
	 * 
	 * Expected Output:Exception Message -> "Price must be greater than 0"
	 * 
	 */

	public void testValidatePrice001() throws PublicationHandler {

		// Test to catch invalid price

		try {

			// Call method under test

			Publication.validatePubPrice(0.00);

			fail("Exception not expected");

		} catch (PublicationHandler e) {

			assertEquals("Price must be greater than 0", e.getMessage());

		}

	}
	
	/*
	 * 
	 * Test #: 11 Test Objective: Catch invalid Price
	 * 
	 * Inputs: price = 100.00
	 * 
	 * Expected Output:Exception Message -> "Price must be less than 100.00"
	 * 
	 */

	public void testValidatePrice002() throws PublicationHandler {

		// Test to catch invalid price

		try {

			// Call method under test

			Publication.validatePubPrice(100.00);

			fail("Exception not expected");

		} catch (PublicationHandler e) {

			assertEquals("Price must be less than 100.00", e.getMessage());

		}

	}

	/*
	 * 
	 * Test #: 12 Test Objective: Catch invalid stock
	 * 
	 * Inputs: price = -1
	 * 
	 * Expected Output:Exception Message -> "Stock must not be less than 0"
	 * 
	 */

	public void testValidateStock001() throws PublicationHandler {

		// Test to catch invalid stock

		try {

			// Call method under test

			Publication.validateStock(-1);

			fail("Exception not expected");

		} catch (PublicationHandler e) {

			assertEquals("Stock must not be less than 0", e.getMessage());

		}

	}
	
	/*
	 * 
	 * Test #: 13 Test Objective: Catch invalid stock
	 * 
	 * Inputs: price = 1001
	 * 
	 * Expected Output:Exception Message -> "Stock must be less than 1000"
	 * 
	 */

	public void testValidateStock002() throws PublicationHandler {

		// Test to catch invalid stock

		try {

			// Call method under test

			Publication.validateStock(1001);

			fail("Exception not expected");

		} catch (PublicationHandler e) {

			assertEquals("Stock must be less than 1000", e.getMessage());

		}

	}

}

package Invoice;

import junit.framework.*;

public class InvoiceTest extends TestCase {
	/*
	 * Test #: 1 Test Objective: Create an Invoice Inputs: publications =
	 * "Irish Times", total price = 100.50, date = 12/10/2024, quantity = 1, order
	 * number = 24 Expected Output: Invoice Object created with id = 0, publications
	 * = "Irish Times", total price = 100.50, date = 12/10/2024, quantity = 1, order
	 * number = 24
	 */
	public void testInvoice001() throws InvoiceHandler {
		try {
			Invoice invoice = new Invoice(100.50, "Irish Times", "12/10/2024", 1, 24);
			assertEquals(0, invoice.getInvoice_ID());
			assertEquals(100.50, invoice.getTotalPrice());
			assertEquals("Irish Times", invoice.getPublication());
			assertEquals("12/10/2024", invoice.getInvoiceDate());
			assertEquals(1, invoice.getPubQuantity());
			assertEquals(24, invoice.getOrderNum());
		} catch (InvoiceHandler e) {
			fail("Exception not expected");
		}
	}

	/*
	 * Test #: 2 Test Objective: Catch invalid total price Inputs: name = "0"
	 * Expected Output: Exception Message -> "Total price cannot be 0"
	 */

	public void testValidatePrice001() throws InvoiceHandler {
//Test to catch invalid total price
		try {
//Call method under test
			Invoice.validatePrice(0);
			fail("Exception not expected");
		} catch (InvoiceHandler e) {
			assertEquals("Price must be greater than 0", e.getMessage());
		}
	}

	/*
	 * Test #: 3 Test Objective: Catch invalid total price Inputs: name =
	 * "1000000001" Expected Output: Exception Message ->
	 * "Price must be less than 1000000000"
	 */

	public void testValidatePrice002() throws InvoiceHandler {
//Test to catch invalid total price
		try {
//Call method under test
			Invoice.validatePrice(1000000001);
			fail("Exception not expected");
		} catch (InvoiceHandler e) {
			assertEquals("Price must be less than 1000000000", e.getMessage());
		}
	}

	/*
	 * Test #: 4 Test Objective: Catch invalid quantity Inputs: name = 0 Expected
	 * Output: Exception Message -> "Quantity must be greater than 0"
	 */

//how do invoices work when customer is away
	public void testValidatePubQuantity001() throws InvoiceHandler {
//Test to catch invalid quantity
		try {
//Call method under test
			Invoice.validateQuantity(0);
			fail("Exception not expected");
		} catch (InvoiceHandler e) {
			assertEquals("Quantity must be greater than 0", e.getMessage());
		}
	}

	/*
	 * Test #: 5 Test Objective: Catch invalid quantity Inputs: name = 101 Expected
	 * Output: Exception Message -> "Quantity must be less than 101"
	 */

//how do invoices work when customer is away
	public void testValidatePubQuantity002() throws InvoiceHandler {
//Test to catch invalid quantity
		try {
//Call method under test
			Invoice.validateQuantity(101);
			fail("Exception not expected");
		} catch (InvoiceHandler e) {
			assertEquals("Quantity must be less than 101", e.getMessage());
		}
	}

	/*
	 * Test #: 6 Test Objective: Catch invalid publication Inputs: name = ""
	 * Expected Output: Exception Message -> "Publication field cannot be empty!"
	 */

	public void testValidatePublication001() throws InvoiceHandler {
//Test to catch invalid publication
		try {
//Call method under test
			Invoice.validatePublication("");
			fail("Exception not expected");
		} catch (InvoiceHandler e) {
			assertEquals("Publication field cannot be empty!", e.getMessage());
		}
	}

	/*
	 * Test #: 7 Test Objective: Catch invalid publication Inputs: name =
	 * "Irish Timessssss" Expected Output: Exception Message ->
	 * "Publication name can't be more than 15 characters."
	 */

	public void testValidatePublication002() throws InvoiceHandler {
//Test to catch invalid publication
		try {
//Call method under test
			Invoice.validatePublication("Irish Timessssss");
			fail("Exception not expected");
		} catch (InvoiceHandler e) {
			assertEquals("Publication name can't be more than 15 characters.", e.getMessage());
		}
	}

	/*
	 * Test #: 8 Test Objective: Catch valid publication Inputs: name = "Ir"
	 * Expected Output: Exception Message ->
	 * "Publication name can't be less than 3 characters."
	 */

	public void testValidatePublication003() throws InvoiceHandler {
//Test to catch invalid publication
		try {
//Call method under test
			Invoice.validatePublication("Ir");
			fail("Exception not expected");
		} catch (InvoiceHandler e) {
			assertEquals("Publication name can't be less than 3 characters.", e.getMessage());
		}
	}

	/*
	 * Test #: 9 Test Objective: Catch invalid order Number Inputs: 0 Expected
	 * Output: Exception Message -> "Order Number has to be more than 0"
	 */

	public void testValidateOrderNum001() throws InvoiceHandler {
		try {
//Call method under test
			Invoice.validateOrderNum(0);
			fail("Exception not expected");
		} catch (InvoiceHandler e) {
			assertEquals("Order Number has to be more than 0", e.getMessage());
		}
	}

	/*
	 * Test #: 9 Test Objective: Catch invalid order Number Inputs: 1000 Expected
	 * Output: Exception Message -> "Order number cannot be more than 999"
	 */

	public void testValidateOrderNum002() throws InvoiceHandler {
		try {
//Call method under test
			Invoice.validateOrderNum(1000);
			fail("Exception not expected");
		} catch (InvoiceHandler e) {
			assertEquals("Order Number has to be less than 999", e.getMessage());
		}
	}

	/*
	 * Test #: 10 Test Objective: Catch invalid order Number Inputs: null Expected
	 * Output: Exception Message -> "Date cannot be more than 0"
	 */

	public void testValidateInvoiceDate001() throws InvoiceHandler {
		try {
//Call method under test
			Invoice.validateInvoiceDate("");
			fail("Date can't be empty");
		} catch (InvoiceHandler e) {
			assertEquals("Date can't be empty", e.getMessage());
		}
	}

	/*
	 * Test #: 11 Test Objective: Catch invalid order Number Inputs: 12 Expected
	 * Output: Exception Message -> "Date cannot be less than 12"
	 */

	public void testValidateInvoiceDate002() throws InvoiceHandler {
		try {
//Call method under test
			Invoice.validateInvoiceDate("12");
			fail("Exception not expected");
		} catch (InvoiceHandler e) {
			assertEquals("Date cannot be less than 3", e.getMessage());
		}
	}

	/*
	 * Test #: 13 Test Objective: Catch invalid order Number Inputs: 12 Expected
	 * Output: Exception Message -> "Date cannot be more than 12"
	 */

	public void testValidateInvoiceDate003() throws InvoiceHandler {
		try {
//Call method under test
			Invoice.validateInvoiceDate("12/22/20024");
			fail("Exception not expected");
		} catch (InvoiceHandler e) {
			assertEquals("Date cannot be more than 12", e.getMessage());
		}
	}

}

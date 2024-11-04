package Invoice;
import junit.framework.*;

public class InvoiceTest extends TestCase{
	
	/*
	Test #: 1
	Test Objective: Create an Invoice
	Inputs: , phoneNo = "123456789", publications = "irish Times", total price = 20.00
	Expected Output: Invoice Object created with id = 0, phoneNo = "123456789", publications = "Irish Tines", price = 20.00
	*/
	
public void testInvoice001() throws InvoiceHandler {
	
	try {
		Invoice invoice = new Invoice(1, 100.50, "Irish Times", "12/10/2024", 1, 24);
		 
		assertEquals(1, invoice.getInvoice_ID());
	    assertEquals(100.50, invoice.getTotalPrice());
	    assertEquals("Irish Times", invoice.getPublication());
	    assertEquals("12/10/2024", invoice.getInvoiceDate());
	    assertEquals(1, invoice.getPubQuantity());
	    assertEquals(24, invoice.getOrderNum());
	}
	catch(InvoiceHandler e) {
		fail("Exception not expected");
	}
	
	
}

/*
Test #: 2
Test Objective: Catch invalid total price
Inputs: name = "0"
Expected Output: Exception Message -> "Total price cannot be 0"
*/

public void testValidatePrice001() throws InvoiceHandler {
	
	//Test to catch invalid total price
	try {
		
		//Call method under test
		Invoice.validatePrice(0.00);
		fail("Exception not expected");
	}
	catch (InvoiceHandler e) {
		assertEquals("Total price cannot be 0", e.getMessage());
	}
	
}

/*
Test #: 3
Test Objective: Catch invalid total price
Inputs: name = "1000000001"
Expected Output: Exception Message -> "Total price cannot be more than 1000000000"
*/

public void testValidatePrice002() throws InvoiceHandler {
	
	//Test to catch invalid total price
	try {
		
		//Call method under test
		Invoice.validatePrice(1000000001);
		fail("Exception not expected");
	}
	catch (InvoiceHandler e) {
		assertEquals("Total price cannot be less than 0", e.getMessage());
	}
	
}

/*
Test #: 4
Test Objective: Catch invalid quantity
Inputs: name = 0
Expected Output: Exception Message -> "Total quantity of publications can't be less than 0"
*/

//how do invoices work when customer is away
public void testValidatePubQuantity001() throws InvoiceHandler {
	
	//Test to catch invalid quantity
	try {
		
		//Call method under test
		Invoice.validateQuantity(0);
		fail("Exception not expected");
	}
	catch (InvoiceHandler e) {
		assertEquals("Total quantity of publications can't be less than 0", e.getMessage());
	}
	
}

/*
Test #: 5
Test Objective: Catch invalid quantity
Inputs: name = 101
Expected Output: Exception Message -> "Total quantity of publications can't be over 100"
*/

//how do invoices work when customer is away
public void testValidatePubQuantity002() throws InvoiceHandler {
	
	//Test to catch invalid quantity
	try {
		
		//Call method under test
		Invoice.validateQuantity(101);
		fail("Exception not expected");
	}
	catch (InvoiceHandler e) {
		assertEquals("Total quantity of publications can't be over 99", e.getMessage());
	}
	
}

/*
Test #: 6
Test Objective: Catch invalid publication
Inputs: name = null
Expected Output: Exception Message -> "A publication requires an author"
*/

public void testValidatePublication001() throws InvoiceHandler {
	
	//Test to catch invalid publication
	try {
		
		//Call method under test
		Invoice.validatePublication(null);
		fail("Exception not expected");
	}
	catch (InvoiceHandler e) {
		assertEquals("A publication requires an author", e.getMessage());
	}
	
}

/*
Test #: 7
Test Objective: Catch valid publication
Inputs: name = "Irish Times"
Expected Output: Exception Message -> ""
*/

public void testValidatePublication002() throws InvoiceHandler {
	
	//Test to catch invalid publication
	try {
		
		//Call method under test
		Invoice.validatePublication("Irish Times");
		fail("Exception not expected");
	}
	catch (InvoiceHandler e) {
		assertEquals("", e.getMessage());
	}
	
}

/*
Test #: 8
Test Objective: Catch valid publication
Inputs: name = "Ir"
Expected Output: Exception Message -> "A publication cannot be less than 3 characters"
*/

public void testValidatePublication003() throws InvoiceHandler {
	
	//Test to catch invalid publication
	try {
		
		//Call method under test
		Invoice.validatePublication("Ir");
		fail("Exception not expected");
	}
	catch (InvoiceHandler e) {
		assertEquals("A publication cannot be less than 3 characters", e.getMessage());
	}
	
}

/*
Test #: 9
Test Objective: Catch invalid order Number
Inputs: 0
Expected Output: Exception Message -> "Order number cannot be less than 0"
*/

public void testValidateOrderNum001() throws InvoiceHandler {
	
	try {
		
		//Call method under test
		Invoice.validateOrderNum(0);
		fail("Exception not expected");
	}
	catch (InvoiceHandler e) {
		assertEquals("Order number cannot be less than 0", e.getMessage());
	}
	
}

/*
Test #: 9
Test Objective: Catch invalid order Number
Inputs: 1000
Expected Output: Exception Message -> "Order number cannot be more than 999"
*/

public void testValidateOrderNum002() throws InvoiceHandler {
	
	try {
		
		//Call method under test
		Invoice.validateOrderNum(1000);
		fail("Exception not expected");
	}
	catch (InvoiceHandler e) {
		assertEquals("Order number cannot be more than 999", e.getMessage());
	}
	
}

/*
Test #: 10
Test Objective: Catch invalid order Number
Inputs: null
Expected Output: Exception Message -> "Date cannot be more than 0"
*/

public void testValidateInvoiceDate001() throws InvoiceHandler {
	
	try {
		
		//Call method under test
		Invoice.validateInvoiceDate(null);
		fail("Exception not expected");
	}
	catch (InvoiceHandler e) {
		assertEquals("Date cannot be null", e.getMessage());
	}
	
}

/*
Test #: 11
Test Objective: Catch invalid order Number
Inputs: 12
Expected Output: Exception Message -> "Date cannot be less than 12"
*/

public void testValidateInvoiceDate002() throws InvoiceHandler {
	
	try {
		
		//Call method under test
		Invoice.validateInvoiceDate("12");
		fail("Exception not expected");
	}
	catch (InvoiceHandler e) {
		assertEquals("Date cannot be more than 12", e.getMessage());
	}
	
}

/*
Test #: 13
Test Objective: Catch invalid order Number
Inputs: 12
Expected Output: Exception Message -> "Date cannot be more than 12"
*/

public void testValidateInvoiceDate003() throws InvoiceHandler {
	
	try {
		
		//Call method under test
		Invoice.validateInvoiceDate("12/2/20024");
		fail("Exception not expected");
	}
	catch (InvoiceHandler e) {
		assertEquals("Date cannot be more than 12", e.getMessage());
		
		
	}
	
}














	

}

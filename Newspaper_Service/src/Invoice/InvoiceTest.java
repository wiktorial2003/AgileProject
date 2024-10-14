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
		
	 Invoice invoice = new Invoice(1, 100.50, "Irish Times", "12/10/2024", 1, 24);
	 
	assertEquals(1, invoice.getInvoice_ID());
    assertEquals(100.50, invoice.getTotalPrice());
    assertEquals("Irish Times", invoice.getPublication());
    assertEquals("12/10/2024", invoice.getInvoiceDate());
    assertEquals(1, invoice.getPubQuantity());
    assertEquals(24, invoice.getOrderNum());
    
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
		Invoice.validatePrice(0);
		fail("Exception not expected");
	}
	catch (InvoiceHandler e) {
		assertEquals("Total price cannot be 0", e.getMessage());
	}
	
}

/*
Test #: 3
Test Objective: Catch invalid total price
Inputs: name = "-10"
Expected Output: Exception Message -> "Total price cannot be less than 0"
*/

public void testValidatePrice002() throws InvoiceHandler {
	
	//Test to catch invalid total price
	try {
		
		//Call method under test
		Invoice.validatePrice(-10);
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
Test Objective: Catch invalid publication
Inputs: name = null
Expected Output: Exception Message -> ""
*/

public void testValidatePublication001() throws InvoiceHandler {
	
	//Test to catch invalid publication
	try {
		
		//Call method under test
		Invoice.validatePublication(null);
		fail("Exception not expected");
	}
	catch (InvoiceHandler e) {
		assertEquals("", e.getMessage());
	}
	
}









	

}

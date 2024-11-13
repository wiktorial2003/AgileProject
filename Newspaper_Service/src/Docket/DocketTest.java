package Docket;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import Customer.Customer;
import Docket.DocketHandler;
import junit.framework.TestCase;

public class DocketTest extends TestCase {
	
	/* 
	 Test #: 1
	 Test Objective: Cacth invalid docket id
	 Inputs: N/A
	 Expected output: Docket ID must be greater than 0  
	 C*/
	
	@Test
	public void validateDeliveryDocketId001() throws DocketHandler {
		
		Exception exception = assertThrows(DocketHandler.class, () -> {
            new DeliveryDocket(0, 12345, 101, "Alice", "22 Willow ave", "123456789");
        });
        assertEquals("Delivery docket ID must be greater than 0.", exception.getMessage());
		
	}
	
	@Test
	public void validateDeliveryDocket002() throws DocketHandler {
		
		Exception exception = assertThrows(DocketHandler.class, () -> {
            new DeliveryDocket(1, 123, 101, "Alice", "22 Willow ave", "123456789");
        });
        assertEquals("Customer ID cannot be less than 4 digits", exception.getMessage());
	}

	@Test 
	public void validateDeliveryDocket003() throws DocketHandler {
		DeliveryDocket docket = new DeliveryDocket(1, 12345, 101, "Alice", "22 Willow ave", "123456789");
        assertEquals(445328, docket.getdockId());
        assertEquals(6833283, docket.getcustId());
        assertEquals(101, docket.getordNum());
        assertEquals("Alice", docket.getName());
        assertEquals("22 Willow ave", docket.getAddress());
        assertEquals("123456789", docket.getPhoneNumber());
	}
	
	@Test
	public void validateCustomer001() throws DocketHandler {
		 Exception exception = assertThrows(DocketHandler.class, () -> {
	            new DeliveryDocket(1, 123, 101, "Alice", "22 Willow ave", "123456789");
	        });
	        assertEquals("Customer ID cannot be less than 4 digits", exception.getMessage());
	}
		
	@Test 
	public void validateCustomer002() throws DocketHandler {
		Exception exception = assertThrows(DocketHandler.class, () -> {
			 new DeliveryDocket(1, 12345678901L, 101, "Alice", "22 Willow ave", "123456789"); 
        });
        assertEquals("Customer ID cannot be more than 10 digits", exception.getMessage());
	}
	
	@Test
	public void validateOrder001() throws DocketHandler {
		Exception exception = assertThrows(DocketHandler.class, ()-> {
			new DeliveryDocket(1, 12345, 0, "Alice", "22 Willow ave", "123456789");
		});
		assertEquals("Order number must be greater than 0", exception.getMessage());
	}
	
	@Test
	public void validateName001() throws DocketHandler {
		 Exception exception = assertThrows(DocketHandler.class, () -> {
	            new DeliveryDocket(1, 12345, 101, "Al", "123 Street Name", "123456789");
	        });
	        assertEquals("Customer name too cannot be less than 3 characters", exception.getMessage());
	}
	
	@Test
	public void validateName002() throws DocketHandler {
        Exception exception = assertThrows(DocketHandler.class, () -> {
            new DeliveryDocket(1, 12345, 101, "Alice Wonderland Extra", "123 Street Name", "123456789");
        });
        assertEquals("Customer name cannot be more than 15 characters", exception.getMessage());
	}
	
	@Test
	public void validateAddress001() throws DocketHandler {
		Exception exception = assertThrows(DocketHandler.class, () -> {
            new DeliveryDocket(1, 12345, 101, "Alice", "", "123456789");
        });
        assertEquals("Address cannot be empty.", exception.getMessage());
	}
	
	@Test
	public void validateAddress002() throws DocketHandler { 
		Exception exception = assertThrows(DocketHandler.class, () -> {
            new DeliveryDocket(1, 12345, 101, "Alice", "St", "123456789");
        });
        assertEquals("Customer address cannot be less than 3 characters", exception.getMessage());
	}
	
	@Test
	public void validateAddress003() throws DocketHandler {
	        Exception exception = assertThrows(DocketHandler.class, () -> {
	            new DeliveryDocket(1, 12345, 101, "Alice", "123 Very Long Street Address That Exceeds Limit", "123456789");
	        });
	        assertEquals("Customer address should be longer than 25 characters", exception.getMessage());
		}
	
		
	@Test
	public void validatePhoneNumber001() throws DocketHandler {
		Exception exception = assertThrows(DocketHandler.class, () -> {
            new DeliveryDocket(1, 12345, 101, "Alice", "123 Street Name", "12345678");
        });
        assertEquals("Phone number should be 9 digits", exception.getMessage());
	}
	
	@Test
	public void validatePhoneNumber002() throws DocketHandler {
		Exception exception = assertThrows(DocketHandler.class, () -> {
            new DeliveryDocket(1, 12345, 101, "Alice", "123 Street Name", "1234567890");
        });
        assertEquals("Phone number should be 9 digits", exception.getMessage());
	}
	
	@Test
	public void testLowerBoundaryValidAddress() throws DocketHandler {
	    // Assume the minimum valid address length is 5 characters
	    DeliveryDocket.validateAddress("12345");  // Lower boundary valid case (5 characters)
	}

	@Test
	public void testUpperBoundaryValidAddress() throws DocketHandler {

	    DeliveryDocket.validateAddress("1234567890123456789012345");  // Upper boundary valid case (25 characters)
	}

	@Test(expected = DocketHandler.class)
	public void testLowerBoundaryInvalidphoneNumber() throws DocketHandler {
	    DeliveryDocket.validatePhoneNumber(8);  // Just below lower boundary (invalid)
	}

	@Test(expected = DocketHandler.class)
	public void testUpperBoundaryInvalidAge() throws DocketHandler {
	    DeliveryDocket.validatePhoneNumber(10);  // Just above upper boundary (invalid)
	}

	
	
}

package Customer;

import java.time.*;
public class Customer {

	private int customer_id; // should this be in the object or?
	private String name;
	private String address;
	private int phoneNo;
	private boolean isAway;

	
	

//	private LocalDate isAwayStartDate; // Getters, Setters, JUnits and Test Design not written for this
//	private LocalDate isAwayEndDate; // Getters, Setters, JUnits and Test Design not written for this
//	private String subscriptions;


	//In C.R.U.D, the create refers to the constructor
	Customer(String name, String address, int phoneNo, boolean isAway) throws CustomerHandler 
	{
		customer_id = 0;
		try 
		{
			validateName(name);
			validateAddress(address);
			validatePhone(phoneNo);
//			validateCustomer(customer_id);
		}
		catch (CustomerHandler e)
		{
			throw e;
		}
	
		this.name = name;
		this.address = address;
		this.phoneNo = phoneNo;
		this.isAway= isAway;
	
		
	}
	
	

	// Getters = READ, Setters = UPDATE
	public int getId() {
		return customer_id;
	}

	public void setId(int customer_id) {
		this.customer_id = customer_id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}


	public boolean getIsAway() {
		return isAway;
	}

	public void setAway(boolean isAway) {
		this.isAway = isAway;
	}


	//Delete in C.R.U.D.
	public void deleteCustomer(Customer c) 
	{
		c = null;
	}
	
	
	
	//Validate methods for all properties
	public static void validateName(String custName) throws CustomerHandler 
	{
		// Verify that there is a customer's name between 3 and 15 characters.
		if(custName.isBlank() || custName.isEmpty()) 
		{
			throw new CustomerHandler("Customer name cannot be empty!");
		}
		else if(custName.length() < 3) 
		{
			throw new CustomerHandler("Customer name cannot be less than 3 characters.");
		}
		else if(custName.length() > 15) 
		{
			throw new CustomerHandler("Customer name cannot be more than 15 characters.");
		} 
	}
	
	
	public static void validateAddress(String custAddress) throws CustomerHandler 
	{
		// Verify that there is a customer's address between 5 and 25 characters.
		if(custAddress.isBlank() || custAddress.isEmpty()) 
		{
			throw new CustomerHandler("Customer address cannot be empty!");
		}
		else if(custAddress.length() < 3) 
		{
			throw new CustomerHandler("Customer name cannot be less than 5 characters.");
		}
		else if(custAddress.length() > 25) 
		{
			throw new CustomerHandler("Customer name cannot be more than 25 characters.");
		} 
	}
	
	public static void validatePhone(int custPhoneNumber) throws CustomerHandler 
	{
		int customerLength = String.valueOf(custPhoneNumber).length();
		// Verify that there is a customer's phone number and its 9 characters.
		if(customerLength != 9) 
		{
			throw new CustomerHandler("Customer phone number has to be 9 digits.");
		}

	}
	
//	public static void validateCustomer(int custID) throws CustomerHandler
//	{
//		int customerLength = String.valueOf(custID).length();
//		// Verify that there is a customer's phone number and its 9 characters.
//		if(customerLength < 4) 
//		{
//			throw new CustomerHandler("Customer ID cannot be less than 4 digits");
//		}
//		else if(customerLength > 10)
//		{
//			throw new CustomerHandler("Customer ID cannot be more than 10 digits");
//		}
//
//	}
	

	public static void main(String[] args) {
	}
	
}

package Customer;

public class Customer {

	private int customer_id; // should this be in the object or?
	private String name;
	private String address;
	private int phoneNo;
	private boolean isAway;
	private String subscriptions;
	
	//In C.R.U.D, the create refers to the constructor
	Customer(int customer_id,String name, String address, int phoneNo, boolean isAway, String subscriptions) 
	{
		//Make try catch or an if block that checks if the values are empty or aren't what they should be? or maybe when object is created make the user in the GUI not be able to type anything
		this.customer_id = customer_id;
		this.name = name;
		this.address = address;
		this.phoneNo = phoneNo;
		this.isAway = isAway;
		this.subscriptions = subscriptions;
		
	}
	
	

	// Getters = READ, Setters = UPDATE
	public int getCustomerId() {
		return customer_id;
	}

	public void setCustomerId(int customer_id) {
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


	public boolean isAway() {
		return isAway;
	}

	public void setAway(boolean isAway) {
		this.isAway = isAway;
	}

	public String getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(String subscriptions) {
		this.subscriptions = subscriptions;
	}

	//Delete in C.R.U.D.
	public void deleteCustomer(Customer c) 
	{
		c = null;
	}
	
	
	
	//Validate methods for all properties
	public static void validateName(String custName) throws CustomerHandler 
	{
		// Verify that there is a customer's name is between 3 and 50 characters.
		if(custName.isBlank() || custName.isEmpty()) 
		{
			throw new CustomerHandler("Customer name cannot be empty!");
		}
		else if(custName.length() < 3) 
		{
			throw new CustomerHandler("Customer name cannot be less than 3 characters.");
		}
		else if(custName.length() < 50) 
		{
			throw new CustomerHandler("Customer name cannot be more than 50 characters.");
		} 
	}
	

	public static void main(String[] args) {
	
	}

}

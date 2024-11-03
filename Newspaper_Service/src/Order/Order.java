 package Order;

public class Order {
	
	private static int order_id; // in the object?
	private int cus_id;
	private double price;
	private int quantity_pub;
	private String del_date;
	private int pub_id;
	
	
	//CReate
	public Order(int cus_id, double price, int quantity_pub, String del_date, int pub_id) throws OrderHandler {
		order_id = 0;
		
		try{
			validatePrice(price);
			validateQuantity(quantity_pub);
			validatepub_id(pub_id);
		}
		catch(OrderHandler e)
		{
			throw e;
		}
		
		this.price = price;
		this.quantity_pub = quantity_pub;
		this.del_date = del_date;
		this.pub_id = pub_id;
		this.cus_id = cus_id;
	}


	//get = read set = update
	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	
	public int getCus_id() {
		return cus_id;
	}


	public void setCus_id(int cus_id) {
		this.cus_id = cus_id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity_pub() {
		return quantity_pub;
	}

	public void setQuantity_pub(int quantity_pub) {
		this.quantity_pub = quantity_pub;
	}

	public String getDel_date() {
		return del_date;
	}

	public void setDel_date(String del_date) {
		this.del_date = del_date;
	}
	
	public int getPub_id() {
		return pub_id;
	}


	public void setPub_id(int pub_id) {
		this.pub_id = pub_id;
	}

	
	public void deleteOrder(Order o) 
	{
		o = null;
	}
	
	//Add validate methods


	public static void validateID(int ordId)throws OrderHandler 
	{
		// Verify that there is a order ID between 1 and 10 ints.
				 if(ordId < 1) 
				{
					throw new OrderHandler("Order Id must be at least 1 digit long and starts at 1");
				}
				else if(ordId > 1000000000) 
				{
					throw new OrderHandler("Order Id cannot be more than 10 digits long and msut be less than 1000000000");
				} 
	}
	//do i need to validate cus id? or ois it handle in customer
	
//	public static void validateCusID(int cusId)throws OrderHandler 
//	{
//		// Verify that there is a order ID between 1 and 10 ints.
//				 if(cusId < 1) 
//				{
//					throw new OrderHandler("Customer Id must be at least 1 digit long and starts at 1");
//				}
//				else if(cusId > 1000000000) 
//				{
//					throw new OrderHandler("Customer Id cannot be more than 10 digits long and msut be less than 1000000000");
//				} 
//	}


	public static void validatePrice(double price)throws OrderHandler {
		// Verify that there is a price as a double greater than 0.00 and less than 1000000000.00.
		 if(price <= 0.00) 
		{
			throw new OrderHandler("Price must be greater than 0");
		}
		else if(price > 100.1) //check limits with team
		{
			throw new OrderHandler("Price must be less than 100.00");
		} 
		
	}


	public static void validateQuantity(int quantity) throws OrderHandler {
		if(quantity < 1) 
		{
			throw new OrderHandler("Quantity must be greater than 0");
		}
		else if(quantity > 10) 
		{
			throw new OrderHandler("Quantity must be less than 11");
		} 	
	}
	
	//Validate date -> unsure how to
	
	//validate or just increment?
	
		public static void validatepub_id(int pub_id) throws OrderHandler 
		{
			// pub_id name between 3 and 15 characters.
			if(pub_id < 1) 
			{
				throw new OrderHandler("Publication Id must be at least 1 digit long and starts at 1");
			}
			else if(pub_id > 1000000000) 
			{
				throw new OrderHandler("Publication Id cannot be more than 10 digits long and msut be less than 1000000000");
			} 
		}


}

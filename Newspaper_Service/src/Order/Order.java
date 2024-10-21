package Order;

public class Order {
	
	private static int order_id; // in the object?
	// customer id?
	private double price;
	private int quantity_pub;
	private String del_date;
	private int pub_id;
	
	
	//CReate
	public Order(int order_id, double price, int quantity_pub, String del_date, int pub_id) {
		super();
		this.order_id = order_id;
		this.price = price;
		this.quantity_pub = quantity_pub;
		this.del_date = del_date;
		this.pub_id = pub_id;
	}
	
	
	//get = read set = update
	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
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

	public int getpub_id() {
		return pub_id;
	}

	public void setpub_id(int pub_id) {
		this.pub_id = pub_id;
	}
	
	/*skeleton for delete
	public void deleteOrder(Order o) 
	{
		
	}*/
	
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


	public static void validatePrice(double price)throws OrderHandler {
		// Verify that there is a price as a double greater than 0.00 and less than 1000000000.00.
		 if(price < 0.00) 
		{
			throw new OrderHandler("Price must be greater than 0");
		}
		else if(price > 1000000000) //check limits with team
		{
			throw new OrderHandler("Price must be less than 1000000000");
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
	
	
	//need array for pub list too?
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

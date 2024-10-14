package Order;

public class Order {
	
	private static int order_id; // in the object?
	//include customer id?
	private double price;
	private int quantity_pub;
	private String del_date;
	private String publication;
	
	
	//CReate
	public Order(int order_id, double price, int quantity_pub, String del_date, String publication) {
		super();
		this.order_id = order_id;
		this.price = price;
		this.quantity_pub = quantity_pub;
		this.del_date = del_date;
		this.publication = publication;
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

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
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
	
	
	//need array for pub list too
		public static void validatePublication(String pub) throws OrderHandler 
		{
			// publication name between 3 and 15 characters.
			if(pub.isBlank() || pub.isEmpty()) 
			{
				throw new OrderHandler("Publication field cannot be empty!");
			}
			else if(pub.length() < 3) 
			{
				throw new OrderHandler("Publication name can't be less than 3 characters.");
			}
			else if(pub.length() > 15) 
			{
				throw new OrderHandler("Publication name can't be more than 15 characters.");
			} 
		}


}

package Invoice;

public class Invoice {
	
	private int invoice_ID;
	private double totalPrice;
	private String publication;
	private String invoiceDate;
	private int pubQuantity;
	private int orderNum;
	
	public Invoice(int invoice_ID, double totalPrice, String publication, String invoiceDate, int pubQuantity, int orderNum)
	{
		super();
		this.invoice_ID = invoice_ID;
		this.invoiceDate = invoiceDate;
		this.publication = publication;
		this.pubQuantity = pubQuantity;
		this.totalPrice = totalPrice;
		this.orderNum = orderNum;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public int getInvoice_ID() {
		return invoice_ID;
	}

	public void setInvoice_ID(int invoice_ID) {
		this.invoice_ID = invoice_ID;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public int getPubQuantity() {
		return pubQuantity;
	}

	public void setPubQuantity(int pubQuantity) {
		this.pubQuantity = pubQuantity;
	}
	
	public static void validateID(int invoice_ID)throws InvoiceHandler 
	{
		// Verify that there is an invoice ID between 1 and 10 ints.
				 if(invoice_ID < 1) 
				{
					throw new InvoiceHandler("Invoice Id must be at least 1 digit long and starts at 1");
				}
				else if(invoice_ID > 1000000000) 
				{
					throw new InvoiceHandler("Invoice Id cannot be more than 10 digits long and msut be less than 1000000000");
				} 
	}


	public static void validatePrice(double totalPrice)throws InvoiceHandler {
		// Verify that there is a total price as a double greater than 0.00 and less than 1000000000.00.
		 if(totalPrice < 0.00) 
		{
			throw new InvoiceHandler("Price must be greater than 0");
		}
		else if(totalPrice > 1000000000) //check limits with team
		{
			throw new InvoiceHandler("Price must be less than 1000000000");
		} 
		
	}


	public static void validateQuantity(int quantity) throws InvoiceHandler {
		if(quantity < 1) 
		{
			throw new InvoiceHandler("Quantity must be greater than 0");
		}
		else if(quantity > 10) 
		{
			throw new InvoiceHandler("Quantity must be less than 11");
		} 	
	}
	
	//Validate date -> unsure how to
	
	
	//need array for pub list too
		public static void validatePublication(String pub) throws InvoiceHandler 
		{
			// publication name between 3 and 15 characters.
			if(pub.isBlank() || pub.isEmpty()) 
			{
				throw new InvoiceHandler("Publication field cannot be empty!");
			}
			else if(pub.length() < 3) 
			{
				throw new InvoiceHandler("Publication name can't be less than 3 characters.");
			}
			else if(pub.length() > 15) 
			{
				throw new InvoiceHandler("Publication name can't be more than 15 characters.");
			} 
		}
	
	

}

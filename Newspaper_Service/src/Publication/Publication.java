package Publication;

public class Publication {

	private String pubName;
	private int stock;
	private String pubType;
	private double pubPrice;
	private String frequency;

	private int pub_id;
	
	
	public Publication(String pubName, int stock, String pubType, double pubPrice, String frequency)throws PublicationHandler 
	{
		pub_id = 0;
		try {
			validateName(pubName);
			validateStock(stock);
			validatePubType(pubType);
			validatePubPrice(pubPrice);
			validateFrequency(frequency);
			
			
			
		}
		catch(PublicationHandler e)
		{
			throw e;
		}
		
		this.pubName = pubName;
		this.stock = stock;
		this.pubType = pubType;
		this.pubPrice = pubPrice;
		this.frequency = frequency;
		 
	}
	
	
	public String getPubName() {
		return pubName;
	}
	
	public void setPubName(String name) {
		this.pubName = name;
	}
	
	public String getPubType() {
		return pubType;
	}
	
	public void setPubType(String pubType) {
		this.pubType = pubType;
	}
	
	public String getFrequency() {
		return frequency;
	}
	
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	
	public double getPubPrice() {
		return pubPrice;
	}
	
	public void setPubPrice(double pubPrice) {
		this.pubPrice = pubPrice;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
//	public int getPub_id() {
//		return pub_id;
//	}
//	
//	public void setPub_id(int pub_id) {
//		this.pub_id = pub_id;
//	}
	
	//delete
	public void deletePublication(Publication p) 
	{
		p = null;
	}
	
	
	//validate methods
	
	public static void validateName(String pubName) throws PublicationHandler{
		if(pubName.isBlank() || pubName.isEmpty()) 
		{
			throw new PublicationHandler("Publication name cannot be empty!");
		}
		else if(pubName.length() < 3) 
		{
			throw new PublicationHandler("Publication name cannot be less than 3 characters.");
		}
		else if(pubName.length() > 20) 
		{
			throw new PublicationHandler("Publication name cannot be more than 20 characters.");
		} 
	}
	
	public static void validatePubType(String pubType) throws PublicationHandler{
		if(pubType.isBlank() || pubType.isEmpty()) 
		{
			throw new PublicationHandler("Publication type cannot be empty!");
		}
		else if(pubType.length() < 5) 
		{
			throw new PublicationHandler("Publication type cannot be less than 5 characters.");
		}
		else if(pubType.length() > 30) 
		{
			throw new PublicationHandler("Publication type cannot be more than 30 characters.");
		} 
	}
	
	public static void validateFrequency(String frequency) throws PublicationHandler{
		if(frequency.isBlank() || frequency.isEmpty()) 
		{
			throw new PublicationHandler("Publication frequency cannot be empty!");
		}
		else if(!frequency.equals("daily") && !frequency.equals("weekly") && !frequency.equals("monthly")) 
		{
			throw new PublicationHandler("Publication frequency must be daily, weekly or monthly.");
		}
		
	}
	public static void validatePubPrice(double pubPrice)throws PublicationHandler {
		// Verify that there is a price as a double greater than 0.00 and less than 100.00.
		 if(pubPrice <= 0.00) 
		{
			throw new PublicationHandler("Price must be greater than 0");
		}
		else if(pubPrice > 100.00) 
		{
			throw new PublicationHandler("Price must be less than 100.00");
		} 
		
	}
	
	public static void validateStock(int stock)throws PublicationHandler {
		// Verify that there is a price as a double greater than 0.00 and less than 100.00.
		 if(stock < 0) 
		{
			throw new PublicationHandler("Stock must not be less than 0");
		}
		else if(stock > 1000) 
		{
			throw new PublicationHandler("Stock must be less than 1000");
		} 
		
	}
	//pub_id??
	
	

}

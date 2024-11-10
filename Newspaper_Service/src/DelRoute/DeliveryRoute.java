package DelRoute;


public class DeliveryRoute {
	
	private String routeName;
	private int route_id;
	private int driver_id; //dirver separate?
	
	public DeliveryRoute(String routeName, int route_id, int driver_id) throws DeliveryRouteHandler {
		
		try {
			validateName(routeName);
			validateID(route_id);
			validateDriver(driver_id);	
		}
		catch(DeliveryRouteHandler e)
		{
			throw e;
		}
		this.routeName = routeName;
		this.route_id = route_id;
		this.driver_id = driver_id;
	}
	
	

	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	public int getRoute_id() {
		return route_id;
	}
	public void setRoute_id(int route_id) {
		this.route_id = route_id;
	}
	public int getDriver_id() {
		return driver_id;
	}
	public void setDriver_id(int driver_id) {
		this.driver_id = driver_id;
	}
	
	public void deleteRoute(DeliveryRoute d) {
		d = null;
	}
	
	public static void validateName(String routeName) throws DeliveryRouteHandler{
		if(routeName.isBlank() || routeName.isEmpty()) 
		{
			throw new DeliveryRouteHandler("Delivery Route name cannot be empty!");
		}
		else if(routeName.length() < 3) 
		{
			throw new DeliveryRouteHandler("Delivery Route name cannot be less than 3 characters.");
		}
		else if(routeName.length() > 20) 
		{
			throw new DeliveryRouteHandler("Delivery Route name cannot be more than 20 characters.");
		} 
		
	}
	
	public static void validateID(int route_id) throws DeliveryRouteHandler{
		
		if(route_id < 1) 
		{
			throw new DeliveryRouteHandler("ID must not be less than 1");
		}
		else if(route_id > 24) 
		{
			throw new DeliveryRouteHandler("ID must be less than 25");
		} 
	}

	public static void validateDriver(int driver_id) throws DeliveryRouteHandler{
		if(driver_id < 1) 
		{
			throw new DeliveryRouteHandler("ID must not be less than 1");
		}
		else if(driver_id > 24) 
		{
			throw new DeliveryRouteHandler("ID must be less than 25");
		} 
	
	}
	
	

}

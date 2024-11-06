package DelRoute;

public class DeliveryRouteHandler extends Exception {
String message;
	
	public DeliveryRouteHandler(String errMessage){
		message = errMessage;
	}
	
	public String getMessage() {
		return message;
	}
}

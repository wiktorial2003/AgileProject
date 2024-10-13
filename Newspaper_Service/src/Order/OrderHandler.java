package Order;

public class OrderHandler extends Exception {

String message;
	
	public OrderHandler(String errMessage){
		message = errMessage;
	}
	
	public String getMessage() {
		return message;
	}

}

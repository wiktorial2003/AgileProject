package Customer;

public class CustomerHandler extends Exception {
	
	String message;
	
	public CustomerHandler(String errMessage){
		message = errMessage;
	}
	
	public String getMessage() {
		return message;
	}

}

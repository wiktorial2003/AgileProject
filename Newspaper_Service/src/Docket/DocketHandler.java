package Docket;

public class DocketHandler extends Exception {
	
	String message;
	
	public DocketHandler(String errMessage) {
		message  = errMessage;
	}
	
	public String getMessage() {
		return message;
	}

}

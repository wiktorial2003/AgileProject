package Publication;

public class PublicationHandler extends Exception {
String message;
	
	public PublicationHandler(String errMessage){
		message = errMessage;
	}
	
	public String getMessage() {
		return message;
	}


}

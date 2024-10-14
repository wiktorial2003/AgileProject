package Invoice;
	
	public class InvoiceHandler extends Exception {
		
		String message;
		
		public InvoiceHandler(String errMessage){
			message = errMessage;
		}
		
		public String getMessage() {
			return message;
		}

	}


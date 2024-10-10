package Docket;


public class DeliveryDocket {
	private int dockId;
	private int custId;
	private int ordNum;
	private String name;
	private String address;
	private String phoneNumber;
	
	void setDeliveryDocketId(int docketId) {
		dockId = docketId;
	}
	
	void setCustomerID(int customerId) {
		custId = customerId;
	}
	
	void setOrderNumber(int orderNumber) {
		ordNum = orderNumber;
	}
	void setName(String custName) {
		name = custName;
	}
	
	void setAddress(String custAddr) {
		address = custAddr;
	}
	
	void setPhoneNumber(String custPhone) {
		phoneNumber = custPhone;
	}
	
	int getdockId() {
		return dockId;
	}
	
	int getcustId() {
		return custId;
	}
	
	int getordNum() {
		return ordNum;
	}
	
	String getName() {
		return name;
	}
	
	String getAddress() {
		return address;
	}
	
	String getPhoneNumber() {
		return phoneNumber;
		
	}
	
	public DeliveryDocket(int dockId, int custID, int ordNum, String custName, String custAddr, String custPhone)
	throws CustomerHandler {
		
		id = 0;
		
		try {
			
			validateDeliberyDocketId(dockId);
			validateCustomerID(custId);
			validateOrderNumber(ordNum);
			validateName(custName);
			validateAddress(custAddr);
			validatePhoneNumber(custPhone);

		}
		catch (CustomerHandler e) {
			throw e;
		}
		dockId = docketId;
		custId = customerId;
		ordNum = orderNumber;
		name = custName;
		address = custAddr;
		phoneNumber = custPhone;

		
		
	}

	private void validateOrderNumber(int ordNum2) {
		// TODO Auto-generated method stub
		
	}

	private void validateCustomerID(int custId2) {
		// TODO Auto-generated method stub
		
	}

	private void validateDeliberyDocketId(int dockId2) {
		// TODO Auto-generated method stub
		
	}

	
	


}

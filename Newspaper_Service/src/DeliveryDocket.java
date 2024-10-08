


public class DeliveryDocket {
	private int dockId;
	private int custId;
	private int ordNum;
	private String name;
	private String address;
	private String phoneNumber;
	
	void setdockId(int docketId) {
		dockId = docketId;
	}
	
	void setcustId(int customerId) {
		custId = customerId;
	}
	
	void setordNum(int orderNumber) {
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

	
	


}

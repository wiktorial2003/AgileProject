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

        try {
            validateDeliveryDocketId(dockId);
            validateCustomerID(custID);
            validateOrderNumber(ordNum);
            validateName(custName);
            validateAddress(custAddr);
            validatePhoneNumber(custPhone);

            this.dockId = dockId;
            this.custId = custID;
            this.ordNum = ordNum;
            this.name = custName;
            this.address = custAddr;
            this.phoneNumber = custPhone;
        } catch (CustomerHandler e) {
            throw e;
        }
    }

    private void validateOrderNumber(int ordNum) throws CustomerHandler {
        if (ordNum <= 0) {
            throw new CustomerHandler("Order number must be greater than 0.");
        }
    }

    private void validateCustomerID(int custId) throws CustomerHandler {
        if (custId <= 0) {
            throw new CustomerHandler("Customer ID must be greater than 0.");
        }
    }

    private void validateDeliveryDocketId(int dockId) throws CustomerHandler {
        if (dockId <= 0) {
            throw new CustomerHandler("Delivery docket ID must be greater than 0.");
        }
    }

    public static void validateName(String custName) throws CustomerHandler {
        if (custName == null || custName.trim().isEmpty()) {
            throw new CustomerHandler("Customer name cannot be empty.");
        }
    }

    public static void validateAddress(String custAddr) throws CustomerHandler {
        if (custAddr == null || custAddr.trim().isEmpty()) {
            throw new CustomerHandler("Address cannot be empty.");
        }
    }

    public static void validatePhoneNumber(String custPhone) throws CustomerHandler {
        if (custPhone == null || custPhone.trim().isEmpty()) {
            throw new CustomerHandler("Phone number cannot be empty.");
        }
    }
}

// You need to define the CustomerHandler class to make this functional
class CustomerHandler extends Exception {
    public CustomerHandler(String message) {
        super(message);
    }
}



//import java.awt.*;
//
//package Docket;
//
//
//public class DeliveryDocket {
//	private int dockId;
//	private int custId;
//	private int ordNum;
//	private String name;
//	private String address;
//	private String phoneNumber;
//	
//	void setDeliveryDocketId(int docketId) {
//		dockId = docketId;
//	}
//	
//	void setCustomerID(int customerId) {
//		custId = customerId;
//	}
//	
//	void setOrderNumber(int orderNumber) {
//		ordNum = orderNumber;
//	}
//	void setName(String custName) {
//		name = custName;
//	}
//	
//	void setAddress(String custAddr) {
//		address = custAddr;
//	}
//	
//	void setPhoneNumber(String custPhone) {
//		phoneNumber = custPhone;
//	}
//	
//	int getdockId() {
//		return dockId;
//	}
//	
//	int getcustId() {
//		return custId;
//	}
//	
//	int getordNum() {
//		return ordNum;
//	}
//	
//	String getName() {
//		return name;
//	}
//	
//	String getAddress() {
//		return address;
//	}
//	
//	String getPhoneNumber() {
//		return phoneNumber;
//		
//	}
//	
//	public DeliveryDocket(int dockId, int custID, int ordNum, String custName, String custAddr, String custPhone)
//	throws CustomerHandler {
//		
//		dockId = 0;
//		custId = 0;
//		ordNum = 0;
//		
//		try {
//			
//			validateDeliberyDocketId(dockId);
//			validateCustomerID(custId);
//			validateOrderNumber(ordNum);
//			validateName(custName);
//			validateAddress(custAddr);
//			validatePhoneNumber(custPhone);
//
//		}
//		catch (CustomerHandler e) {
//			throw e;
//		}
//		
//		dockId = dockId;
//		custId = custId;
//		ordNum = ordNum;
//		name = custName;
//		address = custAddr;
//		phoneNumber = custPhone;
//
//		
//		
//	}
//
//	private void validateOrderNumber(int ordNum2) {
//		
//		
//	}
//
//	private void validateCustomerID(int custId2) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	private void validateDeliveryDocketId(int dockId2) {
//		// TODO Auto-generated method stub
//		
//	}
//	
//	public static void validateDocketId(int docketId) {
//		if (docketId.isBlank() || docketId.isEmpty())
//				throw new CustomerHandler("Docket ID not specified");
//		else if("Docket ID accepted");	
//	}
//	
//	public static void validateCustomerId(int customerId) {
//		if (customerId.isBlank() || custId.isEmpty())
//				throw new CustomerHandler("Customer ID not specified");
//		else if("Custoner ID  accepted");
//	}
//	
//	public static void validateOrderNumber(int ordNum) {
//		if (ordNum.isBlank() || ordNum.isEmpty())
//				throw new CustomerHandler("Order Number not specified");
//		else ("Order Number  accepted");
//	}
//	
//	public static void validate
//	
//	
//	public static void validateName(String custName) throws CustomerHandler {
//		
//	}
//
//	
//	
//
//
//}
//
//
//

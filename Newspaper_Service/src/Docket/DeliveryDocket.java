package Docket;

public class DeliveryDocket {
    private int dockId;
    private long custId;
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
        return (int) custId;
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

    public DeliveryDocket(int dockId, long l, int ordNum, String custName, String custAddr, String custPhone)
            throws DocketHandler {

        try {
            validateDeliveryDocketId(dockId);
            validateCustomer(custId);
            validateOrderNumber(ordNum);
            validateName(custName);
            validateAddress(custAddr);
            validatePhoneNumber(custPhone);

            this.dockId = dockId;
            this.custId = l;
            this.ordNum = ordNum;
            this.name = custName;
            this.address = custAddr;
            this.phoneNumber = custPhone;
        } catch (DocketHandler e) {
            throw e;
        }
    }

    private void validateOrderNumber(int ordNum) throws DocketHandler {
        if (ordNum <= 0) {
            throw new DocketHandler("Order number must be greater than 0.");
        }
         
    }

    public static void validateCustomer(long custId2) throws DocketHandler
	{
		int customerLength = String.valueOf(custId2).length();
		// Verify that there is a customer's phone number and its 9 characters.
		if(customerLength < 4) 
		{
			throw new DocketHandler("Customer ID cannot be less than 4 digits");
		}
		else if(customerLength > 10)
		{
			throw new DocketHandler("Customer ID cannot be more than 10 digits");
		}

	}

    private void validateDeliveryDocketId(int dockId) throws DocketHandler {
    	int customerLength = String.valueOf(dockId).length();
		if(customerLength < 0) 
		{
			throw new DocketHandler("Docket ID cannot be less than 4 digits");
		}
		else if(customerLength > 12)
		{
			throw new DocketHandler("Docket ID cannot be more than 10 digits");
		}
    }

    public static void validateName(String custName) throws DocketHandler {
        if (custName == null || custName.trim().isEmpty()) {
            throw new DocketHandler("Customer name cannot be empty.");
        }
        else if (custName.length()<3)
        {
        	throw new DocketHandler("Customer name too cannot be less than 3 characters");
        }
        else if (custName.length()>15)
        {
        	throw new DocketHandler("Customer name cannot be more than 15 characters");
        }
    }

    public static void validateAddress(String custAddr) throws DocketHandler {
        if (custAddr == null || custAddr.trim().isEmpty()) {
            throw new DocketHandler("Address cannot be empty.");
        }
        else if (custAddr.length()<3)
        {
        	throw new DocketHandler("Customer address cannot be less than 3 characters");
        }
        else if (custAddr.length()>25)
        {
        	throw new DocketHandler("Customer address should be longer than 25 characters");
        }
    }

    public static void validatePhoneNumber(String custPhone) throws DocketHandler {
        if (custPhone == null || custPhone.trim().isEmpty()) {
            throw new DocketHandler("Phone number cannot be empty.");
        }
        else if (custPhone.length()<9)
        {
        	throw new DocketHandler("Phone number should be 9 digits");
        }
        else if (custPhone.length()>9)
        {
        	throw new DocketHandler("Phone number should be 9 digits");
        }
    }

	public static void validatePhoneNumber(int i) {
		// TODO Auto-generated method stub
		
	}
}

// You need to define the DocketHandler class to make this functional
//class DocketHandler extends Exception {
//    public DocketHandler(String message) {
//        super(message);
//    }}





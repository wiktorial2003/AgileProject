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
            throws DocketHandler {

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
        } catch (DocketHandler e) {
            throw e;
        }
    }

    private void validateOrderNumber(int ordNum) throws DocketHandler {
        if (ordNum <= 0) {
            throw new DocketHandler("Order number must be greater than 0.");
        }
    }

    private void validateCustomerID(int custId) throws DocketHandler {
        if (custId <= 0) {
            throw new DocketHandler("Customer ID must be greater than 0.");
        }
    }

    private void validateDeliveryDocketId(int dockId) throws DocketHandler {
        if (dockId <= 0) {
            throw new DocketHandler("Delivery docket ID must be greater than 0.");
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
}

// You need to define the DocketHandler class to make this functional
//class DocketHandler extends Exception {
//    public DocketHandler(String message) {
//        super(message);
//    }}





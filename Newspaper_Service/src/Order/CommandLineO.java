package Order;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;


import Database.Database;
import Database.MenuHandler;

public class CommandLineO {
	
	private static void listOfFunctions() {
		
		System.out.println(" ");
		System.out.println("=============================================");
		System.out.println("Please choose ONE of the following options:");
		System.out.println("1. Create an Order");
		System.out.println("2. View ALL Order Records");
		System.out.println("3. Update Order Records");
		System.out.println("4. Delete an Order by ID");
		System.out.println("99. Close the Application");
		System.out.println("=============================================");
		System.out.println(" ");
		
	}

	
	private static boolean printOrderTable(ResultSet rs) throws Exception {
		
		
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Table: " + rs.getMetaData().getTableName(1));
		for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
			System.out.printf("%30s",rs.getMetaData().getColumnName(i));
		}
		System.out.println();
		while (rs.next()) {
			int id = rs.getInt("order_id");
			double price = rs.getDouble("price");
			int quantity = rs.getInt("quantity_pub");
			String delDate = rs.getString("del_date");
			int publication = rs.getInt("pub_id");
			System.out.printf("%30s", id);
			System.out.printf("%30s", price);
			System.out.printf("%30s", quantity);
			System.out.printf("%30s", delDate);
			//System.out.printf("%30s", pubID);
			System.out.println();
			
			// these vars refer to the column names in the Customer database table, will be 
			//changed when database is made. They only copy the data, so the names can be different
			
		}// end while
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
		
		return true;
		
	}

	public static void main(String[] args) {
		
		//Create the Database Object
		
		try {
			
			Database dao = new Database();
		
			// Configure System for Running
			Scanner keyboard = new Scanner(System.in); 
			String functionNumber = "-99";
			boolean keepAppOpen = true;
		
			while (keepAppOpen == true) {
			
				//Present list of functionality and get selection
				
				listOfFunctions();
				functionNumber = keyboard.next();
		
				switch (functionNumber) {
		
				case "1":
//					//Get Order Details from the User
					//get customer to link
					System.out.printf("Enter CustomerID: \n");
					int customerID = keyboard.nextInt();
					System.out.printf("Enter Publication ID: \n");
					int pubID = keyboard.nextInt();
					System.out.printf("Enter Quantity: \n");
					int quantity = keyboard.nextInt();
					System.out.printf("Enter price: \n");
					double price = keyboard.nextDouble();
					System.out.printf("Enter Delivery Date: \n");
					String delDate = keyboard.next();
				
					Order orderObj = new Order(customerID,price,quantity,delDate,pubID);
				
//					//Insert Customer Details into the database
					boolean insertResult = dao.insertOrderDetails(orderObj);
					if (insertResult == true)
					System.out.println("Order Details Saved");
					else 
						System.out.println("ERROR: Order Details NOT Saved");
					break;
					
				case "2": 
//					//Retrieve ALL Customer Records
					ResultSet rSet = dao.getAllOrders();
					if (rSet == null) {
						System.out.println("No Records Found");
						break;
					}
					else {
						boolean tablePrinted = printOrderTable(rSet);
						if (tablePrinted == true)
							rSet.close();
					}
					break;
					
				case "3":
					//Update Customer Records
					
					 
					System.out.println("Enter the Order ID to update: ");
				    int updateOrderId = keyboard.nextInt();
				    try {
				    	// check if there is an entry in the database through id
				    }catch(Exception e){
				    	// no id on database, no customer, update fails
				    }

				    System.out.println("Enter New Customer ID: ");
				    int newCustID = keyboard.nextInt();

				    System.out.println("Enter New Publication ID: ");
				    int newPubID = keyboard.nextInt();

				    System.out.println("Enter New Quantitity: ");
				    int newQuantity = keyboard.nextInt();
				    
				    System.out.println("Enter New Price: ");
				    double newPrice = keyboard.nextDouble();
				    
				    System.out.println("Enter New Delivery Date: ");
				    String newDelDate = keyboard.next();
				    
				    Order orderObj1 = new Order(newCustID,newPrice,newQuantity,newDelDate,newPubID);
				    
				    insertResult = dao.updateOrderById(updateOrderId, orderObj1);
					if (insertResult == true)
						System.out.println("Order Details updated successfuly");
					else
						System.out.println("ERROR: Order Details were not updated.");
				    break;
					
				case "4":
//				//Delete Customer Record by ID
					System.out.println("Enter Order Id to be deleted or -99 to Clear all Rows");
					String deleteOrdId = keyboard.next();
				boolean deleteResult = dao.deleteOrderById(Integer.parseInt(deleteOrdId));
					if ((deleteResult == true) && (deleteOrdId.equals("-99")))
						System.out.println("Order Table Emptied");
					else if (deleteResult == true)
						System.out.println("Order Deleted");
					else 
						System.out.println("ERROR: Order Details NOT Deleted or Do Not Exist");
					break;
			
				case "99":
					keepAppOpen = false;
					System.out.println("Closing the Application");
					break;
			
				default:
					System.out.println("No Valid Function Selected");
					break;
				} // end switch
		
			}// end while
		
			//Tidy up Resources
			keyboard.close();
		
		}
	
		catch(Exception e) {
			System.out.println("PROGRAM TERMINATED - ERROR MESSAGE:" + e.getMessage());
		} // end try-catch
		

	} // end main
	
	
}
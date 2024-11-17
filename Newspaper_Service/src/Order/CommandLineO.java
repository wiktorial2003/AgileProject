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
			int id = rs.getInt("id");
			double price = rs.getDouble("price");
			int quantity = rs.getInt("quantity");
			String delDate = rs.getString("delDate");
			String publication = rs.getString("pubs");
			System.out.printf("%30s", id);
			System.out.printf("%30s", price);
			System.out.printf("%30s", quantity);
			System.out.printf("%30s", delDate);
			System.out.printf("%30s", publication);
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
				MenuHandler.displayWelcomeMenu();
				listOfFunctions();
				functionNumber = keyboard.next();
		
				switch (functionNumber) {
		
//				case "1":
//					//Get Order Details from the User
//					System.out.printf("Enter Order: \n");
//					double orderPrice = keyboard.nextDouble();
//					System.out.printf("Enter Customer Address: \n");
//					String custAddr = keyboard.next();
//					System.out.printf("Enter Customer PhoneNumber: \n");
//					String custphoneNumber = keyboard.next();
//				
//					Order orderObj = new Order(orderPrice,address,phoneNo,isAway,subscriptions);
//				
//					//Insert Customer Details into the database
//					boolean insertResult = dao.insertOrderDetailsAccount(orderObj);
//					if (insertResult == true)
//					System.out.println("Customer Details Saved");
//					else 
//						System.out.println("ERROR: Customer Details NOT Saved");
//					break;
//					
//				case "2": 
//					//Retrieve ALL Customer Records
//					ResultSet rSet = dao.getAllOrders();
//					if (rSet == null) {
//						System.out.println("No Records Found");
//						break;
//					}
//					else {
//						boolean tablePrinted = printOrderTable(rSet);
//						if (tablePrinted == true)
//							rSet.close();
//					}
//					break;
//					
//				case "3":
//				//Delete Customer Record by ID
//					System.out.println("Enter Customer Id to be deleted or -99 to Clear all Rows");
//					String deleteCustId = keyboard.next();
//				boolean deleteResult = dao.deleteCustomerById(Integer.parseInt(deleteCustId));
//					if ((deleteResult == true) && (deleteCustId.equals("-99")))
//						System.out.println("Customer Table Emptied");
//					else if (deleteResult == true)
//						System.out.println("Customer Deleted");
//					else 
//						System.out.println("ERROR: Customer Details NOT Deleted or Do Not Exist");
//					break;
//			
//				case "99":
//					keepAppOpen = false;
//					System.out.println("Closing the Application");
//					break;
//			
//				default:
//					System.out.println("No Valid Function Selected");
//					break;
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
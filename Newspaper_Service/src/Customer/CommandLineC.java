package Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;

import Database.Database;

public class CommandLineC {

	private static void listOfFunctions() {

		System.out.println(" ");
		System.out.println("=============================================");
		System.out.println("Please choose ONE of the following options:");
		System.out.println("1. Create Customer Account");
		System.out.println("2. View ALL Customer Records");
		System.out.println("3. Update Customer Records");
		System.out.println("3. Delete Customer Record by ID");
		System.out.println("99. Close the Application");
		System.out.println("=============================================");
		System.out.println(" ");

	}

	private static boolean printCustomerTable(ResultSet rs) throws Exception {

		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Table: " + rs.getMetaData().getTableName(1));
		for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
			System.out.printf("%30s", rs.getMetaData().getColumnName(i));
		}
		System.out.println();
		while (rs.next()) {
			int id = rs.getInt("customer_id");
			String name = rs.getString("name");
			String addr = rs.getString("address");
			String phone = rs.getString("phoneNo");
			boolean isAway = rs.getBoolean("isAway");
			//String subscriptions = rs.getString("subscriptions");
			System.out.printf("%30s", id);
			System.out.printf("%30s", name);
			System.out.printf("%30s", addr);
			System.out.printf("%30s", phone);
			System.out.printf("%30s", isAway);
			//System.out.printf("%30s", subscriptions);
			System.out.println();

			// these vars refer to the column names in the Customer database table, will be
			// changed when database is made. They only copy the data, so the names can be
			// different

		} // end while
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------------------");

		return true;

	}

	public static void main(String[] args) {

		// Create the Database Object

		try {
			// Create database object from class Database
			Database dao = new Database();

			// Configure System for Running
			Scanner keyboard = new Scanner(System.in);
			String functionNumber = "-99";
			boolean keepAppOpen = true;

			while (keepAppOpen == true) {

				// Present list of functionality and get selection
				listOfFunctions();
				functionNumber = keyboard.next();

				switch (functionNumber) {

				case "1":
					// Get Customer Details from the User
					System.out.printf("Enter Customer Name: \n");
					String custName = keyboard.next();
					System.out.printf("Enter Customer Address: \n");
					String custAddr = keyboard.next();
					System.out.printf("Enter Customer Phone Number: \n");
					int custPhoneNo = keyboard.nextInt();

					Customer custObj = new Customer(custName, custAddr, custPhoneNo, false);

					// Insert Customer Details into the database
					boolean insertResult = dao.insertCustomerDetailsAccount(custObj);
					if (insertResult == true)
						System.out.println("Customer Details Saved");
					else
						System.out.println("ERROR: Customer Details NOT Saved");
					break;

				case "2":
					// Retrieve ALL Customer Records
					ResultSet rSet = dao.getAllCustomers();
					if (rSet == null) {
						System.out.println("No Records Found");
						break;
					} else {
						boolean tablePrinted = printCustomerTable(rSet);
						if (tablePrinted == true)
							rSet.close();
					}
					break;
					
				case "3":
				    System.out.println("Enter the Customer ID to update: ");
				    int updateCustomerId = keyboard.nextInt();

				    // Collect new customer data
				    System.out.println("Enter New Customer Name: ");
				    String newCustName = keyboard.next();

				    System.out.println("Enter New Customer Address: ");
				    String newCustAddr = keyboard.next();

				    System.out.println("Enter New Customer Phone Number: ");
				    int newCustPhone = keyboard.nextInt();

				    // Create a new customer object with updated details
				    Customer updatedCustomer = new Customer(newCustName, newCustAddr, newCustPhone, false);

				    // Perform the update operation
				    boolean updateResult = dao.updateCustomerById(updateCustomerId, updatedCustomer);
				    if (updateResult) {
				        System.out.println("Customer Details updated successfully");
				    } else {
				        System.out.println("ERROR: Customer Details were not updated.");
				    }
				    break;

					

				case "4":
					// Delete Customer Record by ID
					System.out.println("Enter Customer Id to be deleted or -99 to Clear all Rows");
					String deleteCustId = keyboard.next();
					boolean deleteResult = dao.deleteCustomerById(Integer.parseInt(deleteCustId));
					if ((deleteResult == true) && (deleteCustId.equals("-99")))
						System.out.println("Customer Table Emptied");
					else if (deleteResult == true)
						System.out.println("Customer Deleted");
					else
						System.out.println("ERROR: Customer Details NOT Deleted or Do Not Exist");
					break;

				case "99":
					keepAppOpen = false;
					System.out.println("Closing the Application");
					break;

				default:
					System.out.println("No Valid Function Selected");
					break;
				} // end switch

			} // end while

			// Tidy up Resources
			keyboard.close();

		}

		catch (Exception e) {
			System.out.println("PROGRAM TERMINATED - ERROR MESSAGE:" + e.getMessage());
		} // end try-catch

	} // end main

}
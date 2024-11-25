 package Publication;
 
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;

import Customer.Customer;
import Database.Database;
import Database.MenuHandler;

public class CommandLineP {
	
	private static void listOfFunctions() {
		
		System.out.println(" ");
		System.out.println("=============================================");
		System.out.println("Please choose ONE of the following options:");
		System.out.println("1. Create a Publication");
		System.out.println("2. View ALL Publications");
		System.out.println("3. Update Publications");
		System.out.println("4. Delete Publication by ID");
		System.out.println("99. Close the Application");
		System.out.println("=============================================");
		System.out.println(" ");
		
	}

	
	private static boolean printPublicationTable(ResultSet rs) throws Exception {
		
		
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Table: " + rs.getMetaData().getTableName(1));
		for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
			System.out.printf("%30s",rs.getMetaData().getColumnName(i));
		}
		System.out.println();
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("custname");
			String type = rs.getString("pubType");
			String date = rs.getString("date");
			double price = rs.getDouble("price"); // is this correct??
			String frequency = rs.getString("frequency");
			System.out.printf("%30s", id);
			System.out.printf("%30s", name);
			System.out.printf("%30s", type);
			System.out.printf("%30s", date);
			System.out.printf("%30s", price); //correct??
			System.out.printf("%30s", frequency);
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

				// Present list of functionality and get selection
				listOfFunctions();
				functionNumber = keyboard.next();
		
				switch (functionNumber) {
		
				case "1":
				    // Get Publication Details from the User
				    
					System.out.printf("Enter Publication Name: \n");
				    String pubName = keyboard.next();
				    
				    System.out.printf("Enter Stock Amount: \n");
				    int stock = keyboard.nextInt();
				    
				    System.out.printf("Enter Publication Type: \n");
				    String pubType = keyboard.next();
				   
				    System.out.printf("Enter Publication Price: \n");
				    double pubPrice = keyboard.nextDouble();
				    
				    System.out.printf("Enter Publication frequency (daily, weekly, monthly): \n");
				    String frequency = keyboard.next();

				    // Create Publication object
				    Publication pubObj = new Publication(pubName, stock,  pubType, pubPrice, frequency);

				    // Insert publication details into the database
				    boolean insertResult = dao.insertPublicationDetails(pubObj);
				    if (insertResult) {
				        System.out.println("Publication Details Saved");
				    } else {
				        System.out.println("ERROR: Publication Details NOT Saved");
				    }
				    break;

				case "2": 
					//Retrieve ALL publication Records
					ResultSet rSet = dao.getAllPublications();
					if (rSet == null) {
						System.out.println("No Records Found");
						break;
					}
					else {
						boolean tablePrinted = printPublicationTable(rSet);
						if (tablePrinted == true)
							rSet.close();
					}
					break;
					
				case "3": 
					System.out.println("Enter the Customer ID to update: ");
				    int updatePublicationId = keyboard.nextInt();

				    // Collect new customer data
				    System.out.println("Enter New Customer Name: ");
				    String newPubName = keyboard.next();

				    System.out.printf("Enter Stock Amount: \n");
				    int newStock = keyboard.nextInt();
				    
				    System.out.println("Enter New Customer Address: ");
				    String newPubType = keyboard.next();
				    
				    System.out.printf("Enter Publication Price: \n");
					double newPubPrice = keyboard.nextDouble();
					
					System.out.printf("Enter Publication frequency: \n");
					String newFrequency = keyboard.next();

				    // Create a new customer object with updated details
				    Publication updatedPublication = new Publication(newPubName, newStock, newPubType,  newPubPrice, newFrequency);

				    // Perform the update operation
				    boolean updateResult = dao.updatePublicationById(updatePublicationId, updatedPublication);
				    if (updateResult) {
				        System.out.println("Publication Details updated successfully");
				    } else {
				        System.out.println("ERROR: Publication Details were not updated.");
				    }
				    break;

				case "4":
					//Delete Publication Record by ID
					System.out.println("Enter Publication Id to be deleted or -99 to Clear all Rows");
					String deletePubId = keyboard.next();
					boolean deleteResult = dao.deletePublicationById(Integer.parseInt(deletePubId));
					if ((deleteResult == true) && (deletePubId.equals("-99")))
						System.out.println("Publication Table Emptied");
					else if (deleteResult == true)
						System.out.println("Publication Deleted");
					else 
						System.out.println("ERROR: Publication Details NOT Deleted or Do Not Exist");
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


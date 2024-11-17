package Database;

import java.util.Scanner;

import Publication.CommandLineP;
import Customer.CommandLineC;
// Import other entity classes as needed
import Database.MenuHandler;

public class MainCaller {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        boolean keepAppRunning = true;

        while (keepAppRunning) {
            // Display the main menu
            MenuHandler.displayWelcomeMenu();
            System.out.print("Enter your choice: ");
            String choice = keyboard.next();

            switch (choice) {
                case "1":
                    System.out.println("Opening Customer Management...");
                    CommandLineC.main(new String[0]); // Replace with customer management logic
                    break;

                case "2":
                    System.out.println("Opening Delivery Route Management...");
                    // Call delivery route management logic here
                    break;

                case "3":
                    System.out.println("Opening Docket Management...");
                    // Call docket management logic here
                    break;

                case "4":
                    System.out.println("Opening Invoice Management...");
                    // Call invoice management logic here
                    break;

                case "5":
                    System.out.println("Opening Order Management...");
                    // Call order management logic here
                    break;

                case "6":
                    System.out.println("Opening Publication Management...");
                    CommandLineC.main(new String[0]); // Replace with publication management logic
                    break;

                case "99":
                    keepAppRunning = false;
                    System.out.println("Exiting the application. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        keyboard.close();
    }
}

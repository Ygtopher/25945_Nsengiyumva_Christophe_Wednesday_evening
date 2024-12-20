package ManagingTrafficLines;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Main Execution
public class TrafficFineManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Driver> drivers = new ArrayList<>();
        boolean continueRunning = true;

        while (continueRunning) {
            try {
                // Allow user to input driver details
                System.out.println("Enter the number of drivers:");
                int numOfDrivers = getValidInt(scanner);
                for (int i = 0; i < numOfDrivers; i++) {
                    System.out.println("Enter details for Driver " + (i + 1));

                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter license number: ");
                    String licenseNumber = scanner.nextLine();

                    Driver driver = new Driver(name, licenseNumber);
                    drivers.add(driver);

                    // Allow user to input violations for each driver
                    System.out.print("Enter the number of violations for " + name + ": ");
                    int numOfViolations = getValidInt(scanner);

                    for (int j = 0; j < numOfViolations; j++) {
                        System.out.println("Enter violation " + (j + 1) + " details:");

                        // Get violation type
                        System.out.print("Enter violation type: ");
                        String violationType = scanner.nextLine();

                        // Get violation fine amount
                        System.out.print("Enter fine amount: ");
                        double fineAmount = getValidDouble(scanner);

                        // Create violation and add it to the driver
                        SpecificViolation violation = new SpecificViolation(violationType, fineAmount);
                        driver.addViolation(violation.getFineAmount());
                    }
                }

                // Display Driver Details
                System.out.println("\n--- Driver Details ---");
                for (Driver driver : drivers) {
                    driver.displayDetails();
                    System.out.println();
                }

                // Reset Violations for Driver 1
                if (!drivers.isEmpty()) {
                    System.out.println("Resetting violations for driver: " + drivers.get(0).name);
                    drivers.get(0).resetViolations();
                    drivers.get(0).displayDetails();
                }

                // Ask user if they want to continue or exit
                System.out.print("Do you want to continue? (yes/no): ");
                String userChoice = scanner.nextLine().trim().toLowerCase();

                if (userChoice.equals("no") || userChoice.equals("n")) {
                    continueRunning = false;  // Exit the loop and end the program
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println("Thank you for using the Traffic Fine Management System. Goodbye!");
    }

    // Method to get valid integer input
    private static int getValidInt(Scanner scanner) {
        int value = -1;
        while (value <= 0) {
            try {
                value = Integer.parseInt(scanner.nextLine());
                if (value <= 0) {
                    System.out.print("Please enter a positive number: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
        return value;
    }

    // Method to get valid double input
    private static double getValidDouble(Scanner scanner) {
        double value = -1;
        while (value <= 0) {
            try {
                value = Double.parseDouble(scanner.nextLine());
                if (value <= 0) {
                    System.out.print("Please enter a positive fine amount: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid fine amount: ");
            }
        }
        return value;
    }
}

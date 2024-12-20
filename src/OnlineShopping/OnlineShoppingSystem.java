package OnlineShopping;


import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class OnlineShoppingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the Online Shopping System!");
            System.out.println("1. Add a Product");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 2) {
                System.out.println("Exiting... Thank you for using the system!");
                break;
            }

            if (choice == 1) {
                Product product = null;

                // Input Product ID
                int productId = 0;
                while (true) {
                    System.out.print("Enter Product ID (must be positive): ");
                    try {
                        productId = Integer.parseInt(scanner.nextLine());
                        if (productId <= 0) {
                            throw new IllegalArgumentException("Product ID must be a positive integer.");
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage() + ". Please try again.");
                    }
                }

                // Input Product Name
                String productName = null;
                while (true) {
                    System.out.print("Enter Product Name (cannot be empty): ");
                    try {
                        productName = scanner.nextLine();
                        if (productName.trim().isEmpty()) {
                            throw new IllegalArgumentException("Product name cannot be empty.");
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage() + ". Please try again.");
                    }
                }

                // Input Product Price
                double productPrice = 0.0;
                while (true) {
                    System.out.print("Enter Product Price (must be positive): ");
                    try {
                        productPrice = Double.parseDouble(scanner.nextLine());
                        if (productPrice <= 0) {
                            throw new IllegalArgumentException("Product price must be positive.");
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage() + ". Please try again.");
                    }
                }

                // Choose Product Type
                System.out.println("\nChoose Product Type:");
                System.out.println("1. Electronics");
                System.out.println("2. Clothing");
                System.out.println("3. Grocery");
                int productType = 0;
                while (true) {
                    System.out.print("Enter Product Type: ");
                    try {
                        productType = Integer.parseInt(scanner.nextLine());
                        if (productType < 1 || productType > 3) {
                            throw new IllegalArgumentException("Invalid product type. Must be 1, 2, or 3.");
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage() + ". Please try again.");
                    }
                }

                // Product Type Specific Attributes
                switch (productType) {
                    case 1: // Electronics
                        int warrantyPeriod = 0;
                        while (true) {
                            System.out.print("Enter Warranty Period (in months): ");
                            try {
                                warrantyPeriod = Integer.parseInt(scanner.nextLine());
                                if (warrantyPeriod < 0) {
                                    throw new IllegalArgumentException("Warranty period cannot be negative.");
                                }
                                break;
                            } catch (Exception e) {
                                System.out.println("Error: " + e.getMessage() + ". Please try again.");
                            }
                        }
                        product = new Electronics(productId, productName, productPrice, warrantyPeriod);
                        break;

                    case 2: // Clothing
                        String size = null;
                        while (true) {
                            System.out.print("Enter Size (S, M, L, XL): ");
                            try {
                                size = scanner.nextLine();
                                if (!size.matches("S|M|L|XL")) {
                                    throw new IllegalArgumentException("Invalid size. Must be one of S, M, L, XL.");
                                }
                                break;
                            } catch (Exception e) {
                                System.out.println("Error: " + e.getMessage() + ". Please try again.");
                            }
                        }
                        product = new Clothing(productId, productName, productPrice, size);
                        break;

                    case 3: // Grocery
                        Date expiryDate = null;
                        while (true) {
                            System.out.print("Enter Expiry Date (yyyy-MM-dd): ");
                            try {
                                String expiryDateString = scanner.nextLine();
                                expiryDate = new SimpleDateFormat("yyyy-MM-dd").parse(expiryDateString);
                                if (expiryDate.before(new Date())) {
                                    throw new IllegalArgumentException("Expiry date must be in the future.");
                                }
                                break;
                            } catch (ParseException e) {
                                System.out.println("Error: Invalid date format. Please use yyyy-MM-dd.");
                            } catch (Exception e) {
                                System.out.println("Error: " + e.getMessage() + ". Please try again.");
                            }
                        }
                        product = new Grocery(productId, productName, productPrice, expiryDate);
                        break;
                }

                System.out.println("Product added successfully!");
                System.out.println(product.getDetails());

                // Prompt for Retry or Exit
                System.out.println("\nDo you want to:");
                System.out.println("1. Add another product");
                System.out.println("2. Exit");
                System.out.print("Choose an option: ");
                int retryChoice = Integer.parseInt(scanner.nextLine());
                if (retryChoice == 2) {
                    System.out.println("Exiting... Thank you for using the system!");
                    break;
                }
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Product and Derived Classes (as defined earlier)
    // Include Electronics, Clothing, Grocery, and abstract Product classes
}

package OnlineBetting;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RegularUser currentUser = null;
        AdminUser admin = new AdminUser("admin", "admin123");

        // Adding some games for testing
        Game game1 = new Game("GAME1", "Football", 1.5);
        admin.addGame(game1);
        Game game2 = new Game("GAME2", "Basketball", 2.0);
        admin.addGame(game2);

        // User Registration and Login
        System.out.println("Welcome to the Online Betting System");
        System.out.println("Do you want to register a new account? (yes/no)");

        String registerChoice = scanner.nextLine();
        if (registerChoice.equalsIgnoreCase("yes")) {
            String username = getUsername(scanner);
            String password = getPassword(scanner);

            try {
                currentUser = new RegularUser(username, password);
                System.out.println("User registered successfully!");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                return; // Stop execution if registration fails
            }
        }

        // User Login
        System.out.println("Enter username to login:");
        String loginUsername = getUsername(scanner);
        System.out.println("Enter password:");
        String loginPassword = getPassword(scanner);

        if (currentUser != null && currentUser.login(loginUsername, loginPassword)) {
            System.out.println("Login successful!");

            // User Menu
            boolean exit = false;
            while (!exit) {
                System.out.println("\nChoose an option:");
                System.out.println("1. Deposit Money");
                System.out.println("2. Place Bet");
                System.out.println("3. View Bet History");
                System.out.println("4. View Balance");
                System.out.println("5. Logout");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        // Deposit Money
                        double amount = getDepositAmount(scanner);
                        try {
                            currentUser.deposit(amount);
                            System.out.println("Deposit successful! New balance: " + currentUser.getBalance());
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 2:
                        // Place Bet
                        System.out.println("Available Games:");
                        System.out.println("1. Football");
                        System.out.println("2. Basketball");
                        System.out.print("Choose a game (1 or 2): ");
                        int gameChoice = Integer.parseInt(scanner.nextLine());
                        String gameId = (gameChoice == 1) ? "GAME1" : "GAME2";

                        double betAmount = getBetAmount(scanner);
                        String outcome = getBetOutcome(scanner);

                        Bet bet = new Bet(betAmount, gameId, outcome);
                        try {
                            currentUser.placeBet(bet);
                            System.out.println("Bet placed successfully!");
                        } catch (InsufficientBalanceException | InvalidBetException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 3:
                        // View Bet History
                        System.out.println("Bet History:");
                        for (Bet b : currentUser.viewBetHistory()) {
                            System.out.println(b.getBetDetails());
                        }
                        break;

                    case 4:
                        // View Balance
                        System.out.println("Current balance: " + currentUser.getBalance());
                        break;

                    case 5:
                        // Logout
                        System.out.println("Logged out successfully!");
                        exit = true;
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Invalid login credentials.");
        }

        scanner.close();
    }

    // Method to validate username input
    private static String getUsername(Scanner scanner) {
        String username;
        while (true) {
            System.out.print("Enter username: ");
            username = scanner.nextLine();
            if (!username.trim().isEmpty()) {
                break;
            }
            System.out.println("Username cannot be empty. Please try again.");
        }
        return username;
    }

    // Method to validate password input
    private static String getPassword(Scanner scanner) {
        String password;
        while (true) {
            System.out.print("Enter password (min 8 characters, must contain letters and numbers): ");
            password = scanner.nextLine();
            if (password.length() >= 8 && password.matches(".*[a-zA-Z]+.*") && password.matches(".*\\d+.*")) {
                break;
            }
            System.out.println("Invalid password. Ensure it's at least 8 characters long and contains both letters and numbers.");
        }
        return password;
    }

    // Method to validate deposit amount
    private static double getDepositAmount(Scanner scanner) {
        double amount;
        while (true) {
            System.out.print("Enter amount to deposit: ");
            try {
                amount = Double.parseDouble(scanner.nextLine());
                if (amount <= 0) {
                    System.out.println("Amount must be positive. Please try again.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid amount.");
            }
        }
        return amount;
    }

    // Method to validate bet amount
    private static double getBetAmount(Scanner scanner) {
        double betAmount;
        while (true) {
            System.out.print("Enter bet amount: ");
            try {
                betAmount = Double.parseDouble(scanner.nextLine());
                if (betAmount <= 0) {
                    System.out.println("Bet amount must be positive. Please try again.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid bet amount.");
            }
        }
        return betAmount;
    }

    // Method to validate bet outcome
    private static String getBetOutcome(Scanner scanner) {
        String outcome;
        while (true) {
            System.out.print("Enter bet outcome (win/loss): ");
            outcome = scanner.nextLine().toLowerCase();
            if (outcome.equals("win") || outcome.equals("loss")) {
                break;
            }
            System.out.println("Invalid outcome. Please enter 'win' or 'loss'.");
        }
        return outcome;
    }
}

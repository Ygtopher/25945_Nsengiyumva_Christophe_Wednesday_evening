package OnlineBetting;

abstract class User {
    private String username;
    private String password;
    private double balance;

    // Constructor
    public User(String username, String password) {
        this.username = username;
        setPassword(password);
        this.balance = 0;
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Login Method
    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    // Deposit Method
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        this.balance += amount;
    }

    // Setter for password with validation
    private void setPassword(String password) {
        if (password.length() < 8 || !password.matches(".*[A-Za-z].*") || !password.matches(".*[0-9].*")) {
            throw new IllegalArgumentException("Password must be at least 8 characters long and contain a mix of letters and numbers.");
        }
        this.password = password;
    }
}


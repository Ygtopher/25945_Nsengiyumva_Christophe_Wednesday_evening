package OnlineShopping;

import java.util.*;
import java.util.regex.*;
import java.text.*;

// Custom Exceptions
class RegistrationException extends Exception {
    public RegistrationException(String message) {
        super(message);
    }
}

class LoginException extends Exception {
    public LoginException(String message) {
        super(message);
    }
}

class CartException extends Exception {
    public CartException(String message) {
        super(message);
    }
}

class PaymentException extends Exception {
    public PaymentException(String message) {
        super(message);
    }
}

// Base Class: User
abstract class User {
    private int userId;
    private String name;
    private String email;
    private String password;

    public User(int userId, String name, String email, String password) throws RegistrationException {
        if (userId <= 0) throw new RegistrationException("User ID must be positive.");
        if (name.isEmpty()) throw new RegistrationException("Name cannot be empty.");
        if (!isValidEmail(email)) throw new RegistrationException("Invalid email format.");
        if (!isValidPassword(password)) throw new RegistrationException("Password must be at least 8 characters long and contain at least one number and one special character.");

        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public boolean login(String email, String password) throws LoginException {
        if (this.email.equals(email) && this.password.equals(password)) {
            return true;
        } else {
            throw new LoginException("Invalid email or password.");
        }
    }

    private boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

    private boolean isValidPassword(String password) {
        return password.length() >= 8 && password.matches(".*[A-Za-z]+.*") && password.matches(".*[0-9]+.*") && password.matches(".*[!@#$%^&*()_+=<>?]+.*");
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}


package StudentAttendanceManagement;

import java.util.*;
import java.util.regex.*;
import java.util.Scanner;

class InvalidAttendanceException extends Exception {
    public InvalidAttendanceException(String message) {
        super(message);
    }
}

class InvalidStudentIdException extends Exception {
    public InvalidStudentIdException(String message) {
        super(message);
    }
}
abstract class Person {
    private String name;
    private int id;
    private String email;

    // Constructor
    public Person(String name, int id, String email) {
        this.name = name;
        this.id = id;
        setEmail(email); // Use setter to validate email
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for email with validation
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (isValidEmail(email)) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Invalid email format.");
        }
    }

    private boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}


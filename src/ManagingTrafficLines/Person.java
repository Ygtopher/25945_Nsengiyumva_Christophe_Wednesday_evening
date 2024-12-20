package ManagingTrafficLines;

import java.util.*;

// Custom Exceptions
class InvalidLicenseNumberException extends Exception {
    public InvalidLicenseNumberException(String message) {
        super(message);
    }
}

class InvalidFineAmountException extends Exception {
    public InvalidFineAmountException(String message) {
        super(message);
    }
}

class InvalidViolationTypeException extends Exception {
    public InvalidViolationTypeException(String message) {
        super(message);
    }
}

// Abstract Base Class
abstract class Person {
    protected String name;
    protected String licenseNumber;

    public Person(String name, String licenseNumber) throws InvalidLicenseNumberException {
        this.name = name;
        setLicenseNumber(licenseNumber);
    }

    private void setLicenseNumber(String licenseNumber) throws InvalidLicenseNumberException {
        if (licenseNumber.matches("[a-zA-Z0-9]{8,12}")) {
            this.licenseNumber = licenseNumber;
        } else {
            throw new InvalidLicenseNumberException("License number must be alphanumeric and 8-12 characters long.");
        }
    }

    public abstract void displayDetails();
}


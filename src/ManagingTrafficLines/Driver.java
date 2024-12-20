package ManagingTrafficLines;

// Derived Class
class Driver extends Person {
    private double totalFines;
    private int violationCount;

    public Driver(String name, String licenseNumber) throws InvalidLicenseNumberException {
        super(name, licenseNumber);
        this.totalFines = 0.0;
        this.violationCount = 0;
    }

    public void addViolation(double fineAmount) throws InvalidFineAmountException {
        if (fineAmount > 0) {
            totalFines += fineAmount;
            violationCount++;
        } else {
            throw new InvalidFineAmountException("Fine amount must be greater than zero.");
        }
    }

    public void resetViolations() {
        totalFines = 0.0;
        violationCount = 0;
    }

    @Override
    public void displayDetails() {
        System.out.println("Driver Details:");
        System.out.println("Name: " + name);
        System.out.println("License Number: " + licenseNumber);
        System.out.println("Total Fines: " + totalFines);
        System.out.println("Violation Count: " + violationCount);
    }
}


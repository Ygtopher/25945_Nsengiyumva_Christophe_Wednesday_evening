package ManagingTrafficLines;

import java.util.*;

// Derived Class from TrafficViolation
class SpecificViolation implements TrafficViolation {
    private String violationType;
    private double fineAmount;
    private static final Set<String> VALID_VIOLATION_TYPES =
            new HashSet<>(Arrays.asList("Speeding", "Parking", "Signal Violation"));

    public SpecificViolation(String violationType, double fineAmount) throws InvalidViolationTypeException, InvalidFineAmountException {
        setViolationType(violationType);
        setFineAmount(fineAmount);
    }

    private void setViolationType(String violationType) throws InvalidViolationTypeException {
        if (VALID_VIOLATION_TYPES.contains(violationType)) {
            this.violationType = violationType;
        } else {
            throw new InvalidViolationTypeException("Invalid violation type. Valid types are: " + VALID_VIOLATION_TYPES);
        }
    }

    private void setFineAmount(double fineAmount) throws InvalidFineAmountException {
        if (fineAmount > 0) {
            this.fineAmount = fineAmount;
        } else {
            throw new InvalidFineAmountException("Fine amount must be greater than zero.");
        }
    }

    @Override
    public void validateViolation() throws InvalidViolationTypeException, InvalidFineAmountException {
        setViolationType(violationType);
        setFineAmount(fineAmount);
    }

    public String getViolationDetails() {
        return "Violation Type: " + violationType + ", Fine Amount: " + fineAmount;
    }

    public double getFineAmount() {
        return fineAmount;
    }
}

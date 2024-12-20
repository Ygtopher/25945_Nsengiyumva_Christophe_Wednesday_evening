package ManagingTrafficLines;

// Interface
interface TrafficViolation {
    void validateViolation() throws InvalidViolationTypeException, InvalidFineAmountException;
}


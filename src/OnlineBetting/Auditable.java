package OnlineBetting;

interface Auditable {
    void logAction(String action);
    String generateReport();
}

interface Notifiable {
    void sendNotification(String message);
}

class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class InvalidGameException extends RuntimeException {
    public InvalidGameException(String message) {
        super(message);
    }
}

class InvalidBetException extends RuntimeException {
    public InvalidBetException(String message) {
        super(message);
    }
}

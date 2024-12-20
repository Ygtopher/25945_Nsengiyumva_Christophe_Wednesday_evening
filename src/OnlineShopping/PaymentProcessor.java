package OnlineShopping;

// Class: PaymentProcessor (implements Payment)
class PaymentProcessor implements Payment {
    private static int paymentIdCounter = 0;
    private int paymentId;
    private double amount;

    public PaymentProcessor(double amount) {
        this.paymentId = ++paymentIdCounter;
        this.amount = amount;
    }

    @Override
    public boolean pay(double amount) throws PaymentException {
        if (amount <= 0) {
            throw new PaymentException("Payment amount must be positive.");
        }
        this.amount = amount;
        // Simulate payment processing success
        return true;
    }

    public int getPaymentId() {
        return paymentId;
    }
}


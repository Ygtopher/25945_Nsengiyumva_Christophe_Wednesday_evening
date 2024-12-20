package OnlineShopping;

// Interface: Payment
interface Payment {
    boolean pay(double amount) throws PaymentException;
}

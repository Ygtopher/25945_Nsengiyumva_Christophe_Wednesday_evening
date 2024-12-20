package OnlineShopping;

// Derived Classes: Electronics, Clothing, Grocery
class Electronics extends Product {
    private int warrantyPeriod; // In months

    public Electronics(int productId, String name, double price, int warrantyPeriod) {
        super(productId, name, price);
        if (warrantyPeriod < 0) {
            throw new IllegalArgumentException("Warranty period cannot be negative.");
        }
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public String getDetails() {
        return "Electronics [ID: " + getProductId() + ", Name: " + getName() + ", Price: $" + getPrice() + ", Warranty: " + warrantyPeriod + " months]";
    }
}



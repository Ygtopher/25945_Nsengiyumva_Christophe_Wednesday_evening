package OnlineShopping;
import java.text.SimpleDateFormat;
import java.util.Date;

 class Grocery extends Product {
    private Date expiryDate;

    public Grocery(int productId, String name, double price, Date expiryDate) {
        super(productId, name, price);
        if (expiryDate.before(new Date())) {
            throw new IllegalArgumentException("Expiry date must be in the future.");
        }
        this.expiryDate = expiryDate;
    }

    @Override
    public String getDetails() {
        return "Grocery [ID: " + getProductId() + ", Name: " + getName() + ", Price: $" + getPrice() + ", Expiry Date: " + expiryDate + "]";
    }
}



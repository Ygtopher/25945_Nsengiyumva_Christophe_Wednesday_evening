package OnlineShopping;

class Clothing extends Product {
    private String size;

    public Clothing(int productId, String name, double price, String size) {
        super(productId, name, price);
        if (!size.matches("S|M|L|XL")) {
            throw new IllegalArgumentException("Invalid size. Must be one of: S, M, L, XL.");
        }
        this.size = size;
    }

    @Override
    public String getDetails() {
        return "Clothing [ID: " + getProductId() + ", Name: " + getName() + ", Price: $" + getPrice() + ", Size: " + size + "]";
    }
}




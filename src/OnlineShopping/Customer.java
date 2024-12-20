package OnlineShopping;

import java.util.*;


// Derived Class: Customer (extends User)
class Customer extends User {
    private String address;
    private List<Product> cart;

    public Customer(int userId, String name, String email, String password, String address) throws RegistrationException {
        super(userId, name, email, password);
        if (address.isEmpty()) throw new RegistrationException("Address cannot be empty.");
        this.address = address;
        this.cart = new ArrayList<>();
    }

    public void addToCart(Product product) throws CartException {
        if (cart.contains(product)) {
            throw new CartException("Product already in the cart.");
        }
        cart.add(product);
    }

    public void removeFromCart(int productId) throws CartException {
        boolean found = false;
        for (Product product : cart) {
            if (product.getProductId() == productId) {
                cart.remove(product);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new CartException("Product not found in the cart.");
        }
    }

    public List<Product> getCart() {
        return cart;
    }
}


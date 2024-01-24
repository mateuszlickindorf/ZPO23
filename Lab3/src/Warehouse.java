import java.util.ArrayList;
import java.util.List;

/**
 * Represents a warehouse.
 */
public class Warehouse {
    private List<Product> products;

    /**
     * Constructs a new Warehouse with an empty list of products.
     */
    public Warehouse() {
        products = new ArrayList<>();
    }

    /**
     * Adds a product to the warehouse.
     *
     * @param product The product to be added.
     */
    public void addProduct(Product product) {
        if (product != null) {
            products.add(product);
        } else {
            throw new IllegalArgumentException("Product cannot be null.");
        }
    }

    /**
     * Retrieves the list of products in the warehouse.
     *
     * @return A list of products in the warehouse.
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Calculates the total value of all products in the warehouse.
     *
     * @return The total value of all products in the warehouse.
     */
    public double calculateTotalValue() {
        double totalValue = 0.0;
        for (Product product : products) {
            totalValue += product.fetchPrice() * product.fetchCount();
        }
        return totalValue;
    }
}

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a warehouse that stores products in a map.
 */
public class WarehouseMap {
    private Map<String, Product> productMap;

    /**
     * Constructs a new Warehouse with an empty map of products.
     */
    public WarehouseMap() {
        productMap = new HashMap<>();
    }

    /**
     * Adds a product to the warehouse.
     *
     * @param product The product to be added.
     * @throws IllegalArgumentException If the provided product is null.
     */
    public void addProduct(Product product) {
        if (product != null) {
            String productName = product.fetchName();
            productMap.put(productName, product);
        } else {
            throw new IllegalArgumentException("Product cannot be null.");
        }
    }

    /**
     * Retrieves a product from the warehouse by its name.
     *
     * @param productName The name of the product to retrieve.
     * @return The product with the specified name, or null if not found.
     */
    public Product getProduct(String productName) {
        return productMap.get(productName);
    }

    /**
     * Removes a product from the warehouse by its name.
     *
     * @param productName The name of the product to remove.
     */
    public void removeProduct(String productName) {
        productMap.remove(productName);
    }

    /**
     * Updates a product in the warehouse.
     *
     * @param product The updated product.
     * @throws IllegalArgumentException If the provided product is null or not found in the warehouse.
     */
    public void updateProduct(Product product) {
        if (product != null) {
            String productName = product.fetchName();
            if (productMap.containsKey(productName)) {
                productMap.put(productName, product);
            } else {
                throw new IllegalArgumentException("Product not found in the warehouse.");
            }
        } else {
            throw new IllegalArgumentException("Product cannot be null.");
        }
    }

    /**
     * Prints information about a specific product in the warehouse.
     *
     * @param productName The name of the product to print information about.
     */

    /**
     * Calculates the total value of all products in the warehouse.
     *
     * @return The total value of all products in the warehouse.
     */
    public double calculateTotalValue() {
        double totalValue = 0.0;
        for (Product product : productMap.values()) {
            totalValue += product.fetchPrice() * product.fetchCount();
        }
        return totalValue;
    }
}
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a warehouse.
 */
public class WarehouseMap {
    private List<ProductMap> products;

    /**
     * Constructs a new Warehouse with an empty list of products.
     */
    public WarehouseMap() {
        products = new ArrayList<>();
    }

    /**
     * Adds a product to the warehouse.
     *
     * @param product The product to be added.
     */
    public void addProduct(ProductMap product) {
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
    public List<ProductMap> getProducts() {
        return products;
    }

    /**
     * Calculates the total value of all products in the warehouse.
     *
     * @return The total value of all products in the warehouse.
     */
    public double calculateTotalValue() {
        double totalValue = 0.0;
        for (ProductMap product : products) {
            totalValue += product.fetchPrice() * product.fetchCount();
        }
        return totalValue;
    }
}

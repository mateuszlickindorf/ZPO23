/**
 * The Product interface represents a product in a warehouse.
 */
public interface ProductMap {
    /**
     * Gets the name of the product.
     *
     * @return The name of the product.
     */
    String fetchName();

    /**
     * Gets the price of the product.
     *
     * @return The price of the product.
     */
    double fetchPrice();

    /**
     * Gets the count of the product.
     *
     * @return The count of the product.
     */
    int fetchCount();

    /**
     * Gets information about of the product.
     *
     * @return Information about the product.
     */
    int getProductInfo();

}

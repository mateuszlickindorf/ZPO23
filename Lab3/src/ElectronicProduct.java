/**
 * Represents an electronic product in the warehouse.
 */
public class ElectronicProduct implements Product {
    private String name;
    private double price;
    private int count;
    private String manufacturer;

    /**
     * Creates an ElectronicProduct with the given name, price, count, and manufacturer.
     *
     * @param name         The name of the electronic product.
     * @param price        The price of the electronic product.
     * @param count        The count of the electronic product.
     * @param manufacturer The manufacturer of the electronic product.
     */

    public ElectronicProduct(String name, double price, int count, String manufacturer) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.manufacturer = manufacturer;
    }

    @Override
    public String fetchName() {
        return name;
    }

    @Override
    public double fetchPrice() {
        return price;
    }

    @Override
    public int fetchCount() {
        return count;
    }

    /**
     * Gets the manufacturer of the electronic product.
     *
     * @return The manufacturer of the electronic product.
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Sets the manufacturer of the electronic product.
     *
     * @param manufacturer The new manufacturer to set.
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * Increases the count of the electronic product by the specified quantity.
     *
     * @param quantity The quantity by which to increase the count.
     * @throws IllegalArgumentException If the quantity is not positive.
     */
    public void increaseCount(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }
        count += quantity;
    }

    /**
     * Decreases the count of the electronic product by the specified quantity.
     *
     * @param quantity The quantity by which to decrease the count.
     * @throws IllegalArgumentException If the quantity is not positive or exceeds the current count.
     */
    public void decreaseCount(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }
        if (quantity > count) {
            throw new IllegalArgumentException("Quantity exceeds the current count.");
        }
        count -= quantity;
    }

    /**
     * Gets a string containing information about the electronic product.
     *
     * @return A string with information about the product, including its name, manufacturer, price, and count.
     */
    public String getProductInfo() {
        return "Product Name: " + name + ", Manufacturer: " + manufacturer + ", Price: $" + price + ", Count: " + count;
    }
}


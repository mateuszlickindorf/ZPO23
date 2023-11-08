/**
 * Represents a food product in the warehouse.
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a food product in the warehouse.
 */
public class FoodProduct implements Product {
    private String name;
    private double price;
    private int count;
    private LocalDate expirationDate;

    /**
     * Creates a FoodProduct with the given name, price, count, and expiration date.
     *
     * @param name           The name of the food product.
     * @param price          The price of the food product.
     * @param count          The count of the food product.
     * @param expirationDate The expiration date of the food product (in a "yyyy-MM-dd" format).
     */
    public FoodProduct(String name, double price, int count, String expirationDate) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.expirationDate = LocalDate.parse(expirationDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
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
     * Checks if the food product is expired based on the current date.
     *
     * @return true if the food product is expired, false otherwise.
     */
    public boolean isExpired() {
        LocalDate currentDate = LocalDate.now();
        return currentDate.isAfter(expirationDate);
    }

    /**
     * Gets the expiration date of the food product.
     *
     * @return The expiration date in "yyyy-MM-dd" format.
     */
    public String getExpirationDate() {
        return expirationDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    /**
     * Sets the expiration date of the food product.
     *
     * @param expirationDate The new expiration date to set (in "yyyy-MM-dd" format).
     * @throws IllegalArgumentException If the provided date format is invalid.
     */
    public void setExpirationDate(String expirationDate) {
        try {
            this.expirationDate = LocalDate.parse(expirationDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid date format. Please use 'yyyy-MM-dd' format.");
        }
    }

    /**
     * Increases the count of the food product by the specified quantity.
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
     * Decreases the count of the food product by the specified quantity.
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
     * Gets a string containing information about the food product.
     *
     * @return A string with information about the product, including its name, expiration date, price, and count.
     */
    public String getProductInfo() {
        return "Product Name: " + name + ", Expiration Date: " + getExpirationDate() + ", Price: $" + price + ", Count: " + count;
    }
}



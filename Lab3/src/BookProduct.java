/**
 * Represents a book product in the warehouse.
 */
public class BookProduct implements Product {
    private String name;
    private double price;
    private int count;
    private String author;

    /**
     * Creates a BookProduct with the given name, price, count, and author.
     *
     * @param name   The name of the book product.
     * @param price  The price of the book product.
     * @param count  The count of the book product.
     * @param author The author of the book.
     */
    public BookProduct(String name, double price, int count, String author) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.author = author;
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
     * Gets the author of the book.
     *
     * @return The author of the book.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the author of the book.
     *
     * @param author The new author to set.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Increases the count of the book product by the specified quantity.
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
     * Decreases the count of the book product by the specified quantity.
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
     * Gets a string containing information about the book product.
     *
     * @return A string with information about the product, including its name, author, price, and count.
     */
    public String getProductInfo() {
        return "Product Name: " + name + ", Author: " + author + ", Price: $" + price + ", Count: " + count;
    }
}


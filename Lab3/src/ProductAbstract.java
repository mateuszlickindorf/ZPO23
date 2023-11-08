public abstract class ProductAbstract {
    private String name;
    private double price;
    private int count;

    public ProductAbstract(String name, double price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public String fetchName() {
        return name;
    }

    public double fetchPrice() {
        return price;
    }

    public int fetchCount() {
        return count;
    }

    // Mark these methods as abstract to be implemented in subclasses
    public abstract String getProductType();
    public abstract String getProductInfo();
}

public class FoodProductAbstract extends ProductAbstract {
    private String expirationDate;

    public FoodProductAbstract(String name, double price, int count, String expirationDate) {
        super(name, price, count);
        this.expirationDate = expirationDate;
    }

    @Override
    public String getProductType() {
        return "Food";
    }

    @Override
    public String getProductInfo() {
        return "Product Name: " + fetchName() + ", Expiration Date: " + expirationDate + ", Price: $" + fetchPrice() + ", Count: " + fetchCount();
    }
}
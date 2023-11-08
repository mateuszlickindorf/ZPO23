public class ElectronicProductAbstract extends ProductAbstract {
    private String manufacturer;

    public ElectronicProductAbstract(String name, double price, int count, String manufacturer) {
        super(name, price, count);
        this.manufacturer = manufacturer;
    }

    @Override
    public String getProductType() {
        return "Electronic";
    }

    @Override
    public String getProductInfo() {
        return "Product Name: " + fetchName() + ", Manufacturer: " + manufacturer + ", Price: $" + fetchPrice() + ", Count: " + fetchCount();
    }
}
public class BookProductAbstract extends ProductAbstract {
    private String author;

    public BookProductAbstract(String name, double price, int count, String author) {
        super(name, price, count);
        this.author = author;
    }

    @Override
    public String getProductType() {
        return "Book";
    }

    @Override
    public String getProductInfo() {
        return "Product Name: " + fetchName() + ", Author: " + author + ", Price: $" + fetchPrice() + ", Count: " + fetchCount();
    }
}

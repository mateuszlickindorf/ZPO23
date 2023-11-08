public class WarehouseDemo {
    public static void main(String[] args) {
        // Create some product instances
        Product electronicProduct = new ElectronicProduct("Laptop", 1000.0, 5, "Dell");
        Product foodProduct = new FoodProduct("Chocolate", 3.0, 10, "2023-12-31");
        Product bookProduct = new BookProduct("Java Programming", 25.0, 15, "John Doe");

        // Create a warehouse and add products
        Warehouse warehouse = new Warehouse();
        warehouse.addProduct(electronicProduct);
        warehouse.addProduct(foodProduct);
        warehouse.addProduct(bookProduct);

        // Print information about the products in the warehouse
        System.out.println("Products in the warehouse:");
        for (Product product : warehouse.getProducts()) {
            System.out.println(product.fetchName() + " - " + product.fetchCount() + " available");
            if (product instanceof FoodProduct) {
                FoodProduct food = (FoodProduct) product;
                System.out.println("Expiration Date: " + food.getExpirationDate() + " (Expired: " + food.isExpired() + ")");
            } else if (product instanceof BookProduct) {
                BookProduct book = (BookProduct) product;
                System.out.println("Author: " + book.getAuthor());
            }
        }

        // Calculate and print the total value of the warehouse
        double totalValue = warehouse.calculateTotalValue();
        System.out.println("Total Value of the Warehouse: $" + totalValue);
    }
}
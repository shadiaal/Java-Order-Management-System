abstract class Product {
    protected int productID;
    protected String name;
    protected String category;
    protected double price;
    protected int stockQuantity;

    public Product(int productID, String name, String category, double price, int stockQuantity) {
        this.productID = productID;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public abstract double calculateDiscount();

    public int getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void reduceStock(int quantity) throws OutOfStockException {
        if (quantity > stockQuantity) {
            throw new OutOfStockException("Not enough stock available for " + name);
        }
        stockQuantity -= quantity;
    }
}

class Clothing extends Product {
    private String size; // Additional attribute

    public Clothing(int productID, String name, double price, int stockQuantity, String size) {
        super(productID, name, "Clothing", price, stockQuantity);
        this.size = size;
    }

    @Override
    public double calculateDiscount() {
        return price * 0.05; // 5% discount for clothing
    }

    public String getSize() {
        return size;
    }
}

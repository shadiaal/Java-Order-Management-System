import java.util.*;

public class Main {
    private static ArrayList<Order> orders = new ArrayList<>();
    private static HashMap<Integer, Order> userOrderHistory = new HashMap<>();
    private static ArrayList<Product> products = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int orderIDCounter = 1;
    private static int orderDetailIDCounter = 1;

    public static void main(String[] args) {
        initializeProducts();
        while (true) {
            System.out.println("\n1. Place an Order");
            System.out.println("2. View Order History");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    placeOrder();
                    break;
                case 2:
                    viewOrderHistory();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void initializeProducts() {
        products.add(new Electronics(101, "iPhone 13", 799.99, 10, 2));
        products.add(new Clothing(201, "Nike Hoodie", 49.99, 20, "L"));
        products.add(new Electronics(102, "Samsung TV", 1200.00, 5, 3));
        products.add(new Clothing(202, "Adidas T-Shirt", 19.99, 30, "M"));
    }

    private static void placeOrder() {
        System.out.print("Enter User ID: ");
        int userID = scanner.nextInt();
        Order newOrder = new Order(orderIDCounter++, userID);
        System.out.println("Available Products:");
        for (Product p : products) {
            System.out.println(p.getProductID() + ". " + p.getName() + " - $" + p.getPrice() + " (Stock: " + p.getStockQuantity() + ")");
        }
        System.out.print("Enter Product ID to Order: ");
        int productID = scanner.nextInt();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        for (Product p : products) {
            if (p.getProductID() == productID) {
                try {
                    p.reduceStock(quantity);
                    OrderDetails orderDetail = new OrderDetails(orderDetailIDCounter++, newOrder.getOrderID(), p, quantity);
                    newOrder.addOrderDetail(orderDetail);
                    orders.add(newOrder);
                    userOrderHistory.put(userID, newOrder);
                    System.out.println("Order placed successfully!");
                } catch (OutOfStockException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
        System.out.println("Invalid Product ID.");
    }

    private static void viewOrderHistory() {
        System.out.print("Enter User ID: ");
        int userID = scanner.nextInt();
        if (userOrderHistory.containsKey(userID)) {
            Order order = userOrderHistory.get(userID);
            System.out.println("Order ID: " + order.getOrderID() + ", Total: $" + order.getTotalAmount());
        } else {
            System.out.println("No orders found.");
        }
    }
}

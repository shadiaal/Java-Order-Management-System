import java.util.ArrayList;

class Order {
    private int orderID;
    private int userID;
    private ArrayList<OrderDetails> orderDetailsList;

    public Order(int orderID, int userID) {
        this.orderID = orderID;
        this.userID = userID;
        this.orderDetailsList = new ArrayList<>();
    }

    public void addOrderDetail(OrderDetails orderDetail) {
        orderDetailsList.add(orderDetail);
    }

    public int getOrderID() {
        return orderID;
    }

    public int getUserID() {
        return userID;
    }

    public ArrayList<OrderDetails> getOrderDetailsList() {
        return orderDetailsList;
    }

    public double getTotalAmount() {
        double total = 0;
        for (OrderDetails od : orderDetailsList) {
            total += od.getSubTotal();
        }
        return total;
    }
}

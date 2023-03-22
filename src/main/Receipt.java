package main;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Receipt {
    private Order order;

    public Receipt(Order order) {
        this.order = order;
    }
    public Order getOrder() {
        return order;
    }
    public List<Product> getOrderInfo() {
        return order.getClientOrder();
    }

    public void getReceipt(Order order) {
        LocalDateTime orderStart = order.getOrderTime();
        System.out.println("Order received on: " + orderStart);
        System.out.println("Order on preparing stage since " + orderStart.plus(2, ChronoUnit.MINUTES));
        System.out.println("Order was packed at " + orderStart.plus(12, ChronoUnit.MINUTES));
        System.out.println("Order is ready " + orderStart.plus(13, ChronoUnit.MINUTES));
    }

}

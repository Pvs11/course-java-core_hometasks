package main;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> clientOrder = new ArrayList<>();
    private Client client;
    private static int counter = 0;
    private int orderNumber;
    private LocalDateTime orderTime;

    public Order(Client client) {
        this.client = client;
        this.orderNumber = ++counter;
        this.orderTime = LocalDateTime.now();
    }

    public Client getClient() {
        return client;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }
    public List<Product> getClientOrder() {
        return clientOrder;
    }

    public void addToOrder(Product product) {
        clientOrder.add(product);
    }

    @Override
    public String toString() {
        return "Order{" +
                "clientOrder=" + clientOrder +
                '}';
    }
}

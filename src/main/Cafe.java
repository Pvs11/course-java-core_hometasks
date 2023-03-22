package main;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Cafe implements Pizzeria {
    private Menu menu;

    public Cafe(Menu menu) {
        this.menu = menu;
    }

    @Override
    public Menu getMenu() {
        return menu;
    }

    @Override
    public Receipt createReceipt(Order order) {
        Receipt clientReceipt = new Receipt(order);
        return clientReceipt;
    }

    @Override
    public void showReceiptInfo(Receipt receipt) {
        System.out.println("Order number " + receipt.getOrder().getOrderNumber());
        System.out.println("Receipt issuance time: " + receipt.getOrder().getOrderTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm")));
        System.out.println("Client: " + receipt.getOrder().getClient().getName());
        System.out.println("Order content: " + receipt.getOrderInfo());
        System.out.println("Order ready: " + receipt.getOrder().getOrderTime().plus(13, ChronoUnit.MINUTES).format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm")));
    }

    @Override
    public Order giveOrder(Receipt receipt) {
        return receipt.getOrder();
    }
}

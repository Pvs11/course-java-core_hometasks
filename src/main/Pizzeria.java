package main;

public interface Pizzeria {
    Menu getMenu();
    Receipt createReceipt(Order order);
    void showReceiptInfo(Receipt receipt);
    Order giveOrder(Receipt receipt);

}

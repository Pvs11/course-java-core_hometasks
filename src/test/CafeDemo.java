package test;

import main.*;


import java.util.List;

public class CafeDemo {

    public static void main(String[] args) {
        List<Pizza> pizzaList = List.of(new Pizza("Mozzarella", 15), new Pizza("Peperoni", 20));
        List<Drink> drinksList = List.of(new Drink("Sprite", 3), new Drink("Coffee", 5));
        Menu cafeMenu = new Menu(pizzaList, drinksList);

        Client client1 = new Client("Pavel");
        Client client2 = new Client("Alex");

        Cafe myCafe = new Cafe(cafeMenu);

        Order order1 = new Order(client1);
        Order order2 = new Order(client2);
        order1.addToOrder(new Pizza("Mozzarella", 15));
        order2.addToOrder(new Drink("Sprite", 3));
        order2.addToOrder(new Drink("Coffee", 5));
        Receipt receipt1 = myCafe.createReceipt(order1);

        System.out.println(myCafe.getMenu());
        myCafe.showReceiptInfo(receipt1);
        myCafe.showReceiptInfo(new Receipt(order2));
    }
}

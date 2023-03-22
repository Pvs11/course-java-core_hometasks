package main;

public class Pizza extends Product {
    private String pizzaName;
    private double price;

    public Pizza(String pizzaName, double price) {
        this.pizzaName = pizzaName;
        this.price = price;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "pizzaName='" + pizzaName + '\'' +
                ", price=" + price +
                '}';
    }
}

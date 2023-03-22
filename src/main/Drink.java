package main;

public class Drink extends Product {
    private String drinkName;
    private double price;

    public Drink(String drinkName, double price) {
        this.drinkName = drinkName;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "drinkName='" + drinkName + '\'' +
                ", price=" + price +
                '}';
    }
}

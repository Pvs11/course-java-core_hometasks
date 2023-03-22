package main;

import java.util.List;

public class Menu {
    private Pizza pizza;
    private Drink drinks;
    private List<Pizza> pizzaList;
    private List<Drink> drinksList;

    public Menu(List<Pizza> pizzaList, List<Drink> drinksList) {
        this.pizzaList = pizzaList;
        this.drinksList = drinksList;
    }

    public List<Pizza> getPizzaList() {
        return pizzaList;
    }

    public List<Drink> getDrinksList() {
        return drinksList;
    }

    public Pizza getPizza(Pizza pizza) {
        return pizza;
    }
    public Drink getDrink(Drink drink) {
        return drink;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "pizzaList=" + pizzaList +
                ", drinksList=" + drinksList +
                '}';
    }
}

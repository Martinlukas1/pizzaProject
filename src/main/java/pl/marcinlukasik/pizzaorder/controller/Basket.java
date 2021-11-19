package pl.marcinlukasik.pizzaorder.controller;

import pl.marcinlukasik.pizzaorder.model.Pizza;

import java.util.HashMap;
import java.util.Map;

public class Basket {
    private Map<Pizza, Integer> productMap;
    private double totalPrize;
    private Pizza pizza;

    public void setProductMap(Map<Pizza, Integer> productMap) {
        this.productMap = productMap;
    }

    public Basket() {
        productMap = new HashMap<>();
    }

    public Map<Pizza, Integer> getProductMap() {
        return productMap;
    }

    public double getTotalPrize() {
        return totalPrize;
    }

    public void setTotalPrize(double totalPrize) {
        this.totalPrize = totalPrize;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "productList=" + productMap +
                ", totalPrize=" + totalPrize +
                '}';
    }
}

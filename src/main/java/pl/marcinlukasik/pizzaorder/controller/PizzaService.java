package pl.marcinlukasik.pizzaorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PizzaService {
    private final List<Pizza> menu = new ArrayList<>();
    private final Basket basket;


    public PizzaService(Basket basket) {
        this.basket = basket;
    }

    public List<Pizza> getMenu() {
        return menu;
    }

    @PostConstruct
    public void init() {
        menu.add(new Pizza("Margherita", "z sosem pomidorowym, oliwą extra virgin, serem grana padano d.o.p, mozzarellą fior di latte i bazylią", 1, "pizza1", 29.00));
        menu.add(new Pizza("Prosciutto", "z sosem pomidorowym, oliwą extra virgin, serem grana padano d.o.p, mozzarellą fior di latte i bazylią", 2, "pizza2", 31.00));
        menu.add(new Pizza("Diavola", "z sosem pomidorowym, oliwą extra virgin, serem grana padano d.o.p, mozzarellą fior di latte i bazylią", 3, "pizza3", 33.00));
    }

    public void addPizzaToBasket(int pizzaId) {
        System.out.println("Add pizza to basket");
        Pizza pizza = findPizzaById(pizzaId);
        pizza.setAmount(pizza.getAmount() + 1);
        basket.getProductMap().put(pizza, pizza.getAmount());
        basket.setTotalPrize(pizza.getPrize() + basket.getTotalPrize());
    }

    public void removePizzaFromBasket(int pizzaId) {
        System.out.println("Remove pizza from basket");
        Pizza currentPizza=findPizzaById(pizzaId);
        if (currentPizza.getAmount() > 0) {
            currentPizza.setAmount(currentPizza.getAmount()-1);
            getBasketMap().put(currentPizza,currentPizza.getAmount());
            basket.setTotalPrize(basket.getTotalPrize() - currentPizza.getPrize());
            if (currentPizza.getAmount()==0){
                getBasketMap().remove(currentPizza);
            }
        }
    }

    public Pizza findPizzaById(int pizzaId) {
        return menu.stream()
                .filter(p -> p.getPizzaId() == pizzaId)
                .findFirst()
                .orElseGet(() -> new Pizza("not found"));
    }

    public Map<Pizza, Integer> getBasketMap() {
        return basket.getProductMap();
    }

    public double totalPrize() {
        return basket.getTotalPrize();
    }

}

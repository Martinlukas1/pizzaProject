package pl.marcinlukasik.pizzaorder.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.marcinlukasik.pizzaorder.model.Basket;
import pl.marcinlukasik.pizzaorder.model.Pizza;
import pl.marcinlukasik.pizzaorder.model.JPA.PizzaRepository;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class PizzaService {
    private final Basket basket;
    private final PizzaRepository pizzaRepository;

    public List<Pizza> getMenu() {
        return pizzaRepository.findAll();
    }

    public void addPizzaToBasket(Long pizzaId) {
        System.out.println("Add pizza to basket");
        Pizza pizza = findPizzaById(pizzaId);
        if(getBasketMap().containsKey(pizza)) {
            getBasketMap().replace(pizza,getBasketMap().get(pizza) +1);
        } else {
            getBasketMap().put(pizza, 1);
        }
        basket.setTotalPrice(pizza.getPrice() + basket.getTotalPrice());
        log.info("zawartość koszyka {}",getBasketMap());

    }

    public void removePizzaFromBasket(Long pizzaId) {
        System.out.println("Remove pizza from basket");
        Pizza currentPizza = findPizzaById(pizzaId);
        if (getBasketMap().get(currentPizza)> 0) {
            getBasketMap().replace(currentPizza,getBasketMap().get(currentPizza)-1);
            basket.setTotalPrice(basket.getTotalPrice() - currentPizza.getPrice());
            if (getBasketMap().get(currentPizza) == 0) {
                getBasketMap().remove(currentPizza);
            }
        }
        log.info("{}",getBasketMap());
    }

    public Pizza findPizzaById(Long pizzaId) {
        return pizzaRepository.getById(pizzaId);
    }

    public Map<Pizza, Integer> getBasketMap() {
        return basket.getProductMap();
    }

    public double totalPrize() {
        return basket.getTotalPrice();
    }

    public String emailContent () {
        String mapAsString = getBasketMap().keySet().stream()
                .map(key -> key.getName() + key.getPrice() + "zł " + getBasketMap().get(key) + " szt " + "\n")
                .collect(Collectors.joining());
        return mapAsString + "Kosz całkowity: " + basket.getTotalPrice() + "zł";
    }
}

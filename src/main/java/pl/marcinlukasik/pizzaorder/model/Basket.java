package pl.marcinlukasik.pizzaorder.model;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashMap;
import java.util.Map;

@Data
@Component
@SessionScope
public class Basket {
    private Map <Pizza, Integer> productMap;
    private double totalPrice;
    private Pizza pizza;

    public Basket() {
        productMap = new HashMap<>();
    }

}

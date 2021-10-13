package pl.marcinlukasik.pizzaorder.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class MainConfig {

    @SessionScope
    @Bean
    public Basket getBasket() {
        return new Basket();
    }
}

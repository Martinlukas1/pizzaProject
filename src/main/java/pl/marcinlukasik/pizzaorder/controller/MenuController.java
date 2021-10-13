package pl.marcinlukasik.pizzaorder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MenuController {

    PizzaService pizzaService;

    public MenuController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping("/menu")
    public String getMenu(Model model) {
        model.addAttribute("pizzalist", pizzaService.getMenu());
        return "menu";
    }

    @PostMapping("/addtobasket/{id}")
    public String addToBasket(@PathVariable int id) {
        System.out.println("addToBasket");
        pizzaService.addPizzaToBasket(id);
        return "redirect:/menu";
    }

}

package pl.marcinlukasik.pizzaorder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BasketController {
    PizzaService pizzaService;

    public BasketController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping("/basket")
    public String getBasket(Model model) {
        model.addAttribute("basketmap", pizzaService.getBasketMap());
        model.addAttribute("total", pizzaService.totalPrize());
        return "basket";
    }

    @PostMapping("/removefrombasket/{id}")
    public String removeFromBasket(@PathVariable int id) {
        System.out.println("removeFromBasket");
        pizzaService.removePizzaFromBasket(id);
        return "redirect:/basket";
    }
}

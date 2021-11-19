package pl.marcinlukasik.pizzaorder.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class BasketController {
    private final PizzaService pizzaService;


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

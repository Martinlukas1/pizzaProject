package pl.marcinlukasik.pizzaorder.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.marcinlukasik.pizzaorder.model.DTO.UserDTO;
import pl.marcinlukasik.pizzaorder.service.MailService;
import pl.marcinlukasik.pizzaorder.service.PizzaService;

@Slf4j
@RequiredArgsConstructor
@Controller
public class BasketController {
    private final PizzaService pizzaService;
    private final MailService mailService;


    @GetMapping("/basket")
    public String getBasket(Model model) {
        model.addAttribute("basketmap", pizzaService.getBasketMap());
        model.addAttribute("total", pizzaService.totalPrize());
        model.addAttribute("userForm", new UserDTO());
        return "basket";
    }

    @PostMapping("/removefrombasket/{id}")
    public String removeFromBasket(@PathVariable Long id) {
        System.out.println("removeFromBasket");
        pizzaService.removePizzaFromBasket(id);
        return "redirect:/basket";
    }


    @PostMapping("/order")
    public String makeOrder(@ModelAttribute UserDTO userDTO, @RequestParam(name = "email", required = false) String email) {
        log.info("{}", userDTO);
        mailService.sendEmail(email, "Your order : \n" + pizzaService.emailContent() );
        return "success";
    }
}

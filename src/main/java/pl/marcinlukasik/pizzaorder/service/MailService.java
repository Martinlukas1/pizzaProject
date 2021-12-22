package pl.marcinlukasik.pizzaorder.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class MailService {
    private final EmailService emailService;

    public void sendEmail (String email, String content ){
        emailService.sendSimpleMessage(email,"Pizzeria",content);
    }

}

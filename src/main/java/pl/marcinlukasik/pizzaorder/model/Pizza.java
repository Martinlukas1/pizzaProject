package pl.marcinlukasik.pizzaorder.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pizza {


    private String name;
    private String desc;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pizzaId;
    private String img;
    private double price;

    public Pizza(Long pizzaId, String name, String desc, String img, double price) {
        this.pizzaId=pizzaId;
        this.name = name;
        this.desc = desc;
        this.img = img;
        this.price = price;
    }

}

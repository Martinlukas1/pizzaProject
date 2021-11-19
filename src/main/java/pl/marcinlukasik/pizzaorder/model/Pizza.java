package pl.marcinlukasik.pizzaorder.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Pizza {


    private String name;
    private String desc;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pizzaId;
    private String img;
    private double prize;
    private int amount;


}

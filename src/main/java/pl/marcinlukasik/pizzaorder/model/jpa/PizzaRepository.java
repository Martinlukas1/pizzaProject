package pl.marcinlukasik.pizzaorder.model.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.marcinlukasik.pizzaorder.model.Pizza;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza,Long> {

}

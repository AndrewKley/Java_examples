package pizza.repositories;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;
import pizza.models.Pizza;

import java.util.List;

public interface PizzaRepository extends CrudRepository<Pizza, Long> {
//    List<Pizza> findAll(PageRequest page);
}

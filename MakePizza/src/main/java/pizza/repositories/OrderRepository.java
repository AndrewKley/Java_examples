package pizza.repositories;

import org.springframework.data.repository.CrudRepository;
import pizza.models.PizzaOrder;

public interface OrderRepository extends CrudRepository<PizzaOrder, Long> {
    PizzaOrder save(PizzaOrder order);
}

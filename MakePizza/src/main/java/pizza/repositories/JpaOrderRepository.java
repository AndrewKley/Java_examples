package pizza.repositories;

import org.springframework.data.repository.CrudRepository;
import pizza.models.PizzaOrder;

public interface JpaOrderRepository extends CrudRepository<PizzaOrder, Long> {
}

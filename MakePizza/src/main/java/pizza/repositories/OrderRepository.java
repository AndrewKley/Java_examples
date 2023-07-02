package pizza.repositories;

import pizza.models.PizzaOrder;

public interface OrderRepository {
    PizzaOrder save(PizzaOrder order);
}

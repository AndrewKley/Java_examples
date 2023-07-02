package pizza.repositories;

import org.springframework.asm.Type;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pizza.models.Pizza;
import pizza.models.PizzaOrder;

import java.sql.Types;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Repository
public class JdbcOrderRepository implements OrderRepository {
    private JdbcOperations operations;

    public JdbcOrderRepository(JdbcOperations operations) {
        this.operations = operations;
    }

    @Override
    @Transactional
    public PizzaOrder save(PizzaOrder order) {
        PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(
                "insert into pizza_order "
                + "values (?, ?, ?, ?, ?, ?, ?, ?, ?",
                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
                Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP
        );
        pscf.setReturnGeneratedKeys(true);
        order.setPlacedAt(new Date());

        PreparedStatementCreator psc = pscf.newPreparedStatementCreator(
                Arrays.asList(
                        order.getDeliveryName(),
                        order.getDeliveryStreet(),
                        order.getDeliveryCity(),
                        order.getDeliveryState(),
                        order.getDeliveryZip(),
                        order.getCcNumber(),
                        order.getCcExpiration(),
                        order.getCcCW(),
                        order.getPlacedAt()));

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        operations.update(psc, keyHolder);
        long orderId = keyHolder.getKey().longValue();
        order.setId(orderId);

        List<Pizza> pizzas = order.getPizzas();
        int i = 0;
        for (Pizza pizza : pizzas) {
            savePizza(orderId, i++, pizza);
        }

        return order;
    }

    private long savePizza(long orderId, int orderKey, Pizza pizza) {
        PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(
                "insert into pizza"
                + "values (?, ?, ?, ?)",
                Types.VARCHAR, Types.TIMESTAMP, Type.LONG, Type.LONG
        );
        pscf.setReturnGeneratedKeys(true);

        PreparedStatementCreator psc = pscf.newPreparedStatementCreator(
                Arrays.asList(
                        pizza.getName(),
                        pizza.getCreatedAt(),
                        orderId,
                        orderKey));

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        operations.update(psc, keyHolder);
        long pizzaId = keyHolder.getKey().longValue();
        pizza.setId(pizzaId);

//        saveIngredientsRefs(pizzaId, pizza.getIngredients());

        return pizzaId;
    }

    private void saveIngredientsRefs(long pizzaId, List<IngredientRef> ingredientRefs) {
        int key = 0;
        for (IngredientRef ref : ingredientRefs) {
            operations.update(
                    "insert into ingredient_ref"
                    + "values (?, ?, ?,)",
                    ref.getIngredient(), pizzaId, key++);
        }
    }
}

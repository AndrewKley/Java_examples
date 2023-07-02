package pizza.repositories;

import org.springframework.data.repository.CrudRepository;
import pizza.models.Ingredient;

public interface JpaIngredientRepository extends CrudRepository<Ingredient, String> {
}

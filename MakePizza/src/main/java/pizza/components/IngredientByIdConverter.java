package pizza.components;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pizza.models.Ingredient;
import pizza.repositories.IngredientRepository;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
    private final IngredientRepository repository;

    public IngredientByIdConverter(IngredientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Ingredient convert(String id) {
        return repository.findById(id).orElse(null);
    }
}

package pizza.repositories;

import org.springframework.data.repository.CrudRepository;
import pizza.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}

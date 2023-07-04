package pizza.controllers;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pizza.models.Pizza;
import pizza.repositories.PizzaRepository;

@RestController
@RequestMapping(path = "api/pizzas",
                produces = "application/json")  // указывает что методы-обработчики
                // будут обрабатывать запросы с заголовком "Accept" со значением "application/json"
                // сообщает, что клиент может получить только json и ограничивает контроллер только для возварта json
                // produces={"application/json", "text/xml"} для нескольких возвращаемых форматов
@CrossOrigin(origins = "http://pizzacloud:8080")  // для обработки межсайтовых запросов
    // когда фреймворки на других хостах могли использовать api, браузер не позволит без этого (заголовки CORS)
public class PizzaController {
    private PizzaRepository repository;

    public PizzaController(PizzaRepository repository) {
        this.repository = repository;
    }

    @GetMapping(params = "recent")
    public Iterable<Pizza> recentPizzas() {
        PageRequest page = PageRequest.of(
                0, 12, Sort.by("createdAt").descending());
        return repository.findAll(page);
    }
}

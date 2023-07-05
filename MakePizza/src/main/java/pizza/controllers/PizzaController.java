package pizza.controllers;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pizza.models.Ingredient;
import pizza.models.Pizza;
import pizza.models.PizzaOrder;
import pizza.repositories.OrderRepository;
import pizza.repositories.PizzaRepository;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/pizzas",
                produces = "application/json")  // указывает что методы-обработчики
                // будут обрабатывать запросы с заголовком "Accept" со значением "application/json"
                // сообщает, что клиент может получить только json и ограничивает контроллер только для возварта json
                // produces={"application/json", "text/xml"} для нескольких возвращаемых форматов
@CrossOrigin(origins = "http://pizzacloud:8080")  // для обработки межсайтовых запросов
    // когда фреймворки на других хостах могли использовать api, браузер не позволит без этого (заголовки CORS)
    // можно указать много значений @CrossOrigin(origins={"http://pizzacloud:8080", "http://pizzacloud.com"})
public class PizzaController {
    private PizzaRepository pizzaRepository;
    private OrderRepository orderRepository;
    private RestTemplate rest;

    public PizzaController(PizzaRepository pizzaRepository,
                           OrderRepository orderRepository,
                           RestTemplate rest) {
        this.pizzaRepository = pizzaRepository;
        this.orderRepository = orderRepository;
        this.rest = rest;
    }

    @GetMapping("/ing/{id}")
    public Ingredient getIngredientById(@PathVariable("id") String id) {
        return rest.getForObject("http://localhost:8080/ingredients/{id}", Ingredient.class, id);
    }

    @GetMapping(params = "recent")
    public Iterable<Pizza> recentPizzas() {
        PageRequest page = PageRequest.of(
                0, 12, Sort.by("createdAt").descending());
                // 0-я страница с 12 результатами отсортированная по убыванию
        return pizzaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pizza> findPizzaById(@PathVariable("id") Long id) {
        Optional<Pizza> pizza = pizzaRepository.findById(id);
        if (pizza.isPresent()) {
            return new ResponseEntity<>(pizza.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes = "application/json")  // формат входных данных в запросе, а produces выходных
    @ResponseStatus(HttpStatus.CREATED)
    public Pizza postPizza(@RequestBody Pizza pizza) {
        pizzaRepository.save(pizza);
        return pizza;
    }

    @PutMapping(path = "/{orderId}", consumes = "application/json")
    public PizzaOrder putPizzaOrder(
            @PathVariable("orderId") Long orderId,
            @RequestBody PizzaOrder order) {
        order.setId(orderId);
        return orderRepository.save(order);
    }

    @PatchMapping(path = "/{orderId}", consumes = "application/json")
    public PizzaOrder patchOrder(
            @PathVariable("orderId") Long id,
            @RequestBody PizzaOrder patch) {
        PizzaOrder order = orderRepository.findById(id).get();
        if (patch.getDeliveryName() != null) {
            order.setDeliveryName(patch.getDeliveryName());
        }
        if (patch.getDeliveryCity() != null) {
            order.setDeliveryCity(patch.getDeliveryCity());
        }
        if (patch.getDeliveryState() != null) {
            order.setDeliveryState(patch.getDeliveryState());
        }
        if (patch.getDeliveryZip() != null) {
            order.setDeliveryZip(patch.getDeliveryZip());
        }
        if (patch.getDeliveryStreet() != null) {
            order.setDeliveryStreet(patch.getDeliveryStreet());
        }
        if (patch.getCcCW() != null) {
            order.setCcCW(patch.getCcCW());
        }
        if (patch.getCcNumber() != null) {
            order.setCcNumber(patch.getCcNumber());
        }
        if (patch.getCcExpiration() != null) {
            order.setCcExpiration(patch.getCcExpiration());
        }
        return orderRepository.save(order);
    }

    @DeleteMapping(path = "/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable Long id) {
        try {
            orderRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) { }
    }
}

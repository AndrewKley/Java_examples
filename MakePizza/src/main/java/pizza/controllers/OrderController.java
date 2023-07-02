package pizza.controllers;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import pizza.models.PizzaOrder;
import pizza.repositories.JpaOrderRepository;
import pizza.repositories.OrderRepository;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("pizzaOrder")
public class OrderController {
    private JpaOrderRepository repository;

    public OrderController(JpaOrderRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(
            @Valid PizzaOrder pizzaOrder, Errors errors,
            SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "orderForm";
        }
        repository.save(pizzaOrder);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}

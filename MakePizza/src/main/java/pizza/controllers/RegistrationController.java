package pizza.controllers;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pizza.models.RegistrationForm;
import pizza.repositories.UserRepository;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    private UserRepository repository;
    private PasswordEncoder encoder;

    public RegistrationController(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @GetMapping
    public String registerForm() {
        return "registration";
    }

    @PostMapping
    public String processRegistration(RegistrationForm form) {
        repository.save(form.toUser(encoder));
        return "redirect:/login";
    }
}

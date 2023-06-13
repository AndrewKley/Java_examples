package com.example.Controllers;

import com.example.Repositories.ClientRepository;
import com.example.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    private final ClientRepository clientRepository;

    @Autowired
    public HomeController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @GetMapping("/")
    public String home(Model model) {
        Iterable<Client> clients = clientRepository.findAll();
        model.addAttribute("clients", clients);
        return "home";
    }

    @PostMapping("/")
    public String homeAddClient(
            @RequestParam String login,
            @RequestParam String password,
            Model model
    ) {
        Client client = new Client();
        client.setLogin(login);
        client.setPassword(password);
        clientRepository.save(client);
        Iterable<Client> clients = clientRepository.findAll();
        model.addAttribute("clients", clients);
        return "home";
    }
}

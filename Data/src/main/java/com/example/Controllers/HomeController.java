package com.example.Controllers;

import com.example.Services.ClientService;
import com.example.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final ClientService clientService;

    @Autowired
    public HomeController(ClientService clientService) {
        this.clientService = clientService;
    }


    @GetMapping("/")
    public String home(Model model) {
        List<Client> clients = clientService.getAllClient();
        model.addAttribute("clients", clients);
        return "home";
    }
}

package com.example.Controllers;

import com.example.Services.ClientService;
import com.example.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/hi")
    public ResponseEntity<?> getHello() {
        return new ResponseEntity<>("Hello", HttpStatus.OK);
    }

    @GetMapping("/clients")
    public ResponseEntity<List<Client>> getAllClients() {
        final List<Client> clients = clientService.getAllClient();

        return clients != null && !clients.isEmpty()
                ? new ResponseEntity<>(clients, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // curl -v -X POST http://localhost:8080/clients
    // -d '{"id":1, "name":"Arkadiy", "email":"asd@qw.er", "password":"1arkadiy4"}'
    // -H "Content-Type: application/json"
    @PostMapping("/clients")
    public ResponseEntity<?> createClient(@RequestBody Client client) {
        clientService.createClient(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> getClient(@PathVariable(name = "id") int id) {
        final Client client = clientService.getClient(id);

        return client != null
                ? new ResponseEntity<>(client, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<?> updateClient(
            @PathVariable(name = "id") int id,
            @RequestBody Client client
    ) {
        final boolean updated = clientService.updateClient(client, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable(name = "id") int id) {
        final boolean deleted = clientService.deleteClient(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}

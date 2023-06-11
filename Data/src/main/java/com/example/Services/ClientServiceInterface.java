package com.example.Services;

import com.example.models.Client;

import java.util.List;

public interface ClientServiceInterface {
    void createClient(Client client);
    List<Client> getAllClient();
    Client getClient(int id);
    boolean updateClient(Client client, int id);
    boolean deleteClient(int id);
}

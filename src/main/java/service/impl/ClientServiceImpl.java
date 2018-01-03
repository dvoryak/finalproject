package service.impl;

import model.entity.Client;
import service.ClientService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientServiceImpl implements ClientService {

    private ArrayList<Client> clients = new ArrayList<>();

    {
        clients.add(new Client.Builder().login("admin").password("admin").build());
    }

    public Client findByLogin(String login) {
        for (Client client : clients) {
            if(client.getLogin().equals(login)) {
                return client;
            }
        }
        return null;
    }

    public List<Client> findAll() {
        return clients;
    }

    public boolean add(Client client) {
        return clients.add(client);
    }
}

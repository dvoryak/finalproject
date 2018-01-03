package service;

import model.entity.Client;

import java.util.List;

public interface ClientService {

    Client findByLogin(String login);

    List<Client> findAll();

    boolean add(Client client);
}

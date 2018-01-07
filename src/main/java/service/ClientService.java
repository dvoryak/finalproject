package service;

import model.entity.Client;

import java.util.List;

public interface ClientService {

    Client findByLogin(String login);

    boolean add(Client client);
}

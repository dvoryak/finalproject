package dao;

import model.entity.Client;

import java.util.List;

public interface ClientDAO {

    Client findByLogin(String login);

    List<Client> findAll();

    boolean save(Client client);

}

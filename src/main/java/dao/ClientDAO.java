package dao;

import model.entity.Client;
import model.entity.Inspector;

import java.util.List;

public interface ClientDAO {

    Client findByLogin(String login);

    List<Client> findAll();

    boolean save(Client client);

    Client findById(int id);

}

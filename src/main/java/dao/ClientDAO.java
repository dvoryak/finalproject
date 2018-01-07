package dao;

import model.entity.Client;
import model.entity.Entity;

import java.util.List;

public interface ClientDAO {

    Client findByLogin(String login);

    boolean add(Client client);

}

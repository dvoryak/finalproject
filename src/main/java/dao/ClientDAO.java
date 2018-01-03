package dao;

import model.entity.Client;
import model.entity.Entity;

import java.util.List;

public interface ClientDAO {

    Client findById(long id);

    List<Client> findAll();

    boolean add(Client client);
}

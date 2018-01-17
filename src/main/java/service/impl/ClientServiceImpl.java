package service.impl;

import dao.ClientDAO;
import model.entity.Client;
import service.ClientService;

import java.sql.SQLException;
import java.util.List;

public class ClientServiceImpl implements ClientService {

    private ClientDAO clientDAO;

    public ClientServiceImpl(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @Override
    public Client findByLogin(String login) throws SQLException {
        return clientDAO.findByLogin(login);
    }

    @Override
    public List<Client> findAll() throws SQLException  {
        return clientDAO.findAll();
    }

    @Override
    public boolean save(Client client) throws SQLException  {
        return clientDAO.save(client);
    }

    @Override
    public Client findById(int id) throws SQLException {
        return clientDAO.findById(id);
    }
}

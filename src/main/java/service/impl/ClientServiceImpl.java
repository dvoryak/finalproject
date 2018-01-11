package service.impl;

import dao.ClientDAO;
import model.entity.Client;
import service.ClientService;

import java.util.List;

public class ClientServiceImpl implements ClientService {

    private ClientDAO clientDAO;

    public ClientServiceImpl(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @Override
    public Client findByLogin(String login) {
        return clientDAO.findByLogin(login);
    }

    @Override
    public List<Client> findAll() {
        return clientDAO.findAll();
    }

    @Override
    public boolean save(Client client) {
        return clientDAO.save(client);
    }
}

package service.impl;

import dao.ClientDAO;
import dao.mysqlDaoImpl.MysqlDaoFactory;
import dao.pool.ConnectionPool;
import model.entity.Client;
import service.ClientService;

import java.sql.Connection;

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
    public boolean add(Client client) {
        return clientDAO.add(client);
    }
}

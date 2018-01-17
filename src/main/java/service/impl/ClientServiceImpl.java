package service.impl;

import dao.ClientDAO;
import exception.WrongInputException;
import model.entity.Client;
import service.ClientService;

import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

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
    public boolean register(Client client) throws WrongInputException, SQLException {
        String login = client.getLogin();
        String password = client.getPassword();
        String email = client.getEmail();
        String firstName = client.getFirstName();
        String lastName = client.getLastName();
        String phone = client.getPhone();


        ResourceBundle bundle = ResourceBundle.getBundle("regex");

        if(firstName == null || !firstName.matches(bundle.getString("regex.name"))) {
            throw new WrongInputException("front.firstName.incorrect");
        }

        if(lastName == null || !lastName.matches(bundle.getString("regex.name"))) {
            throw new WrongInputException("front.lastName.incorrect");
        }

        if(login == null || !login.matches(bundle.getString("regex.login"))) {
            throw new WrongInputException("front.login.incorrect");
        }

        Client byLogin = clientDAO.findByLogin(login);
        if(byLogin != null && byLogin.getLogin().equals(login)) {
            throw new WrongInputException("front.login.exist");
        }

        if(password == null || !password.matches(bundle.getString("regex.password"))) {
            throw new WrongInputException("front.password.incorrect");
        }

        if(email == null || !email.matches(bundle.getString("regex.email"))) {
            throw new WrongInputException("front.email.incorrect");
        }

        if(phone == null || !phone.matches(bundle.getString("regex.phone"))) {
            throw new WrongInputException("front.phone.incorrect");
        }

        return clientDAO.save(client);
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

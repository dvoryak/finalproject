package dao;

import model.entity.Client;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author paveldvoryak
 * @version 1.0
 */

public interface ClientDAO {


    /**
     * Find a client by Login
     * @param login - login of client
     * @return {@link Client}
     * @throws SQLException
     */
    Client findByLogin(String login) throws SQLException;


    /**
     * Find all client in database
     * @return @{@link List} of {@link Client}
     * @throws SQLException
     */
    List<Client> findAll() throws SQLException;

    /**
     * Save client
     * @param client - {@link Client}
     * @return TRUE if operation was successful otherwise FALSE
     * @throws SQLException
     */
    boolean save(Client client) throws SQLException;


    /**
     * Find by client's id
     * @param id
     * @return {@link Client}
     * @throws SQLException
     */
    Client findById(int id) throws SQLException;

}

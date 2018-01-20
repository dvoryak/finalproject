package dao.mysqlDaoImpl;

import dao.ClientDAO;
import dao.pool.ConnectionPool;
import model.entity.Client;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * MySQL implementation of @{@link ClientDAO}
 *
 * @author paveldvoryak
 * @version 1.0
 */

public class ClientDAOImpl implements ClientDAO {

    private static final Logger logger = Logger.getLogger(ClientDAOImpl.class);

    private ConnectionPool pool;
    private ResourceBundle bundle = ResourceBundle.getBundle("queries/queries");


    public ClientDAOImpl(ConnectionPool pool) {
        this.pool = pool;
    }

    @Override
    public Client findByLogin(String login) throws SQLException {
        try(Connection connection = pool.getConnection();
            Statement statement = connection.createStatement()) {
            String q = bundle.getString("sql.client.findByLogin");
            q = q.replace("?",login);
            ResultSet resultSet = statement.executeQuery(q);
            if (resultSet.next()) {
                return getEntity(resultSet);
            }
        } catch (SQLException e) {
            logger.error("Database error " + e);
            throw e;
        }

        return null;
    }

    @Override
    public Client findById(int id) throws SQLException {
        try(Connection connection = pool.getConnection();
            Statement statement = connection.createStatement()) {
            String q = bundle.getString("sql.client.findById");
            q = q.replace("?",Integer.toString(id));
            ResultSet resultSet = statement.executeQuery(q);

            if (resultSet.next()) {
                return getEntity(resultSet);
            }

        } catch (SQLException e) {
            logger.error("Database error " + e);
            throw e;
        }
        return null;
    }

    @Override
    public List<Client> findAll() throws SQLException {
        try(Connection connection = pool.getConnection();
            Statement statement = connection.createStatement()) {
            List<Client> clients = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery(bundle.getString("sql.client.findAll"));
            while (resultSet.next()) {
                clients.add(getEntity(resultSet));
            }
            return clients;
        } catch (SQLException e) {
            logger.error("Database error " + e);
            throw e;
        }
    }

    @Override
    public boolean save(Client client) throws SQLException {
        try(Connection connection = pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(bundle.getString("sql.client.save"))) {
            ps.setInt(1,client.hashCode());
            ps.setString(2,client.getFirstName());
            ps.setString(3,client.getLastName());
            ps.setString(4,client.getLogin());
            ps.setString(5,client.getPassword());
            ps.setString(6,client.getEmail());
            ps.setString(7,client.getPhone());
            return ps.execute();

        } catch (SQLException e) {
            logger.error("Database error " + e);
            throw e;
        }
    }

    private Client getEntity(ResultSet rs) throws SQLException {
        return new Client.Builder()
                .id(rs.getInt("id"))
                .firstName(rs.getString("firstName"))
                .lastName(rs.getString("lastName"))
                .login(rs.getString("login"))
                .password(rs.getString("password"))
                .email(rs.getString("email"))
                .phone(rs.getString("phone"))
                .build();
    }

    public void setPool(ConnectionPool pool) {
        this.pool = pool;
    }
}

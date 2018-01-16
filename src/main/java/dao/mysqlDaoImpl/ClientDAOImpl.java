package dao.mysqlDaoImpl;

import dao.ClientDAO;
import dao.pool.ConnectionPool;
import model.entity.Client;
import model.entity.Inspector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ClientDAOImpl implements ClientDAO {

    private ConnectionPool pool = ConnectionPool.INSTANCE;
    private ResourceBundle bundle = ResourceBundle.getBundle("queries/queries");

    public ClientDAOImpl() {
    }

    @Override
    public Client findByLogin(String login) {
        try(Connection connection = pool.getConnection();
            Statement statement = connection.createStatement()) {
            String q = bundle.getString("sql.client.findByLogin");
            q = q.replace("?",login);
            ResultSet resultSet = statement.executeQuery(q);
            if (resultSet.next()) {
                return getEntity(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            //TODO logger
        }
        return null;
    }

    @Override
    public Client findById(int id) {
        try(Connection connection = pool.getConnection();
            Statement statement = connection.createStatement()) {
            String q = bundle.getString("sql.client.findById");
            q = q.replace("?",Integer.toString(id));
            ResultSet resultSet = statement.executeQuery(q);

            if (resultSet.next()) {
                return getEntity(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            //TODO logger
        }
        return null;
    }

    @Override
    public List<Client> findAll() {
        try(Connection connection = pool.getConnection();
            Statement statement = connection.createStatement()) {
            List<Client> clients = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery(bundle.getString("sql.client.findAll"));
            while (resultSet.next()) {
                clients.add(getEntity(resultSet));
            }
            return clients;
        } catch (SQLException e) {
            e.printStackTrace();
            //TODO logger
        }
        return null;
    }

    @Override
    public boolean save(Client client) {
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
            e.printStackTrace();
            //TODO logger
        }
        return false;
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
}

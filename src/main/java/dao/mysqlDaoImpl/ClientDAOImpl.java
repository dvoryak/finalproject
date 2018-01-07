package dao.mysqlDaoImpl;

import dao.AbstractDAO;
import dao.ClientDAO;
import dao.pool.ConnectionPool;
import dao.query.QueryBuilder;
import model.entity.Client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientDAOImpl implements ClientDAO {

    private ConnectionPool pool = ConnectionPool.INSTANCE;
    private final String table = "project.client";

    @Override
    public Client findByLogin(String login) {
        Client client = null;
        try (Connection connection = pool.getConnection();
             Statement statement = connection.createStatement()) {
            QueryBuilder query = new QueryBuilder();
            query.selectAll()
                    .from(table)
                    .where(query.condition("login", login, "="));
            ResultSet rs = statement.executeQuery(query.toQuery());
            if(rs.next()) {
                client = getEntity(rs);
            }

        } catch (SQLException e) {
            //TODO add looger
            e.printStackTrace();
            return null;
        }

        return client;
    }

    @Override
    public boolean add(Client client) {
        try (Connection connection = pool.getConnection();
             Statement statement = connection.createStatement()) {
            QueryBuilder query = new QueryBuilder();
            query.insert()
                    .into(table)
                    .values(Integer.toString(client.getId()), client.getFirstName(), client.getLastName(), client.getLogin(),
                            client.getPassword(), client.getEmail(), client.getPhone());
            statement.execute(query.toQuery());
            return true;
        } catch (SQLException e) {
            //TODO add logger
            e.printStackTrace();
            return false;
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
                .phone(rs.getString("phone")).build();
    }
}

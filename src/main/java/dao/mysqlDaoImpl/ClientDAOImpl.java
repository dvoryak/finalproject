package dao.mysqlDaoImpl;

import dao.AbstractDAO;
import dao.ClientDAO;
import dao.query.QueryBuilder;
import model.entity.Client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientDAOImpl extends AbstractDAO implements ClientDAO {

    private QueryBuilder query = new QueryBuilder();

    public ClientDAOImpl(Connection connection) {
        super(connection);
    }

    @Override
    public List<Client> findAll() {
        List<Client> clients = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query
                    .selectAll()
                    .from(Tables.CLIENT)
                    .toQuery());
            while (resultSet.next()) {
                clients.add(new Client.Builder()
                        .firstName(resultSet.getString("firstName"))
                        .lastName(resultSet.getString("lastName"))
                        .email(resultSet.getString("email"))
                        .login(resultSet.getString("login"))
                        .password(resultSet.getString("password"))
                        .phone(resultSet.getString("phone"))
                        .id(resultSet.getInt("id"))
                        .build());

            }
            closeStatement(statement);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            closeConnection(connection);
        }
        return clients;
    }

    @Override
    public Client findById(long id) {
        return null;
    }


    @Override
    public boolean add(Client client) {
        return false;
    }
}

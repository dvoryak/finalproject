package dao.mysqlDaoImpl;

import dao.InspectorDAO;
import dao.pool.ConnectionPool;
import model.entity.Inspector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


/**
 * @author paveldvoryak
 *
 *
 */

public class InspectorDAOImpl implements InspectorDAO {

    private ConnectionPool pool = ConnectionPool.INSTANCE;
    private ResourceBundle bundle = ResourceBundle.getBundle("queries/queries");

    public InspectorDAOImpl() {
    }

    @Override
    public Inspector findByLogin(String login) {
        try(Connection connection = pool.getConnection();
            Statement statement = connection.createStatement()) {
            String q = bundle.getString("sql.inspector.findByLogin");
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
    public List<Inspector> findAll() {
        try(Connection connection = pool.getConnection();
            Statement statement = connection.createStatement()) {
            ArrayList<Inspector> inspectors = new ArrayList<>();
            String q = bundle.getString("sql.inspector.findAll");
            ResultSet resultSet = statement.executeQuery(q);

            while (resultSet.next()) {
                inspectors.add(getEntity(resultSet));
            }

            return inspectors;
        } catch (SQLException e) {
            e.printStackTrace();
            //TODO logger
        }

        return null;
    }

    @Override
    public boolean save(Inspector inspector) {
        try(Connection connection = pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(bundle.getString("sql.inspector.findAll"))) {
            ps.setInt(1,inspector.hashCode());
            ps.setString(2,inspector.getFirstName());
            ps.setString(3,inspector.getLastName());
            ps.setString(4,inspector.getLogin());
            ps.setString(5,inspector.getPassword());

            return ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            //TODO logger
        }
        return false;
    }

    @Override
    public Inspector findById(int id) {
        try(Connection connection = pool.getConnection();
            Statement statement = connection.createStatement()) {
            String q = bundle.getString("sql.inspector.findById");
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

    private Inspector getEntity(ResultSet resultSet) throws SQLException {
        return new Inspector(resultSet.getInt("id"),
                resultSet.getString("login"),
                resultSet.getString("password"),
                resultSet.getString("firstName"),
                resultSet.getString("lastName"));
    }
}

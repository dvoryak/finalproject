package dao;

import model.entity.Entity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDAO {

    protected Connection connection;

    public AbstractDAO(Connection connection) {
        this.connection = connection;
    }

    public void closeStatement(Statement statement) {
        try {

            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // TODO add logger here
        }
    }

    public void closeConnection(Connection connection) {
        try {
            if(connection != null)
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // TODO add logger here
        }
    }
}

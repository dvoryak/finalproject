package dao;

import dao.pool.ConnectionPool;
import model.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PullTest {
    Connection connection = ConnectionPool.INSTANCE.getConnection();
    private String userName;


    public PullTest() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from project.user");
        String out = null;
        while(resultSet.next()) {
            out = resultSet.getString("firstName");

        }
    }

    public String getUserName() throws SQLException {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}

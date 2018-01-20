package dao;

import dao.mysqlDaoImpl.ClientDAOImpl;
import dao.pool.ConnectionPool;
import model.entity.Client;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class ClientDAOImplTest {

    private ConnectionPool pool = mock(ConnectionPool.class);
    private Statement statement;
    private ResultSet resultSet;

    private ClientDAOImpl clientDAO = new ClientDAOImpl(pool);

    {
        clientDAO.setPool(pool);
    }


    @Before
    public void init() throws SQLException {
        Connection connection = mock(Connection.class);

        when(pool.getConnection())
                .thenReturn(connection);

        statement = mock(Statement.class);
        when(connection.createStatement())
                .thenReturn(statement);

        PreparedStatement preparedStatement = mock(PreparedStatement.class);
        when(connection.prepareStatement(anyString()))
                .thenReturn(preparedStatement);

        resultSet = mock(ResultSet.class);
        when(statement.executeQuery(anyString()))
                .thenReturn(resultSet);

        when(resultSet.getString(any()))
                .thenReturn("string");

        when(resultSet.getInt(any()))
                .thenReturn(1);

    }


    @Test
    public void test_findByLogin() throws Exception {
        when(resultSet.next())
                .thenReturn(true);
        when(resultSet.getString("login"))
                .thenReturn("login");
        assertEquals("login", clientDAO.findByLogin("login").getLogin());
        assertNotEquals("text",clientDAO.findByLogin("login").getLogin());
    }

    @Test
    public void test_findById() throws Exception {
        int id;
        when(resultSet.next())
                .thenReturn(true);
        when(resultSet.getInt("id"))
                .thenReturn(101);

        assertEquals(101, clientDAO.findById(101).getId());
        assertNotEquals(105,clientDAO.findById(101).getId());
    }



}
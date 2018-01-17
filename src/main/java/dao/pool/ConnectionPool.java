package dao.pool;

import org.apache.log4j.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author paveldvoryak
 * @version 1.0
 */
public enum ConnectionPool {
    INSTANCE;

    private final static Logger logger = Logger.getLogger(ConnectionPool.class);

    private DataSource dataSource;
    {
        try {
            InitialContext initialContext = new InitialContext();
            dataSource = (DataSource) initialContext.lookup("java:comp/env/jdbc/project");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for getting a connection
     *
     * @return {@link Connection}
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            logger.error("Getting connection error :" + e);
            throw e;
        }
    }

}

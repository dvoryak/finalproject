package service.transaction;

import dao.pool.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionManagerImpl implements TransactionManager {

    private ConnectionPool pool;
    private final static Logger logger = Logger.getLogger(TransactionManager.class);

    public TransactionManagerImpl(ConnectionPool pool) {
        this.pool = pool;
    }

    @Override
    public <T> T processTransaction(Operation<T> operation) {
        T result = null;
        Connection connection = null;
        try {
            connection = pool.getConnection();
            connection.setAutoCommit(false);
            logger.info("Start transaction");
            result = operation.execute(connection);

            connection.commit();
            logger.info("Transaction successful");

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Transaction error" + e);
            if(connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    logger.error("Connection rollback error");
                }
            }
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    logger.error("Connection close error");
                }
            }
        }

        return result;
    }
}

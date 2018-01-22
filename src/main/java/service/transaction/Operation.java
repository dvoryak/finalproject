package service.transaction;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author paveldvoryak
 * @version 1.0
 * @param <T>
 */
@FunctionalInterface
public interface Operation<T> {

    /**
     * Execute a operation
     *
     * @param connection {@link Connection}
     * @return generic type T
     * @throws SQLException
     */
    public T execute(Connection connection) throws SQLException;

}

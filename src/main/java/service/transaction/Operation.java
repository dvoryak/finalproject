package service.transaction;

import java.sql.Connection;
import java.sql.SQLException;

@FunctionalInterface
public interface Operation<T> {

    public T execute(Connection connection) throws SQLException;

}

package dao.mysqlDaoImpl;

import dao.pool.ConnectionPool;
import model.entity.Entity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class AbstractDAOImpl<T extends Entity> {

    private ConnectionPool pool = ConnectionPool.INSTANCE;


    public T findById(int id) {
        return null;
    }


    public abstract T getEntity(ResultSet rs);

    public abstract void setEntity(T entity, PreparedStatement statement);

}

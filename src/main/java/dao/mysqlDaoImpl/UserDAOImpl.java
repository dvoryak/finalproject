package dao.mysqlDaoImpl;

import dao.AbstractDAO;
import dao.UserDAO;
import model.entity.User;

import java.sql.Connection;
import java.util.List;

public class UserDAOImpl extends AbstractDAO<Integer,User> implements UserDAO {

    public UserDAOImpl(Connection connection) {
        super(connection);
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public boolean remove(long id) {
        return false;
    }

    @Override
    public boolean remove(User user) {
        return false;
    }

    @Override
    public boolean add(User user) {
        return false;
    }
}

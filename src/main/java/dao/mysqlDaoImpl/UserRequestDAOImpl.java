package dao.mysqlDaoImpl;

import dao.UserRequestDAO;
import dao.pool.ConnectionPool;
import model.entity.UserRequest;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * MySQL implementation of @{@link UserRequestDAO}
 *
 * @author paveldvoryak
 * @version 1.0
 */

public class UserRequestDAOImpl implements UserRequestDAO {

    private ConnectionPool pool = ConnectionPool.getInstance();
    private final ResourceBundle bundle = ResourceBundle.getBundle("queries/queries");
    private static final Logger logger = Logger.getLogger(UserRequestDAOImpl.class);

    @Override
    public boolean save(UserRequest userRequest) throws SQLException {

        try(Connection connection = pool.getConnection();
            PreparedStatement statement = connection.prepareStatement(bundle.getString("sql.userReq.save"))) {
            statement.setString(1,userRequest.getText());
            statement.setInt(2,userRequest.getUserId());
            return statement.execute();

        } catch (SQLException e) {
            logger.error("Database error (dao level): " + e);
            throw e;
        }

    }

    @Override
    public List<UserRequest> findByUserId(int userId) throws SQLException {
        List<UserRequest> userRequests = new ArrayList<>();
        try(Connection connection = pool.getConnection();
            PreparedStatement statement = connection.prepareStatement(bundle.getString("sql.userReq.findByUserId"))) {
            statement.setInt(1,userId);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                userRequests.add(getEntity(rs));
            }

            return userRequests;

        } catch (SQLException e) {
            logger.error("Database error (dao level): " + e);
            throw e;
        }

    }

    private UserRequest getEntity(ResultSet rs) throws SQLException {
        return new UserRequest(rs.getInt("id"),
                                rs.getString("text"),
                                rs.getInt("user_id"));
    }
}

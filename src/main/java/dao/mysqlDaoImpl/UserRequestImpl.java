package dao.mysqlDaoImpl;

import dao.UserRequestDAO;
import dao.pool.ConnectionPool;
import model.entity.UserRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UserRequestImpl implements UserRequestDAO {

    private ConnectionPool pool = ConnectionPool.INSTANCE;
    private final ResourceBundle bundle = ResourceBundle.getBundle("queries/queries");

    @Override
    public boolean save(UserRequest userRequest) {

        try(Connection connection = pool.getConnection();
            PreparedStatement statement = connection.prepareStatement(bundle.getString("sql.user.save"))) {
            statement.setString(1,userRequest.getText());
            statement.setInt(2,userRequest.getUserId());
            return statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            //TODO save logger here
        }

        return false;
    }

    @Override
    public List<UserRequest> findByUserId(int userId) {
        List<UserRequest> userRequests = new ArrayList<>();
        try(Connection connection = pool.getConnection();
            PreparedStatement statement = connection.prepareStatement(bundle.getString("sql.userReq.findByUserId"))) {
            statement.setInt(1,userId);
            ResultSet rs = statement.executeQuery();

            if(rs.next()) {
                userRequests.add(getEntity(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            //TODO save logger here
        }

        return null;
    }

    private UserRequest getEntity(ResultSet rs) throws SQLException {
        return new UserRequest(rs.getInt("id"),
                                rs.getString("text"),
                                rs.getInt("user_id"));
    }
}

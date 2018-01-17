package dao;

import model.entity.UserRequest;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author paveldvoryak
 * @version 1.0
 */

public interface UserRequestDAO {

    /**
     * Save a request from user
     *
     * @param userRequest {@link UserRequest}
     * @return TRUE if operation was successful otherwise FALSE
     * @throws SQLException
     */
    boolean save(UserRequest userRequest) throws SQLException;

    /**
     * Find by user's id
     *
     * @param userId
     * @return {@link List<UserRequest>}
     * @throws SQLException
     */
    List<UserRequest> findByUserId(int userId) throws SQLException;

}

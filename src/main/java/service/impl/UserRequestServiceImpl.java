package service.impl;

import dao.UserRequestDAO;
import model.entity.UserRequest;
import service.UserRequestService;

import java.sql.SQLException;
import java.util.List;

public class UserRequestServiceImpl implements UserRequestService {

    private UserRequestDAO userRequestDAO;

    public UserRequestServiceImpl(UserRequestDAO userRequestDAO) {
        this.userRequestDAO = userRequestDAO;
    }

    @Override
    public boolean save(UserRequest userRequest) throws SQLException {
        return userRequestDAO.save(userRequest);
    }

    @Override
    public List<UserRequest> findByUserId(int userId) throws SQLException {
        return userRequestDAO.findByUserId(userId);
    }
}

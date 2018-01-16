package service.impl;

import dao.UserRequestDAO;
import model.entity.UserRequest;
import service.UserRequestService;

import java.util.List;

public class UserRequestServiceImpl implements UserRequestService {

    private UserRequestDAO userRequestDAO;

    public UserRequestServiceImpl(UserRequestDAO userRequestDAO) {
        this.userRequestDAO = userRequestDAO;
    }

    @Override
    public boolean save(UserRequest userRequest) {
        return userRequestDAO.save(userRequest);
    }

    @Override
    public List<UserRequest> findByUserId(int userId) {
        return userRequestDAO.findByUserId(userId);
    }
}

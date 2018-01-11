package dao;

import model.entity.UserRequest;

import java.util.List;

public interface UserRequestDAO {

    boolean save(UserRequest userRequest);

    List<UserRequest> findByUserId(int userId);

}

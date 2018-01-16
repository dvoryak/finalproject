package service;

import model.entity.UserRequest;

import java.util.List;

public interface UserRequestService {

    boolean save(UserRequest userRequest);

    List<UserRequest> findByUserId(int userId);

}

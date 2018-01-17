package controller.command;

import controller.constant.Pages;
import model.entity.User;
import model.entity.UserRequest;
import service.UserRequestService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class RequestAddCommand implements Command {

    private UserRequestService requestService;

    public RequestAddCommand(UserRequestService requestService) {
        this.requestService = requestService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        User user = (User) request.getSession().getAttribute("user");
        String text = request.getParameter("text");
        UserRequest userRequest = new UserRequest();
        userRequest.setText(text);
        userRequest.setUserId(user.getId());
        requestService.save(userRequest);

        return Pages.CLIENT_CABINET;
    }
}

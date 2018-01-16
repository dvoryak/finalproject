package controller.command;

import controller.constant.Pages;
import model.entity.User;
import model.entity.UserRequest;
import service.UserRequestService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class PageRequestShow implements Command {

    private UserRequestService requestService;

    public PageRequestShow(UserRequestService requestService) {
        this.requestService = requestService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        List<UserRequest> byUserId = requestService.findByUserId(user.getId());
        request.getSession().setAttribute("requests",byUserId);
        return Pages.REQUEST_SHOW;
    }
}

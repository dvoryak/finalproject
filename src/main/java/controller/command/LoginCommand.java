package controller.command;


import controller.constant.Pages;
import model.entity.Client;
import model.entity.Inspector;
import model.entity.User;
import service.ClientService;
import service.InspectorService;
import service.impl.ServiceFactoryImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand implements Command {

    private ClientService clientService;
    private InspectorService inspectorService;

    public LoginCommand(ClientService clientService, InspectorService inspectorService) {
        this.clientService = clientService;
        this.inspectorService = inspectorService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        String isInspector = request.getParameter("isInspector");

        if(isInspector != null) {
            Inspector inspector = inspectorService.findByLogin(login);
            if(checkUser(inspector,login,password)) {
                request.setAttribute("user",inspector);
                return Pages.INSPECTOR_CABINET;
            }

        } else {
            Client client = clientService.findByLogin(login);
            if(checkUser(client,login,password)) {
                request.getSession().setAttribute("user",client);
                return Pages.CLIENT_CABINET;
            }
        }

        return Pages.LOGIN;
    }

    private boolean checkUser(User user,String login, String password) {
        return user != null && user.getLogin().equals(login) && user.getPassword().equals(password);
    }


}

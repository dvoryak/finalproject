package controller.command;


import controller.constant.Pages;
import model.entity.Client;
import model.entity.Inspector;
import model.entity.User;
import org.apache.log4j.Logger;
import service.ClientService;
import service.InspectorService;
import service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;


public class LoginCommand implements Command {

    private ServiceFactory serviceFactory;

    public LoginCommand(ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");


        String isInspector = request.getParameter("isInspector");

        if(isInspector != null) {
            InspectorService inspectorService = serviceFactory.createInspectorService();
            Inspector inspector = inspectorService.findByLogin(login);
            if(checkUser(inspector,login,password)) {
                request.getSession().setAttribute("user",inspector);
                return Pages.INSPECTOR_CABINET;
            }

        } else {
            ClientService clientService = serviceFactory.createClientService();
            Client client = clientService.findByLogin(login);
            if(checkUser(client,login,password)) {
                request.getSession().setAttribute("user", client);
                return Pages.CLIENT_CABINET;
            }
        }


        request.setAttribute("error","true");

        return Pages.LOGIN;
    }

    private boolean checkUser(User user,String login, String password) {
        return user != null && user.getLogin().equals(login) && user.getPassword().equals(password);
    }

}

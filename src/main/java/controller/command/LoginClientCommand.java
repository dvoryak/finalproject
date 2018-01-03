package controller.command;


import controller.constant.Pages;
import model.entity.Client;
import service.ClientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginClientCommand implements Command {

    ClientService clientService;

    public LoginClientCommand(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        Client client = clientService.findByLogin(login);
        if(client == null) {
            //TODO add something to inform user what login is not exist
            System.out.println("login is not exist");
            return Pages.LOGIN;
        } else if(client.getPassword().equals(password)) {
            request.getSession().setAttribute("auth","valid");
            return Pages.CLIENT_CABINET;
        } else {
            //TODO add inform about wrong password
            System.out.println("wrong password");
            return Pages.LOGIN;
        }

    }
}

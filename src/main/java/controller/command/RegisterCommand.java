package controller.command;

import controller.constant.Pages;
import model.entity.Client;
import service.ClientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterCommand implements Command {

    private ClientService clientService;

    public RegisterCommand(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Client client = new Client.Builder()
                .firstName(request.getParameter("firstName"))
                .lastName(request.getParameter("lastName"))
                .login(request.getParameter("login"))
                .password(request.getParameter("password"))
                .email(request.getParameter("email"))
                .phone(request.getParameter("phone"))
                .build();
        clientService.save(client);
        return Pages.LOGIN;
    }
}

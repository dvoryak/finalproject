package controller.command;

import service.ClientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterCommand implements Command {

    private ClientService clientService;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}

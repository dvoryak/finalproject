package controller.command;

import controller.constant.Pages;
import exception.WrongInputException;
import model.entity.Client;
import service.ClientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class RegisterCommand implements Command {

    private ClientService clientService;

    public RegisterCommand(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");



        Client client = new Client.Builder()
                .firstName(firstName)
                .lastName(lastName)
                .login(login)
                .password(password)
                .email(email)
                .phone(phone)
                .build();
        try {
            clientService.register(client);
        } catch (WrongInputException e) {
            request.setAttribute("exception",e.getMessage());
            request.setAttribute("tmp_user",client);
            return Pages.REGISTER;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Pages.LOGIN;
    }

}

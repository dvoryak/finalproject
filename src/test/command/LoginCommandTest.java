package command;

import controller.command.Command;
import controller.command.CommandExecutor;
import controller.command.LoginCommand;
import controller.constant.Pages;
import model.entity.Client;
import model.entity.Inspector;
import model.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import service.ClientService;
import service.InspectorService;
import service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LoginCommandTest {

    private ServiceFactory serviceFactory = mock(ServiceFactory.class);
    private HttpServletRequest request = mock(HttpServletRequest.class);
    private HttpServletResponse response = mock(HttpServletResponse.class);
    private HttpSession session = mock(HttpSession.class);
    private Command command = new LoginCommand(serviceFactory);


    @Before
    public void init() {
        when(request.getParameter("login"))
                .thenReturn("login");
        when(request.getParameter("password"))
                .thenReturn("password");
        when(request.getSession())
                .thenReturn(session);
    }



    @Test
    public void test_client_execute() throws Exception {

        when(request.getParameter("isInspector"))
                .thenReturn(null);

        ClientService clientService = mock(ClientService.class);
        when(serviceFactory.createClientService())
                .thenReturn(clientService);

        Client client = new Client.Builder()
                .login("login")
                .password("password")
                .build();

        when(clientService.findByLogin("login"))
                .thenReturn(client);

        assertEquals(Pages.CLIENT_CABINET,command.execute(request, response));

        client.setLogin("wrong_login");

        assertEquals(Pages.LOGIN,command.execute(request, response));

    }

    @Test
    public void text_inspector_execute() throws Exception {


        when(request.getParameter("isInspector"))
                .thenReturn("true");

        InspectorService inspectorService = mock(InspectorService.class);
        when(serviceFactory.createInspectorService())
                .thenReturn(inspectorService);

        Inspector inspector = new Inspector();
        inspector.setLogin("login");
        inspector.setPassword("password");

        when(inspectorService.findByLogin("login"))
                .thenReturn(inspector);

        assertEquals(Pages.INSPECTOR_CABINET, command.execute(request,response));

        inspector.setLogin("wrong_login");

        assertEquals(Pages.LOGIN, command.execute(request,response));

    }






}
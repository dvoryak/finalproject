package command;

import controller.command.Command;
import controller.command.CommandExecutor;
import controller.command.CommandType;
import controller.command.LoginCommand;
import controller.constant.Pages;
import org.junit.Test;
import service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CommandExecutorTest {

    private ServiceFactory serviceFactory = mock(ServiceFactory.class);
    private HttpServletRequest request = mock(HttpServletRequest.class);
    private HttpServletResponse response = mock(HttpServletResponse.class);
    private HttpSession session = mock(HttpSession.class);
    private CommandExecutor executor = CommandExecutor.INSTANCE;

    @Test
    public void execute() throws Exception {

        when(request.getAttribute(eq("command")))
                .thenReturn(CommandType.LOGIN_PAGE);
        assertEquals(Pages.LOGIN,executor.execute(request, response));

        when(request.getAttribute(eq("command")))
                .thenReturn(CommandType.REGISTER_PAGE);
        assertEquals(Pages.REGISTER,executor.execute(request, response));


        when(request.getAttribute(eq("command")))
                .thenReturn(CommandType.REPORT_PAGE);
        assertEquals(Pages.REPORT,executor.execute(request, response));

        when(request.getAttribute(eq("command")))
                .thenReturn(CommandType.CREATE_REPORT);
        assertEquals(Pages.REQUEST_ADD,executor.execute(request, response));

    }

}
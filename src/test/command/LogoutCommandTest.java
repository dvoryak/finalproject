package command;

import controller.command.Command;
import controller.command.LoginCommand;
import controller.command.LogoutCommand;
import org.junit.Test;
import service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LogoutCommandTest {

    private ServiceFactory serviceFactory = mock(ServiceFactory.class);
    private HttpServletRequest request = mock(HttpServletRequest.class);
    private HttpServletResponse response = mock(HttpServletResponse.class);
    private HttpSession session = mock(HttpSession.class);
    private Command command = new LogoutCommand();

    @Test
    public void execute() throws Exception {
        when(request.getSession())
                .thenReturn(session);
        command.execute(request,response);
        verify(session,times(1)).invalidate();
    }

}
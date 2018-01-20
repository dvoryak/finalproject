package filter;

import controller.command.CommandType;
import model.entity.Client;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static controller.command.CommandType.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class AuthFilterTest {

    private HttpServletRequest request = mock(HttpServletRequest.class);
    private ServletResponse response = mock(ServletResponse.class);
    private HttpSession session = mock(HttpSession.class);
    private FilterChain chain = mock(FilterChain.class);
    private AuthFilter authFilter = new AuthFilter();



    @Test
    public void doFilter() throws Exception {
        when(request.getSession())
                .thenReturn(session);
        when(session.getAttribute("user"))
                .thenReturn(new Client());



        // when user from session is client and not null trying access to LoginPage \ RegisterPAge

        partTest(CommandType.LOGIN_PAGE.toString(),CommandType.CLIENT_CABINET);

        partTest(CommandType.REGISTER_PAGE.toString(),CommandType.CLIENT_CABINET);

        // when user is null and trying access to cabinet

        when(session.getAttribute("user"))
                .thenReturn(null);

        partTest(CommandType.CLIENT_CABINET.toString(),CommandType.LOGIN_PAGE);
        partTest(CommandType.INSPECTOR_CABINET.toString(),CommandType.LOGIN_PAGE);

        // when command is not exist

        partTest("notexistcommand",CommandType.ABOUT_US);


    }

    private void partTest(String param, CommandType command) throws IOException, ServletException {
        when(request.getParameter("command"))
                .thenReturn(param);
        authFilter.doFilter(request,response,chain);

        verify(request, atLeastOnce()).setAttribute(eq("command"),eq(command.toString()));

    }

}